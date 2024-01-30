/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelex;

import java.util.ArrayList;

/**
 *
 * @author foivl
 */
public class Hotel {

    private String name;
    private ArrayList<Floor> floors;

    public Hotel(String name, int numFloors) {
        this.name = name;
        this.floors = new ArrayList<>();
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new Floor(i));
        }
    }

    public void setFloorData(int floorNumber, ArrayList<Integer> roomNumbers, BedType beds, RoomType roomType) {
        Floor floor = getFloor(floorNumber);
        if (floor != null) {
            floor.setRoomData(roomNumbers, beds, roomType);
        }
    }

    public void setFloorData(int floorNumber, int roomNumber, BedType beds, RoomType roomType) {
        Floor floor = getFloor(floorNumber);
        if (floor != null) {
            floor.setRoomData(roomNumber, beds, roomType);
        }
    }
    
    public void setFloorData(Floor floor, int roomNumber, BedType beds, RoomType roomType) {
        if (floor != null) {
            floor.setRoomData(roomNumber, beds, roomType);
        }
    }

    public Floor getFloor(int floorNumber) {
        for (Floor floor : getFloors()) {
            if (floor != null && floor.getFloorNo() == floorNumber) {
                return floor;
            }
        }
        return null;
    }

    public Room searchRoom(BedType beds, RoomType roomType) {
        for (Floor floor : getFloors()) {
            for (Room room : floor.getRooms()) {
                if (room != null && room.isEmpty() && room.getRoomType() == roomType && room.getBeds() == beds) {
                    return room;
                }
            }
        }
        return null;
    }

    public Room searchRoom(Floor floor, BedType beds, RoomType roomType) {
        for (Room room : floor.getRooms()) {
            if (room != null && room.isEmpty() && room.getRoomType() == roomType && room.getBeds() == beds) {
                return room;
            }
        }
        return null;
    }
    
    public Room searchRoom(int floorNo, BedType beds, RoomType roomType) {
        Floor floor = this.getFloor(floorNo);
        for (Room room : floor.getRooms()) {
            if (room != null && room.isEmpty() && room.getRoomType() == roomType && room.getBeds() == beds) {
                return room;
            }
        }
        return null;
    }

    public boolean bookRoom(Room room, Client client, int simDay, FileProc fp) {
        if (room != null && client != null) {
            room.checkIn(client, simDay, fp);
            return true;
        } else {
            fp.appendToFile("No available room found for booking.\n");
            return false;
        }
    }

    public int emptyRooms(int currentDay, FileProc fp) {
        int manyRooms=0;
        for (Floor floor : getFloors()) {
            for (Room room : floor.getRooms()) {
                if (room != null && room.getCheckOutDate() == currentDay) {
                    room.checkOut(fp);
                    manyRooms++;
                }
            }
        }
        return manyRooms;
    }
    
    public Client serviceClient(){
        return new Client(Statics.numFloors);
    }

    /**
     * @return the floors
     */
    public ArrayList<Floor> getFloors() {
        return floors;
    }

    /**
     * @param floors the floors to set
     */
    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }
    
    public int getEmptyRooms(){
        int k=0;
        for(Floor floor : floors){
            for(Room room :  floor.getRooms()){
                if(room.isEmpty()){
                k++;    
                }
            }
        }
        return k;
    }
    
     public int getReservedRooms(){
         int k=0;
         for(Floor floor : floors){
             k+=floor.getRooms().size();
         }
         return k-this.getEmptyRooms();
     }

}
