package course.controller.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

// TODO rewrite for @Autowired
public class EmailMessage {

    private MailSender mailSender;

//    public void setMailSender(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }

    public EmailMessage() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "Spring-Mail.xml");
        this.mailSender = (MailSender) context.getBean("mailSender");
    }

    public void sendMail(String from, String to, String subject, String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }

    public static class Test {
        public static void main(String[] args) {
            EmailMessage em = new EmailMessage();
            String from = "noreply@alexcoursework.net";
            String to = "nyarnet@mail.ru";
            String subject = "administrator";
            String msg = "Test message.";
            em.sendMail(from, to, subject, msg);
        }
    }
    
}
