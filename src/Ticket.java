public class Ticket {
    private final int ticketId;
    private User user;  // This defines the ticket belong to which user
    private Train train; // This defines the ticket belong to which train
    private int seatBooked;  // no of ticket or how many seats wants to book the user
    private static int counter = 1000; // This counter to maintain the ticketID

    //constructor
    public Ticket(User user, Train train, int seatBooked) {
        this.ticketId = counter++;  // this counter will increase every time
        this.user = user;
        this.train = train;
        this.seatBooked = seatBooked;
    }

    //getter setter methods
    public int getTicketId() {
        return ticketId;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    public int getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        this.seatBooked = seatBooked;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // to-string method
    @Override
    public String toString() {
        return "Ticket Id: " + ticketId + " | belongs to: " + user + " \n| train name: " + train.getTrainName() + " | destination station: " + train.getDstStation() + " \n| total booked seats: " + seatBooked + " | booked By: " + user.getFullName();
    }
}
