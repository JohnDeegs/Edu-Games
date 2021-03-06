package Games;

import UserData.UserData;
import user_Interface.HomeGUI;
import user_Interface.Leaderboard;
import user_Interface.ThirdAndForthGameSeletionGUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import user_Interface.RateGUI;

public class HangmanGUI extends javax.swing.JFrame implements ActionListener {

    public UserData myUser = new UserData();

    private HangmanGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setUserData(UserData player) {
        this.myUser = player;
    }

    //DB conncetion
    Connection conn;
    String url = "jdbc:mysql://sql3.freemysqlhosting.net/";
    String db = "sql368113";
    String driver = "com.mysql.jdbc.Driver";
    String user = "sql368113";
    String pass = "qG9*eZ8*";

    //variables
    public Word_HangmanGUI_Helper currentWord;
    public WordRepository_HangmanGUI_Helper wordBank;
    public char[] wordCharArray;
    public char[] displayArray;
    JButton[] buttonArray = new JButton[26];
    public String guessedLetters;
    public int lettersRemaining;
    public int misses;
    public int score;
    int wrong = 7;
    String missesTxt;

    public HangmanGUI(UserData player) {
        initComponents();
        setLocationRelativeTo(null);

        this.myUser = player;
        System.out.println(myUser.getUser_id());

        //create an instance of the word bank so we can get words to play our game
        wordBank = new WordRepository_HangmanGUI_Helper();

        //initialize the game
        initilizeGame();

        try {
            // connect to db here stated above
            conn = DriverManager.getConnection(url + db, user, pass);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
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

        generatedWordLBL = new javax.swing.JTextField();
        icon_playerStatus = new javax.swing.JLabel();
        lbl_Category = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        homeBtn = new javax.swing.JButton();
        playAgainBtn = new javax.swing.JButton();
        missesLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnB = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnF = new javax.swing.JButton();
        btnG = new javax.swing.JButton();
        btnH = new javax.swing.JButton();
        btnI = new javax.swing.JButton();
        btnJ = new javax.swing.JButton();
        btnK = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        btnN = new javax.swing.JButton();
        btnO = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        btnQ = new javax.swing.JButton();
        btnR = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnT = new javax.swing.JButton();
        btnU = new javax.swing.JButton();
        btnV = new javax.swing.JButton();
        btnW = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnY = new javax.swing.JButton();
        btnZ = new javax.swing.JButton();
        backBtn2 = new javax.swing.JButton();
        progresslbl = new javax.swing.JLabel();
        infoBtn = new javax.swing.JButton();
        rateBtn1 = new javax.swing.JButton();
        InfoSoundBtn = new javax.swing.JButton();
        leaderBtn = new javax.swing.JLabel();
        lbl_lettersUsed = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman");
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        generatedWordLBL.setEditable(false);
        generatedWordLBL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        generatedWordLBL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(generatedWordLBL);
        generatedWordLBL.setBounds(130, 150, 286, 41);

        icon_playerStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(icon_playerStatus);
        icon_playerStatus.setBounds(610, 70, 200, 190);

        lbl_Category.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_Category.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Category.setText("CATEGORY:");
        getContentPane().add(lbl_Category);
        lbl_Category.setBounds(130, 100, 286, 30);

        jPanel2.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel2.setLayout(null);

        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/homeBtn.png"))); // NOI18N
        homeBtn.setBorderPainted(false);
        homeBtn.setContentAreaFilled(false);
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        jPanel2.add(homeBtn);
        homeBtn.setBounds(0, 0, 90, 33);

        playAgainBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/playaBtm.png"))); // NOI18N
        playAgainBtn.setBorderPainted(false);
        playAgainBtn.setContentAreaFilled(false);
        playAgainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainBtnActionPerformed(evt);
            }
        });
        jPanel2.add(playAgainBtn);
        playAgainBtn.setBounds(380, 480, 190, 90);

        missesLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        missesLbl.setText("7");
        jPanel2.add(missesLbl);
        missesLbl.setBounds(280, 210, 30, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/leaderb.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(190, 520, 120, 40);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnB.setText("B");

        btnA.setText("A");

        btnC.setText("C");

        btnD.setText("D");

        btnE.setText("E");

        btnF.setText("F");

        btnG.setText("G");

        btnH.setText("H");

        btnI.setText("I");

        btnJ.setText("J");

        btnK.setText("K");

        btnM.setText("M");

        btnL.setText("L");

        btnN.setText("N");

        btnO.setText("O");

        btnP.setText("P");

        btnQ.setText("Q");

        btnR.setText("R");

        btnS.setText("S");

        btnT.setText("T");

        btnU.setText("U");

        btnV.setText("V");

        btnW.setText("W");

        btnX.setText("X");

        btnY.setText("Y");

        btnZ.setText("Z");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnC))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnU)
                            .addComponent(btnM))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnG)
                        .addGap(14, 14, 14)
                        .addComponent(btnH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnJ))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnT))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnZ)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnO, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnU, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnY, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(120, 280, 657, 185);

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
        jPanel2.add(backBtn2);
        backBtn2.setBounds(100, 0, 90, 33);

        progresslbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        progresslbl.setText("Guesses left:");
        jPanel2.add(progresslbl);
        progresslbl.setBounds(140, 220, 130, 22);

        infoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/infoBtn.png"))); // NOI18N
        infoBtn.setBorderPainted(false);
        infoBtn.setContentAreaFilled(false);
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });
        jPanel2.add(infoBtn);
        infoBtn.setBounds(640, 520, 100, 40);

        rateBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rateb.png"))); // NOI18N
        rateBtn1.setBorderPainted(false);
        rateBtn1.setContentAreaFilled(false);
        rateBtn1.setMaximumSize(new java.awt.Dimension(53, 23));
        rateBtn1.setMinimumSize(new java.awt.Dimension(53, 23));
        rateBtn1.setPreferredSize(new java.awt.Dimension(53, 23));
        rateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(rateBtn1);
        rateBtn1.setBounds(20, 520, 100, 40);

        InfoSoundBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/microphone.png"))); // NOI18N
        InfoSoundBtn.setMaximumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn.setMinimumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn.setPreferredSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoSoundBtnActionPerformed(evt);
            }
        });
        jPanel2.add(InfoSoundBtn);
        InfoSoundBtn.setBounds(810, 510, 50, 50);

        leaderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guessG.png"))); // NOI18N
        jPanel2.add(leaderBtn);
        leaderBtn.setBounds(0, 0, 900, 600);

        lbl_lettersUsed.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lbl_lettersUsed.setText("LETTERS GUESSED:");
        jPanel2.add(lbl_lettersUsed);
        lbl_lettersUsed.setBounds(50, 250, 810, 25);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 900, 600);

        jMenuBar1.setBorder(null);
        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        //put mouse click event into an object
        Object o = e.getSource();

        //go through the buttons if clicked, get char, set to false
        for (int j = 0; j < buttonArray.length; j++) {
            if (o == buttonArray[j]) {

                if (buttonArray[j].isEnabled()) {
                    updateDisplayArray(buttonArray[j].getText().charAt(0));
                    buttonArray[j].setEnabled(false);
                } //end first if
            } //end second if
        } //for loop
    }

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        HomeGUI myHome = new HomeGUI(myUser);
        myHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    //to play again initilize the game from scrach
    private void playAgainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainBtnActionPerformed
        initilizeGame();
    }//GEN-LAST:event_playAgainBtnActionPerformed

    private void backBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn2ActionPerformed
        ThirdAndForthGameSeletionGUI mySecectionGUI = new ThirdAndForthGameSeletionGUI(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtn2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Leaderboard hangLeader = new Leaderboard(8);
        hangLeader.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        JOptionPane.showMessageDialog(null, "This game is scored on a 1 or 0 basis\n1 for a correct geuss beofore all turns are used and 0 for not getting the word\nYou are allowd 7 missed letters.", "Hint!!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoBtnActionPerformed

    private void rateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateBtn1ActionPerformed
        RateGUI myRateGUI = new RateGUI();
        myRateGUI.setVisible(true);
    }//GEN-LAST:event_rateBtn1ActionPerformed

    private void InfoSoundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoSoundBtnActionPerformed
        try {
            // open the sound file as a Java input stream

            String audioFilePath = "src\\InfoSounds\\Hangman.wav";
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
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HangmanGUI().setVisible(true);
            }
        });
    }

    //settin up necassary game play conditions also we can just call this method later when we want to use the replay button
    private void initilizeGame() {
        //calling the random word method in WordRepository class setting it as current word
        currentWord = wordBank.GetRandomWord();
        //making chosen word into a character array
        wordCharArray = currentWord.SendToCharArray();
        lettersRemaining = 0;
        misses = 0;
        wrong = 7;
        missesLbl.setText("7");
        guessedLetters = "";

        initDisplayArray();

        generatedWordLBL.setBackground(Color.WHITE);
        icon_playerStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hangman" + misses + ".png")));
        lbl_lettersUsed.setText("LETTERS GUESSED: " + guessedLetters);
        //setting word hint
        lbl_Category.setText("CATEGORY: " + currentWord.getHint());
        generatedWordLBL.setText(String.copyValueOf(displayArray));

        EnableAllButtons();
    }

    //setting the correct number of dashes to store in the display array
    //this is what will be tracking user correct geusses
    private void initDisplayArray() {
        displayArray = new char[currentWord.getWord().length()];

        for (int i = 0; i < currentWord.getWord().length(); i++) {
            //**32 is the number computer uses to represent space charecter on keyboard
            if (wordCharArray[i] != 32) {
                displayArray[i] = '-';
                lettersRemaining++;
            } else {
                displayArray[i] = ' ';
            }
        }
    }

    private void updateDisplayArray(char c) {
        boolean letterFound = false;

        //adding the usered geussed letter to the guessedLetters String
        guessedLetters += c + " ";
        //SHowing user letters used
        lbl_lettersUsed.setText("LETTERS GUESSED: " + guessedLetters);

        for (int i = 0; i < wordCharArray.length; i++) {
            //here c is user entered letter
            if (wordCharArray[i] == c) {
                letterFound = true;
                displayArray[i] = c;
                //copyValueOf() Returns a String that represents the character sequence in the char[] displayArray.
                generatedWordLBL.setText(String.copyValueOf(displayArray));
                //decremnt number of remainig letters to geuss
                lettersRemaining--;
                //when all letters are geussed correctly disable all buttons
                if (lettersRemaining == 0) {
                    score = 1;
                    DisableAllButtons();
                    generatedWordLBL.setBackground(Color.GREEN);
                    JOptionPane.showMessageDialog(null, "Good Job,\nYou won!");
                    updateScore(score);
                }
            }
        }

        //if letter not found
        if (!letterFound) {
            //increment missed attempt counter
            misses++;

            wrong = wrong - 1;
            String missesTxt = String.valueOf(wrong);
            missesLbl.setText(missesTxt);

            //set icon
            icon_playerStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hangman" + misses + ".png")));

            //7 fails game over
            if (misses == 7) {
                //grey out letters
                DisableAllButtons();

                //keeping this scoring to a 1 or 0 system.
                score = 0;
                updateScore(score);
                //show word after user enters too many incorrect geusses and set backgroun to red
                generatedWordLBL.setText(String.copyValueOf(wordCharArray));
                generatedWordLBL.setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "Too many incorrect geusses \nGame Over!");
            }
        }
    }

    //next two methods used to grey out or allow use of buttons depend on game stage
    private void DisableAllButtons() {
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        btnE.setEnabled(false);
        btnF.setEnabled(false);
        btnG.setEnabled(false);
        btnH.setEnabled(false);
        btnI.setEnabled(false);
        btnJ.setEnabled(false);
        btnK.setEnabled(false);
        btnL.setEnabled(false);
        btnM.setEnabled(false);
        btnN.setEnabled(false);
        btnO.setEnabled(false);
        btnP.setEnabled(false);
        btnQ.setEnabled(false);
        btnR.setEnabled(false);
        btnS.setEnabled(false);
        btnT.setEnabled(false);
        btnU.setEnabled(false);
        btnV.setEnabled(false);
        btnW.setEnabled(false);
        btnX.setEnabled(false);
        btnY.setEnabled(false);
        btnZ.setEnabled(false);
    }

    private void EnableAllButtons() {
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
        btnG.setEnabled(true);
        btnH.setEnabled(true);
        btnI.setEnabled(true);
        btnJ.setEnabled(true);
        btnK.setEnabled(true);
        btnL.setEnabled(true);
        btnM.setEnabled(true);
        btnN.setEnabled(true);
        btnO.setEnabled(true);
        btnP.setEnabled(true);
        btnQ.setEnabled(true);
        btnR.setEnabled(true);
        btnS.setEnabled(true);
        btnT.setEnabled(true);
        btnU.setEnabled(true);
        btnV.setEnabled(true);
        btnW.setEnabled(true);
        btnX.setEnabled(true);
        btnY.setEnabled(true);
        btnZ.setEnabled(true);

        //setting up button array. looping through, add listener
        buttonArray = new JButton[]{btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ};

        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].addActionListener(this);
        }
    }

    ///instances and variables used in following updateScore method which connects to DB
    DBManager connectionManager = new DBManager();
    //storing users unique name and id , these will correspond to values in the DB, stored in userDAta class
    String uName = myUser.getName();
    int uID;

    //updata score in DB
    public void updateScore(int score) {
        uID = myUser.getUser_id();
        connectionManager.setConnection(conn);
        //select all fields from game scroe for only the currently logged in player and the game they are playing
        //and store results in resultset GameID is hardcoded into DB 8 = hangman game
        ResultSet rs = connectionManager.Select_Query("select * from gameScore where user_id = " + uID + " AND GameID = 8;");
        try { //if there is a next position do following
            if (rs.next()) {
                //get the previous score on this game for this specific user
                int oldScore = rs.getInt("Score");
                //if oldscore is less than new score thenn we update DB to the new score
                if (oldScore < score) {
                    connectionManager.Update_Query("UPDATE gameScore SET score = " + score + " WHERE GameID = 8 AND user_id = " + uID + ";");

                } //0nce your dont get the same score twice in a row do following
                else if (score != oldScore) {
                }
            } else {
                //else if this particular user has not played this game before we insert new data 
                connectionManager.Update_Query("insert into gameScore values(" + 8 + ","
                        + "" + "'Guess the word Game'" + "," + uID + "," + score + ");");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangmanGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InfoSoundBtn;
    private javax.swing.JButton backBtn2;
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnD;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnF;
    private javax.swing.JButton btnG;
    private javax.swing.JButton btnH;
    private javax.swing.JButton btnI;
    private javax.swing.JButton btnJ;
    private javax.swing.JButton btnK;
    private javax.swing.JButton btnL;
    private javax.swing.JButton btnM;
    private javax.swing.JButton btnN;
    private javax.swing.JButton btnO;
    private javax.swing.JButton btnP;
    private javax.swing.JButton btnQ;
    private javax.swing.JButton btnR;
    private javax.swing.JButton btnS;
    private javax.swing.JButton btnT;
    private javax.swing.JButton btnU;
    private javax.swing.JButton btnV;
    private javax.swing.JButton btnW;
    private javax.swing.JButton btnX;
    private javax.swing.JButton btnY;
    private javax.swing.JButton btnZ;
    private javax.swing.JTextField generatedWordLBL;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel icon_playerStatus;
    private javax.swing.JButton infoBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_Category;
    private javax.swing.JLabel lbl_lettersUsed;
    private javax.swing.JLabel leaderBtn;
    private javax.swing.JLabel missesLbl;
    private javax.swing.JButton playAgainBtn;
    private javax.swing.JLabel progresslbl;
    private javax.swing.JButton rateBtn1;
    // End of variables declaration//GEN-END:variables
}
