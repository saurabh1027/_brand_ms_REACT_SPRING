package com.neutrux.BrandMS.shared;

import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 8948348209949059807L;
    private String userId;              //Exposable to the http URL's and different than database ID
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String encryptedPassword;

    //Getters & Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}
