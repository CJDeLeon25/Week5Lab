/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import problemdomain.User;

/**
 *
 * @author 798676
 */
public class AccountService {
    
    ArrayList<User> userList = new ArrayList<>();
   
    
    public User login(String username, String password){
        userList.add(new User("abe","password"));
        userList.add(new User("barb","password"));
        
        for(User x : userList){
            if (x.getUsername().equals(username) && x.getPassword().equals(password)){
                return new User(x.getUsername(), null);
            }
        }
        
        return null;
    }
}
