package br.unitins.back.service.email;

public interface EmailService {

    void sendEmail(String to, String subject, String body);
}
