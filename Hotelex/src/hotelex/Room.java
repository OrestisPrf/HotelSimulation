/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelex;

/**
 *
 * @author LENOVO
 */
public class Room {

    private int number;
    private BedType beds;
    private RoomType roomType;
    private Client client;
    private int checkOutDate;

    public Room(int number, BedType beds, RoomType roomType) {
        this.number = number;
        this.beds = beds;
        this.roomType = roomType;
        this.client = null; // Initially, no client stays in the room
        this.checkOutDate = 0; // 0 indicates no client in the room
    }

  

    public int getNumber() {
        return number;
    }

    public BedType getNumBeds() {
        return getBeds();
    }

    public RoomType getType() {
        return getRoomType();
    }

    public Client getClient() {
        return client;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCheckOutDate(int checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void checkIn(Client client, int simDay, FileProc fp) {
        if (isEmpty()) {
            setClient(client);
            setCheckOutDate(simDay + this.client.getStayDuration());
            fp.appendToFile("Room " + number + " is booked by Client " + client.getId() + " until Day " + checkOutDate + ".\n");
//            System.out.println("Room " + number + " is booked by Client " + client.getId()
//                    + " until Day " + checkOutDate + ".");
        } else {
            fp.appendToFile("It is booked. \n");
//            System.out.println("It is booked");
        }
    }

    public void checkOut(FileProc fp) {
        fp.appendToFile("Client " + client.getId() + " is checking out from Room " + number+ ". Room is now available.\n");
//        System.out.println("Client " + client.getId() + " is checking out from Room " + number
//                + ". Room is now available.");
        setClient(null);
        setCheckOutDate(0);
    }

    public boolean isEmpty() {
        return client == null;
    }

    /**
     * @return the beds
     */
    public BedType getBeds() {
        return beds;
    }

    /**
     * @param beds the beds to set
     */
    public void setBeds(BedType beds) {
        this.beds = beds;
    }

    /**
     * @return the roomType
     */
    public RoomType getRoomType() {
        return roomType;
    }

    /**
     * @param roomType the roomType to set
     */
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


}
