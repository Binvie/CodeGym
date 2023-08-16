package com.example.mail.service;

import com.example.mail.model.Mail;

import java.util.List;

public interface IMailService {
    public void edit(int id, Mail mail);
    public Mail searchId(int id);
    public List<Mail> display();

}
