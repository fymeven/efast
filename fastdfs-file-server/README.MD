# FastDFS文件存储服务器集群搭建
### @author: even   
### @email: fymeven@qq.conm  
## notice: 
1.安装包在./src/main/resource/FastDFS目录下  
2.FastDFS 采用时间戳同步同一个卷下的storage存储服务器，所以要保证同个group下storage存储服务器的时钟保持同步，this's important!    
3.before you install,make sure you have already installed gcc  
    #yum install gcc gcc-c++ make automake autoconf libtool pcre pcre-devel zlib zlib-devel openssl openssl-devel
fdfs命令:
-   查看集群信息:
        # /usr/bin/fdfs_monitor /etc/fdfs/storage.conf
-   测试上传文件:
    1.配置/etc/fdfs/client.conf 客户端文件  
    2./usr/bin/fdfs_upload_file /etc/fdfs/client.conf /tmp/test.png  
-   停止tracker与storage服务  
        # killall fdfs_trackerd 
        # killall fdfs_storaged 
 - ### 一.安装 libfastcommon工具包    
1.解压: tar -zxvf libfastcommon-1.0.38.tar.gz  
2.进入libfastcommon-1.0.38目录: cd libfastcommon-1.0.38  
3.编译: ./make.sh  
4.安装: ./make.sh install
***
- ### 二.安装FastDFS 
1.解压: tar -zxvf fastdfs-5.11.tar.gz  
2.进入fastdfs目录:  cd fastdfs-5.11  
3.编译: ./make.sh  
4.安装: ./make.sh install  
5.拷贝配置文件: cp conf/* /etc/fdfs/  
6.修改tracker.conf配置文件: vim /etc/fdfs/tracker.conf  
##### 修改内容
##
    #不限定ip
    bind_addr=0.0.0.0   
    #tracker基础目录
    base_path=/opt/fastdfs/tracker  
    #tracker端口,默认22122      
    port=22122   
    #tracker服务器 web访问端口
    http.server_port=8388
##    
7.修改storage.conf配置文件: vim /etc/fdfs/storage.conf
##### 修改内容
##  
    #不限定ip
    bind_addr=0.0.0.0
    #storage基础目录
    base_path=/opt/fastdfs/storage
    #storage端口号,同一个组的storage端口号必须相同
    port=23000
    #组名:[group1], [group2], ..., [groupN]
    group_name=group1  
    #storage节点1路径
    store_path0=/opt/fastdfs/storage
    #tracker服务器地址,多个 tracker 直接添加多条配置
    tracker_server=192.168.0.137:22122
    #tracker_server=192.168.0.138:22122
    #storage服务器 web访问端口 
    http.server_port=8888  
##
8.启动tracker和storage服务器  
    /usr/bin/fdfs_trackerd /etc/fdfs/tracker.conf start   
    /usr/bin/fdfs_storaged /etc/fdfs/storage.conf start 
- ### 三. 安装fastdfs-nginx-module插件
1.解压：tar -zxvf fastdfs-nginx-module.tar.gz
2.进入fastdfs-nginx-module目录:  cd fastdfs-nginx-module  
3.拷贝配置文件 cp src/mod_fastdfs.conf /etc/fdfs/  
4.修改mod_fastdfs.conf配置文件: vim /etc/fdfs/修改mod_fastdfs.conf
##### 修改内容
##  
    #文件路径包含组名
    url_have_group_name=true
    #storage目录 与 storage.conf一致
    base_path=/opt/fastdfs/storage
    #tracker服务器地址
    tracker_server=192.168.0.137:22122
    # when support multi-group, uncomment following section
    [group2] #多个组时，放开此行注释
## 
5.修改config文件:
##
    更改前：“CORE_INCS="$CORE_INCS /usr/local/include/fastdfs /usr/local/include/fastcommon/"
    CORE_LIBS="$CORE_LIBS -L/usr/local/lib -lfastcommon -lfdfsclient"”
    更改后：“CORE_INCS="$CORE_INCS /usr/include/fastdfs /usr/local/include/fastcommon/"
    CORE_LIBS="$CORE_LIBS -L/usr/lib64 -lfastcommon -lfdfsclient"”
##
- 1.未安装nginx
    带fastdfs-nginx-module插件安装nginx
  2.已安装nginx
    重新编译nginx动态添加fastdfs-nginx-module插件
#####
    1.进入nginx目录: cd /opt/nginx  
    2.带fastdfs-nginx-module插件生成nginx编译文件:  
      .configure --add-module=/opt/fastdfs/fastdfs-nginx-module/src  
    3.编译: make 
    4.
        1.未安装nginx执行make install安装
        2.已安装nginx cp ./objs/nginx /usr/local/nginx/sbin/ 替换原文件
- ### 二.配置启动nginx
1.编辑nginx配置文件: vim /usr/local/nginx/conf/nginx.conf  
##### 单机配置  
##
    #tracker与storage服务器 web访问端口设为一致  
    #http.server_port=8388
    server {
        listen          8388;
        server_name     localhost;
    
        location / {
            root   html;
            index  test.html index.html index.htm;
        }
    
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    
        location ~/group([0-9])/M00 {
            root /opt/fastdfs/storage/data;
            ngx_fastdfs_module;
        }
    }
##
##### 集群配置
##
    # notice: the same group must have the same port   
    upstream cluster_stroage_group1{
        server 192.168.0.137:8888 weight=10 max_fails=2 fail_timeout=30s;
        server 192.168.0.138:8888 weight=10 max_fails=2 fail_timeout=30s;
        server 192.168.0.139:8888 weight=10 max_fails=2 fail_timeout=30s;
    }
    
    upstream cluster_stroage_group2{
        server 192.168.0.137:8889 weight=10 max_fails=2 fail_timeout=30s;
        server 192.168.0.138:8889 weight=10 max_fails=2 fail_timeout=30s;
        server 192.168.0.139:8889 weight=10 max_fails=2 fail_timeout=30s;
    }
    
    server {
        listen          8888;#storage服务器web访问端口
        server_name     localhost;
        
        location ~/group1/M00 {
            root /opt/fastdfs/storage/data;
            ngx_fastdfs_module;
        }
    }
    
    server {
        listen          8388;#tracker服务器web追踪端口
        server_name     localhost;
    
        location / {
            root   html;
            index  test.html index.html index.htm;
        }
    
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    
        location ~/group1/M00 {
            proxy_pas   http://cluster_stroage_group1;
        }
        
        location ~/group2/M00 {
            proxy_pas   http://cluster_stroage_group2;
        }
    
    }
##
2.启动nginx
    
    