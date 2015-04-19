/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asciigradientgenerator;

import commands.CommandParser;
import commands.FileLoader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xorsag2
 */
public class AsciiGridTest {
    
    public AsciiGridTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //AsciiGrid canvas = new AsciiGrid(30, 40);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testHasWidth() {
        
        AsciiGrid asciiGrid = new AsciiGrid(40, 30);
        assertEquals(40, asciiGrid.getWidth());
    }
    
    @Test
    public void testHasHeight() {
        AsciiGrid asciiGrid = new AsciiGrid(40, 30);
        assertEquals(30, asciiGrid.getHeight());
    }

    /**
     * Test of fillGrid method, of class AsciiGrid.
     */
    @Test
    public void testFillGridRadialFirst() {
        String[] cmdLines = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\radial1.txt");
        
        int[] gridProportions = CommandParser.parseGridProportions(cmdLines[0]);
        AsciiGrid asciiGrid = new AsciiGrid(gridProportions[0], gridProportions[1]);
        
        String gradientType = CommandParser.parseGradientType(cmdLines[2]);
        int[] gradientParams = CommandParser.parseGradientParams(cmdLines[2]);
        char[] gradientSigns = CommandParser.parseGradientSigns(cmdLines[1]);
        
        //TODO builder
        IGradient gr = GradientBuilder.build(gradientType, gradientParams, gradientSigns);                
        asciiGrid.fillGrid(gr);
        
        String[] gradientImgLines = FileLoader.loadFileToLines("src\\Files\\GradientTestFiles\\radial1.txt");
        //TODO separate test
        assertEquals(gradientImgLines.length, asciiGrid.getHeight()); 
        //TODO separate test
        
        for(int lineNumber = 0; lineNumber < asciiGrid.getHeight(); lineNumber++){
            String asciiLine = new String(asciiGrid.grid[lineNumber]);
            assertEquals(gradientImgLines[lineNumber], asciiLine);
        }
    }
    
    @Test
    public void testFillGridRadialSecond() {
        String[] cmdLines = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\radial2.txt");
        
        int[] gridProportions = CommandParser.parseGridProportions(cmdLines[0]);
        AsciiGrid asciiGrid = new AsciiGrid(gridProportions[0], gridProportions[1]);
        
        String gradientType = CommandParser.parseGradientType(cmdLines[2]);
        int[] gradientParams = CommandParser.parseGradientParams(cmdLines[2]);
        char[] gradientSigns = CommandParser.parseGradientSigns(cmdLines[1]);
        
        //TODO builder
        IGradient gr = GradientBuilder.build(gradientType, gradientParams, gradientSigns);                
        asciiGrid.fillGrid(gr);
        
        String[] gradientImgLines = FileLoader.loadFileToLines("src\\Files\\GradientTestFiles\\radial2.txt");
        //TODO separate test
        assertEquals(gradientImgLines.length, asciiGrid.getHeight()); 
        //TODO separate test
        
        for(int lineNumber = 0; lineNumber < asciiGrid.getHeight(); lineNumber++){
            String asciiLine = new String(asciiGrid.grid[lineNumber]);
            assertEquals(gradientImgLines[lineNumber], asciiLine);
        }
    }
    
    @Test
    public void testFillGridLinear() {
        String[] cmdLines = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\linear1.txt");
        
        int[] gridProportions = CommandParser.parseGridProportions(cmdLines[0]);
        AsciiGrid asciiGrid = new AsciiGrid(gridProportions[0], gridProportions[1]);
        
        String gradientType = CommandParser.parseGradientType(cmdLines[2]);
        int[] gradientParams = CommandParser.parseGradientParams(cmdLines[2]);
        char[] gradientSigns = CommandParser.parseGradientSigns(cmdLines[1]);
        
        //TODO builder
        IGradient gr = GradientBuilder.build(gradientType, gradientParams, gradientSigns);                
        asciiGrid.fillGrid(gr);
        
        String[] gradientImgLines = FileLoader.loadFileToLines("src\\Files\\GradientTestFiles\\linear1.txt");
        //TODO separate test
        assertEquals(gradientImgLines.length, asciiGrid.getHeight()); 
        //TODO separate test
        
        for(int lineNumber = 0; lineNumber < asciiGrid.getHeight(); lineNumber++){
            String asciiLine = new String(asciiGrid.grid[lineNumber]);
            assertEquals(gradientImgLines[lineNumber], asciiLine);
        }
    }
    
    
    
}
