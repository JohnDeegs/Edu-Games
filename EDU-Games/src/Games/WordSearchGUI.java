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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import user_Interface.RateGUI;

public class WordSearchGUI extends javax.swing.JFrame implements ActionListener { //actionlistener for mouse click

    //DB conncetion
    Connection conn;
    String url = "jdbc:mysql://sql3.freemysqlhosting.net/";
    String db = "sql368113";
    String driver = "com.mysql.jdbc.Driver";
    String user = "sql368113";
    String pass = "qG9*eZ8*";

    public UserData myUser = new UserData();

    private WordSearchGUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setUserData(UserData player) {
        this.myUser = player;
    }

    // set up arrays to go through buttons
    JButton[] buttonArray = new JButton[10];
    JCheckBox[] checkArray = new JCheckBox[10];
    int score = 0;
    int random;

    public WordSearchGUI(UserData player) {
        initComponents();
        setLocationRelativeTo(null);

        this.myUser = player;

        jPanel1.setVisible(false);
        jPanel2.setVisible(false);

        setupArray();
        uID = myUser.getUser_id();

        try {
            // connect to db here stated above
            conn = DriverManager.getConnection(url + db, user, pass);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
    }

    //accessing DB manager class where update and select querys are run from
    DBManager connectionManager = new DBManager();
    int uID;

    public void updateScore(int score) {

        connectionManager.setConnection(conn);
        //select all fields from game scroe for only the currently logged in player and the game they are playing
        //and store results in resultset GameID is hardcoded into DB 5 = search game
        ResultSet rs = connectionManager.Select_Query("select * from gameScore where user_id = " + uID + " AND GameID = 9;");
        ResultSet getCoins = connectionManager.Select_Query("select * from users where user_id = " + uID);

        try { //used to add coins if player gets 100%
            if (getCoins.next()) {
                int oldCoins = getCoins.getInt("coins");
                if (score == 10) {

                    int newCoins = oldCoins + 10;
                    connectionManager.Update_Query("UPDATE users SET coins = " + newCoins + " WHERE user_id = " + uID + ";");
                }
            }
            if (rs.next()) {
                //get the previous score on this game for this specific user
                int oldScore = rs.getInt("Score");
                //if oldscore is less than new score thenn we update DB to the new score
                if (oldScore < score) {
                    connectionManager.Update_Query("UPDATE gameScore SET score = " + score + " WHERE GameID = 9 AND user_id = " + uID + ";");
                    JOptionPane.showMessageDialog(null, "You scored: " + score + " out of 10\nWell done new high score\nGame Over");
                } //0nce your dont get the same score twice in a row do following
                else if (score != oldScore) {
                    JOptionPane.showMessageDialog(null, "You scored: " + score + " out of 10\nGame Over\nNot bad, but not as good as your high score of " + oldScore);
                } else if (score == oldScore) {
                    JOptionPane.showMessageDialog(null, "You scored " + score + " out of 10 again");
                }
            } else {
                //else if this particular user has not played this game before we insert new data 
                connectionManager.Update_Query("insert into gameScore values(" + 9 + ","
                        + "" + "'Word Search Game'" + "," + uID + "," + score + ");");
                JOptionPane.showMessageDialog(null, "You scored: " + score + "out of 10 \nGame Over");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WordSearchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        homeLbl = new javax.swing.JButton();
        backBtn2 = new javax.swing.JButton();
        dog = new javax.swing.JButton();
        donkey = new javax.swing.JButton();
        elephant = new javax.swing.JButton();
        lion = new javax.swing.JButton();
        giraffe = new javax.swing.JButton();
        penguin = new javax.swing.JButton();
        zebra = new javax.swing.JButton();
        monkey = new javax.swing.JButton();
        turtle = new javax.swing.JButton();
        snake = new javax.swing.JButton();
        dogCb = new javax.swing.JCheckBox();
        donkeyCb = new javax.swing.JCheckBox();
        elephantCb = new javax.swing.JCheckBox();
        lionCb = new javax.swing.JCheckBox();
        giraffeCb = new javax.swing.JCheckBox();
        penguinCb = new javax.swing.JCheckBox();
        zebraCb = new javax.swing.JCheckBox();
        monkeyCb = new javax.swing.JCheckBox();
        turtleCb = new javax.swing.JCheckBox();
        snakeCb = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        finishBtn = new javax.swing.JButton();
        infoBtn = new javax.swing.JButton();
        LeaderBtn = new javax.swing.JButton();
        rateBtn = new javax.swing.JButton();
        InfoSoundBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        homeLbl2 = new javax.swing.JButton();
        backBtn4 = new javax.swing.JButton();
        wordSearch1 = new javax.swing.JLabel();
        cartoons = new javax.swing.JButton();
        children = new javax.swing.JButton();
        education = new javax.swing.JButton();
        fun = new javax.swing.JButton();
        hotdogs = new javax.swing.JButton();
        icecream = new javax.swing.JButton();
        learning = new javax.swing.JButton();
        playtime = new javax.swing.JButton();
        school = new javax.swing.JButton();
        teacher = new javax.swing.JButton();
        cartoonsCb = new javax.swing.JCheckBox();
        childrenCb = new javax.swing.JCheckBox();
        educationCb = new javax.swing.JCheckBox();
        funCb = new javax.swing.JCheckBox();
        hotdogsCb = new javax.swing.JCheckBox();
        icecreamCb = new javax.swing.JCheckBox();
        learningCb = new javax.swing.JCheckBox();
        playtimeCb = new javax.swing.JCheckBox();
        schoolCb = new javax.swing.JCheckBox();
        teacherCb = new javax.swing.JCheckBox();
        finishBtnPanel2 = new javax.swing.JButton();
        infoBtnPanelTwo = new javax.swing.JButton();
        LeaderBoard = new javax.swing.JButton();
        InfoSoundBtn1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        rateBtn1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setEnabled(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/animal wordsearch.PNG"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 20, 515, 460);

        homeLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/homeBtn.png"))); // NOI18N
        homeLbl.setBorderPainted(false);
        homeLbl.setContentAreaFilled(false);
        homeLbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeLblActionPerformed(evt);
            }
        });
        jPanel1.add(homeLbl);
        homeLbl.setBounds(0, 0, 90, 40);

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
        jPanel1.add(backBtn2);
        backBtn2.setBounds(100, 0, 90, 40);

        dog.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        dog.setText("D   O    G");
        dog.setAlignmentY(0.0F);
        dog.setBorder(null);
        dog.setBorderPainted(false);
        dog.setContentAreaFilled(false);
        dog.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dog.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        dog.setRolloverEnabled(false);
        jPanel1.add(dog);
        dog.setBounds(620, 262, 80, 30);

        donkey.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        donkey.setText("<html><body>D<br>O<br>N<br>K<br>E<br>Y</body></html>");
        donkey.setActionCommand("DONKEY");
        donkey.setAlignmentY(0.0F);
        donkey.setBorder(null);
        donkey.setBorderPainted(false);
        donkey.setContentAreaFilled(false);
        donkey.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        donkey.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        donkey.setRolloverEnabled(false);
        jPanel1.add(donkey);
        donkey.setBounds(560, 20, 20, 160);

        elephant.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        elephant.setText("<html><body>E<br>L<br>E<br>P<br>H<br>A<br>N<br>T</body></html>");
        elephant.setActionCommand("ELEPHANT");
        elephant.setAlignmentY(0.0F);
        elephant.setBorder(null);
        elephant.setBorderPainted(false);
        elephant.setContentAreaFilled(false);
        elephant.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elephant.setRolloverEnabled(false);
        jPanel1.add(elephant);
        elephant.setBounds(190, 230, 20, 220);

        lion.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lion.setText("<html><body>L<br>I<br>O<br>N</body></html>");
        lion.setActionCommand("LION");
        lion.setAlignmentY(0.0F);
        lion.setBorder(null);
        lion.setBorderPainted(false);
        lion.setContentAreaFilled(false);
        lion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lion.setMaximumSize(new java.awt.Dimension(103, 30));
        lion.setPreferredSize(new java.awt.Dimension(103, 30));
        lion.setRolloverEnabled(false);
        jPanel1.add(lion);
        lion.setBounds(251, 348, 20, 100);

        giraffe.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        giraffe.setText("G     I    R  A    F    F   E");
        giraffe.setActionCommand("GIRAFFE");
        giraffe.setAlignmentY(0.0F);
        giraffe.setBorder(null);
        giraffe.setBorderPainted(false);
        giraffe.setContentAreaFilled(false);
        giraffe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        giraffe.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        giraffe.setRolloverEnabled(false);
        jPanel1.add(giraffe);
        giraffe.setBounds(470, 400, 200, 20);

        penguin.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        penguin.setToolTipText("");
        penguin.setActionCommand("PENGUIN");
        penguin.setAlignmentY(0.0F);
        penguin.setBorder(null);
        penguin.setBorderPainted(false);
        penguin.setContentAreaFilled(false);
        penguin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        penguin.setLabel("<html><body>P<br>E<br>N<br>G<br>U<br>I<br>N</body></html>");
        penguin.setRolloverEnabled(false);
        jPanel1.add(penguin);
        penguin.setBounds(500, 210, 20, 190);

        zebra.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        zebra.setText("Z    E   B    R   A");
        zebra.setAlignmentY(0.0F);
        zebra.setBorder(null);
        zebra.setBorderPainted(false);
        zebra.setContentAreaFilled(false);
        zebra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        zebra.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        zebra.setRolloverEnabled(false);
        jPanel1.add(zebra);
        zebra.setBounds(470, 450, 140, 30);

        monkey.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        monkey.setText("M   O   N   K    E   Y");
        monkey.setAlignmentY(0.0F);
        monkey.setBorder(null);
        monkey.setBorderPainted(false);
        monkey.setContentAreaFilled(false);
        monkey.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        monkey.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        monkey.setRolloverEnabled(false);
        jPanel1.add(monkey);
        monkey.setBounds(440, 423, 170, 27);

        turtle.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        turtle.setText("T    U    R   T    L    E");
        turtle.setAlignmentY(0.0F);
        turtle.setBorder(null);
        turtle.setBorderPainted(false);
        turtle.setContentAreaFilled(false);
        turtle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        turtle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        turtle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        turtle.setRolloverEnabled(false);
        jPanel1.add(turtle);
        turtle.setBounds(320, 290, 170, 20);

        snake.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        snake.setText("S    N   A    K    E");
        snake.setAlignmentY(0.0F);
        snake.setBorder(null);
        snake.setBorderPainted(false);
        snake.setContentAreaFilled(false);
        snake.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        snake.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        snake.setRolloverEnabled(false);
        jPanel1.add(snake);
        snake.setBounds(383, 20, 137, 20);

        dogCb.setBackground(new java.awt.Color(204, 204, 204));
        dogCb.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        dogCb.setText("DOG");
        dogCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dogCb.setBorderPainted(true);
        dogCb.setRolloverEnabled(false);
        jPanel1.add(dogCb);
        dogCb.setBounds(190, 490, 100, 17);

        donkeyCb.setBackground(new java.awt.Color(204, 204, 204));
        donkeyCb.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        donkeyCb.setText("DONKEY");
        donkeyCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        donkeyCb.setBorderPainted(true);
        donkeyCb.setRolloverEnabled(false);
        jPanel1.add(donkeyCb);
        donkeyCb.setBounds(310, 490, 100, 17);

        elephantCb.setBackground(new java.awt.Color(204, 204, 204));
        elephantCb.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        elephantCb.setText("ELEPHANT");
        elephantCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        elephantCb.setBorderPainted(true);
        elephantCb.setRolloverEnabled(false);
        jPanel1.add(elephantCb);
        elephantCb.setBounds(420, 490, 90, 17);

        lionCb.setBackground(new java.awt.Color(204, 204, 204));
        lionCb.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        lionCb.setText("LION");
        lionCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lionCb.setBorderPainted(true);
        lionCb.setRolloverEnabled(false);
        jPanel1.add(lionCb);
        lionCb.setBounds(530, 490, 80, 17);

        giraffeCb.setBackground(new java.awt.Color(204, 204, 204));
        giraffeCb.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        giraffeCb.setText("GIRAFFE");
        giraffeCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        giraffeCb.setBorderPainted(true);
        giraffeCb.setRolloverEnabled(false);
        jPanel1.add(giraffeCb);
        giraffeCb.setBounds(630, 490, 90, 17);

        penguinCb.setText("PENGUIN");
        penguinCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        penguinCb.setBorderPainted(true);
        penguinCb.setRolloverEnabled(false);
        jPanel1.add(penguinCb);
        penguinCb.setBounds(190, 530, 100, 17);

        zebraCb.setText("ZEBRA");
        zebraCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        zebraCb.setBorderPainted(true);
        zebraCb.setRolloverEnabled(false);
        jPanel1.add(zebraCb);
        zebraCb.setBounds(310, 530, 100, 17);

        monkeyCb.setText("MONKEY");
        monkeyCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monkeyCb.setBorderPainted(true);
        monkeyCb.setRolloverEnabled(false);
        jPanel1.add(monkeyCb);
        monkeyCb.setBounds(420, 530, 90, 17);

        turtleCb.setText("TURTLE");
        turtleCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        turtleCb.setBorderPainted(true);
        turtleCb.setRolloverEnabled(false);
        jPanel1.add(turtleCb);
        turtleCb.setBounds(530, 530, 80, 17);

        snakeCb.setText("SNAKE");
        snakeCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        snakeCb.setBorderPainted(true);
        snakeCb.setRolloverEnabled(false);
        jPanel1.add(snakeCb);
        snakeCb.setBounds(630, 530, 90, 17);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("<html><body>Click the words <br> when you find them</body</html>");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 250, 160, 170);

        finishBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finish.png"))); // NOI18N
        finishBtn.setBorderPainted(false);
        finishBtn.setContentAreaFilled(false);
        finishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishBtnActionPerformed(evt);
            }
        });
        jPanel1.add(finishBtn);
        finishBtn.setBounds(50, 430, 100, 40);

        infoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/infoBtn.png"))); // NOI18N
        infoBtn.setBorderPainted(false);
        infoBtn.setContentAreaFilled(false);
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });
        jPanel1.add(infoBtn);
        infoBtn.setBounds(760, 410, 90, 41);

        LeaderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/leaderb.png"))); // NOI18N
        LeaderBtn.setBorderPainted(false);
        LeaderBtn.setContentAreaFilled(false);
        LeaderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderBtnActionPerformed(evt);
            }
        });
        jPanel1.add(LeaderBtn);
        LeaderBtn.setBounds(750, 290, 120, 39);

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
        jPanel1.add(rateBtn);
        rateBtn.setBounds(760, 350, 90, 40);

        InfoSoundBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/microphone.png"))); // NOI18N
        InfoSoundBtn.setMaximumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn.setMinimumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn.setPreferredSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoSoundBtnActionPerformed(evt);
            }
        });
        jPanel1.add(InfoSoundBtn);
        InfoSoundBtn.setBounds(780, 100, 50, 50);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wSearch.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 900, 600);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 600);

        jPanel2.setEnabled(false);
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel2.setLayout(null);

        homeLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/homeBtn.png"))); // NOI18N
        homeLbl2.setBorderPainted(false);
        homeLbl2.setContentAreaFilled(false);
        homeLbl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeLbl2ActionPerformed(evt);
            }
        });
        jPanel2.add(homeLbl2);
        homeLbl2.setBounds(0, 0, 90, 40);

        backBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backBtn.png"))); // NOI18N
        backBtn4.setBorderPainted(false);
        backBtn4.setContentAreaFilled(false);
        backBtn4.setMaximumSize(new java.awt.Dimension(85, 32));
        backBtn4.setMinimumSize(new java.awt.Dimension(85, 32));
        backBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn4ActionPerformed(evt);
            }
        });
        jPanel2.add(backBtn4);
        backBtn4.setBounds(100, 0, 90, 40);

        wordSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wordsearch.PNG"))); // NOI18N
        jPanel2.add(wordSearch1);
        wordSearch1.setBounds(190, 10, 504, 460);

        cartoons.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cartoons.setText("<html><body>C<br>A<br>R<br>T<br>O<br>O<br>N<br>S</body></html>");
        cartoons.setActionCommand("C A R T O O N S");
        cartoons.setAlignmentY(0.0F);
        cartoons.setBorder(null);
        cartoons.setBorderPainted(false);
        cartoons.setContentAreaFilled(false);
        cartoons.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cartoons.setMaximumSize(new java.awt.Dimension(103, 30));
        cartoons.setPreferredSize(new java.awt.Dimension(103, 30));
        cartoons.setRolloverEnabled(false);
        jPanel2.add(cartoons);
        cartoons.setBounds(250, 110, 30, 220);

        children.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        children.setText("<html><body>C<br>H<br>I<br>L<br>D<br>R<br>E<br>N</body></html>");
        children.setActionCommand("CHILDREN");
        children.setAlignmentY(0.0F);
        children.setBorder(null);
        children.setBorderPainted(false);
        children.setContentAreaFilled(false);
        children.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        children.setRolloverEnabled(false);
        jPanel2.add(children);
        children.setBounds(460, 10, 20, 210);

        education.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        education.setText(" E   D   U   C    A   T    I    O    N");
        education.setAlignmentY(0.0F);
        education.setBorder(null);
        education.setBorderPainted(false);
        education.setContentAreaFilled(false);
        education.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        education.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        education.setRolloverEnabled(false);
        jPanel2.add(education);
        education.setBounds(430, 120, 260, 22);

        fun.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        fun.setText(" F    U   N");
        fun.setAlignmentY(0.0F);
        fun.setBorder(null);
        fun.setBorderPainted(false);
        fun.setContentAreaFilled(false);
        fun.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fun.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        fun.setRolloverEnabled(false);
        jPanel2.add(fun);
        fun.setBounds(340, 10, 90, 20);

        hotdogs.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        hotdogs.setText("H   O   T    D   O   G    S");
        hotdogs.setAlignmentY(0.0F);
        hotdogs.setBorder(null);
        hotdogs.setBorderPainted(false);
        hotdogs.setContentAreaFilled(false);
        hotdogs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hotdogs.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        hotdogs.setRolloverEnabled(false);
        jPanel2.add(hotdogs);
        hotdogs.setBounds(460, 420, 200, 20);

        icecream.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        icecream.setText("I   C   E   C    R   E    A   M");
        icecream.setAlignmentY(0.0F);
        icecream.setBorder(null);
        icecream.setBorderPainted(false);
        icecream.setContentAreaFilled(false);
        icecream.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        icecream.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        icecream.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        icecream.setRolloverEnabled(false);
        jPanel2.add(icecream);
        icecream.setBounds(403, 229, 220, 20);

        learning.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        learning.setText("<html><body>L<br>E<br>A<br>R <br>N <br>I<br>N<br>G</body></html>");
        learning.setToolTipText("");
        learning.setActionCommand("LEARNING");
        learning.setAlignmentY(0.0F);
        learning.setBorder(null);
        learning.setBorderPainted(false);
        learning.setContentAreaFilled(false);
        learning.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        learning.setRolloverEnabled(false);
        jPanel2.add(learning);
        learning.setBounds(630, 140, 30, 220);

        playtime.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        playtime.setText("<html><body>P<br>L<br>A<br>Y<br>T<br>I<br>M<br>E</body></html>");
        playtime.setActionCommand("PLAYTIME");
        playtime.setAlignmentY(0.0F);
        playtime.setBorder(null);
        playtime.setBorderPainted(false);
        playtime.setContentAreaFilled(false);
        playtime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playtime.setRolloverEnabled(false);
        jPanel2.add(playtime);
        playtime.setBounds(570, 10, 30, 220);

        school.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        school.setText("S     C    H   O   O   L");
        school.setAlignmentY(0.0F);
        school.setBorder(null);
        school.setBorderPainted(false);
        school.setContentAreaFilled(false);
        school.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        school.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        school.setRolloverEnabled(false);
        jPanel2.add(school);
        school.setBounds(310, 280, 170, 25);

        teacher.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        teacher.setText("<html><body>T<br>E<br>A<br>C<br>H<br>E<br>R</body></html>");
        teacher.setActionCommand("TEACHER");
        teacher.setAlignmentY(0.0F);
        teacher.setBorder(null);
        teacher.setBorderPainted(false);
        teacher.setContentAreaFilled(false);
        teacher.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        teacher.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        teacher.setRolloverEnabled(false);
        jPanel2.add(teacher);
        teacher.setBounds(370, 170, 30, 190);

        cartoonsCb.setText("CARTOONS");
        cartoonsCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cartoonsCb.setBorderPainted(true);
        cartoonsCb.setRolloverEnabled(false);
        jPanel2.add(cartoonsCb);
        cartoonsCb.setBounds(190, 490, 100, 17);

        childrenCb.setText("CHILDREN");
        childrenCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        childrenCb.setBorderPainted(true);
        childrenCb.setRolloverEnabled(false);
        jPanel2.add(childrenCb);
        childrenCb.setBounds(310, 490, 100, 17);

        educationCb.setText("EDUCATION");
        educationCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        educationCb.setBorderPainted(true);
        educationCb.setRolloverEnabled(false);
        jPanel2.add(educationCb);
        educationCb.setBounds(420, 490, 110, 17);

        funCb.setText("FUN");
        funCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        funCb.setBorderPainted(true);
        funCb.setRolloverEnabled(false);
        jPanel2.add(funCb);
        funCb.setBounds(540, 490, 80, 17);

        hotdogsCb.setText("HOTDOGS");
        hotdogsCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        hotdogsCb.setBorderPainted(true);
        hotdogsCb.setRolloverEnabled(false);
        jPanel2.add(hotdogsCb);
        hotdogsCb.setBounds(640, 490, 110, 17);

        icecreamCb.setText("ICECREAM");
        icecreamCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        icecreamCb.setBorderPainted(true);
        icecreamCb.setRolloverEnabled(false);
        jPanel2.add(icecreamCb);
        icecreamCb.setBounds(190, 510, 100, 17);

        learningCb.setText("LEARNING");
        learningCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        learningCb.setBorderPainted(true);
        learningCb.setRolloverEnabled(false);
        jPanel2.add(learningCb);
        learningCb.setBounds(310, 510, 100, 17);

        playtimeCb.setText("PLAYTIME");
        playtimeCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playtimeCb.setBorderPainted(true);
        playtimeCb.setRolloverEnabled(false);
        jPanel2.add(playtimeCb);
        playtimeCb.setBounds(420, 510, 110, 17);

        schoolCb.setText("SCHOOL");
        schoolCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        schoolCb.setBorderPainted(true);
        schoolCb.setRolloverEnabled(false);
        jPanel2.add(schoolCb);
        schoolCb.setBounds(540, 510, 80, 17);

        teacherCb.setText("TEACHER");
        teacherCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        teacherCb.setBorderPainted(true);
        teacherCb.setRolloverEnabled(false);
        jPanel2.add(teacherCb);
        teacherCb.setBounds(640, 510, 110, 17);

        finishBtnPanel2.setText("Finish");
        finishBtnPanel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishBtnPanel2ActionPerformed(evt);
            }
        });
        jPanel2.add(finishBtnPanel2);
        finishBtnPanel2.setBounds(750, 70, 80, 23);

        infoBtnPanelTwo.setText("Info");
        infoBtnPanelTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnPanelTwoActionPerformed(evt);
            }
        });
        jPanel2.add(infoBtnPanelTwo);
        infoBtnPanelTwo.setBounds(750, 120, 80, 23);

        LeaderBoard.setText("LeaderBoard");
        LeaderBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderBoardActionPerformed(evt);
            }
        });
        jPanel2.add(LeaderBoard);
        LeaderBoard.setBounds(750, 170, 110, 23);

        InfoSoundBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/microphone.jpg"))); // NOI18N
        InfoSoundBtn1.setMaximumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn1.setMinimumSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn1.setPreferredSize(new java.awt.Dimension(50, 50));
        InfoSoundBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoSoundBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(InfoSoundBtn1);
        InfoSoundBtn1.setBounds(840, 100, 50, 50);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("<html><body>Click the words <br> when you find them</body</html>");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 250, 160, 170);

        rateBtn1.setText("Rate");
        rateBtn1.setMaximumSize(new java.awt.Dimension(53, 23));
        rateBtn1.setMinimumSize(new java.awt.Dimension(53, 23));
        rateBtn1.setPreferredSize(new java.awt.Dimension(53, 23));
        rateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(rateBtn1);
        rateBtn1.setBounds(750, 210, 70, 23);

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wordS.png"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, 0, 900, 600);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setupArray() {

        //pick a random number between 0-1 
        Random randomGenerator = new Random();
        for (int i = 1; i <= 1; i++) {
            random = randomGenerator.nextInt(2);
        }

        //choose wordsearch based on random number picked
        if (random == 0) {

            jPanel1.setVisible(true);

            //fill array with buttons
            buttonArray = new JButton[]{dog, donkey, elephant, lion, giraffe, penguin, zebra, monkey, turtle, snake};

            //fill checkbox array
            checkArray = new JCheckBox[]{dogCb, donkeyCb, elephantCb, lionCb, giraffeCb, penguinCb, zebraCb, monkeyCb, turtleCb, snakeCb};

        } else if (random == 1) {
            jPanel2.setVisible(true);

            //fill array with buttons
            buttonArray = new JButton[]{cartoons, children, education, fun, hotdogs, icecream, learning, playtime, school, teacher};

            //fill checkbox array
            checkArray = new JCheckBox[]{cartoonsCb, childrenCb, educationCb, funCb, hotdogsCb, icecreamCb, learningCb, playtimeCb, schoolCb, teacherCb};

        }

        //add listener to each button in array
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].addActionListener(this);
        }

    }
    int clickCountn = 0;

    //action listner for mouse click
    @Override
    public void actionPerformed(ActionEvent e) {

        //put mouse click event into an object
        Object o = e.getSource();

        //go through the images if clicked is in the array
        for (int j = 0; j < buttonArray.length; j++) {
            if (o == buttonArray[j]) {

                //highlight found word
                buttonArray[j].setBackground(Color.YELLOW);
                buttonArray[j].setContentAreaFilled(true);

                //get strings of word and checkbox
                String word = buttonArray[j].getActionCommand().replace(" ", "");
                String check = checkArray[j].getText();
                System.out.println(word);
                System.out.println(check);

                //compare, check the box, add a point 
                if (word.equals(check)) {
                    System.out.println("score++");
                    checkArray[j].setSelected(true);
                    System.out.println(checkArray[j]);
                    score++;

                    //end the game
                    if (score == 10) {
                        updateScore(score);

                        endGame();

                    }
                }

            } //end if
        } //for loop
    } //end action performed


    private void homeLblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeLblActionPerformed
        HomeGUI myHome = new HomeGUI(myUser);
        myHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeLblActionPerformed

    private void backBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn2ActionPerformed
        ThirdAndForthGameSeletionGUI mySecectionGUI = new ThirdAndForthGameSeletionGUI(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtn2ActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        JOptionPane.showMessageDialog(null, "Find all the words to finish the Game\nThe Game ends automatically when all words are found\nOr you can give up at any time by clicking the finish button!", "Hint!!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoBtnActionPerformed

    private void finishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishBtnActionPerformed
        updateScore(score);

        endGame();
    }//GEN-LAST:event_finishBtnActionPerformed

    private void LeaderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderBtnActionPerformed
        Leaderboard wordLeader = new Leaderboard(9);
        wordLeader.setVisible(true);
    }//GEN-LAST:event_LeaderBtnActionPerformed

    private void infoBtnPanelTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnPanelTwoActionPerformed
        JOptionPane.showMessageDialog(null, "Find all the words to finish the Game\nThe Game ends automatically when all words are found\nOr you can give up at any time by clicking the finish button!", "Hint!!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoBtnPanelTwoActionPerformed

    private void finishBtnPanel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishBtnPanel2ActionPerformed
        updateScore(score);

        endGame();
    }//GEN-LAST:event_finishBtnPanel2ActionPerformed

    private void LeaderBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderBoardActionPerformed
        Leaderboard wordLeader = new Leaderboard(9);
        wordLeader.setVisible(true);
    }//GEN-LAST:event_LeaderBoardActionPerformed

    private void homeLbl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeLbl2ActionPerformed
        HomeGUI myHome = new HomeGUI(myUser);
        myHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeLbl2ActionPerformed

    private void backBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn4ActionPerformed
        ThirdAndForthGameSeletionGUI mySecectionGUI = new ThirdAndForthGameSeletionGUI(myUser);
        mySecectionGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtn4ActionPerformed

    private void rateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateBtnActionPerformed
        RateGUI myRateGUI = new RateGUI();
        myRateGUI.setVisible(true);
    }//GEN-LAST:event_rateBtnActionPerformed

    private void InfoSoundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoSoundBtnActionPerformed
        try {
            // open the sound file as a Java input stream

            String audioFilePath = "src\\InfoSounds\\wordsearch.wav";
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

    private void InfoSoundBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoSoundBtn1ActionPerformed
        try {
            // open the sound file as a Java input stream

            String audioFilePath = "src\\InfoSounds\\wordsearch.wav";
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

    private void rateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateBtn1ActionPerformed
        RateGUI myRateGUI = new RateGUI();
        myRateGUI.setVisible(true);
    }//GEN-LAST:event_rateBtn1ActionPerformed

    public void endGame() {
        ThirdAndForthGameSeletionGUI mySecectionGUI = new ThirdAndForthGameSeletionGUI(myUser);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WordSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WordSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WordSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WordSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WordSearchGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InfoSoundBtn;
    private javax.swing.JButton InfoSoundBtn1;
    private javax.swing.JButton LeaderBoard;
    private javax.swing.JButton LeaderBtn;
    private javax.swing.JButton backBtn2;
    private javax.swing.JButton backBtn4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cartoons;
    private javax.swing.JCheckBox cartoonsCb;
    private javax.swing.JButton children;
    private javax.swing.JCheckBox childrenCb;
    private javax.swing.JButton dog;
    private javax.swing.JCheckBox dogCb;
    private javax.swing.JButton donkey;
    private javax.swing.JCheckBox donkeyCb;
    private javax.swing.JButton education;
    private javax.swing.JCheckBox educationCb;
    private javax.swing.JButton elephant;
    private javax.swing.JCheckBox elephantCb;
    private javax.swing.JButton finishBtn;
    private javax.swing.JButton finishBtnPanel2;
    private javax.swing.JButton fun;
    private javax.swing.JCheckBox funCb;
    private javax.swing.JButton giraffe;
    private javax.swing.JCheckBox giraffeCb;
    private javax.swing.JButton homeLbl;
    private javax.swing.JButton homeLbl2;
    private javax.swing.JButton hotdogs;
    private javax.swing.JCheckBox hotdogsCb;
    private javax.swing.JButton icecream;
    private javax.swing.JCheckBox icecreamCb;
    private javax.swing.JButton infoBtn;
    private javax.swing.JButton infoBtnPanelTwo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton learning;
    private javax.swing.JCheckBox learningCb;
    private javax.swing.JButton lion;
    private javax.swing.JCheckBox lionCb;
    private javax.swing.JButton monkey;
    private javax.swing.JCheckBox monkeyCb;
    private javax.swing.JButton penguin;
    private javax.swing.JCheckBox penguinCb;
    private javax.swing.JButton playtime;
    private javax.swing.JCheckBox playtimeCb;
    private javax.swing.JButton rateBtn;
    private javax.swing.JButton rateBtn1;
    private javax.swing.JButton school;
    private javax.swing.JCheckBox schoolCb;
    private javax.swing.JButton snake;
    private javax.swing.JCheckBox snakeCb;
    private javax.swing.JButton teacher;
    private javax.swing.JCheckBox teacherCb;
    private javax.swing.JButton turtle;
    private javax.swing.JCheckBox turtleCb;
    private javax.swing.JLabel wordSearch1;
    private javax.swing.JButton zebra;
    private javax.swing.JCheckBox zebraCb;
    // End of variables declaration//GEN-END:variables
}