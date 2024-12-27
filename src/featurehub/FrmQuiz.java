/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package featurehub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author daved
 */

public class FrmQuiz extends javax.swing.JFrame {
    private String username;
    private String role;
    private int timeLeft = 300; // 5 minutes in seconds
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;
    private Question[] questions;
    private Timer timer; // Declare the timer here as an instance variable
    
    public FrmQuiz(String username, String role) {
        initComponents();
        this.username = username;
        this.role = role;
        loadQuestions();
        displayQuestion();
        startTimer();
        this.setLocationRelativeTo(null);
       userLabel.setText(username);
      
        
        ButtonGroup group = new ButtonGroup();
        group.add(choice1);
        group.add(choice2);
        group.add(choice3);
        group.add(choice4);
        
    }

    FrmQuiz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // Initialize timer
    private void startTimer(){
        
        timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                    timerLabel.setText("Time left: " + timeLeft + "s");
                } else {
                   // endQuiz(); // End quiz when time is up
                }
            }

            
        });
    timer.start();
    
    
    }
    private void endQuiz() {
    // Stop the timer
    if (timer != null) {
        timer.stop();
    }

    // Calculate remarks based on the score
    String remarks = "";
    if (correctAnswers >= 15) {
        remarks = "Excellent";
    } else if (correctAnswers >= 12) {
        remarks = "Very Good";
    } else if (correctAnswers >= 9) {
        remarks = "Fair";
    } else {
        remarks = "Failed";
    }

    // Show results
    JOptionPane.showMessageDialog(this,
        "Quiz Finished!\n" +
        "Your Score: " + correctAnswers + "/17\n" +
        "Remarks: " + remarks);
    
    // Show recommendation
    showRecommendation(correctAnswers);

    // Ask the user if they want to retake the quiz or go back to the dashboard
    int choice = JOptionPane.showOptionDialog(this,
        "Do you want to retake the quiz or go back to the dashboard?",
        "Quiz Finished",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        new Object[] {"Retake Quiz", "Back to Dashboard"},
        "Retake Quiz");

    if (choice == JOptionPane.YES_OPTION) {
        // Retake the quiz: reset the quiz
        resetQuiz();
    } else if (choice == JOptionPane.NO_OPTION) {
        // Go back to the dashboard: close the current frame and show the dashboard
        this.setVisible(false);
        FrmDashboard frmdashboard = new FrmDashboard(username, role); // Assuming you have a DashboardFrame class
        frmdashboard.setVisible(true);
    }
}
  private void resetQuiz() {
    // Reset quiz variables
    currentQuestionIndex = 0;
    correctAnswers = 0;
    timeLeft = 300; // Reset to 5 minutes (300 seconds)
    
    // Reload questions if needed (if it's not already stored in a static variable)
    loadQuestions();
    
    // Restart the timer
    startTimer();
    
    // Display the first question
    displayQuestion();
}

    // Show a recommendation based on score
private void showRecommendation(int score) {
    String recommendation = "";
    if (score >= 15) {
        recommendation = "Keep up the great work!";
    } else if (score >= 12) {
        recommendation = "Good job, but there's room for improvement.";
    } else {
        recommendation = "Review the material and try again.";
    }
    JOptionPane.showMessageDialog(this, recommendation);
}

    
    
    // Create an array of questions
private void loadQuestions() {
    questions = new Question[] {
        new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, "4"),
        new Question("What is 3 * 3?", new String[]{"6", "7", "8", "9"}, "9"),
        new Question("What is 5 - 3?", new String[]{"1", "2", "3", "4"}, "2"),
        new Question("What is 6 / 2?", new String[]{"1", "2", "3", "4"}, "3"),
        new Question("What is 7 + 8?", new String[]{"14", "15", "16", "17"}, "15"),
        new Question("What is 12 / 4?", new String[]{"2", "3", "4", "5"}, "3"),
        new Question("What is 9 * 5?", new String[]{"45", "50", "55", "60"}, "45"),
        new Question("What is 18 - 7?", new String[]{"10", "11", "12", "13"}, "11"),
        new Question("What is 15 / 3?", new String[]{"3", "4", "5", "6"}, "5"),
        new Question("What is 10 * 2?", new String[]{"15", "18", "20", "25"}, "20"),
        new Question("What is 11 + 6?", new String[]{"15", "16", "17", "18"}, "17"),
        new Question("What is 8 * 7?", new String[]{"50", "54", "56", "60"}, "56"),
        new Question("What is 100 / 10?", new String[]{"9", "10", "11", "12"}, "10"),
        new Question("What is 14 - 6?", new String[]{"7", "8", "9", "10"}, "8"),
        new Question("What is 4 * 4?", new String[]{"12", "14", "16", "18"}, "16"),
        new Question("What is 20 / 4?", new String[]{"4", "5", "6", "7"}, "5"),
        new Question("What is 3 + 15?", new String[]{"16", "17", "18", "19"}, "18")
    };
}

    // Display current question
    private void displayQuestion() {
        if (currentQuestionIndex < questions.length) {
            Question currentQuestion = questions[currentQuestionIndex];
            questionLabel.setText(currentQuestion.getQuestionText());
            choice1.setText(currentQuestion.getChoices()[0]);
            choice2.setText(currentQuestion.getChoices()[1]);
            choice3.setText(currentQuestion.getChoices()[2]);
            choice4.setText(currentQuestion.getChoices()[3]);
        } else {
           // endQuiz(); // End the quiz after all questions
        }
    }
    // Button actions for answers (you can attach this to all the choice buttons)
    private void checkAnswer(String selectedAnswer) {
        String correctAnswer = questions[currentQuestionIndex].getCorrectAnswer();
        if (selectedAnswer.equals(correctAnswer)) {
            correctAnswers++;
        }
        currentQuestionIndex++;
        displayQuestion(); // Move to next question
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
        backButton = new javax.swing.JButton();
        choice1 = new javax.swing.JRadioButton();
        choice2 = new javax.swing.JRadioButton();
        choice3 = new javax.swing.JRadioButton();
        choice4 = new javax.swing.JRadioButton();
        questionLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        backButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        choice1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        choice1.setText("Choice 1");

        choice2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        choice2.setText("Choice 2");

        choice3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        choice3.setText("Choice 3");

        choice4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        choice4.setText("Choice 4");

        questionLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        questionLabel.setForeground(new java.awt.Color(255, 255, 255));
        questionLabel.setText("questionLabel");

        timerLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(255, 255, 255));
        timerLabel.setText("timerLabel");

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        userLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setText("userLabel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addComponent(nextButton)
                .addGap(102, 102, 102))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(questionLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(choice2)
                                .addComponent(choice3)
                                .addComponent(choice4)
                                .addComponent(choice1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
                        .addComponent(timerLabel)))
                .addGap(116, 116, 116))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timerLabel)
                    .addComponent(questionLabel))
                .addGap(18, 18, 18)
                .addComponent(userLabel)
                .addGap(4, 4, 4)
                .addComponent(choice1)
                .addGap(18, 18, 18)
                .addComponent(choice2)
                .addGap(18, 18, 18)
                .addComponent(choice3)
                .addGap(18, 18, 18)
                .addComponent(choice4)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(backButton))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);  // Hide the current frame
        FrmDashboard frmdashboard = new FrmDashboard(username, role);
        frmdashboard.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // Check if there are more questions to answer
        if (currentQuestionIndex < questions.length) {
            // Check selected answer
            if (choice1.isSelected()) {
                checkAnswer(choice1.getText());
            } else if (choice2.isSelected()) {
                checkAnswer(choice2.getText());
            } else if (choice3.isSelected()) {
                checkAnswer(choice3.getText());
            } else if (choice4.isSelected()) {
                checkAnswer(choice4.getText());
            }

            // Move to next question
            displayQuestion();
        } else {
            // End the quiz if there are no more questions
            endQuiz();
        }
    }//GEN-LAST:event_nextButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FrmQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQuiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JRadioButton choice1;
    private javax.swing.JRadioButton choice2;
    private javax.swing.JRadioButton choice3;
    private javax.swing.JRadioButton choice4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
