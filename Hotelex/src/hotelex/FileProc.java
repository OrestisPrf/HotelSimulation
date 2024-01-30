/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author PE3
 */
public class FileProc {
    private String fileName;

    public FileProc(String fileName) {
        this.fileName = fileName;
    }   

    public void createAndWriteToFile(String details) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(details);

            writer.close();
        } catch (IOException ex) {

        }
    }
    
    public void appendToFile(String details) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
            writer.write(details);

            writer.close();
        } catch (IOException ex) {

        }

    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    

}
