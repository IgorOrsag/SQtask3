/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

/**
 *
 * @author orsag
 */
public class CommandParser {
    public static int[] parseGridProportions(String proportionsLine)throws NumberFormatException{
        if(proportionsLine.length() == 0){
            return null;
        }
        
        String[] strPropotions = proportionsLine.split(" ");
        if(strPropotions.length != 2){
            throw new IllegalArgumentException("Wrong number of grid proportions");
        }
        
        int[] proportions = new int[strPropotions.length];
        for(int i = 0; i < strPropotions.length; i++){            
            proportions[i] = Integer.parseInt(strPropotions[i]);
        }        
        return proportions;
    }
    
    public static char[] parseGradientSigns(String signsLine){
        if(signsLine.length() == 0){
            throw new IllegalArgumentException("No ascii signs for gradient");
        }        
        char[] signsArray = signsLine.toCharArray();
        
        return signsArray;
    }
    
    public static int[] parseGradientParams(String paramsLine) throws NumberFormatException{
        if(paramsLine.length() == 0){
            return null;
        }
        String[] paramStr = paramsLine.split(" ");
        int[] params = new int[paramStr.length - 1];
        for(int i = 1; i < paramStr.length; i++){            
            params[i - 1] = Integer.parseInt(paramStr[i]);
        }
        
         
        return params;
    }
    
    public static String parseGradientType(String paramsLine){
        if(paramsLine.length() == 0){
            return null;
        }
        return paramsLine.split(" ")[0];
    }
}
