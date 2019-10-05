package core;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");
    
    private String text;
    private Gender(String text) {
        this.text = text;
    }
    public String getText() {return text;}
}
