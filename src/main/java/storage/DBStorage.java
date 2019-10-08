package storage;

import core.Member;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBStorage {

    private SQLConnector connector;

    public DBStorage() {
        try {
            connector = new SQLConnector(true);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SQLConnector getConnector() {
        return connector;
    }

    public int createMember(Member member, String psw) {
        int id = -1;
        String sql = "insert into members(member_username,member_firstName,member_lastName,member_birthdate,member_gender) values (?,?,?,?,?)";
        PreparedStatement query;
        try {
            query = connector.getConnection().prepareStatement(sql);
            query.setString(1, member.getUsername());
            query.setString(2, member.getFirstName());
            query.setString(3, member.getLastName());
            query.setDate(4, java.sql.Date.valueOf(member.getBirthday()));
            query.setString(5, member.getGender().getText());
            connector.insertUpdateDeleteQuery(query);

            sql = "SELECT LAST_INSERT_ID() as member_id";
            query = connector.getConnection().prepareStatement(sql);
            id =  Integer.parseInt(connector.selectQuery(query).get(0).get("member_id"));
            if(id > 0) {
                sql = "insert into login (login_username,login_password) values (?,?)";
                query = connector.getConnection().prepareStatement(sql);
                query.setString(1, member.getUsername());
                query.setString(2, psw);
                connector.insertUpdateDeleteQuery(query);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return id;
        }
        return id;
    }

    public void updateMember(Member member) {
        String sql = "update members set member_picture_path = ?, member_bio = ? where member_id = ?";
        PreparedStatement query;
        try {
            query = connector.getConnection().prepareStatement(sql);
            query.setString(1, member.getProfilePicture());
            query.setString(2, member.getBio());
            query.setInt(3, member.getID());
            connector.insertUpdateDeleteQuery(query);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public boolean checkLogin(String username, String psw) {
        boolean res = false;
        String sql = "select * from login where login_username = ? and login_password = ?";
        PreparedStatement query;
        try {
            query = connector.getConnection().prepareStatement(sql);
            query.setString(1, username);
            query.setString(2, psw);
            if (connector.selectQuery(query).size() == 1)
                res = true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;
    }
}
