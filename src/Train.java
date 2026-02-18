public class Train {
    private int trainID;
    private String trainName;
    private String srcStation;
    private String dstStation;
    private int totalSeat;
    private int avlSeats;

    // constructor
    public Train(int trainID, String trainName, String srcStation, int totalSeat, String dstStation) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.srcStation = srcStation;
        this.totalSeat = totalSeat;
        this.dstStation = dstStation;
        this.avlSeats = totalSeat;  // for a new train available seats = total seats
    }

    // all getter and setter methods
    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getDstStation() {
        return dstStation;
    }

    public void setDstStation(String dstStation) {
        this.dstStation = dstStation;
    }

    public String getSrcStation() {
        return srcStation;
    }

    public void setSrcStation(String srcStation) {
        this.srcStation = srcStation;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getAvlSeats() {
        return avlSeats;
    }

    public void setAvlSeats(int avlSeats) {
        this.avlSeats = avlSeats;
    }

    // method to book seats
    public boolean bookSeat(int count){
        if(count<=avlSeats){
            avlSeats -= count;  // after booking seats available seats will be reduces
            return true;
        }
        System.out.println("Available seats is less than your required seats");
        return false;
    }

    //method to cancel seat
    public void cancelSeat(int count){
        avlSeats += count; // after cancellation available seats will be increased
    }

    //to-string method
    @Override
    public String toString() {
        return trainID + " | " + trainName + " | " + srcStation + " | " + dstStation +  " | No of Total Seat: " + totalSeat + " | Seats Available: " + avlSeats;
    }
}

