## 框架说明：
### 架构：
    springboot + mybatis
    集成swagger2.0文档
    redis缓存
    pagehelper自动分页插件
    mybatis generator代码自动生成工具
    tk通用mapper工具
    websocket在线消息
    quartz任务调度
    springMail邮件服务
    validation JSR验证
### 目录：

* yth -------------------- parent项目
   * bean -------------------- 实体
      * java -------------------- java
         * entity -------------------- ORM 映射 
         * enums -------------------- 枚举
         * model -------------------- 其他实体
         * request -------------------- 入参实体
         * response -------------------- 出参实体
   * dal -------------------- 数据层
      * java -------------------- java
         * MybatisGenerator.java -------------------- generator生成类
      * resources -------------------- resources
         * mybatis-generator.xml -------------------- generator配置文件
   * api -------------------- 接口层
   * business -------------------- 接口实现业务层
   * common --------------------  公共方法
   * web -------------------- web层
 
### 注意：
####兼容 PostGreSQL：
######  1.pg 主键id自增处理   
1. generator配置文件\<table>标签中设置\<generatedKey column="id" sqlStatement="JDBC"/>
2. entity 添加id主键注解@Column(insertable = false)
3. 重写mapper insertSelective方法添加注解  
@InsertProvider(type = BaseInsertProvider.class,method = "dynamicSQL")  
@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
######  2.pg数组类型处理 
1. entity 添加注解@ColumnType(typeHandler = ArrayTypeHandler.class)


    
    
    
