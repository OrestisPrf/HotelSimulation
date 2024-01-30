/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelex;

import java.util.Random;

public class Client {

    private static int nextId = 1;

    private int id;
    private BedType beds;
    private RoomType roomType;
    private int preferredFloor;
    private int stayDuration;

    public Client(int numberOfFloors) {
        this.id = nextId++;
        decideBooking(numberOfFloors);
    }

//    public Client(int preferredFloor, BedType beds, RoomType roomType, int stayDuration) {
//        this.id = nextId++;
//        this.beds = beds;
//        this.preferredFloor = preferredFloor;
//        this.stayDuration = stayDuration;
//        this.roomType = roomType;
//    }

    private void decideBooking(int numberOfFloors) {
        Random random = new Random();
        beds = (random.nextBoolean()) ? BedType.DIKLINO : BedType.TRIKLINO;
        roomType = (random.nextBoolean()) ? RoomType.STD : RoomType.SUP;
        preferredFloor = (random.nextBoolean()) ? random.nextInt(numberOfFloors) + 1 : 0;
        stayDuration = random.nextInt(Statics.stayDuration) + 1; // Stay duration between 1 and 5 days
    }

    public int getId() {
        return id;
    }

    public BedType getBeds() {
        return beds;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getPreferredFloor() {
        return preferredFloor;
    }

    public int getStayDuration() {
        return stayDuration;
    }

    public String printBookingDetails() {
        return "Client " + id + " wants to book: "
                + beds + "-bed " + roomType + " room on floor "
                + preferredFloor + " for " + stayDuration + " days.\n";
    }
}
