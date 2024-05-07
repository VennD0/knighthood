package com.knighthood.knighthood.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    private int user_id;
    private String username;
    private String password;
    private String country;
    private String firstname;
    private String lastname;

    public User(String username, String password, String coun, String firstname, String lastname){
        this.username = username;
        this.password = password;
        this.country = coun;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(){

    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getCountry(){
        return this.country;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public String getLastname(){
        return this.lastname;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPass(String password){
        this.password = password;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }
}
