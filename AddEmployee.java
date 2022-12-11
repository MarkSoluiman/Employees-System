/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employeessystem;

import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author marka
 */
public class AddEmployee extends javax.swing.JFrame {

    /**
     * Creates new form AddEmployee
     */
    
    ArrayList<Job> jobs;
    ArrayList<Employee> employees;
    public AddEmployee() {
        initComponents();
        
        jobs=new ArrayList<>();
        employees=new ArrayList<>();
        
        populateEmployeesArrayList();
        populateJobsArrayList();
        
        
       String [] jobsArray=new String [jobs.size()];
      
       for (int i=0;i<jobs.size();i++){
           jobsArray[i]=jobs.get(i).getName()+", $:"+jobs.get(i).getSalary();
       }
                
       JobCB.setModel(new javax.swing.DefaultComboBoxModel<>(jobsArray));
       
       if(jobs.isEmpty()){
           firstName.setEditable(false);
           lastName.setEditable(false);
           ID.setEditable(false);
           JobCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No jobs found" }));
           createButton.setEnabled(false);

           
       }

        
        
                
    }
    
    //Returns true if text doesnt contain numbers, false otherwise.
    
    public boolean containsNumbers(String s){
        return (s.matches(".*[0-9].*"));
    }
    
    //Returns true if text is positive integer, false otherwise.
    
    public boolean isPositiveInteger(String s) {

    if (s == null) {
        return false;
    }
    int length = s.length();
    if (length == 0) {
        return false;
    }
    if (s.charAt(0) == '-') {
            return false;
    }
    for (int i = 0; i < length; i++) {
        char c = s.charAt(i);
        boolean isDigit = (c >= '0' && c <= '9');
        if (!isDigit) {
            return false;
        }
    }
    return true;
}
    
    public void setBlanckTextFields(){
        firstName.setText("");
        lastName.setText("");
        ID.setText("");
    }
    
    //This method reads every job from the jobs data file and 
    // and puts them in the jobs arraylist
    public void populateJobsArrayList(){
        try{
              FileInputStream file=new FileInputStream("jobs.dat");
              ObjectInputStream inputFile=new ObjectInputStream(file);
              
              boolean endOfFile=false;
              
              while(!endOfFile){
                  try{
                      jobs.add((Job)(inputFile.readObject()));
                  }
                  catch(EOFException e){
                      endOfFile=true;
                  }
                  catch(Exception f){
                      JOptionPane.showMessageDialog(null, f.getMessage());
                  }
              }
                
              inputFile.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Message",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void populateEmployeesArrayList(){
        try{
          FileInputStream file=new FileInputStream("employees.dat");
          ObjectInputStream inputfile=new ObjectInputStream(file); 
          
          boolean endOfFile=false;
          
          while(!endOfFile){
              try{
                  
                  employees.add((Employee)inputfile.readObject());
              }catch(EOFException e){
                  endOfFile=true;
              }
              catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());

              }
          }
          inputfile.close();
        }
        
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //This method takes each job from the jobs arraylist
    //and puts it into the jobs data file
    public void saveJobsToFile(){
        
        try{
             FileOutputStream file=new FileOutputStream("jobs.dat");
              ObjectOutputStream outputFile=new ObjectOutputStream(file); 
              
              for (Job job:jobs){
                  outputFile.writeObject(job);
              }
              outputFile.close();
        }
        
        catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());

        }
       
       
        
    }
    
    //This method takes each employee from the employees arraylist
    //and puts it into the employees data file
    public void saveEmployeesToFile(){
        
        try{
            FileOutputStream file=new FileOutputStream("employees.dat");
            ObjectOutputStream outputFile=new ObjectOutputStream(file);
            
            for(Employee employee:employees){
                outputFile.writeObject(employee);
            }
            outputFile.close();
        }
        catch(IOException e){
         JOptionPane.showMessageDialog(null, e.getMessage());

        }
        
    }
    
   public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JobCB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Create a new Employee");

        jLabel2.setText(" First Name:");

        jLabel3.setText(" Last Name:");

        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Select Job:");

        JobCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JobCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JobCBActionPerformed(evt);
            }
        });

        jLabel5.setText("Staff ID:");

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeessystem/save.png"))); // NOI18N
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(164, 164, 164))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstName)
                    .addComponent(lastName)
                    .addComponent(JobCB, 0, 312, Short.MAX_VALUE)
                    .addComponent(ID)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(createButton)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JobCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        
        String employeeFirstName=firstName.getText().trim();
        String employeeLastName=lastName.getText().trim();
        String employeeID=ID.getText().trim();
        boolean invalidID=false;
    
        if(!isInteger(employeeID) || !isPositiveInteger(employeeID)){
         JOptionPane.showMessageDialog(null, "ID has to be only in whole positive numbers");
         ID.setText("");
        }
        
        else{
            for(Employee employee:employees){
            if(Integer.parseInt(employeeID)==employee.getSaffID()){
                invalidID=true;
                break;
            }
        }
        
        
        if(employeeFirstName.isEmpty()||employeeLastName.isEmpty()||employeeID.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill out the required fields!");
        }
        else if(invalidID){
            JOptionPane.showMessageDialog(null, "ID is already taken, please enter another id");
            ID.setText("");
        }
        else{
            
        
        
        if(containsNumbers(employeeFirstName)||containsNumbers(employeeLastName)){
            JOptionPane.showMessageDialog(null, "First and last names can't contain numbers");
        }
           else{
            int index=JobCB.getSelectedIndex();
            Job job=jobs.get(index);
            int employeeIDNum=Integer.parseInt(employeeID);
            Employee employee=new Employee(employeeFirstName, employeeLastName, job,employeeIDNum );
            employees.add(employee);
            saveEmployeesToFile();
            JOptionPane.showMessageDialog(null, "Employee added successfully!");
            setBlanckTextFields();
            
            
        }
        }
        

        }
        
 
        
        
    }//GEN-LAST:event_createButtonActionPerformed

    private void JobCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JobCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JobCBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JComboBox<String> JobCB;
    private javax.swing.JButton createButton;
    private javax.swing.JTextField firstName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField lastName;
    // End of variables declaration//GEN-END:variables
}
