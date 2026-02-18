// Booking service

import java.util.*;

public class BookingService {
    private List<Train> trainList = new ArrayList<>(); // list of trains
    private List<Ticket> ticketList = new ArrayList<>();  // list of tickets

    //constructor
    public BookingService(){
        trainList.add(new Train(101, "Rajdhani Express", "Howrah", 1455, "Delhi"));
        trainList.add(new Train(102, "Apple Express", "Howrah", 1055, "Kashmir"));
        trainList.add(new Train(103, "Duronto Express", "Mumbai", 1230, "Delhi"));
        trainList.add(new Train(104, "Shatabdi Express", "Chennai", 930, "Bangalore"));
        trainList.add(new Train(105, "Garib Rath", "Patna", 2215, "New Delhi"));
        trainList.add(new Train(106, "Vande Bharat Express", "Varanasi", 600, "New Delhi"));
        trainList.add(new Train(107, "Humsafar Express", "Ahmedabad", 1745, "Kolkata"));
    }

    // search train, return list of trains [also can add date]
    public List<Train> searchTrain(String source, String destination){
        List<Train> res = new ArrayList<>();  // here we will store resultant trains
        // loop through train
        for (Train train : trainList){
            if(train.getSrcStation().equalsIgnoreCase(source) && train.getDstStation().equalsIgnoreCase(destination)){
                res.add(train);  // add the result train in the res
            }
        }
        return res;
    }

    //ticket booking [need user, trainId, seatCount]
    public Ticket bookTicket(User user, int trainId, int seatCount){
        for(Train train : trainList){
            if(train.getTrainID() == trainId){
                // if there is enough seat available then only user will get ticket
                if(train.bookSeat(seatCount)){
                    Ticket ticket = new Ticket(user, train, seatCount);
                    ticketList.add(ticket);
                    return ticket;
                }
                // if there is not enough seats
                else{
                    System.out.println("not enough seats available");
                    return null;
                }
            }
        }
        System.out.println("Train id not found");
        return null;
    }


    // check all trains [need username to check your booked ticket]
    public List<Ticket> getTicketByUser(User user){
        List<Ticket> res = new ArrayList<>();
        // loop through ticket
        for(Ticket ticket : ticketList){
            // check the ticket username is matched with provided username
            if(ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                res.add(ticket);
            }
        }
        return res;
    }

    // cancel ticket [need ticket_id to know which ticket we have to delete and the username who owns the ticket]
    public boolean cancelTicket(int ticketId, User user){
        Iterator<Ticket> iterator = ticketList.listIterator();
        while(iterator.hasNext()){
            Ticket ticket = iterator.next();
            // check current ticket's ticket_id and username with provided ones
            if(ticket.getTicketId() == ticketId && ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                Train train = ticket.getTrain();  // fetch the trains from the ticket
                train.cancelSeat(ticket.getSeatBooked());  // cancel the ticket from the train, so the seatCount gets increased
                iterator.remove();
                System.out.println("Ticket" + ticketId+"cancelled successfully");
                return true;
            }
        }
        System.out.println("Ticket not found or does not belong to the current user");
        return false;
    }

    //list of all trains
    public void listOfAllTrains(){
        System.out.println("All trains");
        for(Train train : trainList){
            System.out.println(train);
        }
    }
}

