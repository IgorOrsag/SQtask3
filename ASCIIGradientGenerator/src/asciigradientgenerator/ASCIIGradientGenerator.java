/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asciigradientgenerator;

import commands.CommandParser;
import commands.FileLoader;

/**
 *
 * @author xorsag2
 */
public class ASCIIGradientGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TODO retrieve fileName 
        //TODO retrieve commands
        /**
        int width = 40;
        int height = 30;
        
        int centerx = 20;
        int centery = 15;
        int gradientRadius = 20;
        char[] signs ={' ','.', ',',':',';','x','X','&','@'};
        **/
        
        
        int width = 40;
        int height = 30;
        
        int centerx = 20;
        int centery = 15;
        int gradientRadius = 20;
        char[] signs ={' ','.', ',',':',';','x','X','&','@'};
        
        /**
        int width = 60;
        int height = 30;
        
        int startx = 30;
        int starty = 30;
        int endx = 0;
        int endy = 0;
        
        char[] signs ={' ',';','"','x','+','$'};
        **/
        
        String[] cmdLines = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\radial1.txt");
        int[] gridProportions = CommandParser.parseGridProportions(cmdLines[0]);
        AsciiGrid asciiGrid = new AsciiGrid(gridProportions[0], gridProportions[1]);
        
        String gradientType = CommandParser.parseGradientType(cmdLines[2]);
        int[] gradientParams = CommandParser.parseGradientParams(cmdLines[2]);
        char[] gradientSigns = CommandParser.parseGradientSigns(cmdLines[1]);
        
        //TODO builder
        IGradient gr = GradientBuilder.build(gradientType, gradientParams, gradientSigns);
        
        //TODO fix bug pravdepodobne zaokruholanie, urobit podla javovych zdrojakov
        
        //IGradient gr = new GradientLinear(startx, starty, endx, endy, signs);
        asciiGrid.fillGrid(gr);
        //TODO export to stream(file, cmdline,...) - some stream interface
        
        
    }
    
}
