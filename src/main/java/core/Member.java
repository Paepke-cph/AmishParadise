package core;

import java.time.LocalDate;

public class Member {
    private int id;
    private String username, firstName, lastName;
    private LocalDate birthdate;
    private Gender gender;
    private String imagePath;
    
    public Member(String username, String firstName,String lastName, LocalDate birthdate, Gender gender) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
    }
    
    public void setID(int id) { this.id = id; }
    public int getID() { return id; }
    
    public void setNickName(String nickName) { this.username = nickName; }
    public String getNickName() { return username; }
    
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }
    
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }
    
    public void setBirthday(LocalDate birthday) { this.birthdate = birthday;} 
    public LocalDate getBirthday() { return birthdate; }
    
    public void setGender(Gender gender) {this.gender = gender;}
    public Gender getGender() { return gender; }
}
