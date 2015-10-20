package user_Interface;

import UserData.UserData;

public class FoodTipsGUI extends javax.swing.JFrame {

    public UserData myUser = new UserData();

    public FoodTipsGUI(UserData player) {
        initComponents();
        setLocationRelativeTo(null);

        this.myUser = player;
    }

    private FoodTipsGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        homeLbl = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        imageLbl2 = new javax.swing.JLabel();
        imageLbl3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        homeLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/homeBtnGrey.png"))); // NOI18N
        homeLbl.setBorderPainted(false);
        homeLbl.setContentAreaFilled(false);
        homeLbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeLblActionPerformed(evt);
            }
        });
        jPanel1.add(homeLbl);
        homeLbl.setBounds(0, 0, 90, 40);

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backBtnGrey.png"))); // NOI18N
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn);
        backBtn.setBounds(90, 0, 90, 40);

        jTextArea2.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Few kids crave a fiber-rich meal. But fiber is filling and when combined with drinking plenty of water, helps prevent constipation. A high-fiber food has 5 grams or more of fiber per serving and a “good” source of fiber is one that provides 2.5 to 4.9 grams per serving. Some fiber-friendly foods include cooked navy beans (9.6 grams of fiber for ½ cup), a medium baked sweet potato with skin (3.8 grams) and bran flakes (5.3 grams).");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(250, 210, 630, 100);

        jTextArea3.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("There are creative tactics you can employ to make sure your child is getting plenty of calcium. Add low-fat cheese to meals and snacks: put Cheddar in an omelet; add a slice of cheese to sandwiches; create mini pizzas by topping whole-wheat English muffins with pizza sauce and part-skim mozzarella; make grilled cheese sandwiches appealing by using cookie cutters to create fun shapes.");
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(jTextArea3);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(250, 420, 630, 100);

        imageLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sweetpotatoes.png"))); // NOI18N
        imageLbl2.setMaximumSize(new java.awt.Dimension(200, 200));
        imageLbl2.setMinimumSize(new java.awt.Dimension(200, 200));
        imageLbl2.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel1.add(imageLbl2);
        imageLbl2.setBounds(50, 200, 170, 130);

        imageLbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/panini.png"))); // NOI18N
        imageLbl3.setMaximumSize(new java.awt.Dimension(200, 200));
        imageLbl3.setMinimumSize(new java.awt.Dimension(200, 200));
        imageLbl3.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel1.add(imageLbl3);
        imageLbl3.setBounds(50, 410, 170, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nightBk.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeLblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeLblActionPerformed
        HomeGUI myHome = new HomeGUI(myUser);
        myHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeLblActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        ParentSelectionGUI parentGUI = new ParentSelectionGUI(myUser);
        parentGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FoodTipsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodTipsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodTipsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodTipsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodTipsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton homeLbl;
    private javax.swing.JLabel imageLbl2;
    private javax.swing.JLabel imageLbl3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}