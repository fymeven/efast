package cn._51even.efast.core.mail;

import com.sun.mail.util.MailSSLSocketFactory;

import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by fymeven on 2017/7/3.
 */

/**
 * Email send Model
 */
public class MailModel implements Serializable {
    //个人邮箱配置
    private String host="smtp.sina.com.cn";    //Email host
    private String from="fymhyfcom@sina.com";  //Email account
    private String passWord="FYMhyf201314"; //Email password

    //邮箱内容主体
    private String title;   //Email title
    private String content; //Email content
    private String[] to;    //Email receiver
    private String[] cc;    //carbon copy to sb.
    private String[] bcc;   //blind carbon copy to sb.
    private Date sentDate;  //send Email date
    private String[] picPath;   //pic
    private String[] filePath;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Properties getProperties() throws GeneralSecurityException {
        Properties prop= new Properties();
        prop.put("mail.smtp.auth" ,"true") ;  //  将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
        prop.put("mail.smtp.timeout" ,"25000") ;
        MailSSLSocketFactory sslSocketFactory= null;
        sslSocketFactory = new MailSSLSocketFactory();
        sslSocketFactory.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");//ssl安全协议
        prop.put("mail.smtp.ssl.socketFactory", sslSocketFactory);
        return prop;
    }
    public String[] getFilePath() {
        return filePath;
    }

    public void setFilePath(String[] filePath) {
        this.filePath = filePath;
    }

    public String[] getPicPath() {
        return picPath;
    }

    public void setPicPath(String[] picPath) {
        this.picPath = picPath;
    }

    public Date getSentDate() {
        if(sentDate==null){
            return new Date();
        }
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
