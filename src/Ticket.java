public class Ticket {
    private final int ticketId;
    private User user;
    private Train train;
    private int seatBooked;
    private static int counter = 1000;

    public Ticket(User user, Train train, int seatBooked) {
        this.ticketId = counter++;
        this.user = user;
        this.train = train;
        this.seatBooked = seatBooked;
    }

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

    @Override
    public String toString() {
        return "Ticket Id" + ticketId + " | " + user + " | " + train.getTrainName() + " | destination: " + train.getDstStation() + " | seats: " + seatBooked + " | booked By: " + user.getFullName();
    }
}
