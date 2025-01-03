/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package featurehub;

import java.awt.Toolkit;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author daved
 */

public class FrmQuiz extends javax.swing.JFrame {
    private List<String> resultSummary; // To store each question's result
    private List<Boolean> answerResults;

    private String username;
    private String role;
    private int timeLeft = 300; // 5 minutes in seconds
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;
    private int quizCount = 1;
    private Question[] questions;
    private Timer timer; // Declare the timer here as an instance variable
    private ButtonGroup group;
    // Declare the button and icons
    private ImageIcon defaultIcon;
    private ImageIcon hoverIcon;
    
    public FrmQuiz(String username, String role) {
        this.setUndecorated(true); // Removes the title bar
        
        this.answerResults = new ArrayList<>();
        this.group = new ButtonGroup();
        initComponents();
        this.resultSummary = new ArrayList<>(); // Initialize the result list
        this.username = username;
        this.role = role;
        loadQuestions();
        displayQuestion();
        startTimer();
        userLabel.setText("User Level: " + username);
        
        this.setLocationRelativeTo(null);
        
        setFullScreen(); // Set the frame into fullscreen
        
        // Load the Icons
        defaultIcon = new ImageIcon(getClass().getResource("/featurehub/Icons/ExitDefaultIcon.png"));  // Replace with your default icon path
        hoverIcon = new ImageIcon(getClass().getResource("/featurehub/Icons/ExitHoverIconChatbot.png")); // Replace with your hover icon path
        
        exitBtn.setIcon(defaultIcon);

        addHoverEffectToExitButton(); // Method to change the color of the exit button when you hover
      
        lblQuizCounter.setText(quizCount + " / 17");
        
        group.add(choice1);
        group.add(choice2);
        group.add(choice3);
        group.add(choice4);
        
        // Disable nextButton initially
        nextButton.setEnabled(false);

        // Enable nextButton when any choice is selected
        choice1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nextButton.setEnabled(true);
        }
    });

    choice2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nextButton.setEnabled(true);
        }
    });

    choice3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nextButton.setEnabled(true);
        }
    });

    choice4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            nextButton.setEnabled(true);
        }
    });
        
     // Ensure the frame or specific component has focus and can capture key events
    this.setFocusable(true);
    this.requestFocusInWindow();  // Ensure it has focus to listen to key events
    
    // Add the key listener to detect the Enter key
    this.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
            // Print a debug message to confirm key event is being captured
            System.out.println("Key pressed: " + evt.getKeyCode());  // Debug output

            // Check if Enter key was pressed
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                System.out.println("Enter key pressed");  // Debug output

                // Check if any answer is selected
                if (choice1.isSelected() || choice2.isSelected() || choice3.isSelected() || choice4.isSelected()) {
                    // Simulate button click by calling the method directly
                    nextButtonActionPerformed(null);  // null is passed as no actual event is fired
                } else {
                    JOptionPane.showMessageDialog(FrmQuiz.this, "Please select an answer before proceeding.");
                }
            }
        }
    });

    // Ensure that the frame is focused on startup
    this.requestFocusInWindow();  // Ensures the frame can capture key events
    }

    FrmQuiz() {
        this.answerResults = new ArrayList<>();
        this.group = new ButtonGroup();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    // Initialize timer
    private void startTimer(){
        
        timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                    timerLabel.setText("Time left: " + timeLeft + "s");
                } else {
                    endQuiz(); // End quiz when time is up
                }
            }

            
        });
    timer.start();
    
    
    }
    
    
    private void updateProgress() {
    String progress = "Question " + (currentQuestionIndex + 1) + " of " + questions.length;
    this.setTitle(progress);
}
    
     private void endQuiz() {
        if (timer != null) {
            timer.stop();
        }

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

        // Show detailed summary of results
        StringBuilder summary = new StringBuilder("Quiz Summary:\n\n");
        for (int i = 0; i < resultSummary.size(); i++) {
            summary.append(resultSummary.get(i)).append("\n");
        }
        
        // Add overall score at the end
        summary.append("\nTotal Score: ").append(correctAnswers).append("/17");
        
        // Show the detailed summary first
        JOptionPane.showMessageDialog(this, summary.toString(), 
            "Quiz Summary", JOptionPane.INFORMATION_MESSAGE);

        // Then show final score and remarks
        JOptionPane.showMessageDialog(this,
            "Quiz Finished!\n" +
            "Your Score: " + correctAnswers + "/17\n" +
            "Remarks: " + remarks);

        // Show recommendation
        showRecommendation(correctAnswers);

        // Ask for next steps
        int choice = JOptionPane.showOptionDialog(this,
                "Would you like to retry or return to the dashboard?",
                "Quiz Complete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Retry", "Dashboard"},
                "Retry");

        if (choice == JOptionPane.YES_OPTION) {
            resetQuiz();
        } else if (choice == JOptionPane.NO_OPTION) {
            this.setVisible(false);
            FrmDashboard frmdashboard = new FrmDashboard(username, role);
            frmdashboard.setVisible(true);
        }
    }

    private void resetQuiz() {
        currentQuestionIndex = 0;
        correctAnswers = 0;
        timeLeft = 300;
        quizCount = 1;  // Reset to 1 instead of 0
        answerResults.clear();
        resultSummary.clear();
        loadQuestions();
        displayQuestion();
        startTimer();
        lblQuizCounter.setText(quizCount + " / 17");
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
             // Get the current question
             Question currentQuestion = questions[currentQuestionIndex];

             // Set the question text and choices
             questionLabel.setText(currentQuestion.getQuestionText());
             choice1.setText(currentQuestion.getChoices()[0]);
             choice2.setText(currentQuestion.getChoices()[1]);
             choice3.setText(currentQuestion.getChoices()[2]);
             choice4.setText(currentQuestion.getChoices()[3]);

             // Clear the selection of the radio buttons
             group.clearSelection();

             // Disable the Next button until a choice is selected
             nextButton.setEnabled(false);

             // Update the progress display
             updateProgress();
         } else {
             endQuiz(); // End the quiz if no more questions
         }
}
    // Button actions for answers (you can attach this to all the choice buttons)
    private void checkAnswer(String selectedAnswer) {
        Question currentQuestion = questions[currentQuestionIndex];
        boolean isCorrect = selectedAnswer.equals(currentQuestion.getCorrectAnswer());
        
        // Add the result to both tracking mechanisms
        answerResults.add(isCorrect);
        resultSummary.add("Question " + (currentQuestionIndex + 1) + ": " + 
                         (isCorrect ? "Correct" : "Incorrect") + 
                         " (Your answer: " + selectedAnswer + 
                         ", Correct answer: " + currentQuestion.getCorrectAnswer() + ")");
        
        if (isCorrect) {
            correctAnswers++;
        }
        currentQuestionIndex++;
        
        if (currentQuestionIndex < questions.length) {
            displayQuestion();
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

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        choice1 = new javax.swing.JRadioButton();
        choice2 = new javax.swing.JRadioButton();
        choice3 = new javax.swing.JRadioButton();
        choice4 = new javax.swing.JRadioButton();
        timerLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        exitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblQuizCounter = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        questionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(27, 25, 34));

        backButton.setBackground(new java.awt.Color(49, 51, 126));
        backButton.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 51, 126)));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        choice1.setBackground(new java.awt.Color(55, 51, 71));
        choice1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        choice1.setForeground(new java.awt.Color(255, 255, 255));
        choice1.setText("Choice 1");
        choice1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 51, 71), 1, true));

        choice2.setBackground(new java.awt.Color(55, 51, 71));
        choice2.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        choice2.setForeground(new java.awt.Color(255, 255, 255));
        choice2.setText("Choice 2");
        choice2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 51, 71), 1, true));

        choice3.setBackground(new java.awt.Color(55, 51, 71));
        choice3.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        choice3.setForeground(new java.awt.Color(255, 255, 255));
        choice3.setText("Choice 3");
        choice3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 51, 71), 1, true));

        choice4.setBackground(new java.awt.Color(55, 51, 71));
        choice4.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        choice4.setForeground(new java.awt.Color(255, 255, 255));
        choice4.setText("Choice 4");
        choice4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 51, 71), 1, true));

        timerLabel.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(255, 255, 255));
        timerLabel.setText("timerLabel");

        nextButton.setBackground(new java.awt.Color(66, 19, 80));
        nextButton.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next");
        nextButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 19, 80)));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        userLabel.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setText("userLabel");

        jPanel2.setBackground(new java.awt.Color(66, 19, 80));

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setBorder(null);
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FeatureHub | Quiz");

        lblQuizCounter.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        lblQuizCounter.setForeground(new java.awt.Color(255, 255, 255));
        lblQuizCounter.setText("1 / 20");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuizCounter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBtn)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exitBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblQuizCounter))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(27, 25, 34));

        questionLabel.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        questionLabel.setForeground(new java.awt.Color(255, 255, 255));
        questionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionLabel.setText("What is 2*2?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(655, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(questionLabel)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timerLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(choice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choice1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
                        .addGap(269, 269, 269)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(userLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timerLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choice1)
                    .addComponent(choice3))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choice2)
                    .addComponent(choice4))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(nextButton))
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
              
        // Check if no option is selected
         if (!choice1.isSelected() && !choice2.isSelected() && !choice3.isSelected() && !choice4.isSelected()) {
             JOptionPane.showMessageDialog(this, "Please select an answer before proceeding.");
             return; // Prevent moving to the next question
         }

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

         // Increment quiz counter only if we haven't reached the end
         if (currentQuestionIndex < questions.length) {
             quizCount++;
             lblQuizCounter.setText(quizCount + " / 17");
             displayQuestion();
         }

         // If we've reached the last question (after checking the answer)
         if (currentQuestionIndex >= questions.length) {
             endQuiz();
         }
    }//GEN-LAST:event_nextButtonActionPerformed

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
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblQuizCounter;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
