/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelex;

import java.util.ArrayList;

/**
 *
 * @author PST2
 */
public class Floor {

    private int floorNo;
    private ArrayList<Room> rooms;

    public Floor(int floorNo) {
        this.floorNo = floorNo;
        this.rooms = new ArrayList<>();
    }

    public void setRoomData(int roomNumber, BedType beds, RoomType roomType) {
        rooms.add(new Room(roomNumber, beds, roomType));
        
        
//        if (rooms.size() >= rNum) {
//            rooms.get(rNum - 1).setRoomType(roomType);
//            rooms.get(rNum - 1).setBeds(beds);
//        } else {
//            int x = rNum - rooms.size();
//            for (int i = 0; i < x; i++) {
//                
//            }
//            rooms.get(rooms.size() - 1).setRoomType(roomType);
//            rooms.get(rooms.size() - 1).setBeds(beds);
//        }
    }

    public void setRoomData(ArrayList<Integer> roomNumber, BedType beds, RoomType roomType) {
        for (Integer rNumber : roomNumber) {
             rooms.add(new Room(rNumber, beds, roomType));
//            int rNum = rNumber % 100;
//            if (rooms.size() >= rNum) {
//                rooms.get(rNum - 1).setRoomType(roomType);
//                rooms.get(rNum - 1).setBeds(beds);
//            } else {
//                int x = rNum - rooms.size();
//                for (int i = 0; i < x; i++) {
//                    rooms.add(new Room(floorNo * 100 + rooms.size() + 1));
//                }
//                rooms.get(rooms.size() - 1).setRoomType(roomType);
//                rooms.get(rooms.size() - 1).setBeds(beds);
//            }

        }
    }

    public Room searchRoom(BedType beds, RoomType roomType) {
        for (Room room : rooms) {
            if (room.isEmpty() && room.getRoomType() == roomType && room.getBeds() == beds) {
                return room;
            }
        }
        return null;
    }

    public void emptyRooms(int currentDay, FileProc fp) {
        for (Room room : rooms) {
            if (!room.isEmpty() && room.getCheckOutDate() == currentDay) {
                room.checkOut(fp);
            }
        }
    }
    
    public int getRoomIndex(int roomNumber){
        for(int i=0; i<rooms.size(); i++){
            if(rooms.get(i).getNumber()==roomNumber){
                return i;
            }
        }
        return -1;
    }

    /**
     * @return the floorNo
     */
    public int getFloorNo() {
        return floorNo;
    }

    /**
     * @param floorNo the floorNo to set
     */
    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    /**
     * @return the rooms
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    
    

}
