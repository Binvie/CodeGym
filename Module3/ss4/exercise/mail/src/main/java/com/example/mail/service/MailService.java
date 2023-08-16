package com.example.mail.service;

import com.example.mail.model.Mail;
import com.example.mail.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService{
    @Autowired
    private IMailRepository mailRepository;
    @Override
    public void edit(int id, Mail mail) {
        mailRepository.edit(id,mail);
    }

    @Override
    public Mail searchId(int id) {
        return mailRepository.searchId(id);
    }

    @Override
    public List<Mail> display() {
        return mailRepository.display();
    }
}
