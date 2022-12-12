/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeessystem;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author marka
 */
public class readFiles {

    private Scanner emailScan;
    private Scanner passwordScan;
    private ArrayList<String> validEmails;

    private ArrayList<String> validpasswords;

    //Constructor
    public readFiles() {
        this.validEmails = new ArrayList<>();
        this.validpasswords = new ArrayList<>();

    }

    public void openEmailFile() {
        try {
            emailScan = new Scanner(new File("emails.txt"));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void openPasswordFiles() {
        try {
            passwordScan = new Scanner(new File("passwords.txt"));

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);

        }

    }

    public ArrayList<String> readPasswordFile() {
        while (passwordScan.hasNext()) {
            validpasswords.add(passwordScan.next());
        }
        return validpasswords;
    }

    public ArrayList<String> readEmailFile() {
        while (emailScan.hasNext()) {
            validEmails.add(emailScan.next());
        }
        return validEmails;
    }

    public void closeEmailFile() {
        emailScan.close();
    }
    public void closePasswordFile(){
        passwordScan.close();
    }

}
