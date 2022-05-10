package com.nitish.emailservice.repository;

import com.nitish.emailservice.utils.EnvVariables;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class EmailRepo {

    public static boolean sendMail() {
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props , new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(EnvVariables.EMAIL,EnvVariables.PASS);
            }
        });

        session.setDebug(true);

        MimeMessage msg = new MimeMessage(session);

        try{
            //From Email
            msg.setFrom("nitishsonthalia@gmail.com");

            //Adding Recipient to message
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("nitish102000@gmail.com"));

            //Adding Subject
            msg.setSubject("Test email");

            //Adding Test
            msg.setText("Test Email hai ye");

            //Send Message
            Transport.send(msg);

            System.out.println("Sent Successfully!!!!!!!!!!!!!!");

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;

//        msg.setSentDate(new Date());
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent("Test Email hai ye", "text/html");
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//
//        msg.setContent(multipart);

    }
    public static boolean sendMailWithAttachment() {
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props , new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(EnvVariables.EMAIL,EnvVariables.PASS);
            }
        });

        session.setDebug(true);

        MimeMessage msg = new MimeMessage(session);

        try{
            //From Email
            msg.setFrom("nitishsonthalia@gmail.com");

            //Adding Recipient to message
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("nitish102000@gmail.com"));

            //Adding Subject
            msg.setSubject("Test email");

            //File Path
            String path = "C:\\Users\\nitis\\Desktop\\MOM_3196.jpg";

            //Multiple Body Part
            MimeMultipart mimeMultipart = new MimeMultipart();

            //Text
            MimeBodyPart textMime = new MimeBodyPart();
            textMime.setText("Test Email hai ye");

            //File
            MimeBodyPart fileMime = new MimeBodyPart();
            File file = new File(path);
            fileMime.attachFile(file);

            //Adding to MultiPart
            mimeMultipart.addBodyPart(textMime);
            mimeMultipart.addBodyPart(fileMime);

            msg.setContent(mimeMultipart);

            //Send Message
            Transport.send(msg);

            System.out.println("Sent Successfully!!!!!!!!!!!!!!");

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;

//        msg.setSentDate(new Date());
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent("Test Email hai ye", "text/html");
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//
//        msg.setContent(multipart);

    }

}
