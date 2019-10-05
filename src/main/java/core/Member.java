package core;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Member {
    private int id;
    private String username, firstName, lastName, imagePath;
    private LocalDate birthdate;
    private Gender gender;
    
    public Member(String username, String firstName,String lastName,
            LocalDate birthdate, Gender gender) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
    }
    
    public Member(int id, String username, String firstName,String lastName,
            LocalDate birthdate, Gender gender) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
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
}
