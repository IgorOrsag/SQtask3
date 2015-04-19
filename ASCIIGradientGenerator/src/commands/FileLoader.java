/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author orsag
 */
public class FileLoader {
    
    public static String[] loadFileToLines(String fileName){  
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            
            String line = br.readLine();
            
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }                        
        }
        catch(IOException ex){
            System.err.println(ex.toString() );
        }
        
        if(sb.length() == 0){
            return null;
        }
        return sb.toString().split(System.lineSeparator());
    }
}
