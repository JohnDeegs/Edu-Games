package Games;

import java.sql.*;

public class DBManager {

    private Connection conn;

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ResultSet Select_Query(String query) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }

    }

    public boolean Update_Query(String query) {
         try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
}
