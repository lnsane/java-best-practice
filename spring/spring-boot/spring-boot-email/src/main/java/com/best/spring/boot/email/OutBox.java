package com.best.spring.boot.email;

import com.sun.mail.imap.IMAPStore;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.*;
import javax.mail.search.SearchTerm;
import java.util.HashMap;
import java.util.Properties;

public class OutBox {



    /**
     * Searches for e-mail messages containing the specified keyword in
     * Subject field.
     * @param host
     * @param port
     * @param userName
     * @param password
     * @param keyword
     */
    public void searchEmail(String host, String port, String userName,
                            String password, final String keyword) {
        Properties properties = new Properties();

        // server setting
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", port);

        // SSL setting
        properties.setProperty("mail.imap.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port",
                String.valueOf(port));

        Session session = Session.getDefaultInstance(properties);

        try {
            HashMap IAM = new HashMap();

            IAM.put("name","myname");
            IAM.put("version","1.0.0");
            IAM.put("vendor","myclient");
            IAM.put("support-email","testmail@test.com");

            IMAPStore store = (IMAPStore) session.getStore("imap");
//下方替换对应帐号和授权码
            // connects to the message store
            store.connect(userName, password);

            store.id(IAM);


            // opens the inbox folder
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);

            // creates a search criterion
            SearchTerm searchCondition = new SearchTerm() {
                @Override
                public boolean match(Message message) {
                    try {
                        if (message.getSubject().contains(keyword)) {
                            return true;
                        }
                    } catch (MessagingException ex) {
                        ex.printStackTrace();
                    }
                    return false;
                }
            };

            // performs search through the folder
            Message[] foundMessages = folderInbox.search(searchCondition);

            for (int i = 0; i < foundMessages.length; i++) {
                Message message = foundMessages[i];
                String subject = message.getSubject();
                System.out.println("Found message #" + i + ": " + subject);
            }

            // disconnect
            folderInbox.close(false);
            store.close();
        } catch (NoSuchProviderException ex) {
            System.out.println("No provider.");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store.");
            ex.printStackTrace();
        }
    }

    /**
     * Test this program with a Gmail's account
     */
    public static void main(String[] args) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("18357128255@163.com");
        message.setTo("1137738840@qq.com");
        message.setSubject("subject");
        message.setText("text");


        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");

        mailSender.setHost("smtp.163.com");
        mailSender.setPort(465);

        mailSender.setUsername("18357128255@163.com");
        mailSender.setPassword("PJYJYHNNUVGIIZCC");
        mailSender.send(message);





        for (Folder folder : mailSender.getSession().getStore("smtp").getDefaultFolder().list()) {
            System.out.println(folder.getName());
        }

    }

}
