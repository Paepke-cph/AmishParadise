package core;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Benjamin
 */
public class GenderTest {

    public GenderTest() {
    }

    /**
     * Test of values method, of class Gender.
     */
    @Test
    public void testValues() {
        Gender[] genders = new Gender[]{Gender.MALE,Gender.FEMALE};
        for (int i = 0; i < Gender.values().length; i++) {
            assertEquals(genders[i],Gender.values()[i]);
        }
    }

    /**
     * Test of getText method, of class Gender.
     */
    @Test
    public void testGetText() {
        assertEquals("Male",Gender.MALE.getText());
        assertEquals("Female",Gender.FEMALE.getText());
    }

    /**
     * Test of from method, of class Gender.
     */
    @Test
    public void testFrom() {
        assertEquals(Gender.MALE, Gender.from("Male"));
        assertEquals(Gender.FEMALE, Gender.from("Female"));
    }
}