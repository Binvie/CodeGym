package com.example.mail.repository;

import com.example.mail.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepository implements IMailRepository{
    public static List<Mail> mailList = new ArrayList<>();
    static {
        mailList.add(new Mail("English",25,1,"Thienprovipn01"));
        mailList.add(new Mail("VietNamese",5,1,"Hai"));
        mailList.add(new Mail("Japanese",10,10,"Sang"));
    }
    public Mail searchId(int id){
        return mailList.get(id);
    }
    public List<Mail> display(){
        return mailList;
    }
    @Override
    public void edit(int id, Mail mail) {
        mailList.set(id, mail);
    }
}
