/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package featurehub;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.*; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author daved
 */
public class FrmDashboard extends javax.swing.JFrame {
    private String username;
    private String role;
   
    /**
     * Creates new form DashboardFrame
     * @param username
     * @param role
     */
     // Declare the button and icons
    private ImageIcon defaultIcon;
    private ImageIcon hoverIcon;
    
    public FrmDashboard(String username, String role) {
        this.setUndecorated(true); // Removes the title bar
        
        initComponents();
        setFullScreen(); // Set the frame into fullscreen
        
        // Load the Icons
        defaultIcon = new ImageIcon(getClass().getResource("/featurehub/Icons/ExitDefaultIcon.png"));  // Replace with your default icon path
        hoverIcon = new ImageIcon(getClass().getResource("/featurehub/Icons/ExitHoverIcon.png")); // Replace with your hover icon path
        
        exitBtn.setIcon(defaultIcon);
        
        addHoverEffectToExitButton(); // Method to change the color of the exit button when you hover
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.username = username;
        this.role = role;
      
        lblUser.setText("Welcome, " + username);
        lblRole.setText("User Level: " + role);
        
        viewMenuPerRole(role);
        
        
        this.setLocationRelativeTo(null);
        // Create a timer that triggers every second (1000 milliseconds)
        // Create a timer that triggers every second (1000 milliseconds)
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                updateTime(); // Call the method to update the time
            }
        });
        timer.start(); // Start the timer
        // Initialize your components here, such as timeLabel
        
        timeLabel.setText("00-00-0000 00:00:00"); // Initial text

  
    }
    
    // Set the Frame into Full Screen
    private void setFullScreen() {
        // Maximize the frame
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Ensure the frame occupies the entire screen dynamically based on device size
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        // Optionally, center the frame
        this.setLocationRelativeTo(null);

        // Ensure the frame is resizable (optional)
        this.setResizable(true);
    }
    
    // Add hover effect to exit button
    private void addHoverEffectToExitButton() {
        exitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitBtn.setIcon(hoverIcon); // Change to hover icon
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitBtn.setIcon(defaultIcon); // Revert to default icon
            }
        });
    }
    
    // Method to update the time
    private void updateTime() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeLabel.setText(dateFormat.format(currentDate)); // Update the time label
    }
    
    private void viewMenuPerRole(String role)
    {
        switch (role) {
            case "USER":
            // Enable buttons for USER
            btnQuiz.setEnabled(true);
            btnChatbot.setEnabled(true);
            btnCredits.setEnabled(true);

            // Disable other buttons for USER
            btnVisualization.setEnabled(false);
            btnEncryptDecrypt.setEnabled(false);
            break;
                
            case "GUEST":
            // Enable buttons for GUEST
            btnVisualization.setEnabled(true);
            btnEncryptDecrypt.setEnabled(true);
            btnCredits.setEnabled(true);

            // Disable other buttons for GUEST
            btnQuiz.setEnabled(false);
            btnChatbot.setEnabled(false);
            btnLogout.setText("Go to Sign in");
            break;
            
            case "Admin":
            // Enable buttons for GUEST
            btnQuiz.setEnabled(true);
            btnChatbot.setEnabled(true);
            btnVisualization.setEnabled(true);
            btnEncryptDecrypt.setEnabled(true);
            btnCredits.setEnabled(true);   
        }
    }

    FrmDashboard() {
        initComponents();
        setTitle("Dashboard");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btnQuiz = new javax.swing.JButton();
        btnVisualization = new javax.swing.JButton();
        btnChatbot = new javax.swing.JButton();
        btnEncryptDecrypt = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnCredits = new javax.swing.JButton();
        lblRole = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        exitBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(49, 55, 62));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        timeLabel.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setText("timeLabel");

        lblUser.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Welcome, user!");

        btnQuiz.setBackground(new java.awt.Color(66, 19, 80));
        btnQuiz.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        btnQuiz.setForeground(new java.awt.Color(255, 255, 255));
        btnQuiz.setText("Take Quiz");
        btnQuiz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 19, 80)));
        btnQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuizActionPerformed(evt);
            }
        });

        btnVisualization.setBackground(new java.awt.Color(41, 64, 91));
        btnVisualization.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        btnVisualization.setForeground(new java.awt.Color(255, 255, 255));
        btnVisualization.setText("<html><p align=\"center\"> Data<p/>Visualization</html>");
        btnVisualization.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 64, 91)));
        btnVisualization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizationActionPerformed(evt);
            }
        });

        btnChatbot.setBackground(new java.awt.Color(19, 28, 39));
        btnChatbot.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        btnChatbot.setForeground(new java.awt.Color(255, 255, 255));
        btnChatbot.setText("<html><p align=\"center\">Simple</p> Chatbot</html>");
        btnChatbot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 28, 39)));
        btnChatbot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatbotActionPerformed(evt);
            }
        });

        btnEncryptDecrypt.setBackground(new java.awt.Color(16, 55, 24));
        btnEncryptDecrypt.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        btnEncryptDecrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnEncryptDecrypt.setText("<html>Encryption <br> <p align=\"center\"> and </p> Decryption</html>");
        btnEncryptDecrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(16, 55, 24)));
        btnEncryptDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptDecryptActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(35, 36, 33));
        btnLogout.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Log out");
        btnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 36, 33)));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnCredits.setBackground(new java.awt.Color(25, 29, 34));
        btnCredits.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        btnCredits.setForeground(new java.awt.Color(255, 255, 255));
        btnCredits.setText("Credits");
        btnCredits.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 34)));
        btnCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditsActionPerformed(evt);
            }
        });

        lblRole.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setText("jLabel1");

        jPanel2.setBackground(new java.awt.Color(25, 29, 34));

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setBorder(null);
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FeatureHub");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBtn)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(exitBtn))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRole)
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblUser)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeLabel))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(btnChatbot, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(btnVisualization, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(btnEncryptDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(lblRole)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(timeLabel))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEncryptDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnChatbot, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVisualization, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        dispose();
                new FrmLogin().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuizActionPerformed
       
        FrmQuiz frmquiz = new FrmQuiz(username, role); // Pass logged-in username
        frmquiz.setVisible(true);
        this.setVisible(false); // Hide the dashbo
    
    }//GEN-LAST:event_btnQuizActionPerformed

    private void btnChatbotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatbotActionPerformed
       
        FrmChatbot frmchatbot = new FrmChatbot (username, role);
        frmchatbot.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnChatbotActionPerformed

    private void btnVisualizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizationActionPerformed
        FrmVisualization frmvisuals = new FrmVisualization(username, role);
        frmvisuals.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVisualizationActionPerformed

    private void btnCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditsActionPerformed
       FrmCredits frmcredits = new FrmCredits(username, role);
       frmcredits.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnCreditsActionPerformed

    private void btnEncryptDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptDecryptActionPerformed
        // TODO add your handling code here:
        FrmEncryption form = new FrmEncryption(username, role);
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEncryptDecryptActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChatbot;
    private javax.swing.JButton btnCredits;
    private javax.swing.JButton btnEncryptDecrypt;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnQuiz;
    private javax.swing.JButton btnVisualization;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
