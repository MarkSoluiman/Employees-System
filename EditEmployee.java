/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employeessystem;

/**
 *
 * @author marka
 */

import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.JDialog;

public class EditEmployee extends javax.swing.JFrame {

    
     ArrayList<Job> jobs;
    ArrayList<Employee> employees;
    /**
     * Creates new form EditEmployee
     */
    public EditEmployee() {
        initComponents();
        
         jobs=new ArrayList<>();
        employees=new ArrayList<>();
        
        populateEmployeesArrayList();
        populateJobsArrayList();
        
        String[] employeesStringArray=new String[employees.size()];
        String[] jobsStringArray=new String[jobs.size()];
        
        for(int i=0;i<employees.size();i++){
            employeesStringArray[i]=employees.get(i).getLastName()+" "+employees.get(i).getSaffID(); 
        }
        
        for(int i=0;i<jobs.size();i++){
            jobsStringArray[i]=jobs.get(i).getName();
        }

        EmployeeCB.setModel(new javax.swing.DefaultComboBoxModel<>(employeesStringArray));
        JobCB.setModel(new javax.swing.DefaultComboBoxModel<>(jobsStringArray));
        
        if(!employees.isEmpty()){
            EmployeeCB.setSelectedIndex(0);
        }
        else{
            
        EmployeeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No employees were found" }));
        firstName.setEditable(false);
        lastName.setEditable(false);

        }

        


       


    }
    
     public void populateJobsArrayList(){
        try{
              FileInputStream file=new FileInputStream("Jobs.dat");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EmployeeCB = new javax.swing.JComboBox<>();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        JobCB = new javax.swing.JComboBox<>();
        ID = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Edit Employee info");

        jLabel2.setText("Choose Employee:");

        jLabel3.setText("First Name:");

        jLabel4.setText("Last Name:");

        jLabel5.setText("Employee Job:");

        jLabel6.setText("Staff Number:");

        EmployeeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        EmployeeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeCBActionPerformed(evt);
            }
        });

        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });

        JobCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JobCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JobCBActionPerformed(evt);
            }
        });

        ID.setEditable(false);
        ID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeessystem/save.png"))); // NOI18N
        saveButton.setText("Save Changes");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeessystem/exit.png"))); // NOI18N
        deleteButton.setText("Delete ");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(219, 219, 219))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmployeeCB, 0, 327, Short.MAX_VALUE)
                            .addComponent(firstName)
                            .addComponent(lastName)
                            .addComponent(JobCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(EmployeeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JobCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameActionPerformed

    private void EmployeeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeCBActionPerformed
        // TODO add your handling code here:
        
        try{
          int index=EmployeeCB.getSelectedIndex();
        String idString=Integer.toString(employees.get(index).getSaffID());
        firstName.setText(employees.get(index).getFirstName());
        lastName.setText(employees.get(index).getLastName());
        ID.setText(idString);
        int jobIndex=0;
        Job job=employees.get(index).getJob();
        
        for(int i=0;i<jobs.size();i++){
            if(jobs.get(i).equals(job)){
                jobIndex=i;
                break;
            }
        }
        
        JobCB.setSelectedIndex(jobIndex);
        }
        catch(IndexOutOfBoundsException e){
          //JOptionPane.showMessageDialog(null,"Employee not found" );
          JOptionPane.showMessageDialog(null, "Employee not found","Message",JOptionPane.ERROR_MESSAGE);

           firstName.setText("");
           lastName.setText("");
           ID.setText("");
           
        }
      
        
        
        
        
        
    }//GEN-LAST:event_EmployeeCBActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        
        String employeeFirstName=firstName.getText().trim();
        String employeeLastName=lastName.getText().trim();
        if(employeeFirstName.isEmpty()||employeeLastName.isEmpty()){
           JOptionPane.showMessageDialog(null, "Please fill all the required fields!");
           
        }
        else{
        int index=EmployeeCB.getSelectedIndex();
        employees.get(index).setFirstName(employeeFirstName);
        employees.get(index).setLastName(employeeLastName);
        Job job=jobs.get(JobCB.getSelectedIndex());
        employees.get(index).setJob(job);
        
        saveEmployeesToFile();
        JOptionPane.showMessageDialog(null, "successfully updated");
        
        
        }
     
        
        
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
     // TODO add your handling code here:
     try{
      int index=EmployeeCB.getSelectedIndex();
     
     employees.remove(index);
     saveEmployeesToFile();
     JOptionPane.showMessageDialog(null, "Successfully deleted");
     this.dispose();
     }
     
     catch(IndexOutOfBoundsException e){
         JOptionPane.showMessageDialog(null, "No employee chosen to delete");
                 
     }

     
     
     
     


     
     
     

        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

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
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> EmployeeCB;
    private javax.swing.JTextField ID;
    private javax.swing.JComboBox<String> JobCB;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField lastName;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
