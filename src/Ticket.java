// creating a class named Ticket.
public class Ticket {
    // Adding instance variables.
    private int row;
    private int seat;
    private int price;
    private Person person;

    // creating a constructor.
    public Ticket(int row, int seat, int price,Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // creating a method called print.
    void print() {
        System.out.println("Person name: " + person.getname());
        System.out.println("Person surname: " + person.getsurname());
        System.out.println("Person email: " + person.getemail());
        System.out.println("Row num: " + row);
        System.out.println("Seat num: " + seat);
        System.out.println("Price: " + price + "\n");
    }

    // Getter for row.
    public int row(){
        return row;
    }

    // Getter for seat.
    public int seat(){
        return seat;
    }

    // Getter for price.
    public int price(){
        return price;
    }
}
