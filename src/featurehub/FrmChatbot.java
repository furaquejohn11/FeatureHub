/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package featurehub;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

/**
 *
 * @author daved
 */
public class FrmChatbot extends javax.swing.JFrame {
     private final String chatbotName = "DeptBot";
    
    private final Map<String, String> responseMap; // Store predefined responses
    private final String username;
    private final String role;
    
     private final String[] suggestions;
     private String suggestion;
              
    /**
     * Creates new form ChatbotFrame
     * 
     * @param username
     * @param role
     */
    
    public FrmChatbot(String username, String role) {
        this.suggestion = "";
        this.suggestions = new String[]{"Ano ang mga produkto?", "Magkano ang mga sapatos?", "Saan ang inyong lokasyon?", "May mga promo ba?", "Puwede bang mag-ibaliko ng produkto?", "Anong mga electronics ang mayroon kayo?"};
        this.username = username;
        this.role = role;
        this.responseMap = initializeResponses();
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Chatbot - Department Store");
        this.setSize(665,531); // Explicitly set size
        conversationArea.setEditable(false);
        conversationArea.setColumns(20);
        conversationArea.setFont(new java.awt.Font("Tahoma", 0, 24)); // Font size and style
        conversationArea.setRows(5);
        conversationArea.setLineWrap(true); // Enable line wrapping
        conversationArea.setWrapStyleWord(true); // Wrap at word boundaries
        jScrollPane1.setViewportView(conversationArea);

        // Start conversation
        addConversation(chatbotName, "Kumusta! Ako si DeptBot, ang iyong gabay sa department store. Ano ang maitutulong ko sa iyo?");
           
       
     
    }
    
    
  
    // Initialize chatbot responses  
private Map<String, String> initializeResponses() {  
    Map<String, String> map = new HashMap<>();  
    map.put("ano ang mga produkto", "Mayroon kaming malawak na hanay ng mga produkto tulad ng damit (simula PHP 199), sapatos (simula PHP 499), gamit sa bahay, electronics, groceries, at iba pa. May partikular ka bang hinahanap?");  
    map.put("magkano", "Depende po sa produkto. Halimbawa, ang t-shirts ay nagsisimula sa PHP 199, ang mga sports shoes ay PHP 999 pataas, at ang mga appliances tulad ng blender ay PHP 1,500. May nais ka bang malaman ang presyo?");  
    map.put("anong oras bukas", "Ang aming store ay bukas mula Lunes hanggang Linggo, 9:00 AM hanggang 9:00 PM. Mainam na pumunta sa umaga para iwas sa pila!");  
    map.put("saan ang lokasyon", "Makikita ang aming department store sa gitna ng lungsod, malapit sa San Pablo City Plaza. Hanapin lamang ang aming malaking signage!");  
    map.put("paano mag-return", "Ang produkto ay maaaring ibalik o i-exchange sa loob ng 7 araw, basta't may resibo at nasa maayos pa itong kondisyon. Halimbawa, ang damit na hindi akma ang sukat ay maaaring palitan basta't hindi pa nagamit.");  
    map.put("tumatanggap ba ng return", "Oo, tumatanggap kami ng returns. Siguraduhin lamang na may resibo ka. Ang mga nasirang electronics ay maaaring palitan kung sakop pa ito ng warranty.");  
    map.put("may sale ba", "Oo! May sale kami ngayong linggo. Halimbawa, ang LED TVs ay may hanggang 30% discount, at ang t-shirts ay may 'Buy 1 Take 1' promo.");  
    map.put("ano ang promo ngayon", "May mga ongoing promo kami! Ang 'Buy 1 Take 1' sa casual wear at 20% off sa kitchen appliances ay sulit na sulit!");  
    map.put("anong klaseng damit ang meron", "Mayroon kaming t-shirts (simula PHP 199), dresses (simula PHP 499), at jackets (simula PHP 799). Maraming estilo at kulay ang mapagpipilian!");  
    map.put("may sapatos ba", "Oo, mayroon kaming sapatos simula PHP 499. May sports shoes (PHP 999), leather shoes (PHP 1,499), at sandals (PHP 399). Siguradong magugustuhan mo ang kalidad!");  
    map.put("may gamit ba sa bahay", "Oo, mayroon! Ang mga kitchen tools ay nagsisimula sa PHP 149. Ang rice cooker ay nasa PHP 1,199, at vacuum cleaner ay PHP 2,999. Meron ding bundle offers!");  
    map.put("paano ang bayaran", "Tumatanggap kami ng cash, credit card, debit card, at GCash. Para sa installment plans, puwedeng gamitin ang credit card mo para sa appliances.");  
    map.put("ano ang contact number", "Ang aming contact number ay (02) 123-4567. Maaari ka rin mag-email sa support@deptstore.com para sa iba pang tanong.");  
    map.put("sino ang pwedeng tumulong", "Ang aming customer service desk ay handang tumulong sa anumang kailangan mo. Pumunta lamang sa information counter.");  
    map.put("may tulong ba", "Oo, nandito kami para tumulong. Pumunta lamang sa information counter kung may katanungan o kailangan ng assistance.");  
    map.put("salamat", "Walang anuman! Maraming salamat din sa pagtangkilik sa aming department store. Balik ka ulit!");  
    map.put("hello", "Hello! Ano po ang maitutulong ko? May hinahanap ka bang partikular?");  
    map.put("may grocery ba", "Oo, mayroon kaming groceries. Halimbawa, ang apples ay PHP 120/kilo, ang carrots ay PHP 80/kilo, at ang canned goods ay nagsisimula sa PHP 25.");  
    map.put("anong electronics ang meron", "Marami kaming electronics tulad ng cellphones (simula PHP 4,999), laptops (simula PHP 15,000), at LED TVs na may hanggang 30% discount. Lahat ay may warranty!");  
    map.put("may food court ba", "Oo! May food court kami sa ground floor na nag-aalok ng fried chicken meals (PHP 99), rice bowls (PHP 89), at desserts (PHP 50). Tamang-tama para sa shopping break!");  
    map.put("may parking ba", "Oo, may libreng parking para sa mga customers. Siguraduhing magpakita ng resibo bago umalis.");  
    map.put("may bagong products", "May mga bagong dating kaming trendy dresses sa PHP 699 at smart home devices tulad ng smart plugs sa PHP 799.");  
    map.put("paano makarating", "Madaling puntahan ang aming store! Malapit kami sa San Pablo City Plaza, at may libreng parking para sa mga customers.");  
    map.put("ano ang presyo ng blender", "Ang mga blender ay nagsisimula sa PHP 1,500. Meron ding mas advanced models na nagkakahalaga ng PHP 2,999.");  
    map.put("may promo ba sa damit", "Oo, ang aming casual wear ay may 'Buy 1 Take 1' promo. Siguraduhing ma-check ang bagong koleksyon!");  
    map.put("pwede ba mag-inquire", "Oo naman! Tawagan kami sa (02) 123-4567 o mag-email sa support@deptstore.com. Bukas kami mula 9:00 AM hanggang 9:00 PM.");  
    map.put("ano ang sale ngayon", "Ngayong linggo, ang mga LED TVs ay may 30% discount, at ang Buy 1 Take 1 promo ay available sa t-shirts.");  
    return map;  
}

     // Process user input
    private void processUserInput() {
        String userInput = userInputField.getText().trim().toLowerCase();
        if (userInput.isEmpty()) {
            return; // Ignore empty input
        }

        // Add user input to conversation area
        addConversation(username, userInput);

        // Generate chatbot response
        String botResponse = getBotResponse(userInput);
        addConversation(chatbotName, botResponse);

        // Clear input field
        userInputField.setText("");
    }

       // Add conversation text
    private void addConversation(String sender, String message) {
        conversationArea.append(sender + ": " + message + "\n");
    }

    // Get chatbot response
   private String getBotResponse(String userInput) {
    userInput = userInput.trim().toLowerCase(); // Sanitize input
    for (Map.Entry<String, String> entry : responseMap.entrySet()) {
        if (userInput.matches(".*\\b" + entry.getKey() + "\\b.*")) { // Exact word match
            return entry.getValue();
        }
    }
    return "Pasensya na, hindi ko maintindihan ang iyong tanong. Maaari bang ulitin o gawing mas detalyado?";
}

    
    


    private FrmChatbot() {
        this.suggestion = "";
        this.suggestions = new String[]{"Ano ang mga produkto?", "Magkano ang mga sapatos?", "Saan ang inyong lokasyon?", "May mga promo ba?", "Puwede bang mag-ibaliko ng produkto?", "Anong mga electronics ang mayroon kayo?"};
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jScrollPane1 = new javax.swing.JScrollPane();
        conversationArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        userInputField = new javax.swing.JTextField();
        suggestionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        backButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        conversationArea.setEditable(false);
        conversationArea.setColumns(20);
        conversationArea.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        conversationArea.setRows(5);
        jScrollPane1.setViewportView(conversationArea);

        sendButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        userInputField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputFieldActionPerformed(evt);
            }
        });

        suggestionButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        suggestionButton.setText("Chat suggestions");
        suggestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suggestionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(suggestionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sendButton)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                            .addComponent(userInputField))
                        .addGap(0, 37, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendButton)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(backButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(suggestionButton)))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);  // Hide the current frame
        new FrmDashboard(username, role).setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
            processUserInput();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void userInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputFieldActionPerformed
         processUserInput();
    }//GEN-LAST:event_userInputFieldActionPerformed

    private void suggestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suggestionButtonActionPerformed
        // Create a modal dialog to display suggestions
    final javax.swing.JDialog suggestionsDialog = new javax.swing.JDialog(this, "Suggestions", true);
    suggestionsDialog.setSize(400, 300);
    suggestionsDialog.setLocationRelativeTo(this);

    // Create a list model and populate it with keys from responseMap
    javax.swing.DefaultListModel<String> listModel = new javax.swing.DefaultListModel<>();
    for (String key : responseMap.keySet()) {
        listModel.addElement(key);
    }

    // Create a JList to display the suggestions
    final javax.swing.JList<String> suggestionsList = new javax.swing.JList<>(listModel);
    suggestionsList.setFont(new java.awt.Font("Tahoma", 0, 16));

    // Add the JList to a scroll pane
    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(suggestionsList);

    // Add a button to select a suggestion
    javax.swing.JButton selectButton = new javax.swing.JButton("Select");
    selectButton.setFont(new java.awt.Font("Tahoma", 0, 16));

    // Add an action listener for the button
    selectButton.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String selectedSuggestion = suggestionsList.getSelectedValue();
            if (selectedSuggestion != null) {
                userInputField.setText(selectedSuggestion); // Set the selected suggestion in the input field
                suggestionsDialog.dispose(); // Close the dialog
            }
        }
    });

    // Add components to the dialog
    javax.swing.JPanel dialogPanel = new javax.swing.JPanel();
    dialogPanel.setLayout(new java.awt.BorderLayout());
    dialogPanel.add(scrollPane, java.awt.BorderLayout.CENTER);
    dialogPanel.add(selectButton, java.awt.BorderLayout.SOUTH);

    suggestionsDialog.add(dialogPanel);
    suggestionsDialog.setVisible(true);
    }//GEN-LAST:event_suggestionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FrmChatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmChatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmChatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmChatbot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmChatbot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea conversationArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton suggestionButton;
    private javax.swing.JTextField userInputField;
    // End of variables declaration//GEN-END:variables
}
