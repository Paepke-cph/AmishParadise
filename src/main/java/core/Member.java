package core;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Member {
    private static final int MAX_BIO_LENGTH = 400;
    private int id;
    private String username, firstName, lastName, imagePath, bio;
    private LocalDate birthdate;
    private Gender gender;
    
    /**
     * Used when creating a member in memory.
     * @param username
     * @param firstName
     * @param lastName
     * @param birthdate
     * @param gender 
     */
    public Member(String username, String firstName,String lastName,
            LocalDate birthdate, Gender gender) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
    }
    
    /**
     * Use when pulling members from the database.
     * @param id
     * @param username
     * @param firstName
     * @param lastName
     * @param birthdate
     * @param gender
     * @param bio 
     */
    public Member(int id, String username, String firstName,String lastName,
            LocalDate birthdate, Gender gender,String bio) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.bio = bio;
    }
    
    public int getAge() { return (int)ChronoUnit.YEARS.between(birthdate, LocalDate.now()); }
    
    public void setID(int id) { this.id = id; }
    public int getID() { return id; }
    
    public void setUsername(String username) { this.username = username; }
    public String getUsername() { return username; }
    
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }
    
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }
    
    public void setBirthday(LocalDate birthday) { this.birthdate = birthday;} 
    public LocalDate getBirthday() { return birthdate; }
    
    public void setGender(Gender gender) {this.gender = gender;}
    public Gender getGender() { return gender; }
    
    public void setProfilePicture(String path) { imagePath = path;}
    public String getProfilePicture() { return imagePath; }
    
    public void setBio(String bio) {
        if(bio != null && bio.length() > MAX_BIO_LENGTH) 
            throw new IllegalArgumentException("Bio is too long");
        else
            this.bio = bio;
    }
    
    public String getBio() { return bio; }
}
