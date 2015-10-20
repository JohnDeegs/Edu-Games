package user_Interface;

import Games.ColourGUI;
import Games.MatchUpGUI;
import Games.NumberGameGUI;
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

public class JuniorAndSeniorGameSeletionGUI extends javax.swing.JFrame {

    MatchUpGUI myMatchGame;
    ColourGUI myColourGame;
    NumberGameGUI myNumGUI;

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

    public JuniorAndSeniorGameSeletionGUI(UserData player) {
        initComponents();

        setLocationRelativeTo(null);
        this.myUser = player;

        AvailableTa.setVisible(false);

        //get name for start of database connection
        uName = myUser.getName();

        try {
            // connect to db here stated above
            conn = DriverManager.getConnection(url + db, user, pass);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }

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
    }

    private JuniorAndSeniorGameSeletionGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void getPlayer() {
        try {

            Statement st = conn.createStatement();
            ResultSet rs1 = st.executeQuery("select * from users WHERE name = '" + uName + "';");
            if (rs1.next()) {
                myUser.setCoins(rs1.getInt("coins"));

            } else {
                System.out.println("error test 1");
            }

        } catch (SQLException ex) {
            Logger.getLogger(JuniorAndSeniorGameSeletionGUI.class.getName()).log(Level.SEVERE, null, ex);
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

        JuniorSeniorBtnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        selectionLbl = new javax.swing.JLabel();
        matchUpRbtn = new javax.swing.JRadioButton();
        coloursRbtn = new javax.swing.JRadioButton();
        numbersRbtn = new javax.swing.JRadioButton();
        launchBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        ProfileBtn = new javax.swing.JButton();
        avatarLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        coinsPicLbl = new javax.swing.JLabel();
        coinsLbl = new javax.swing.JLabel();
        AvailableTa = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(null);

        selectionLbl.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        selectionLbl.setText("Select one game and press \"LAUNCH GAME\" to begin");
        jPanel1.add(selectionLbl);
        selectionLbl.setBounds(250, 120, 450, 32);

        JuniorSeniorBtnGroup.add(matchUpRbtn);
        matchUpRbtn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        matchUpRbtn.setText("Match Up");
        matchUpRbtn.setOpaque(false);
        matchUpRbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchUpRbtnActionPerformed(evt);
            }
        });
        jPanel1.add(matchUpRbtn);
        matchUpRbtn.setBounds(380, 200, 140, 29);

        JuniorSeniorBtnGroup.add(coloursRbtn);
        coloursRbtn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        coloursRbtn.setText("Colours");
        coloursRbtn.setOpaque(false);
        coloursRbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coloursRbtnActionPerformed(evt);
            }
        });
        jPanel1.add(coloursRbtn);
        coloursRbtn.setBounds(380, 300, 130, 29);

        JuniorSeniorBtnGroup.add(numbersRbtn);
        numbersRbtn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        numbersRbtn.setText("Numbers");
        numbersRbtn.setOpaque(false);
        numbersRbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numbersRbtnActionPerformed(evt);
            }
        });
        jPanel1.add(numbersRbtn);
        numbersRbtn.setBounds(380, 250, 140, 29);

        launchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LAUNCHbtn.png"))); // NOI18N
        launchBtn.setBorderPainted(false);
        launchBtn.setContentAreaFilled(false);
        launchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(launchBtn);
        launchBtn.setBounds(380, 400, 180, 90);

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
        homeBtn.setBounds(0, 0, 85, 32);

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backBtn.png"))); // NOI18N
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setDefaultCapable(false);
        backBtn.setMaximumSize(new java.awt.Dimension(85, 32));
        backBtn.setMinimumSize(new java.awt.Dimension(85, 32));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn);
        backBtn.setBounds(90, 0, 85, 32);

        ProfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profileB.png"))); // NOI18N
        ProfileBtn.setBorderPainted(false);
        ProfileBtn.setContentAreaFilled(false);
        ProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ProfileBtn);
        ProfileBtn.setBounds(760, 70, 120, 39);

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

        AvailableTa.setBackground(new java.awt.Color(102, 255, 204));
        AvailableTa.setColumns(20);
        AvailableTa.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        AvailableTa.setLineWrap(true);
        AvailableTa.setRows(5);
        AvailableTa.setText("Coins available in this game!");
        AvailableTa.setWrapStyleWord(true);
        AvailableTa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(AvailableTa);
        AvailableTa.setBounds(600, 250, 170, 20);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Checking which radio button is selected and then launching apropriate game
    private void launchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchBtnActionPerformed
        if (matchUpRbtn.isSelected()) {
            myMatchGame = new MatchUpGUI(myUser);
            myMatchGame.setVisible(true);
        } else if (coloursRbtn.isSelected()) {
            myColourGame = new ColourGUI(myUser);
            myColourGame.setVisible(true);
        } else {
            myNumGUI = new NumberGameGUI(myUser);
            myNumGUI.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_launchBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        HomeGUI myHome = new HomeGUI(myUser);
        myHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        ChildAgeSelectionGUI mySecectionGUI = new ChildAgeSelectionGUI(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void coloursRbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coloursRbtnActionPerformed
        AvailableTa.setVisible(true);
    }//GEN-LAST:event_coloursRbtnActionPerformed

    private void ProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileBtnActionPerformed
        if (uName.equals("Guest")) {
            JOptionPane.showMessageDialog(null, "You must be logged in to access profile");
        } else {
            Profile selectionGUI = new Profile(myUser);
            selectionGUI.setUserData(myUser);
            selectionGUI.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ProfileBtnActionPerformed

    private void numbersRbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numbersRbtnActionPerformed
        AvailableTa.setVisible(true);
    }//GEN-LAST:event_numbersRbtnActionPerformed

    private void matchUpRbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchUpRbtnActionPerformed
        AvailableTa.setVisible(false);
    }//GEN-LAST:event_matchUpRbtnActionPerformed

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
            java.util.logging.Logger.getLogger(JuniorAndSeniorGameSeletionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuniorAndSeniorGameSeletionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuniorAndSeniorGameSeletionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuniorAndSeniorGameSeletionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuniorAndSeniorGameSeletionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AvailableTa;
    private javax.swing.ButtonGroup JuniorSeniorBtnGroup;
    private javax.swing.JButton ProfileBtn;
    private javax.swing.JLabel avatarLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel coinsLbl;
    private javax.swing.JLabel coinsPicLbl;
    private javax.swing.JRadioButton coloursRbtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton launchBtn;
    private javax.swing.JRadioButton matchUpRbtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JRadioButton numbersRbtn;
    private javax.swing.JLabel selectionLbl;
    // End of variables declaration//GEN-END:variables
}