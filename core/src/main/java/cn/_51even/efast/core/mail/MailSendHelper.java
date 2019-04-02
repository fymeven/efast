package cn._51even.efast.core.mail;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.security.GeneralSecurityException;

/**
 * Created by fymeven on 2017/7/3.
 */
public class MailSendHelper {

    private static JavaMailSenderImpl senderImpl =  new JavaMailSenderImpl();
    //初始化邮件服务器信息
    static {
        // 设定mail server
        MailModel mailModel=new MailModel();
        senderImpl.setHost(mailModel.getHost());
        senderImpl.setUsername(mailModel.getFrom());
        senderImpl.setPassword(mailModel.getPassWord()) ;
        try {
            senderImpl.setJavaMailProperties(mailModel.getProperties());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public static void sendSimpleMail(MailModel mailModel) {
        // 建立邮件消息
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setFrom(mailModel.getFrom());
        mail.setTo(mailModel.getTo());
        mail.setSubject(mailModel.getTitle());
        mail.setText(mailModel.getContent());
        mail.setSentDate(mailModel.getSentDate());
        if (mailModel.getCc()!=null)
            mail.setCc(mailModel.getCc());
        if (mailModel.getBcc()!=null)
            mail.setBcc(mailModel.getBcc());
        // 发送邮件
        senderImpl.send(mail);
    }

    public static void sendMimeMail(MailModel mailModel) throws Exception {
            MimeMessage mimeMessage=senderImpl.createMimeMessage();
            MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
            messageHelper.setFrom(mailModel.getFrom());
            messageHelper.setTo(mailModel.getTo());
            messageHelper.setSubject(mailModel.getTitle());
            messageHelper.setText(mailModel.getContent(), true);
            messageHelper.setSentDate(mailModel.getSentDate());
            if (mailModel.getCc()!=null)
                messageHelper.setCc(mailModel.getCc());
            if (mailModel.getBcc()!=null)
                messageHelper.setBcc(mailModel.getBcc());
            if (mailModel.getPicPath()!=null){
                for (String picPath : mailModel.getPicPath()) {
                    FileSystemResource file=new FileSystemResource(new File(picPath));
                    messageHelper.addInline(MimeUtility.encodeWord(file.getFilename()),file);
                }
            }
            if (mailModel.getFilePath()!=null){
                for (String filePath : mailModel.getFilePath()) {
                    FileSystemResource file=new FileSystemResource(new File(filePath));
                    messageHelper.addAttachment(MimeUtility.encodeWord(file.getFilename()), file);
                }
            }
        senderImpl.send(mimeMessage);
    }

    public static void sendTamplateMail(MailModel mailModel) throws Exception {
        MimeMessage mimeMessage=senderImpl.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
        messageHelper.setFrom(mailModel.getFrom());
        messageHelper.setTo(mailModel.getTo());
        messageHelper.setSubject(mailModel.getTitle());
        messageHelper.setText(mailModel.getContent(), true);
        messageHelper.setSentDate(mailModel.getSentDate());
        if (mailModel.getCc()!=null)
            messageHelper.setCc(mailModel.getCc());
        if (mailModel.getBcc()!=null)
            messageHelper.setBcc(mailModel.getBcc());
        if (mailModel.getPicPath()!=null){
            for (String picPath : mailModel.getPicPath()) {
                FileSystemResource file=new FileSystemResource(new File(picPath));
                messageHelper.addInline(MimeUtility.encodeWord(file.getFilename()),file);
            }
        }
        if (mailModel.getFilePath()!=null){
            for (String filePath : mailModel.getFilePath()) {
                FileSystemResource file=new FileSystemResource(new File(filePath));
                messageHelper.addAttachment(MimeUtility.encodeWord(file.getFilename()), file);
            }
        }
        senderImpl.send(mimeMessage);
    }


}
