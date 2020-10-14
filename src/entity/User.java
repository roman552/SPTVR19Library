/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class User implements Serializable{
    private String login;
    private String password;
    private Reader reader;
    
    public User(){
    }

    public User(String login, String password, Reader reader) {
        this.login = login;
        this.password = password;
        this.reader = reader;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" 
                + "login=" + login 
                + ", password=" + password 
                + ", reader=" + reader.getFirstName()
                + " " + reader .getLastName()
                + '}';
    }
    
    
}
