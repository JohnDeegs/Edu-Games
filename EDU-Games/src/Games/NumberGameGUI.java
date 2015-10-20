package Games;

import UserData.UserData;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import user_Interface.HomeGUI;
import user_Interface.JuniorAndSeniorGameSeletionGUI;
import user_Interface.Leaderboard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import user_Interface.RateGUI;

public class NumberGameGUI extends javax.swing.JFrame {

    public UserData myUser = new UserData();

    private NumberGameGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setUserData(UserData player) {
        this.myUser = player;
    }

    int score;

    //DB conncetion
    Connection conn;
    String url = "jdbc:mysql://sql3.freemysqlhosting.net/";
    String db = "sql368113";
    String driver = "com.mysql.jdbc.Driver";
    String user = "sql368113";
    String pass = "qG9*eZ8*";

    public NumberGameGUI(UserData player) {
        score = 0;
        initComponents();
        setLocationRelativeTo(null);

        this.myUser = player;

        //hide checkboxes
        check1.setVisible(false);
        check2.setVisible(false);
        check3.setVisible(false);
        check4.setVisible(false);
        check5.setVisible(false);
        wrong1.setVisible(false);
        wrong2.setVisible(false);
        wrong3.setVisible(false);
        wrong4.setVisible(false);
        wrong5.setVisible(false);

        //accessing DB on cloud
        try {
            // connect to db here stated above
            conn = DriverManager.getConnection(url + db, user, pass);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
    }

    public void endGame() {
        JOptionPane.showMessageDialog(null, "You scored: " + score + " out of 5\nGame Over");

        JuniorAndSeniorGameSeletionGUI mySecectionGUI = new JuniorAndSeniorGameSeletionGUI(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Q1 = new javax.swing.JLabel();
        Q2 = new javax.swing.JLabel();
        Q3 = new javax.swing.JLabel();
        Q4 = new javax.swing.JLabel();
        Q5 = new javax.swing.JLabel();
        A1 = new javax.swing.JTextField();
        A2 = new javax.swing.JTextField();
        A3 = new javax.swing.JTextField();
        A4 = new javax.swing.JTextField();
        A5 = new javax.swing.JTextField();
        check1 = new javax.swing.JLabel();
        check2 = new javax.swing.JLabel();
        check3 = new javax.swing.JLabel();
        check4 = new javax.swing.JLabel();
        check5 = new javax.swing.JLabel();
        wrong1 = new javax.swing.JLabel();
        wrong2 = new javax.swing.JLabel();
        wrong3 = new javax.swing.JLabel();
        wrong4 = new javax.swing.JLabel();
        wrong5 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        backBtn2 = new javax.swing.JButton();
        HomeBtm = new javax.swing.JButton();
        leaderBtn = new javax.swing.JButton();
        infoBtn = new javax.swing.JButton();
        rateBtn = new javax.swing.JButton();
        InfoSoundBtn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        Q1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Q1.setText("5      +           =      9");
        getContentPane().add(Q1);
        Q1.setBounds(250, 150, 440, 60);

        Q2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Q2.setText("7              2    =      5");
        getContentPane().add(Q2);
        Q2.setBounds(250, 220, 440, 60);

        Q3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Q3.setText("2       +     4    =      ");
        getContentPane().add(Q3);
        Q3.setBounds(250, 280, 440, 60);

        Q4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Q4.setText("         +     6    =    16");
        getContentPane().add(Q4);
        Q4.setBounds(250, 340, 440, 60);

        Q5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Q5.setText("10     -     9     =      ");
        getContentPane().add(Q5);
        Q5.setBounds(250, 410, 440, 60);

        A1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        A1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(A1);
        A1.setBounds(410, 150, 59, 60);

        A2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        A2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(A2);
        A2.setBounds(330, 220, 59, 60);

        A3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        A3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(A3);
        A3.setBounds(570, 280, 59, 60);

        A4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        A4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(A4);
        A4.setBounds(240, 340, 59, 60);

        A5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        A5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(A5);
        A5.setBounds(570, 400, 59, 60);

        check1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(check1);
        check1.setBounds(680, 140, 50, 60);

        check2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(check2);
        check2.setBounds(680, 220, 50, 60);

        check3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(check3);
        check3.setBounds(680, 280, 50, 60);

        check4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(check4);
        check4.setBounds(680, 340, 50, 60);

        check5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(check5);
        check5.setBounds(680, 410, 50, 60);

        wrong1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox-wrong.png"))); // NOI18N
        getContentPane().add(wrong1);
        wrong1.setBounds(680, 140, 50, 60);

        wrong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox-wrong.png"))); // NOI18N
        getContentPane().add(wrong2);
        wrong2.setBounds(680, 220, 50, 60);

        wrong3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox-wrong.png"))); // NOI18N
        getContentPane().add(wrong3);
        wrong3.setBounds(680, 290, 50, 60);

        wrong4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox-wrong.png"))); // NOI18N
        getContentPane().add(wrong4);
        wrong4.setBounds(680, 350, 50, 60);

        wrong5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox-wrong.png"))); // NOI18N
        getContentPane().add(wrong5);
        wrong5.setBounds(680, 410, 50, 60);

        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/submitBtn.png"))); // NOI18N
        submitBtn.setBorderPainted(false);
        submitBtn.setContentAreaFilled(false);
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn);
        submitBtn.setBounds(360, 470, 210, 90);

        backBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backBtn.png"))); // NOI18N
        backBtn2.setBorderPainted(false);
        backBtn2.setContentAreaFilled(false);
        backBtn2.setMaximumSize(new java.awt.Dimension(85, 32));
        backBtn2.setMinimumSize(new java.awt.Dimension(85, 32));
        backBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn2);
        backBtn2.setBounds(100, 0, 100, 40);

        HomeBtm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/homeBtn.png"))); // NOI18N
        HomeBtm.setBorderPainted(false);
        HomeBtm.setContentAreaFilled(false);
        HomeBtm.setMaximumSize(new java.awt.Dimension(85, 32));
        HomeBtm.setMinimumSize(new java.awt.Dimension(85, 32));
        HomeBtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtmActionPerformed(evt);
            }
        });
        getContentPane().add(HomeBtm);
        HomeBtm.setBounds(0, 0, 100, 40);

        leaderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/leaderb.png"))); // NOI18N
        leaderBtn.setBorderPainted(false);
        leaderBtn.setContentAreaFilled(false);
        leaderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBtnActionPerformed(evt);
            }
        });
        getContentPane().add(leaderBtn);
        leaderBtn.setBounds(180, 520, 120, 40);

        infoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/infoBtn.png"))); // NOI18N
        infoBtn.setBorderPainted(false);
        infoBtn.setContentAreaFilled(false);
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(infoBtn);
        infoBtn.setBounds(610, 520, 90, 40);

        rateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rateb.png"))); // NOI18N
        rateBtn.setBorderPainted(false);
        rateBtn.setContentAreaFilled(false);
        rateBtn.setMaximumSize(new java.awt.Dimension(53, 23));
        rateBtn.setMinimumSize(new java.awt.Dimension(53, 23));
        rateBtn.setPreferredSize(new java.awt.Dimension(53, 23));
        rateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(rateBtn);
        rateBtn.setBounds(770, 520, 90, 40);

        InfoSoundBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/microphone.png"))); // NOI18N
        InfoSoundBtn1.setMaximumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn1.setMinimumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn1.setPreferredSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoSoundBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(InfoSoundBtn1);
        InfoSoundBtn1.setBounds(60, 500, 50, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/numberBk.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        System.out.println("gg");
        if (A1.getText().equals("4")) {
            check1.setVisible(true);
            score++;
        } else {
            wrong1.setVisible(true);
        }
        if (A2.getText().equals("-")) {
            check2.setVisible(true);
            score++;
        } else {
            wrong2.setVisible(true);
        }
        if (A3.getText().equals("6")) {
            check3.setVisible(true);
            score++;
        } else {
            wrong3.setVisible(true);
        }
        if (A4.getText().equals("10")) {
            check4.setVisible(true);
            score++;
        } else {
            wrong4.setVisible(true);
        }
        if (A5.getText().equals("1")) {
            check5.setVisible(true);
            score++;
        } else {
            wrong5.setVisible(true);
        }

        updateScore(score);
        System.out.println("score: " + score);
        endGame();
    }//GEN-LAST:event_submitBtnActionPerformed

    //home button
    private void HomeBtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtmActionPerformed
        HomeGUI myHome = new HomeGUI(myUser);
        myHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeBtmActionPerformed

    private void backBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn2ActionPerformed
        JuniorAndSeniorGameSeletionGUI mySecectionGUI = new JuniorAndSeniorGameSeletionGUI(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtn2ActionPerformed

    private void leaderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBtnActionPerformed
        Leaderboard numberLeader = new Leaderboard(2);
        numberLeader.setVisible(true);
    }//GEN-LAST:event_leaderBtnActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        JOptionPane.showMessageDialog(null, "Math can be fun!!\nFill in the blanks with the correct maths symbol", "Hint!!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoBtnActionPerformed

    private void rateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateBtnActionPerformed
        RateGUI myRateGUI = new RateGUI();
        myRateGUI.setVisible(true);
    }//GEN-LAST:event_rateBtnActionPerformed

    private void InfoSoundBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoSoundBtn1ActionPerformed
        try {
            // open the sound file as a Java input stream

            String audioFilePath = "src\\InfoSounds\\numberGame.wav";
            InputStream in = new FileInputStream(audioFilePath);

            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(in);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);
        } catch (Exception e) {
            //Error Handeling
            System.out.println("Audio error: " + e);

        }
    }//GEN-LAST:event_InfoSoundBtn1ActionPerformed

    //instances and variables used in following updateScore method which connects to DB
    DBManager connectionManager = new DBManager();
    //storing users unique name and id , these will correspond to values in the DB, stored in userDAta class
    int uID;

    public void updateScore(int score) {
        uID = myUser.getUser_id();
        connectionManager.setConnection(conn);
        //select all fields from game scroe for only the currently logged in player and the game they are playing
        //and store results in resultset
        ResultSet rs = connectionManager.Select_Query("select * from gameScore where user_id = " + uID + " AND GameID = 2;");
        ResultSet getCoins = connectionManager.Select_Query("select * from users where user_id = " + uID);

        try { //used to add coins if player gets 100%
            if (getCoins.next()) {
                int oldCoins = getCoins.getInt("coins");
                if (score == 5) {

                    int newCoins = oldCoins + 10;
                    connectionManager.Update_Query("UPDATE users SET coins = " + newCoins + " WHERE user_id = " + uID + ";");
                }
            }
            if (rs.next()) {
                //get the previous score on this game for this specific user
                int oldScore = rs.getInt("Score");
                //if oldscore is less than new score thenn we update DB to the new score
                if (oldScore < score) {
                    connectionManager.Update_Query("UPDATE gameScore SET score = " + score + " WHERE GameID = 2 AND user_id = " + uID + ";");
                } //0nce your dont get the same score twice in a row do following
                else if (score != oldScore) {
                    JOptionPane.showMessageDialog(null, "Not bad, but not as good as your high score of " + oldScore);
                }
            } else {
                //else if this particular user has not played this game before we insert new data 
                connectionManager.Update_Query("insert into gameScore values(" + 2 + ","
                        + "" + "'Numbers Game'" + "," + uID + "," + score + ");");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GeographyGameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectionManager.closeConnection();
    }

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
            java.util.logging.Logger.getLogger(NumberGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumberGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumberGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumberGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumberGameGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField A1;
    private javax.swing.JTextField A2;
    private javax.swing.JTextField A3;
    private javax.swing.JTextField A4;
    private javax.swing.JTextField A5;
    private javax.swing.JButton HomeBtm;
    private javax.swing.JButton InfoSoundBtn1;
    private javax.swing.JLabel Q1;
    private javax.swing.JLabel Q2;
    private javax.swing.JLabel Q3;
    private javax.swing.JLabel Q4;
    private javax.swing.JLabel Q5;
    private javax.swing.JButton backBtn2;
    private javax.swing.JLabel check1;
    private javax.swing.JLabel check2;
    private javax.swing.JLabel check3;
    private javax.swing.JLabel check4;
    private javax.swing.JLabel check5;
    private javax.swing.JButton infoBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton leaderBtn;
    private javax.swing.JButton rateBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel wrong1;
    private javax.swing.JLabel wrong2;
    private javax.swing.JLabel wrong3;
    private javax.swing.JLabel wrong4;
    private javax.swing.JLabel wrong5;
    // End of variables declaration//GEN-END:variables
}