/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package featurehub;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author daved
 */
public class FrmChatbot extends javax.swing.JFrame {
     private final String chatbotName = "DeptBot";
    
    private final Map<String, String> responseMap; // Store predefined responses
    private String username;
              
    /**
     * Creates new form ChatbotFrame
     * 
     * @param username
     */
    
    public FrmChatbot(String username) {
       this.username = username;
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
    map.put("ano ang mga produkto", "Mayroon kaming malawak na pagpipilian ng mga produkto tulad ng damit (simula PHP 199), sapatos (simula PHP 499), gamit sa bahay, electronics, groceries, at marami pang iba. May specific ka bang hinahanap?");  
    map.put("magkano", "Depende po ito sa produkto. Halimbawa, ang t-shirts ay nagsisimula sa PHP 199, ang mga sports shoes ay PHP 999 pataas, at ang mga appliances tulad ng blender ay nasa PHP 1,500. Ano po ang nais mong malaman ang presyo?");  
    map.put("oras", "Ang aming store ay bukas mula Lunes hanggang Linggo, 9:00 AM hanggang 9:00 PM. Magandang bumisita sa umaga para iwas sa pila!");  
    map.put("lokasyon", "Ang aming department store ay matatagpuan sa gitna ng siyudad, malapit sa pangunahing parke. Malapit kami sa San Pablo City Plaza. Hanapin mo ang malaking signage namin!");  
    map.put("return", "Walang problema! Ang produkto ay maaaring ibalik o i-exchange sa loob ng 7 araw, basta’t kumpleto ang resibo at nasa maayos pa itong kondisyon. Halimbawa, ang damit na hindi tama ang sukat ay maaaring palitan basta hindi pa ito nagamit.");  
    map.put("ibalik", "Oo, tinatanggap namin ang returns. Siguraduhin lamang na mayroon kang resibo. Ang mga nasirang electronics ay maaaring palitan basta’t covered pa ng warranty.");  
    map.put("sale", "Excited ka ba sa sale? May malaking discount kami ngayong linggo! Halimbawa, ang LED TVs ay may discount na hanggang 30% off, at ang Buy 1 Take 1 promo namin para sa mga t-shirts ay available na.");  
    map.put("promo", "May mga ongoing promo kami! Siguraduhin mong makita ang aming 'Buy 1 Take 1' deals sa mga casual wear at 20% off sa kitchen appliances. Sulit ang shopping mo ngayong linggo!");  
    map.put("damit", "Ang aming clothing section ay may mga bagong t-shirts na nagsisimula sa PHP 199, dresses na nasa PHP 499 pataas, at jackets na PHP 799. Maraming style na mapagpipilian!");  
    map.put("sapatos", "Ang aming sapatos ay nagsisimula sa PHP 499. May sports shoes (PHP 999), leather shoes (PHP 1,499), at sandals (PHP 399). Siguradong magugustuhan mo ang quality!");  
    map.put("gamit sa bahay", "Ang gamit sa bahay ay nagsisimula sa PHP 149 para sa kitchen tools. Ang mga appliances tulad ng rice cooker ay nasa PHP 1,199, habang ang vacuum cleaner ay PHP 2,999. May mga bundle offers din kami!");  
    map.put("babayaran", "Tumatanggap kami ng cash, credit card, debit card, at GCash. Para sa installment plans, maaari rin sa mga appliances kung may credit card ka.");  
    map.put("contact number", "Kung may iba ka pang tanong, tawagan mo kami sa (02) 123-4567 o mag-email sa support@deptstore.com.");  
    map.put("numero", "Ang aming contact number ay (02) 123-4567. Bukas kami para sagutin ang iyong mga tanong mula 9:00 AM hanggang 9:00 PM.");  
    map.put("help", "Kung kailangan mo ng tulong, bisitahin ang aming customer service desk. Friendly ang aming staff na handang tumulong sa iyo!");  
    map.put("tulong", "Nandito lang kami para tumulong. Pumunta lang sa aming information counter kung kailangan mo ng assistance.");  
    map.put("thank you", "Walang anuman! Salamat din sa pagtangkilik sa aming department store. Balik ka ulit!");  
    map.put("salamat", "Salamat din! Nandito lang ako palagi kung may iba kang tanong.");  
    map.put("hello", "Hello! Paano kita matutulungan ngayon? May hinahanap ka bang partikular?");  
    map.put("grocery", "Para sa grocery needs mo, may sariwang prutas at gulay kami. Halimbawa, ang apples ay nasa PHP 120/kilo, carrots PHP 80/kilo, at canned goods ay nagsisimula sa PHP 25.");  
    map.put("electronic", "Kung electronics ang hanap mo, ang mga cellphone ay nagsisimula sa PHP 4,999, laptops sa PHP 15,000, at LED TVs ay may promo na hanggang 30% off. May warranty din lahat ng items!");  
    map.put("paano makarating", "Madali lang kaming puntahan! Malapit kami sa San Pablo City Plaza. May libreng parking para sa mga customers.");  
    map.put("may food court ba", "Oo! May food court kami sa ground floor na may mga pagkain tulad ng fried chicken meals (PHP 99), rice bowls (PHP 89), at desserts (PHP 50). Perfect para sa shopping break!");  
    map.put("may libreng parking", "Oo, mayroon kaming libreng parking space para sa mga customers. Siguraduhin lamang na may resibo ka bago umalis.");  
    map.put("bagong products", "May bagong dating kaming koleksyon tulad ng trendy dresses sa PHP 699 at mga smart home devices tulad ng smart plugs sa PHP 799.");  
    map.put("balik kaagad", "Salamat sa pagtangkilik! Kung may ibang tanong ka, huwag kang mag-atubiling magtanong ulit.");  
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
        // Check if user input matches any keyword
        for (Map.Entry<String, String> entry : responseMap.entrySet()) {
            if (userInput.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        // Default response if no match is found
        return "Pasensya na, hindi ko maintindihan ang iyong tanong. Maaari bang ulitin o gawing mas detalyado?";
    }



    private FrmChatbot() {
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                .addGap(27, 27, 27)
                .addComponent(backButton)
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
        new FrmDashboard(username).setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
            processUserInput();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void userInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputFieldActionPerformed
         processUserInput();
    }//GEN-LAST:event_userInputFieldActionPerformed

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
    private javax.swing.JTextField userInputField;
    // End of variables declaration//GEN-END:variables
}
