/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelex;

import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class Hotelex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        FileProc fp = new FileProc("results.txt");
        fp.createAndWriteToFile("Start Simulation \n\n");
        Hotel ht = new Hotel("hilton", Statics.numFloors);
//        int k=0,rr=0;
        for(Floor floor : ht.getFloors()){
            for(int i=0; i<Statics.numRooms; i++){
                BedType bt = rand.nextBoolean()? BedType.DIKLINO:BedType.TRIKLINO;
                RoomType rt = rand.nextBoolean()? RoomType.STD:RoomType.SUP;
                ht.setFloorData(floor, floor.getFloorNo()*100+(i+1), bt, rt);
//                rr++;
            }
//           k++;
        }
//        System.out.println(k);
//          System.out.println(rr);
        

        for (int i = 1; i < Statics.simulationDays; i++) {
            int rb=0;
            fp.appendToFile("\n\nStart new Day --- "+i+" -----\n\n");
            fp.appendToFile("Empty rooms ="+ht.emptyRooms(i, fp)+"\n");
            fp.appendToFile("Free rooms = "+ht.getEmptyRooms()+"\n");
            fp.appendToFile("Reserved rooms = "+ht.getReservedRooms()+"\n");
            int dayClients = rand.nextInt(Statics.randomWelcomeClientsAmount)+1;
            for(int cl=0; cl<dayClients; cl++){
                Client temp = ht.serviceClient();
                fp.appendToFile(temp.printBookingDetails());
                if(temp.getPreferredFloor()>0){
                    Room r = ht.searchRoom(temp.getPreferredFloor(), temp.getBeds(), temp.getRoomType());
                    if(ht.bookRoom(r, temp, i, fp)){
                        rb++;
                    }
                }else{
                    Room r = ht.searchRoom(temp.getBeds(), temp.getRoomType());
                    if(ht.bookRoom(r, temp, i, fp)){
                        rb++;
                    }
                }
                fp.appendToFile("From "+dayClients +" serviced "+rb+"\n");
            }
           
        }
        

    }

}
