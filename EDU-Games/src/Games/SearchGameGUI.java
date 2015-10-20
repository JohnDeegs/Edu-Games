package Games;

import UserData.UserData;
import user_Interface.FirstAndSecondGameSelection;
import user_Interface.HomeGUI;
import user_Interface.Leaderboard;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import user_Interface.RateGUI;

public class SearchGameGUI extends javax.swing.JFrame {

    public UserData myUser = new UserData();

    private SearchGameGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setUserData(UserData player) {
        this.myUser = player;
    }

    Connection conn;
    String url = "jdbc:mysql://sql3.freemysqlhosting.net/";
    String db = "sql368113";
    String driver = "com.mysql.jdbc.Driver";
    String user = "sql368113";
    String pass = "qG9*eZ8*";

    int score;

    public SearchGameGUI(UserData player) {
        initComponents();
        setLocationRelativeTo(null);

        this.myUser = player;

        //hide all checkboxes
        tresureCb.setVisible(false);
        snakeCb.setVisible(false);
        birdCb.setVisible(false);
        samuraiCb.setVisible(false);
        ladderCb.setVisible(false);
        score = 0;

        try {
            // connect to db here stated above
            conn = DriverManager.getConnection(url + db, user, pass);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
    }

    public void endGame() {

        //end game if all items are found, return to previous screen
        if (tresureCb.isVisible() && snakeCb.isVisible() && birdCb.isVisible() && samuraiCb.isVisible() && ladderCb.isVisible()) {

            updateScore(score);

            FirstAndSecondGameSelection mySecectionGUI = new FirstAndSecondGameSelection(myUser);
            mySecectionGUI.setVisible(true);
            this.dispose();
        }
    }

    //accessing DB manager class where update and select querys are run from
    DBManager connectionManager = new DBManager();
    int uID;

    public void updateScore(int score) {
        uID = myUser.getUser_id();
        connectionManager.setConnection(conn);
        //select all fields from game scroe for only the currently logged in player and the game they are playing
        //and store results in resultset GameID is hardcoded into DB 5 = search game
        ResultSet rs = connectionManager.Select_Query("select * from gameScore where user_id = " + uID + " AND GameID = 5;");
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
                    connectionManager.Update_Query("UPDATE gameScore SET score = " + score + " WHERE GameID = 5 AND user_id = " + uID + ";");
                    JOptionPane.showMessageDialog(null, "You scored: " + score + "\nWell done new high score\nGame Over");
                } //0nce your dont get the same score twice in a row do following
                else if (score != oldScore) {
                    JOptionPane.showMessageDialog(null, "You scored: " + score + "\nGame Over\nNot bad, but not as good as your high score of " + oldScore);
                } else if (score == oldScore) {
                    JOptionPane.showMessageDialog(null, "You scored " + score + " again");
                }
            } else {
                //else if this particular user has not played this game before we insert new data 
                connectionManager.Update_Query("insert into gameScore values(" + 5 + ","
                        + "" + "'Search Game'" + "," + uID + "," + score + ");");
                JOptionPane.showMessageDialog(null, "You scored: " + score + " out of 5 \nGame Over");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchGameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLabel();
        treasureLbl = new javax.swing.JLabel();
        tresureCb = new javax.swing.JLabel();
        tresureBtn = new javax.swing.JToggleButton();
        snakeLbl = new javax.swing.JLabel();
        snakeCb = new javax.swing.JLabel();
        snakeBtn = new javax.swing.JToggleButton();
        birdLbl = new javax.swing.JLabel();
        birdCb = new javax.swing.JLabel();
        birdBtn = new javax.swing.JToggleButton();
        samuraiLbl = new javax.swing.JLabel();
        samuraiCb = new javax.swing.JLabel();
        samuraiBtn = new javax.swing.JToggleButton();
        ladderLbl = new javax.swing.JLabel();
        ladderCb = new javax.swing.JLabel();
        ladderBtn = new javax.swing.JToggleButton();
        homeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        finishBtn = new javax.swing.JButton();
        leaderBtn = new javax.swing.JButton();
        infoBtn = new javax.swing.JButton();
        rateBtn = new javax.swing.JButton();
        InfoSoundBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Playground.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(190, 0, 710, 575);

        treasureLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        treasureLbl.setForeground(new java.awt.Color(255, 255, 255));
        treasureLbl.setText("Treasure chest");
        getContentPane().add(treasureLbl);
        treasureLbl.setBounds(10, 210, 110, 14);

        tresureCb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(tresureCb);
        tresureCb.setBounds(130, 180, 50, 50);

        tresureBtn.setToolTipText("");
        tresureBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresureBtnActionPerformed(evt);
            }
        });
        getContentPane().add(tresureBtn);
        tresureBtn.setBounds(690, 353, 30, 30);

        snakeLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        snakeLbl.setForeground(new java.awt.Color(255, 255, 255));
        snakeLbl.setText("A snake");
        getContentPane().add(snakeLbl);
        snakeLbl.setBounds(10, 250, 110, 14);

        snakeCb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(snakeCb);
        snakeCb.setBounds(130, 230, 50, 50);

        snakeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snakeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(snakeBtn);
        snakeBtn.setBounds(590, 540, 40, 20);

        birdLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        birdLbl.setForeground(new java.awt.Color(255, 255, 255));
        birdLbl.setText("A bird");
        getContentPane().add(birdLbl);
        birdLbl.setBounds(10, 310, 110, 14);

        birdCb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(birdCb);
        birdCb.setBounds(130, 280, 50, 50);

        birdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birdBtnActionPerformed(evt);
            }
        });
        getContentPane().add(birdBtn);
        birdBtn.setBounds(250, 260, 30, 20);

        samuraiLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        samuraiLbl.setForeground(new java.awt.Color(255, 255, 255));
        samuraiLbl.setText("A samurai");
        getContentPane().add(samuraiLbl);
        samuraiLbl.setBounds(10, 360, 110, 14);

        samuraiCb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(samuraiCb);
        samuraiCb.setBounds(130, 330, 50, 50);

        samuraiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                samuraiBtnActionPerformed(evt);
            }
        });
        getContentPane().add(samuraiBtn);
        samuraiBtn.setBounds(790, 210, 40, 70);

        ladderLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ladderLbl.setForeground(new java.awt.Color(255, 255, 255));
        ladderLbl.setText("Yellow ladder");
        getContentPane().add(ladderLbl);
        ladderLbl.setBounds(10, 400, 110, 14);

        ladderCb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checkbox.png"))); // NOI18N
        getContentPane().add(ladderCb);
        ladderCb.setBounds(130, 380, 50, 50);

        ladderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ladderBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ladderBtn);
        ladderBtn.setBounds(450, 150, 40, 70);

        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/homeBtn.png"))); // NOI18N
        homeBtn.setBorderPainted(false);
        homeBtn.setContentAreaFilled(false);
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(homeBtn);
        homeBtn.setBounds(0, 0, 90, 40);

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backBtn.png"))); // NOI18N
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setMaximumSize(new java.awt.Dimension(85, 32));
        backBtn.setMinimumSize(new java.awt.Dimension(85, 32));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn);
        backBtn.setBounds(90, 0, 90, 40);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(240, 240, 240));
        jTextField1.setText("Click on a...");
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(10, 170, 150, 21);

        finishBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finish.png"))); // NOI18N
        finishBtn.setBorderPainted(false);
        finishBtn.setContentAreaFilled(false);
        finishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishBtnActionPerformed(evt);
            }
        });
        getContentPane().add(finishBtn);
        finishBtn.setBounds(20, 430, 90, 40);

        leaderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/leaderb.png"))); // NOI18N
        leaderBtn.setBorderPainted(false);
        leaderBtn.setContentAreaFilled(false);
        leaderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBtnActionPerformed(evt);
            }
        });
        getContentPane().add(leaderBtn);
        leaderBtn.setBounds(30, 50, 120, 39);

        infoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/infoBtn.png"))); // NOI18N
        infoBtn.setBorderPainted(false);
        infoBtn.setContentAreaFilled(false);
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(infoBtn);
        infoBtn.setBounds(20, 530, 90, 40);

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
        rateBtn.setBounds(20, 480, 90, 40);

        InfoSoundBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/microphone.png"))); // NOI18N
        InfoSoundBtn.setMaximumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn.setMinimumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn.setPreferredSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoSoundBtnActionPerformed(evt);
            }
        });
        getContentPane().add(InfoSoundBtn);
        InfoSoundBtn.setBounds(130, 480, 50, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchG.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //making sure than only one click counts as a score, 
    int clickcounter1 = 0;
    int clickcounter2 = 0;
    int clickcounter3 = 0;
    int clickcounter4 = 0;
    int clickcounter5 = 0;

    //show checkboxes when they find an item
    private void tresureBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresureBtnActionPerformed
        tresureBtn.setVisible(false);
        tresureCb.setVisible(true);

        if (clickcounter1 == 0) {
            score++;
        }
        clickcounter1++;
        endGame();
    }//GEN-LAST:event_tresureBtnActionPerformed

    private void snakeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snakeBtnActionPerformed
        snakeBtn.setVisible(false);
        snakeCb.setVisible(true);

        if (clickcounter2 == 0) {
            score++;
        }
        clickcounter2++;
        endGame();

    }//GEN-LAST:event_snakeBtnActionPerformed

    private void birdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birdBtnActionPerformed
        birdBtn.setVisible(false);
        birdCb.setVisible(true);

        if (clickcounter3 == 0) {
            score++;
        }
        clickcounter3++;
        endGame();
    }//GEN-LAST:event_birdBtnActionPerformed

    private void samuraiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_samuraiBtnActionPerformed
        samuraiBtn.setVisible(false);
        samuraiCb.setVisible(true);

        if (clickcounter4 == 0) {
            score++;
        }
        clickcounter4++;
        endGame();
    }//GEN-LAST:event_samuraiBtnActionPerformed

    private void ladderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ladderBtnActionPerformed
        ladderBtn.setVisible(false);
        ladderCb.setVisible(true);

        if (clickcounter5 == 0) {
            score++;
        }
        clickcounter5++;
        endGame();
    }//GEN-LAST:event_ladderBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        HomeGUI myHome = new HomeGUI(myUser);
        myHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        FirstAndSecondGameSelection mySecectionGUI = new FirstAndSecondGameSelection(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void finishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishBtnActionPerformed

        updateScore(score);
        //leave game
        FirstAndSecondGameSelection mySecectionGUI = new FirstAndSecondGameSelection(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_finishBtnActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        JOptionPane.showMessageDialog(null, "Find all the pieces to finish the Game\nThe Game ends automatically when all pieces are found\nOr you can give up at any time by clicking the finish button!", "Hint!!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoBtnActionPerformed

    private void leaderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBtnActionPerformed
        Leaderboard searchLeader = new Leaderboard(5);
        searchLeader.setVisible(true);
    }//GEN-LAST:event_leaderBtnActionPerformed

    private void rateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateBtnActionPerformed
        RateGUI myRateGUI = new RateGUI();
        myRateGUI.setVisible(true);
    }//GEN-LAST:event_rateBtnActionPerformed

    private void InfoSoundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoSoundBtnActionPerformed
        try {
            // open the sound file as a Java input stream

            String audioFilePath = "src\\InfoSounds\\searchGame.wav";
            InputStream in = new FileInputStream(audioFilePath);

            // create an audiostream from the inputstream
            AudioStream audioStream = new AudioStream(in);

            // play the audio clip with the audioplayer class
            AudioPlayer.player.start(audioStream);
        } catch (Exception e) {
            //Error Handeling
            System.out.println("Audio error: " + e);

        }
    }//GEN-LAST:event_InfoSoundBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SearchGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchGameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchGameGUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InfoSoundBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel background;
    private javax.swing.JToggleButton birdBtn;
    private javax.swing.JLabel birdCb;
    private javax.swing.JLabel birdLbl;
    private javax.swing.JButton finishBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton infoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton ladderBtn;
    private javax.swing.JLabel ladderCb;
    private javax.swing.JLabel ladderLbl;
    private javax.swing.JButton leaderBtn;
    private javax.swing.JButton rateBtn;
    private javax.swing.JToggleButton samuraiBtn;
    private javax.swing.JLabel samuraiCb;
    private javax.swing.JLabel samuraiLbl;
    private javax.swing.JToggleButton snakeBtn;
    private javax.swing.JLabel snakeCb;
    private javax.swing.JLabel snakeLbl;
    private javax.swing.JLabel treasureLbl;
    private javax.swing.JToggleButton tresureBtn;
    private javax.swing.JLabel tresureCb;
    // End of variables declaration//GEN-END:variables
}