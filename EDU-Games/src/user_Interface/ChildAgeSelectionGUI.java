package user_Interface;

import UserData.UserData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public final class ChildAgeSelectionGUI extends javax.swing.JFrame {

    //Setting up connection details
    public UserData myUser = new UserData();

    // for avatar image
    ImageIcon image;
    String avatar;
    String uName;

    //DB conncetion
    Connection conn;
    String url = "jdbc:mysql://sql3.freemysqlhosting.net/";
    String db = "sql368113";
    String driver = "com.mysql.jdbc.Driver";
    String user = "sql368113";
    String pass = "qG9*eZ8*";

    //initlilizer
    public ChildAgeSelectionGUI(UserData player) {
        initComponents();
        setLocationRelativeTo(null);
        this.myUser = player;

        //get name for start of database connection
        uName = myUser.getName();

        try {
            // connect to db here stated above
            conn = DriverManager.getConnection(url + db, user, pass);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }

        //get player details from the database
        getPlayer();

        //set name
        nameLbl.setText(uName);

        //set avatar
        avatar = myUser.getAvatar();
        image = new ImageIcon(avatar);
        avatarLbl.setIcon(image);

        //set coins
        int coins = myUser.getCoins();
        String CoinTxt = String.valueOf(coins);
        coinsLbl.setText(CoinTxt + " coins");
    }//end constructor

    public void getPlayer() {
        try {

            Statement st = conn.createStatement();
            ResultSet rs1 = st.executeQuery("select * from users WHERE name = '" + uName + "';");
            if (rs1.next()) {
                myUser.setName(rs1.getString("name"));
                myUser.setUser_id(rs1.getInt("user_id"));
                myUser.setAvatar(rs1.getString("avatar"));
                myUser.setCoins(rs1.getInt("coins"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChildAgeSelectionGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ChildAgeSelectionGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setUserData(UserData player) {
        this.myUser = player;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JuniorSeniourClass = new javax.swing.JButton();
        FirstSecondClass = new javax.swing.JButton();
        ThirdFourthClass = new javax.swing.JButton();
        ProfileBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        avatarLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        coinsPicLbl = new javax.swing.JLabel();
        coinsLbl = new javax.swing.JLabel();
        leaderBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(null);

        JuniorSeniourClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ageSelButtonTempl.png"))); // NOI18N
        JuniorSeniourClass.setBorderPainted(false);
        JuniorSeniourClass.setContentAreaFilled(false);
        JuniorSeniourClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JuniorSeniourClassActionPerformed(evt);
            }
        });
        jPanel1.add(JuniorSeniourClass);
        JuniorSeniourClass.setBounds(100, 270, 180, 90);

        FirstSecondClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ageSel1stButtonTempl.png"))); // NOI18N
        FirstSecondClass.setBorderPainted(false);
        FirstSecondClass.setContentAreaFilled(false);
        FirstSecondClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstSecondClassActionPerformed(evt);
            }
        });
        jPanel1.add(FirstSecondClass);
        FirstSecondClass.setBounds(380, 260, 180, 100);

        ThirdFourthClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ageSel3rdButtonTempl.png"))); // NOI18N
        ThirdFourthClass.setBorderPainted(false);
        ThirdFourthClass.setContentAreaFilled(false);
        ThirdFourthClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThirdFourthClassActionPerformed(evt);
            }
        });
        jPanel1.add(ThirdFourthClass);
        ThirdFourthClass.setBounds(650, 270, 180, 84);

        ProfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profileB.png"))); // NOI18N
        ProfileBtn.setBorderPainted(false);
        ProfileBtn.setContentAreaFilled(false);
        ProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ProfileBtn);
        ProfileBtn.setBounds(760, 70, 120, 40);

        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/homeBtn.png"))); // NOI18N
        homeBtn.setBorderPainted(false);
        homeBtn.setContentAreaFilled(false);
        homeBtn.setMaximumSize(new java.awt.Dimension(85, 32));
        homeBtn.setMinimumSize(new java.awt.Dimension(85, 32));
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        jPanel1.add(homeBtn);
        homeBtn.setBounds(0, 0, 90, 40);

        avatarLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guest.png"))); // NOI18N
        jPanel1.add(avatarLbl);
        avatarLbl.setBounds(670, 0, 80, 100);

        nameLbl.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        nameLbl.setText("Name");
        jPanel1.add(nameLbl);
        nameLbl.setBounds(760, 10, 120, 21);

        coinsPicLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/coins.png"))); // NOI18N
        jPanel1.add(coinsPicLbl);
        coinsPicLbl.setBounds(760, 30, 30, 30);

        coinsLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(coinsLbl);
        coinsLbl.setBounds(800, 34, 70, 20);

        leaderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/leaderb.png"))); // NOI18N
        leaderBtn.setBorderPainted(false);
        leaderBtn.setContentAreaFilled(false);
        leaderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBtnActionPerformed(evt);
            }
        });
        jPanel1.add(leaderBtn);
        leaderBtn.setBounds(760, 543, 120, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ageSel.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 900, 600);

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

    private void JuniorSeniourClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JuniorSeniourClassActionPerformed
        JuniorAndSeniorGameSeletionGUI selectionGUI = new JuniorAndSeniorGameSeletionGUI(myUser);
        selectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JuniorSeniourClassActionPerformed

    private void FirstSecondClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstSecondClassActionPerformed
        FirstAndSecondGameSelection selectionGUI = new FirstAndSecondGameSelection(myUser);
        selectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_FirstSecondClassActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        HomeGUI myHome = new HomeGUI(myUser);
        myHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void ThirdFourthClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThirdFourthClassActionPerformed
        ThirdAndForthGameSeletionGUI selectionGUI = new ThirdAndForthGameSeletionGUI(myUser);
        selectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ThirdFourthClassActionPerformed

    private void ProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileBtnActionPerformed
        if (uName.equals("Guest")) {
            JOptionPane.showMessageDialog(null, "You must be logged in to access profile");

        } else {
            Profile selectionGUI = new Profile(myUser);
            selectionGUI.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ProfileBtnActionPerformed

    private void leaderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBtnActionPerformed
        LeaderboardOverall Leader = new LeaderboardOverall();
        Leader.setVisible(true);
    }//GEN-LAST:event_leaderBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ChildAgeSelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChildAgeSelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChildAgeSelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChildAgeSelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChildAgeSelectionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FirstSecondClass;
    private javax.swing.JButton JuniorSeniourClass;
    private javax.swing.JButton ProfileBtn;
    private javax.swing.JButton ThirdFourthClass;
    private javax.swing.JLabel avatarLbl;
    private javax.swing.JLabel coinsLbl;
    private javax.swing.JLabel coinsPicLbl;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leaderBtn;
    private javax.swing.JLabel nameLbl;
    // End of variables declaration//GEN-END:variables
}