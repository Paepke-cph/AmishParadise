package mapper;

import core.Gender;
import core.Member;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
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
        Member member = new Member(1,"username", "firstname", "lastname", LocalDate.of(2000, Month.JANUARY, 01), Gender.MALE,"bio");
        Member member2 = new Member(2,"username2", "firstname2", "lastname2", LocalDate.of(2001, Month.JANUARY, 01), Gender.FEMALE,"bio2");
        ArrayList<Member> members = new ArrayList<>();
        members.add(member);
        members.add(member2);
        
        MemberMapper mapper = mock(MemberMapper.class);
        when(mapper.getAllMembers()).thenReturn(members);
        
        ArrayList<Member> res = mapper.getAllMembers();
        
        assertEquals(2,res.size());
        Member m1 = res.get(0);
        Member m2 = res.get(1);
        assertEquals(1,m1.getID());
        assertEquals("username",m1.getUsername());
        assertEquals("firstname",m1.getFirstName());
        assertEquals("lastname",m1.getLastName());
        assertEquals(19,m1.getAge());
        assertEquals(LocalDate.of(2000,Month.JANUARY,01),m1.getBirthday());
        assertEquals(Gender.MALE,m1.getGender());
        assertEquals("bio",m1.getBio());
        
        assertEquals(2,m2.getID());
        assertEquals("username2",m2.getUsername());
        assertEquals("firstname2",m2.getFirstName());
        assertEquals("lastname2",m2.getLastName());
        assertEquals(18,m2.getAge());
        assertEquals(LocalDate.of(2001,Month.JANUARY,01),m2.getBirthday());
        assertEquals(Gender.FEMALE,m2.getGender());
        assertEquals("bio2",m2.getBio());
        
    }

    /**
     * Test of getMember method, of class MemberMapper.
     */
    @Test
    public void testGetMember() {
        Member member = new Member(1,"username", "firstname", "lastname", LocalDate.of(2000, Month.JANUARY, 01), Gender.MALE,"bio");
        MemberMapper mapper = mock(MemberMapper.class);
        when(mapper.getMember("username")).thenReturn(member);
        
        Member res = mapper.getMember("username");
        
        assertEquals(1,res.getID());
        assertEquals("username",res.getUsername());
        assertEquals("firstname",res.getFirstName());
        assertEquals("lastname",res.getLastName());
        assertEquals(19,res.getAge());
        assertEquals(LocalDate.of(2000,Month.JANUARY,01),res.getBirthday());
        assertEquals(Gender.MALE,res.getGender());
        assertEquals("bio",res.getBio());
    }

}