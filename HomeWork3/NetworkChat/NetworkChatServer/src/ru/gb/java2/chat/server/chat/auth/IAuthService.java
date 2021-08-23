package ru.gb.java2.chat.server.chat.auth;

public interface IAuthService {

    default void start() {

    }

    String getUsernameByLoginAndPassword(String login, String password);

    default void stop() {

    }
}
