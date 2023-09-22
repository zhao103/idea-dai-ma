package cn.baisee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private String state;

//    public User(String username, String password, String state) {
//        this.username = username;
//        this.password = password;
//        this.state = state;
//    }
}
