package user_Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Launch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            //this is where the db is stored online
            String url = "jdbc:mysql://sql3.freemysqlhosting.net/";
            String db = "sql368113";
            String driver = "com.mysql.jdbc.Driver";
            String user = "sql368113";
            String pass = "qG9*eZ8*";

            // connect to db where stated above, launch GUI
            Connection conn = DriverManager.getConnection(url + db, user, pass);
            LoginGUI myjdbcTest = new LoginGUI();
            myjdbcTest.setVisible(true);

            // set connection, get table, login related stuff
            myjdbcTest.setConn(conn);
            myjdbcTest.doCreateTable();
            myjdbcTest.doGetAdminUserNameAndPassword();
            myjdbcTest.doGetAllUsernames();
            myjdbcTest.doGetAllPasswordss();

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
    }
}