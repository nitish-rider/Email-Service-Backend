package com.nitish.emailservice.controller;

import com.nitish.emailservice.repository.EmailRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @RequestMapping(value = "/sendEmail")
    public String sendEmail(){
        boolean result = EmailRepo.sendMail();
        if(result){
            return "Email Sent Successfully";
        }
        else{
            return "Email Not Sent";
        }
    }

    @RequestMapping(value = "/sendEmailAtt")
    public String sendEmailAtt(){
        boolean result = EmailRepo.sendMailWithAttachment();
        if(result){
            return "Email Sent Successfully";
        }
        else{
            return "Email Not Sent";
        }
    }
}
