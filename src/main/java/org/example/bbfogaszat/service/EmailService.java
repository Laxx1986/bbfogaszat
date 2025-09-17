package org.example.bbfogaszat.service;
/*    */ 
/*    */ import com.sendgrid.Method;
/*    */ import com.sendgrid.Request;
/*    */ import com.sendgrid.SendGrid;
/*    */ import com.sendgrid.helpers.mail.Mail;
/*    */ import com.sendgrid.helpers.mail.objects.Content;
/*    */ import com.sendgrid.helpers.mail.objects.Email;
/*    */ import java.io.IOException;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class EmailService
/*    */ {
/*    */   public void sendContactFormToAdmin(String name, String email, String phone, String subject, String message) throws IOException {
/* 18 */     Email from = new Email("kapcsolat@innovweb.hu");
/* 19 */     String subjectText = "Új kapcsolatfelvételi űrlap";
/* 20 */     Email to = new Email("lszendrey86@gmail.com");
/* 21 */     Email replyTo = new Email(email);
/* 22 */     Content content = new Content("text/plain", "Név: " + name + "\nEmail: " + email + "\nTelefon: " + phone + "\nTárgy: " + subject + "\nÜzenet: " + message);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     Mail mail = new Mail(from, subjectText, to, content);
/* 30 */     mail.setReplyTo(replyTo);
/* 31 */     SendGrid sg = new SendGrid(this.sendGridApiKey);
/* 32 */     Request request = new Request();
/*    */     
/*    */     try {
/* 35 */       request.setMethod(Method.POST);
/* 36 */       request.setEndpoint("mail/send");
/* 37 */       request.setBody(mail.build());
/* 38 */       sg.api(request);
/* 39 */     } catch (IOException ex) {
/* 40 */       throw ex;
/*    */     } 
/*    */   } @Value("${sendgrid.api.key}")
/*    */   private String sendGridApiKey;
/*    */   public void sendConfirmationEmail(String recipientEmail, String name) throws IOException {
/* 45 */     Email from = new Email("kapcsolat@innovweb.hu");
/* 46 */     String subject = "Köszönjük a kapcsolatfelvételt!";
/* 47 */     Email to = new Email(recipientEmail);
/* 48 */     Content content = new Content("text/plain", "Kedves " + name + ",\n\nKöszönjük, hogy felvette velünk a kapcsolatot.\n\nHamarosan válaszolunk Önnek.\n\nÜdvözlettel:\nB&B fogászat");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 54 */     Mail mail = new Mail(from, subject, to, content);
/* 55 */     SendGrid sg = new SendGrid(this.sendGridApiKey);
/* 56 */     Request request = new Request();
/*    */     
/*    */     try {
/* 59 */       request.setMethod(Method.POST);
/* 60 */       request.setEndpoint("mail/send");
/* 61 */       request.setBody(mail.build());
/* 62 */       sg.api(request);
/* 63 */     } catch (IOException ex) {
/* 64 */       throw ex;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\lszen\bb.jar!\BOOT-INF\classes\com\b_b_fogaszat\service\EmailService.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */