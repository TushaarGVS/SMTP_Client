/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author akshayuprabhu
 */
public class popProjectGUI extends javax.swing.JFrame {
    
    String message = new String();
    String SenderMailID =new String();
    String  RecieverMailID= new String();
    String Subject =new String();
    
    /**
     * Creates new form popProjectGUI
     */
    public popProjectGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelr = new javax.swing.JLabel();
        jLabels = new javax.swing.JLabel();
        jTextFieldr = new javax.swing.JTextField();
        jTextFields = new javax.swing.JTextField();
        jLabelm = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        jLabelt = new javax.swing.JLabel();
        jTextFieldt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextFieldm = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SMTP Mail sender");

        jLabelr.setText("Reciepient Mail ID:");

        jLabels.setText("Subject:");

        jTextFieldr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldrActionPerformed(evt);
            }
        });

        jLabelm.setText("Message:");

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        jLabelt.setText("Sender Mail ID:");

        jTextFieldt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldtActionPerformed(evt);
            }
        });

        jTextFieldm.setColumns(20);
        jTextFieldm.setRows(5);
        jScrollPane1.setViewportView(jTextFieldm);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(926, Short.MAX_VALUE)
                .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextFields, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldr, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelr)
                            .addComponent(jLabels)
                            .addComponent(jLabelm)
                            .addComponent(jLabelt))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldr, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabels)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldrActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
      SenderMailID = jTextFieldt.getText();
      RecieverMailID = jTextFieldr.getText();
      message = jTextFieldm.getText();
      Subject = jTextFields.getText();
        
        Socket smtpSocket = null;
        DataInputStream is = null;
        DataOutputStream os = null;
        
        try{
            
        smtpSocket = new Socket("localhost",25);
        is = new DataInputStream(smtpSocket.getInputStream());
        os = new DataOutputStream(smtpSocket.getOutputStream());

        if(smtpSocket != null && os != null && is != null) {
            os.writeBytes("HELO\n");
            os.writeBytes("MAIL FROM: <"+ SenderMailID +">\n");
            os.writeBytes("RCPT TO: <"+ RecieverMailID +">\n");
            os.writeBytes("DATA\n");
            os.writeBytes("\n\n Subject:" + Subject + "\n\n Message:"+ message + "\n");
            os.writeBytes("\r\n.\r\n");
            os.writeBytes("QUIT");

            String response;
            while ((response = is.readLine()) != null) {
                System.out.println("Server " + response);
                if (response.indexOf("Ok") != -1) {
                    break;
                }
            }

            os.close();
        }
        is.close();
        smtpSocket.close();
 
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_sendActionPerformed

    private void jTextFieldtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldtActionPerformed

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
            java.util.logging.Logger.getLogger(popProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popProjectGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelm;
    private javax.swing.JLabel jLabelr;
    private javax.swing.JLabel jLabels;
    private javax.swing.JLabel jLabelt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextFieldm;
    private javax.swing.JTextField jTextFieldr;
    private javax.swing.JTextField jTextFields;
    private javax.swing.JTextField jTextFieldt;
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables
}
