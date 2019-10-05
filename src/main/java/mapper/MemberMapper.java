package mapper;

import core.Gender;
import core.Member;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.DBContext;
import storage.SQLConnector;

public class MemberMapper {
    public static ArrayList<Member> getAllMembers() {
        SQLConnector connector = DBContext.getInstance().getDB();
        ArrayList<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try {
            ArrayList<HashMap<String,String>> sqlResult = connector.selectQuery(connector.getConnection().prepareStatement(sql));
            for (HashMap<String, String> hashMap : sqlResult) {
                int id = Integer.parseInt(hashMap.get("member_id"));
                String firstName = hashMap.get("member_firstname");
                String lastName = hashMap.get("member_lastname");
                String username = hashMap.get("member_username");
                LocalDate birthdate = (java.sql.Date.valueOf(hashMap.get("member_birthdate"))).toLocalDate();
                Gender gender = Gender.from(hashMap.get("member_gender"));
                String picture = hashMap.get("member_imagepath");
                if(picture == null || picture.equals("")) {
                    picture = "images/missingProfilePic.jpg";
                }
                Member member = new Member(id,username,firstName,lastName,birthdate,gender);
                member.setProfilePicture(picture);
                members.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }
}
