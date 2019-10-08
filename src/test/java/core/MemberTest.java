package core;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Benjamin
 */
public class MemberTest {

    private Member member;

    public MemberTest() {
    }

    @Before
    public void setup() {
        member = new Member(1, "username", "firstname", "lastname", LocalDate.of(2000, Month.OCTOBER, 01), Gender.MALE, "bio");
    }

    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAge() {
        int age = 19;
        assertEquals(age, member.getAge());
    }

    /**
     * Test of setID method, of class Member.
     */
    @Test
    public void testSetID() {
        int id = 100;
        member.setID(100);
        assertEquals(id, member.getID());
    }

    /**
     * Test of getID method, of class Member.
     */
    @Test
    public void testGetID() {
        int id = 1;
        assertEquals(id, member.getID());
    }

    /**
     * Test of setUsername method, of class Member.
     */
    @Test
    public void testSetUsername() {
        String username = "uname";
        member.setUsername("uname");
        assertEquals(username, member.getUsername());
    }

    /**
     * Test of getUsername method, of class Member.
     */
    @Test
    public void testGetUsername() {
        String username = "username";
        assertEquals(username, member.getUsername());
    }

    /**
     * Test of setFirstName method, of class Member.
     */
    @Test
    public void testSetFirstName() {
        String firstName = "fname";
        member.setFirstName("fname");
        assertEquals(firstName, member.getFirstName());
    }

    /**
     * Test of getFirstName method, of class Member.
     */
    @Test
    public void testGetFirstName() {
        String firstName = "firstname";
        assertEquals(firstName, member.getFirstName());
    }

    /**
     * Test of setLastName method, of class Member.
     */
    @Test
    public void testSetLastName() {
        String lastName = "lname";
        member.setLastName("lname");
        assertEquals(lastName, member.getLastName());
    }

    /**
     * Test of getLastName method, of class Member.
     */
    @Test
    public void testGetLastName() {
        String lastName = "lastname";
        assertEquals(lastName, member.getLastName());
    }

    /**
     * Test of setBirthday method, of class Member.
     */
    @Test
    public void testSetBirthday() {
        LocalDate date = LocalDate.of(2000, Month.JANUARY, 01);
        member.setBirthday(LocalDate.of(2000, Month.JANUARY, 01));
        assertEquals(date, member.getBirthday());
    }

    /**
     * Test of getBirthday method, of class Member.
     */
    @Test
    public void testGetBirthday() {
        LocalDate date = LocalDate.of(2000, Month.OCTOBER, 01);
        assertEquals(date, member.getBirthday());
    }

    /**
     * Test of setGender method, of class Member.
     */
    @Test
    public void testSetGender() {
        Gender gender = Gender.FEMALE;
        member.setGender(Gender.FEMALE);
        assertEquals(gender, member.getGender());
    }

    /**
     * Test of getGender method, of class Member.
     */
    @Test
    public void testGetGender() {
        Gender gender = Gender.MALE;
        assertEquals(gender, member.getGender());
    }

    /**
     * Test of setProfilePicture method, of class Member.
     */
    @Test
    public void testSetProfilePicture() {
        String path = "images/pp.jpg";
        member.setProfilePicture("images/pp.jpg");
        assertEquals(path, member.getProfilePicture());
    }

    /**
     * Test of getProfilePicture method, of class Member.
     */
    @Test
    public void testGetProfilePicture() {
        String path = "images/pp.jpg";
        member.setProfilePicture("images/pp.jpg");
        assertEquals(path, member.getProfilePicture());
    }

    /**
     * Test of setBio method, of class Member.
     */
    @Test
    public void testSetBio() {
        String bio = "this is a new bio";
        member.setBio("this is a new bio");
        assertEquals(bio, member.getBio());
    }

    /**
     * Test of getBio method, of class Member.
     */
    @Test
    public void testGetBio() {
        String bio = "bio";
        assertEquals(bio, member.getBio());
    }

}
