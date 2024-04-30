// creating a class named person.
public class Person {
    // Adding instance variables.
    private String name;
    private String surname;
    private String email;

    // Adding a constructor.
    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Getter for name.
    public String getname(){
        return name;
    }

    //  Getter for surname.
    public String getsurname(){
        return surname;
    }

    // Getter for email.
    public String getemail(){
        return email;
    }
}
