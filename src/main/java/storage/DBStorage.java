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
    
    public int createMember(Member member) {
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
            return Integer.parseInt(connector.selectQuery(query).get(0).get("member_id"));
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return id;
        }
    }
}
