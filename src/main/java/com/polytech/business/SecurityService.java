package com.polytech.business;

/**
 * Created by KHOA on 11-Apr-17.
 */
public interface SecurityService {
    String findLoggedInUsername();
    void autologin(String username, String password);
}
