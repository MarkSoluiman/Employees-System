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
public class Job implements Serializable{
    
    private String name;
    private double salary;

    public Job(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    
    //returns true if this job salary and name is equal to the input job
    //salary and name
    public boolean equals(Job job){
        return (this.salary==job.salary &&this.name.equals(job.name));
    }
    
    
    
}
