import java.io.File;
import java.io.FileWriter;
import java.io.IOException;    // referred from Stackoverflow
import java.util.ArrayList;
import java.util.Collections;  // referred from Stackoverflow
import java.util.Scanner;

public class Theatre {
    // creating an ArrayList and add TicketDetails.
    static ArrayList<Ticket> details = new ArrayList<Ticket>();

    public static void main(String[] args) {
        System.out.println();
        System.out.println("  Welcome to the New Theatre");

        int[] row1 = new int[12];
        int[] row2 = new int[16];
        int[] row3 = new int[20];

        Scanner scanner = new Scanner(System.in);
        boolean toContinueProgram = true;
        do {
            System.out.println(String.join("", Collections.nCopies(80, "-")));  // referred from Stackoverflow
            System.out.println(" Please select an option:\n\n1) Buy a ticket\n2) Print seating area\n3) Cancel ticket\n4) List available seats\n5) Save to file\n6) Load from file\n7) Print ticket information and total price\n8) Sort tickets by price\n0) Quit");
            System.out.println(String.join("", Collections.nCopies(80, "-")));
            System.out.print("Enter option: ");

            // calling the method Integer validation to check whether the user input is an integer.
            IntegerValidation(scanner,"Invalid option please enter a value (1 - 8 or 0 to Quit): ");

            int option = scanner.nextInt();
            switch(option){
                case 1:
                    buy_ticket(row1,row2,row3);
                    break;
                case 2:
                    print_seating_area(row1,row2,row3);
                    break;
                case 3:
                    cancel_ticket(row1,row2,row3);
                    break;
                case 4:
                    show_available(row1, row2, row3);
                    break;
                case 5:
                    save(row1, row2, row3);
                    break;
                case 6:
                    load(row1, row2, row3);
                    break;
                case 7:
                    show_tickets_info();
                    break;
                case 8:
                    sort_tickets();
                    break;
                case 0:
                    System.out.println(" Program ends!");
                    System.exit(0);
            }
        } while(toContinueProgram);
    }
    public static void buy_ticket(int[] row1,int[] row2,int[] row3){
        int row_num = 0;
        int seat_num = 0;
        Scanner scanner = new Scanner(System.in);
        // calling the method getStringInput to check whether the user input is a String.
        String name = getStringInput("name");
        // calling the method getStingInput to check whether the user input is a String.
        String surname = getStringInput("surname");

        System.out.print("Enter your email: ");
        String email = scanner.next();

        // creating an object of personDetails.
        Person personDetails = new Person(name, surname, email);

        System.out.print("\nEnter the Row number and Seat number,\nRow number(1-3): ");

        boolean invalid_Row = true;
        do {
            // calling the method IntegerValidation to check whether the user input is an integer.
            IntegerValidation(scanner,"Invalid input please enter a value(1-3): ");

            row_num = scanner.nextInt();
            if (row_num > 3){ System.out.print("Invalid Row number, please enter a correct Row number(1-3) :"); }
            else
                invalid_Row = false;

        }while (invalid_Row);

        boolean invalid_Seat = true;
        switch (row_num){
            case 1:
                do {
                    System.out.print("Enter the seat number: ");
                    // calling the method IntegerValidation to check whether the user input is an integer.
                    IntegerValidation(scanner,"Invalid input please enter a value(1-12): ");

                    seat_num = scanner.nextInt();
                    if (seat_num > 13) { System.out.println("Invalid Seat number, please enter a correct Seat number(1-12): "); }

                    else {
                        if (row1[seat_num-1] == 0){
                            System.out.print("Enter your ticket price: £.");
                            // calling the method IntegerValidation to check whether the user input is an integer.
                            IntegerValidation(scanner,"Invalid currency, Try again: ");

                            int price = scanner.nextInt();

                            // making the ticket object and adding details to the array list.
                            Ticket allTheDetails = new Ticket(row_num, seat_num, price, personDetails);
                            details.add(allTheDetails);

                            row1[seat_num-1] = 1;
                            System.out.println("Thank you, Your Booking request is Successful.");

                        } else { System.out.println("Sorry, The Seat has already Occupied (Sold).");}

                        invalid_Seat = false;
                    }
                } while (invalid_Seat);
                break;

            case 2:
                do {
                    System.out.print("Enter the seat number: ");
                    // calling the method IntegerValidation to check whether the user input is an integer.
                    IntegerValidation(scanner,"Invalid input please enter the seat number: ");

                    seat_num = scanner.nextInt();
                    if (seat_num > 17) { System.out.println("Invalid input please enter a correct seat number"); }
                    else {
                        if (row2[seat_num - 1] == 0) {
                            System.out.print("Enter the ticket price: ");
                            // calling the method IntegerValidation to check whether the user input is an integer.
                            IntegerValidation(scanner,"Invalid currency, Try again: ");

                            int price = scanner.nextInt();

                            // making the ticket object and adding details to the array list.
                            Ticket allTheDetails = new Ticket(row_num, seat_num, price, personDetails);
                            details.add(allTheDetails);

                            row2[seat_num - 1] = 1;
                            System.out.println("Thank you, Your Booking request is Successful.");
                        } else
                            System.out.println("Sorry, The Seat has already Occupied (Sold).");
                        invalid_Seat = false;
                    }
                } while (invalid_Seat);
                break;

            case 3:
                do {
                    System.out.print("Enter the seat number: ");
                    // calling the method IntegerValidation to check whether the user input is an integer.
                    IntegerValidation(scanner,"Invalid input please enter a correct seat number: ");

                    seat_num = scanner.nextInt();
                    if (seat_num > 21) { System.out.println("Invalid input please enter a correct Row number");}
                    else{
                        if (row3[seat_num - 1] == 0){
                            System.out.print("Enter the ticket price: ");
                            // calling the method IntegerValidation to check whether the user input is an integer.
                            IntegerValidation(scanner,"Invalid currency. Add again: ");

                            int price = scanner.nextInt();

                            // making the ticket object and adding details to the array list.
                            Ticket allTheDetails = new Ticket(row_num, seat_num, price, personDetails);
                            details.add(allTheDetails);

                            row3[seat_num - 1] = 1;
                            System.out.println("Thank you, Your Booking request is Successful.");
                        } else
                            System.out.println("Sorry, The Seat has already Occupied (Sold).");
                        invalid_Seat=false;
                    }
                } while (invalid_Seat);
                break;
        }
    }
    public static void print_seating_area (int[] row1, int[] row2, int[] row3) {
        System.out.println();
        System.out.print("     ***********\n     *  STAGE  *\n     ***********");

        System.out.print("\n    ");
        int j=0;
        for (int i=0; i <= row1.length; i++) {
            if(i==6) {
                System.out.print(" ");
                continue;
            }
            if (row1[j] == 1) { System.out.print("X");
            } else
                System.out.print("O");
            j++;
        }

        System.out.print("\n  ");
        j=0;
        for (int i=0; i <= row2.length; i++) {
            if(i==8) { System.out.print(" ");
                continue;
            }
            if (row2[j] == 1) { System.out.print("X");
            } else
                System.out.print("O");
            j++;
        }

        System.out.println();
        j=0;
        for (int i=0; i <= row3.length; i++) {
            if(i==10){
                System.out.print(" ");
                continue;
            }
            if (row3[j] == 1) { System.out.print("X");
            } else
                System.out.print("O");
            j++;
        }
        System.out.println();
    }
    public static void cancel_ticket(int[] row1,int[] row2,int[] row3){
        int row_num = 0;
        int seat_num = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the Row number and Seat number you want to cancel,\nRow number(1-3): ");

        boolean invalid_Row = true;
        do {
            // making the ticket object and adding details to the array list.
            IntegerValidation(scanner,"Invalid input please enter a value(1-3): ");

            row_num = scanner.nextInt();
            if (row_num > 3) { System.out.print("Invalid Row number, please enter a correct Row number(1-3) :"); }
            else
                invalid_Row = false;

        } while (invalid_Row);

        boolean invalid_Seat = true;
        switch (row_num){
            case 1:
                do {
                    System.out.print("Enter the seat number: ");
                    // making the ticket object and adding details to the array list.
                    IntegerValidation(scanner,"Invalid input please enter a value(1-12): ");

                    seat_num = scanner.nextInt();

                    if (seat_num > 13) { System.out.println("Invalid Seat number, please enter a correct Seat number(1-12): "); }
                    else {
                        if (row1[seat_num-1] == 1){
                            row1[seat_num-1] = 0;

                            for ( Ticket detail: details){
                                if (detail.row() == row_num && detail.seat() == seat_num){
                                    details.remove(detail);
                                    break;
                                }
                            }
                            System.out.println("Your cancellation request is successful.");
                        } else
                            System.out.println("The Seat is already not Booked.");
                        invalid_Seat = false;
                    }
                } while (invalid_Seat);
                break;

            case 2:
                do {
                    System.out.print("Enter the seat number: ");
                    // making the ticket object and adding details to the array list.
                    IntegerValidation(scanner,"Invalid input please enter the seat number: ");

                    seat_num = scanner.nextInt();
                    if (seat_num > 17){  System.out.println("Invalid input please enter a correct seat number"); }
                    else {
                        if (row2[seat_num - 1] == 1) {
                            row2[seat_num - 1] = 0;

                            for (Ticket detail: details){
                                if(detail.row() == row_num && detail.seat() == seat_num){
                                    details.remove(detail);
                                    break;
                                }
                            }
                            System.out.println("Your cancellation request is successful.");
                        } else
                            System.out.println("The Seat is already not Booked.");
                        invalid_Seat = false;
                    }
                }while (invalid_Seat);
                break;

            case 3:
                do {
                    System.out.print("Enter the seat number: ");
                    // making the ticket object and adding details to the array list.
                    IntegerValidation(scanner,"Invalid input please enter a correct seat number: ");

                    seat_num = scanner.nextInt();
                    if (seat_num > 21)
                        System.out.println("Invalid input please enter a correct seat number");

                    else{
                        if (row3[seat_num - 1] == 1){
                            row3[seat_num - 1] = 0;

                            //remove object of cancel ticket from array list.
                            for(Ticket detail: details){
                                if (detail.row() == row_num && detail.seat() == seat_num){
                                    details.remove(detail);
                                    break;
                                }
                            }
                            System.out.println("Your cancellation request is successful.");
                        } else
                            System.out.println("The Seat is already not Booked.");
                        invalid_Seat=false;
                    }
                } while (invalid_Seat);
                break;
        }
    }
    public static void show_available(int[] row1,int[] row2,int[] row3){
        System.out.print("Seats available in Row 1 =  ");
        for (int i = 0; i < row1.length; i++){
            if (!(row1[i] == 1))
                System.out.print(i+1 + ", ");
            else
                System.out.print("");
        } System.out.println();

        System.out.print("Seats available in Row 2 =  ");
        for (int i = 0; i < row2.length; i++){
            if (!(row2[i] == 1))
                System.out.print(i+1 + ", ");
            else
                System.out.print("");
        } System.out.println();

        System.out.print("Seats available in Row 3 =  ");
        for (int i = 0; i < row3.length; i++){
            if (!(row3[i] == 1))
                System.out.print(i+1 + ", ");
            else
                System.out.print("");
        } System.out.println();
    }
    public static void save(int[] row1,int[] row2,int[] row3) {
        System.out.println("Data saved to the File successfully!");
        try{
            File seatFile = new File("seatFile.txt");
            FileWriter writeFile = new FileWriter(seatFile);

            writeFile.write("Seats available in Row 1:-  ");
            for (int i = 0; i < row1.length; i++){
                if(row1[i] == 0)
                    writeFile.write(Integer.toString(i+1));
                else
                    writeFile.write("X");
                if (!(i == row1.length-1))
                    writeFile.write(", ");
                else
                    writeFile.write (".\n");
            }

            writeFile.write("Seats available in Row 2:-  ");
            for (int i=0; i < row2.length; i++){
                if(row2[i] == 0)
                    writeFile.write(Integer.toString(i+1));
                else
                    writeFile.write("X");
                if (!(i == row2.length-1))
                    writeFile.write(", ");
                else
                    writeFile.write (".\n");
            }

            writeFile.write("Seats available in Row 3:-  ");
            for (int i=0; i < row3.length; i++){
                if(row3[i] == 0)
                    writeFile.write(Integer.toString(i+1));
                else
                    writeFile.write("X");
                if (!(i == row3.length-1))
                    writeFile.write(", ");
                else
                    writeFile.write (".\n");
            }
            writeFile.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();  // referred from stackoverflow
        }
    }
    public static void load(int[] row1, int[] row2, int[] row3) {
        System.out.println("File Loaded successfully!");
        try{
            File seatFile = new File("seatFile.txt");
            Scanner scanFile = new Scanner(seatFile);

            int count = 1;

            while (scanFile.hasNextLine()){
                String line = scanFile.nextLine();
                String[] seatPart = line.split("-");
                String  seatNumberRecordSeat= seatPart[1].trim();
                String  seatNumberRecord= seatNumberRecordSeat.substring(0,seatNumberRecordSeat.length()-1);
                String[] seatNumbers = seatNumberRecord.split(",");

                switch (count){
                    case 1:
                        loadOccupiedSeat(seatNumbers,row1);
                        break;
                    case 2:
                        loadOccupiedSeat(seatNumbers,row2);
                        break;
                    case 3:
                        loadOccupiedSeat(seatNumbers,row3);
                        break;
                }
                count++;
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }       //load booked data from save file to arrays
    public static void loadOccupiedSeat(String[] seatNumbers,int[] row) {
        for (int i =0; i < seatNumbers.length; i++){
            if (seatNumbers[i].trim().equals("X")) {
                row[i] = 1;
            }
        }
    }
    public static void show_tickets_info() {
        int total = 0;
        //get objects from array list and print the object calling print method in the ticket class
        for (Ticket print : details){
            print.print();
            total += print.price();
        }
        System.out.println("Total Price of the Tickets booked: " + total);
    }
    public static void sort_tickets() {
        int lastIndex = details.size()-2;
        Ticket temp;
        boolean exchange = true;
        while(exchange){
            exchange = false;
            for(int i=0; i <= lastIndex; i++){
                if( details.get(i).price() > details.get(i+1).price()){ //check the price of index is greater than the next index price
                    temp = details.get(i);
                    details.set(i,details.get(i+1)); // Switching the indexes
                    details.set(i+1,temp);  // Switching the indexes
                    exchange = true;
                }
            }
            lastIndex--;
        }
        for (int i = 0; i < details.size(); i++) {
            Ticket l = details.get(i);
            l.print();
            System.out.println();
        }
    }   //sort ticket details with the price of the ticket
    public static void IntegerValidation(Scanner scanner,String change) {
        while (!(scanner.hasNextInt())) {
            System.out.printf("%s",change);
            scanner.next();
        }
    }
    public static String getStringInput(String change) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your %s: ", change);
        do {
            String input = scanner.next();
            if (input.matches("[a-zA-Z\\s'-\\.]+")) {  // referred from stackoverflow.
                return input;
            }else System.out.print("Invalid input.Try again: ");
        }while (true);
    }
}
