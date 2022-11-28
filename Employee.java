/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeessystem;

import java.io.*;

/**
 *
 * @author marka
 */
public class Employee implements Serializable{
    private String firstName;
    private String lastName;
    private Job job;
    private int saffID;
    
       public Employee(String firstName, String lastName, Job job, int saffID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.saffID = saffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getSaffID() {
        return saffID;
    }

    public void setSaffID(int saffID) {
        this.saffID = saffID;
    }
    
    

 
}
