/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asciigradientgenerator;

/**
 *
 * @author xorsag2
 */
public class ASCIIGradientGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int xr = 20;
        int yr = 20;
        int width = 40;
        int height = 40;
        //char[] anArray = new char[9];
        //anArray[1] = 
        
        for(int i=1; i <= width; i++){
            for(int j=1; j<=height; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
}
