package com.type.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSenderImpl mailSender;
    //从全局文件里面取值
    @Value("${spring.mail.username}")
    private String from;
    //发送验证码
    public void sendEmail(String to,String subject, String  text){
        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }


}
