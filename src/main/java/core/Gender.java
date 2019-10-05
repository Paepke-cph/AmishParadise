package core;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");
    
    private String text;
    private Gender(String text) {
        this.text = text;
    }
    public String getText() {return text;}
    
    @Override
    public String toString() { return text; }
    
    public static Gender from(String s) {
        Gender[] genders = Gender.values();
        for (int i = 0; i < genders.length; i++) {
            if(genders[i].getText().toLowerCase().equals(s.toLowerCase())) return genders[i];
        }
        return null;
    }
}
