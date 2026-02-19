// MAIN APP

import java.util.*;

public class BookingApp {

    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();
    private final BookingService bookingService = new BookingService();


    public static void main(String[] args) {
        new BookingApp().start();
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to the booking app!");
            if (!userService.isLoggedIn()) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println("Choose your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("Wrong choice");
                }
            }
            // if user already logged in
            else {
                System.out.println("Welcome to the booking app!");

            }
        }
    }

    // register user
    public void register() {
        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();
        scanner.nextLine();
        System.out.println("Enter your email: ");
        String mobileNumber = scanner.next();
        scanner.nextLine();
        System.out.println("Enter your full name: ");
        String fullName = scanner.next();
        scanner.nextLine();
        System.out.println("Enter your phone number: ");
        String phoneNumber = scanner.next();

        userService.registerUser(username, password, mobileNumber, fullName, phoneNumber);
    }

    //login
    public void login() {
        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();

        userService.loginUser(username, password);
    }

    // exit
    private void exitApp() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    // if user is already logged-in we will show him this menu
    private void showUserMenu() {
        while (userService.isLoggedIn()) {
            System.out.println("-----USER MENU -----");
            System.out.println("1. Search Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Tickets");
            System.out.println("4. Cancel Tickets");
            System.out.println("5. View all Trains");
            System.out.println("6. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> searchTrain();
                case 2 -> bookTicket();
                case 3 -> viewMyTicket();
                case 4 -> cancelTicket();
                case 5 -> bookingService.listOfAllTrains();
                case 6 -> userService.logoutUser();
                default -> System.out.println("Wrong choice.. choose form 1 to 6");
            }
        }
    }

    private void searchTrain() {
        System.out.println("Enter Source Station: ");
        String src = scanner.nextLine();
        System.out.println("Enter Destination Station: ");
        String dst = scanner.nextLine();

        List<Train> trains = bookingService.searchTrain(src, dst);

        if (trains.isEmpty()) {
            System.out.println("No trains found between " + src + " and " + dst);
            return;
        }
        System.out.println("Available trains between " + src + " and " + dst);
        for (Train train : trains) {
            System.out.println(train);
        }

        // after showing train we give user 2 option 1. if he/she wants to book train or 2. exit
        System.out.println("Do you want to book trains? (yes/no)");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Enter train id to book:");
            int trainId = scanner.nextInt();
            System.out.println("Enter number of seats to book:");
            int seats = scanner.nextInt();

            // book ticket
            Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(), trainId, seats);

            if (ticket != null) {
                System.out.println("booking successful");
                System.out.println(ticket);
            }
        } else {
            System.out.println("Return to main menu");
        }
    }

    private void bookTicket() {
        System.out.println("Enter Source Station: ");
        String src = scanner.nextLine();
        System.out.println("Enter Destination Station: ");
        String dst = scanner.nextLine();

        List<Train> trains = bookingService.searchTrain(src, dst);
        if (trains.isEmpty()) {
            System.out.println("No trains found between " + src + " and " + dst);
            return;
        }
        System.out.println("Available trains between " + src + " and " + dst);
        for (Train train : trains) {
            System.out.println(train);
        }

        // if available
        System.out.println("Enter train id to book:");
        int trainId = scanner.nextInt();
        System.out.println("Enter number of seats to book:");
        int seats = scanner.nextInt();
        Ticket ticket = bookingService.bookTicket(userService.getCurrentUser(), trainId, seats);

        if (ticket != null) {
            System.out.println("booking successful");
            System.out.println(ticket);
        } else {
            System.out.println("Some internal error occurred");
        }
    }

    private void viewMyTicket() {
        List<Ticket> ticketByUser = bookingService.getTicketByUser(userService.getCurrentUser());
        if (ticketByUser.isEmpty()) {
            System.out.println("No tickets found");
        } else {
            System.out.println("Your tickets are");
            for (Ticket ticket : ticketByUser) {
                System.out.println(ticket);
            }
        }
    }

    private void cancelTicket() {
        System.out.println("Enter the ticket id to cancel:");
        int ticketId = scanner.nextInt();
        bookingService.cancelTicket(ticketId, userService.getCurrentUser());
    }

}
