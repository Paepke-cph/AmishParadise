package mapper;

import core.Gender;
import core.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.internal.matchers.Any;
import org.mockito.internal.matchers.NotNull;
import storage.DBStorage;
import storage.SQLConnector;

/**
 *
 * @author Benjamin
 */
public class MemberMapperTest {

    /**
     * Test of getAllMembers method, of class MemberMapper.
     */
    @Test
    public void testGetAllMembers() {
        Member member = new Member(1, "username", "firstname", "lastname", LocalDate.of(2000, Month.JANUARY, 01), Gender.MALE, "bio");
        Member member2 = new Member(2, "username2", "firstname2", "lastname2", LocalDate.of(2001, Month.JANUARY, 01), Gender.FEMALE, "bio2");
        ArrayList<Member> members = new ArrayList<>();
        members.add(member);
        members.add(member2);

        MemberMapper mapper = mock(MemberMapper.class);
        when(mapper.getAllMembers()).thenReturn(members);

        ArrayList<Member> res = mapper.getAllMembers();

        assertEquals(2, res.size());
        Member m1 = res.get(0);
        Member m2 = res.get(1);
        assertEquals(1, m1.getID());
        assertEquals("username", m1.getUsername());
        assertEquals("firstname", m1.getFirstName());
        assertEquals("lastname", m1.getLastName());
        assertEquals(19, m1.getAge());
        assertEquals(LocalDate.of(2000, Month.JANUARY, 01), m1.getBirthday());
        assertEquals(Gender.MALE, m1.getGender());
        assertEquals("bio", m1.getBio());

        assertEquals(2, m2.getID());
        assertEquals("username2", m2.getUsername());
        assertEquals("firstname2", m2.getFirstName());
        assertEquals("lastname2", m2.getLastName());
        assertEquals(18, m2.getAge());
        assertEquals(LocalDate.of(2001, Month.JANUARY, 01), m2.getBirthday());
        assertEquals(Gender.FEMALE, m2.getGender());
        assertEquals("bio2", m2.getBio());

    }

    /**
     * Test of getMember method, of class MemberMapper.
     */
    @Test
    public void testGetMember() {
        Member member = new Member(1, "username", "firstname", "lastname", LocalDate.of(2000, Month.JANUARY, 01), Gender.MALE, "bio");
        MemberMapper mapper = mock(MemberMapper.class);
        when(mapper.getMember("username")).thenReturn(member);

        Member res = mapper.getMember("username");

        assertEquals(1, res.getID());
        assertEquals("username", res.getUsername());
        assertEquals("firstname", res.getFirstName());
        assertEquals("lastname", res.getLastName());
        assertEquals(19, res.getAge());
        assertEquals(LocalDate.of(2000, Month.JANUARY, 01), res.getBirthday());
        assertEquals(Gender.MALE, res.getGender());
        assertEquals("bio", res.getBio());
    }

    @Test
    public void testGetMember_withOneMember() {
        ArrayList<HashMap<String, String>> sqlRes = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("member_id", "1");
        map.put("member_username", "username");
        map.put("member_firstname", "firstname");
        map.put("member_lastname", "lastname");
        map.put("member_birthdate", "1992-04-02");
        map.put("member_gender", "male");
        map.put("member_profile_path", "images/p1.jpg");
        map.put("member_bio", "bio");

        sqlRes.add(map);
        SQLConnector connector = mock(SQLConnector.class);
        PreparedStatement state = mock(PreparedStatement.class);
        Connection connection = mock(Connection.class);
        DBStorage storage = mock(DBStorage.class);
        MemberMapper mapper = new MemberMapper(storage);

        when(storage.getConnector()).thenReturn(connector);
        when(connector.getConnection()).thenReturn(connection);
        try {
            when(connection.prepareStatement((String)notNull())).thenReturn(state);
        } catch (SQLException ex) {}
        when(connector.selectQuery((PreparedStatement)notNull())).thenReturn(sqlRes);

        ArrayList<Member> m = mapper.getAllMembers();
        assertEquals(1, m.get(0).getID());
    }
}
