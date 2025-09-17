package org.example.bbfogaszat.controller;/*    */

import org.example.bbfogaszat.model.ContactForm;
import org.example.bbfogaszat.service.EmailService;

/*    */ import java.io.IOException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMethod;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/api/contact"})
/*    */ @CrossOrigin(origins = {"https://bandbfogaszat.hu"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
/*    */ public class ContactController {
/*    */   @Autowired
/*    */   public ContactController(EmailService emailService) {
/* 21 */     this.emailService = emailService;
/*    */   }
/*    */ 
/*    */   
/*    */   @PostMapping({"/submit"})
/*    */   public ResponseEntity<?> submitContactForm(@RequestBody ContactForm contactForm) {
/*    */     try {
/* 28 */       this.emailService.sendContactFormToAdmin(contactForm.getName(), contactForm.getEmail(), contactForm.getPhone(), contactForm.getSubject(), contactForm.getMessage());
/*    */ 
/*    */       
/* 31 */       this.emailService.sendConfirmationEmail(contactForm.getEmail(), contactForm.getName());
/*    */       
/* 33 */       return ResponseEntity.ok("Üzenet sikeresen elküldve!");
/* 34 */     } catch (IOException e) {
/* 35 */       return ResponseEntity.status(500).body("Hiba az üzenet elküldésekor: " + e.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   private final EmailService emailService;
/*    */ }