package by.yurusova.entranceExam.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
