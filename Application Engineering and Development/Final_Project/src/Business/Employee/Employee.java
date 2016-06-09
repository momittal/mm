/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.UserAccount.UserAccount;
import static Business.Utils.Methods.randomNum;
import static java.lang.Math.abs;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Mohit
 */
public class Employee {
    private String name;
    private int id;
    private Date timeStamp;
    private int location;
    private UserAccount userAccount;

    public Employee() {
        timeStamp = new Date();
        id = abs((int)timeStamp.getTime()/(1000));
        location = randomNum(1, 100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    
    
    @Override
    public String toString() {
        return name;
    }
}
