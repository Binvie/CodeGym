package com.example.mail.repository;

import com.example.mail.model.Mail;

import java.util.List;

public interface IMailRepository {
    public Mail searchId(int id);
    public List<Mail> display();
    public void edit(int id, Mail mail);

}
