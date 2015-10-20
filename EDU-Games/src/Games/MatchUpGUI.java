package Games;

import UserData.UserData;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import user_Interface.HomeGUI;
import user_Interface.JuniorAndSeniorGameSeletionGUI;
import user_Interface.Leaderboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import user_Interface.RateGUI;

public class MatchUpGUI extends javax.swing.JFrame implements ActionListener {

    private MatchUpGUI() {
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

    int count = 0;
    JButton[] displayArray = new JButton[10];
    JLabel[] realArray = new JLabel[10];
    String first;
    String second;
    int firstnum;
    int secondnum;
    int tryes = 15;
    int score = 0;

    /**
     * Creates new form MatchUpGUI
     */
    public UserData myUser = new UserData();

    public MatchUpGUI(UserData player) {
        initComponents();

        setLocationRelativeTo(null);

        this.myUser = player;
        getContentPane().setBackground(Color.CYAN); // set background colour

        // hide response at start
        hideResponse();
        //call shuffle method
        shuffleImages();

        try {
            // connect to db here stated above
            conn = DriverManager.getConnection(url + db, user, pass);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
    }

    private void shuffleImages() {

        //get images, shuffle them up
        realArray = new JLabel[]{giraffe1, giraffe2, lion1, lion2, bee1, bee2, cow1, cow2, pirate1, pirate2};
        Collections.shuffle(Arrays.asList(realArray));

        //get Question images
        displayArray = new JButton[]{Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10};

        //locations on the GUI where we want the images
        int[] positions = new int[]{60, 240, 400, 550, 710, 60, 240, 400, 550, 710};
        int topRow = 80;
        int bottomRow = 297;

        //put images in location
        for (int i = 0; i < displayArray.length; i++) {
            displayArray[i].addActionListener(this);
            if (i < 5) {
                displayArray[i].setLocation(positions[i], topRow);
                realArray[i].setLocation(positions[i], topRow);

            } else {
                displayArray[i].setLocation(positions[i], bottomRow);
                realArray[i].setLocation(positions[i], bottomRow);

            } //else
        } //for loop
    } //end method

    //action listner for mouse click
    @Override
    public void actionPerformed(ActionEvent e) {

        //put mouse click event into an object
        Object o = e.getSource();

        //go through the images if clicked is in the array
        for (int j = 0; j < displayArray.length; j++) {
            if (o == displayArray[j]) {
                if (count == 0) {

                    //disable the button, set the image on the button
                    displayArray[j].setEnabled(false);
                    displayArray[j].setDisabledIcon(realArray[j].getIcon());

                    //get name of first image selected
                    first = realArray[j].getIcon().toString();

                    //get index of first image selected
                    firstnum = j;

                    //count++ moves on to second click
                    count++;

                } else if (count > 0) {

                    //disable the button, set the image on the button
                    displayArray[j].setEnabled(false);
                    displayArray[j].setDisabledIcon(realArray[j].getIcon());

                    //get name of second image selected
                    second = realArray[j].getIcon().toString();

                    //get index of second image selected
                    secondnum = j;

                    //reset count to start over
                    count = 0;

                    //see if the guess is right or wrong
                    compareString(first, second, firstnum, secondnum);
                    System.out.println(tryes);
                } //end else if
            } //end if
        } //for loop
    } //end action performed

    public void compareString(String first, String second, final int firstnum, final int secondnum) {

        if (first.equals(second)) {
            //the pictures match
            hideResponse();
            isRight();

        } else {
            //they dont match
            hideResponse();
            isWrong();

            // new thread for 1 second pause
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        //pause the game for 1.2 seconds
                        Thread.sleep(1200);

                        //then display question marks again
                        displayArray[firstnum].setEnabled(true);
                        displayArray[secondnum].setEnabled(true);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(MatchUpGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });

            //start the paused thread again
            t.start();
        }
    }

    // hide response method for reuse
    private void hideResponse() {
        goodLbl.setVisible(false);
        againLbl.setVisible(false);
        smileLbl.setVisible(false);
        sadLbl.setVisible(false);
    }

    //used to set stuff up for right match
    public void isRight() {
        tryes--;
        String TryTex = String.valueOf(tryes);
        guessCountLbl.setText(TryTex);

        //set the score
        score = score + 1;
        String ScoreTxt = String.valueOf(score);
        scoreLbl.setText(ScoreTxt);

        //set right images
        goodLbl.setText("GOOD JOB " + myUser.getName());
        goodLbl.setVisible(true);
        smileLbl.setVisible(true);

        //end game when all is right
        if (score == 5) {
            JOptionPane.showMessageDialog(null, "Well Done " + myUser.getName() + " \nGame Over!");
            updateScore(tryes);
            endGame();
        } else if (tryes == 0) {
            JOptionPane.showMessageDialog(null, "Tough luck your out of goes\nBetter luck next time!");

            updateScore(tryes);
            endGame();
        }
    }

    //instances and variables used in following updateScore method which connects to DB
    DBManager connectionManager = new DBManager();
    int uID;

    public void updateScore(int score) {
        uID = myUser.getUser_id();
        connectionManager.setConnection(conn);
        //select all fields from game scroe for only the currently logged in player and the game they are playing
        //and store results in resultset GameID is hardcoded into DB 6 = numbergame
        ResultSet rs = connectionManager.Select_Query("select * from gameScore where user_id = " + uID + " AND GameID = 1;");
        try { //if there is a next position do following
            if (rs.next()) {
                //get the previous score on this game for this specific user
                int oldScore = rs.getInt("Score");
                //if oldscore is less than new score thenn we update DB to the new score
                if (oldScore < score) {
                    connectionManager.Update_Query("UPDATE gameScore SET score = " + score + " WHERE GameID = 1 AND user_id = " + uID + ";");
                } //0nce your dont get the same score twice in a row do following
                else if (score != oldScore) {
                }
            } else {
                //else if this particular user has not played this game before we insert new data 
                connectionManager.Update_Query("insert into gameScore values(" + 1 + ","
                        + "" + "'Match up Game'" + "," + uID + "," + score + ");");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatchUpGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectionManager.closeConnection();
    }

    //do stuff when wrong
    public void isWrong() {
        tryes--;
        String TryTex = String.valueOf(tryes);
        guessCountLbl.setText(TryTex);
        //show wrong images
        againLbl.setText("TRY AGAIN " + myUser.getName());
        againLbl.setVisible(true);
        sadLbl.setVisible(true);

        if (tryes == 0) {
            JOptionPane.showMessageDialog(null, "Tough luck your out of goes\nBetter luck next time!");
            endGame();
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

        Q1 = new javax.swing.JButton();
        Q2 = new javax.swing.JButton();
        Q3 = new javax.swing.JButton();
        Q4 = new javax.swing.JButton();
        Q5 = new javax.swing.JButton();
        Q6 = new javax.swing.JButton();
        Q7 = new javax.swing.JButton();
        Q8 = new javax.swing.JButton();
        Q9 = new javax.swing.JButton();
        Q10 = new javax.swing.JButton();
        giraffe1 = new javax.swing.JLabel();
        giraffe2 = new javax.swing.JLabel();
        lion1 = new javax.swing.JLabel();
        lion2 = new javax.swing.JLabel();
        bee1 = new javax.swing.JLabel();
        bee2 = new javax.swing.JLabel();
        cow1 = new javax.swing.JLabel();
        cow2 = new javax.swing.JLabel();
        pirate1 = new javax.swing.JLabel();
        pirate2 = new javax.swing.JLabel();
        correctLbl = new javax.swing.JLabel();
        scoreLbl = new javax.swing.JLabel();
        goodLbl = new javax.swing.JLabel();
        againLbl = new javax.swing.JLabel();
        smileLbl = new javax.swing.JLabel();
        sadLbl = new javax.swing.JLabel();
        homeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        leaderBtn = new javax.swing.JButton();
        infoBtn = new javax.swing.JButton();
        guessesLbl = new javax.swing.JLabel();
        guessCountLbl = new javax.swing.JLabel();
        rateBtn = new javax.swing.JButton();
        InfoSoundBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        Q1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q1.setMaximumSize(new java.awt.Dimension(110, 190));
        Q1.setMinimumSize(new java.awt.Dimension(110, 190));
        Q1.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q1);
        Q1.setBounds(60, 80, 120, 190);

        Q2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q2.setMaximumSize(new java.awt.Dimension(110, 190));
        Q2.setMinimumSize(new java.awt.Dimension(110, 190));
        Q2.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q2);
        Q2.setBounds(240, 80, 120, 190);

        Q3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q3.setMaximumSize(new java.awt.Dimension(110, 190));
        Q3.setMinimumSize(new java.awt.Dimension(110, 190));
        Q3.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q3);
        Q3.setBounds(400, 80, 120, 190);

        Q4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q4.setMaximumSize(new java.awt.Dimension(110, 190));
        Q4.setMinimumSize(new java.awt.Dimension(110, 190));
        Q4.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q4);
        Q4.setBounds(550, 80, 120, 190);

        Q5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q5.setMaximumSize(new java.awt.Dimension(110, 190));
        Q5.setMinimumSize(new java.awt.Dimension(110, 190));
        Q5.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q5);
        Q5.setBounds(710, 80, 120, 190);

        Q6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q6.setMaximumSize(new java.awt.Dimension(110, 190));
        Q6.setMinimumSize(new java.awt.Dimension(110, 190));
        Q6.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q6);
        Q6.setBounds(60, 300, 120, 190);

        Q7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q7.setMaximumSize(new java.awt.Dimension(110, 190));
        Q7.setMinimumSize(new java.awt.Dimension(110, 190));
        Q7.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q7);
        Q7.setBounds(240, 300, 120, 190);

        Q8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q8.setMaximumSize(new java.awt.Dimension(110, 190));
        Q8.setMinimumSize(new java.awt.Dimension(110, 190));
        Q8.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q8);
        Q8.setBounds(400, 300, 120, 190);

        Q9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q9.setMaximumSize(new java.awt.Dimension(110, 190));
        Q9.setMinimumSize(new java.awt.Dimension(110, 190));
        Q9.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q9);
        Q9.setBounds(550, 300, 120, 190);

        Q10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/question_pic.png"))); // NOI18N
        Q10.setMaximumSize(new java.awt.Dimension(110, 190));
        Q10.setMinimumSize(new java.awt.Dimension(110, 190));
        Q10.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(Q10);
        Q10.setBounds(710, 300, 120, 190);

        giraffe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/giraffe.jpg"))); // NOI18N
        giraffe1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        giraffe1.setMaximumSize(new java.awt.Dimension(110, 190));
        giraffe1.setMinimumSize(new java.awt.Dimension(110, 190));
        giraffe1.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(giraffe1);
        giraffe1.setBounds(60, 80, 110, 190);

        giraffe2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/giraffe.jpg"))); // NOI18N
        giraffe2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        giraffe2.setMaximumSize(new java.awt.Dimension(110, 190));
        giraffe2.setMinimumSize(new java.awt.Dimension(110, 190));
        giraffe2.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(giraffe2);
        giraffe2.setBounds(550, 300, 110, 190);

        lion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lion.jpg"))); // NOI18N
        lion1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lion1.setMaximumSize(new java.awt.Dimension(110, 190));
        lion1.setMinimumSize(new java.awt.Dimension(110, 190));
        lion1.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(lion1);
        lion1.setBounds(240, 80, 110, 190);

        lion2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lion.jpg"))); // NOI18N
        lion2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        lion2.setMaximumSize(new java.awt.Dimension(110, 190));
        lion2.setMinimumSize(new java.awt.Dimension(110, 190));
        lion2.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(lion2);
        lion2.setBounds(60, 300, 110, 190);

        bee1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bee.jpg"))); // NOI18N
        bee1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        bee1.setMaximumSize(new java.awt.Dimension(110, 190));
        bee1.setMinimumSize(new java.awt.Dimension(110, 190));
        bee1.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(bee1);
        bee1.setBounds(400, 80, 110, 190);

        bee2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bee.jpg"))); // NOI18N
        bee2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        bee2.setMaximumSize(new java.awt.Dimension(110, 190));
        bee2.setMinimumSize(new java.awt.Dimension(110, 190));
        bee2.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(bee2);
        bee2.setBounds(710, 80, 110, 190);

        cow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cow.jpg"))); // NOI18N
        cow1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        cow1.setMaximumSize(new java.awt.Dimension(110, 190));
        cow1.setMinimumSize(new java.awt.Dimension(110, 190));
        cow1.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(cow1);
        cow1.setBounds(550, 80, 110, 190);

        cow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cow.jpg"))); // NOI18N
        cow2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        cow2.setMaximumSize(new java.awt.Dimension(110, 190));
        cow2.setMinimumSize(new java.awt.Dimension(110, 190));
        cow2.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(cow2);
        cow2.setBounds(400, 300, 110, 190);

        pirate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pirate.jpg"))); // NOI18N
        pirate1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pirate1.setMaximumSize(new java.awt.Dimension(110, 190));
        pirate1.setMinimumSize(new java.awt.Dimension(110, 190));
        pirate1.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(pirate1);
        pirate1.setBounds(240, 300, 110, 190);

        pirate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pirate.jpg"))); // NOI18N
        pirate2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pirate2.setMaximumSize(new java.awt.Dimension(110, 190));
        pirate2.setMinimumSize(new java.awt.Dimension(110, 190));
        pirate2.setPreferredSize(new java.awt.Dimension(110, 190));
        getContentPane().add(pirate2);
        pirate2.setBounds(710, 300, 110, 190);

        correctLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        correctLbl.setForeground(new java.awt.Color(255, 0, 0));
        correctLbl.setText("Correct:");
        getContentPane().add(correctLbl);
        correctLbl.setBounds(60, 500, 150, 29);

        scoreLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        scoreLbl.setForeground(new java.awt.Color(255, 0, 0));
        scoreLbl.setText("0");
        getContentPane().add(scoreLbl);
        scoreLbl.setBounds(190, 490, 50, 50);

        goodLbl.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        goodLbl.setForeground(new java.awt.Color(255, 0, 0));
        goodLbl.setText("GOOD JOB");
        getContentPane().add(goodLbl);
        goodLbl.setBounds(280, 500, 320, 44);

        againLbl.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        againLbl.setForeground(new java.awt.Color(255, 0, 0));
        againLbl.setText("TRY AGAIN");
        getContentPane().add(againLbl);
        againLbl.setBounds(280, 500, 350, 44);

        smileLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/smile.jpg"))); // NOI18N
        getContentPane().add(smileLbl);
        smileLbl.setBounds(610, 500, 50, 50);

        sadLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sad.jpg"))); // NOI18N
        getContentPane().add(sadLbl);
        sadLbl.setBounds(610, 500, 50, 50);

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

        leaderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/leaderb.png"))); // NOI18N
        leaderBtn.setBorderPainted(false);
        leaderBtn.setContentAreaFilled(false);
        leaderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBtnActionPerformed(evt);
            }
        });
        getContentPane().add(leaderBtn);
        leaderBtn.setBounds(730, 530, 120, 40);

        infoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/infoBtn.png"))); // NOI18N
        infoBtn.setBorderPainted(false);
        infoBtn.setContentAreaFilled(false);
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(infoBtn);
        infoBtn.setBounds(790, 491, 100, 40);

        guessesLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        guessesLbl.setForeground(new java.awt.Color(255, 0, 0));
        guessesLbl.setText("Guesses left:");
        getContentPane().add(guessesLbl);
        guessesLbl.setBounds(10, 540, 160, 29);

        guessCountLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        guessCountLbl.setForeground(new java.awt.Color(255, 0, 0));
        guessCountLbl.setText("15");
        getContentPane().add(guessCountLbl);
        guessCountLbl.setBounds(190, 530, 50, 50);

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
        rateBtn.setBounds(690, 490, 90, 40);

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
        InfoSoundBtn.setBounds(740, 20, 50, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/matchupBk.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        HomeGUI myHome = new HomeGUI(myUser);
        myHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        JuniorAndSeniorGameSeletionGUI mySecectionGUI = new JuniorAndSeniorGameSeletionGUI(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        JOptionPane.showMessageDialog(null, "You start the game with 15 guesses\nIf all images are matched before those guesses run out\nThen your remaning guesses equal your score", "Hint!!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoBtnActionPerformed

    private void leaderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBtnActionPerformed
        Leaderboard matchupleader = new Leaderboard(1);
        matchupleader.setVisible(true);
    }//GEN-LAST:event_leaderBtnActionPerformed

    private void rateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateBtnActionPerformed
        RateGUI myRateGUI = new RateGUI();
        myRateGUI.setVisible(true);
    }//GEN-LAST:event_rateBtnActionPerformed

    private void InfoSoundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoSoundBtnActionPerformed
        try {
            // open the sound file as a Java input stream

            String audioFilePath = "src\\InfoSounds\\MatchUp.wav";
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

    public void endGame() {
        JuniorAndSeniorGameSeletionGUI mySecectionGUI = new JuniorAndSeniorGameSeletionGUI(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatchUpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MatchUpGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InfoSoundBtn;
    private javax.swing.JButton Q1;
    private javax.swing.JButton Q10;
    private javax.swing.JButton Q2;
    private javax.swing.JButton Q3;
    private javax.swing.JButton Q4;
    private javax.swing.JButton Q5;
    private javax.swing.JButton Q6;
    private javax.swing.JButton Q7;
    private javax.swing.JButton Q8;
    private javax.swing.JButton Q9;
    private javax.swing.JLabel againLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel bee1;
    private javax.swing.JLabel bee2;
    private javax.swing.JLabel correctLbl;
    private javax.swing.JLabel cow1;
    private javax.swing.JLabel cow2;
    private javax.swing.JLabel giraffe1;
    private javax.swing.JLabel giraffe2;
    private javax.swing.JLabel goodLbl;
    private javax.swing.JLabel guessCountLbl;
    private javax.swing.JLabel guessesLbl;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton infoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton leaderBtn;
    private javax.swing.JLabel lion1;
    private javax.swing.JLabel lion2;
    private javax.swing.JLabel pirate1;
    private javax.swing.JLabel pirate2;
    private javax.swing.JButton rateBtn;
    private javax.swing.JLabel sadLbl;
    private javax.swing.JLabel scoreLbl;
    private javax.swing.JLabel smileLbl;
    // End of variables declaration//GEN-END:variables
}