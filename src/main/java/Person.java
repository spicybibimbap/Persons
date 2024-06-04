public class Person {
    private String firstname;
    private String lastname;
    private String birthday;

    public Person(String firstname, String lastname, String birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthday() {
        return birthday;
    }
}