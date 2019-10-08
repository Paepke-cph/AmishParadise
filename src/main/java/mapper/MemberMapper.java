package mapper;

import core.Gender;
import core.Member;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.DBStorage;
import storage.SQLConnector;

public class MemberMapper {
    private DBStorage storage;
    public MemberMapper(DBStorage storage) {
        this.storage = storage;
    }
    public ArrayList<Member> getAllMembers() {
        SQLConnector connector = storage.getConnector();
        ArrayList<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try {
            ArrayList<HashMap<String,String>> sqlResult = 
                    connector.selectQuery(connector.getConnection().prepareStatement(sql));
            for (HashMap<String, String> hashMap : sqlResult) {
                int id = Integer.parseInt(hashMap.get("member_id"));
                String firstName = hashMap.get("member_firstname");
                String lastName = hashMap.get("member_lastname");
                String username = hashMap.get("member_username");
                LocalDate birthdate = (java.sql.Date
                        .valueOf(hashMap.get("member_birthdate")))
                        .toLocalDate();
                Gender gender = Gender.from(hashMap.get("member_gender"));
                String picture = hashMap.get("member_picture_path");
                if(picture == null || picture.equals("")) {
                    picture = "images/missingProfilePic.jpg";
                }
                String bio = hashMap.get("member_bio");
                Member member = 
                        new Member(id,username,firstName,lastName,birthdate,gender,bio);
                member.setProfilePicture(picture);
                members.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }
    
    public Member getMember(String check) {
        SQLConnector connector = storage.getConnector();
        String sql = "SELECT * FROM members where member_username = ?";
        try {
            PreparedStatement query = connector.getConnection().prepareStatement(sql);
            query.setString(1, check);
            
            ArrayList<HashMap<String,String>> sqlResult = connector.selectQuery(query);
            if(sqlResult.size() > 1) return null;
            else {
                for (HashMap<String, String> hashMap : sqlResult) {
                    int id = Integer.parseInt(hashMap.get("member_id"));
                    String firstName = hashMap.get("member_firstname");
                    String lastName = hashMap.get("member_lastname");
                    String username = hashMap.get("member_username");
                    LocalDate birthdate = (java.sql.Date
                            .valueOf(hashMap.get("member_birthdate")))
                            .toLocalDate();
                    Gender gender = Gender.from(hashMap.get("member_gender"));
                    String picture = hashMap.get("member_picture_path");
                    if(picture == null || picture.equals("")) {
                        picture = "images/missingProfilePic.jpg";
                    }
                    String bio = hashMap.get("member_bio");
                    Member member = 
                            new Member(id,username,firstName,lastName,birthdate,gender,bio);
                    member.setProfilePicture(picture);
                    return member;
                }
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }
}
