package com.pedroacbg.api.register.email;

public interface EmailSender {

    void send(String to, String email);

}
