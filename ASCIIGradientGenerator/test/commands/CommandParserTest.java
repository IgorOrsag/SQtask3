/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class CommandParserTest {
    
    public CommandParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.commmands = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\radial1.txt");
        this.commmandsE = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\radial1E.txt");
        this.commmandsWrongNum = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\radial1WN.txt");
    }
    
    @After
    public void tearDown() {
    }
    
    private String[] commmands;
    private String[] commmandsE;
    private String[] commmandsWrongNum;

    /**
     * Test of parseGridProportions method, of class CommandParser.
     */
    @Test
    public void testParseGridProportions() {        
        System.out.println("parseGridProportions");        
        int width = 40;
        int height = 30;
        int[] result = CommandParser.parseGridProportions(commmands[0]);
        assertEquals(width, result[0]);
        assertEquals(height, result[1]);
        
    }
    
    @Test
    public void testParseGridProportionsException() {        
        try{
            int[] result = CommandParser.parseGridProportions(commmandsWrongNum[0]);
            fail();
        }catch (IllegalArgumentException ex){}
    }
    
    @Test
    public void testParseGridProportionsArgumentException() {        
        try{
            int[] result = CommandParser.parseGridProportions(commmandsE[0]);
            fail();
        }catch (NumberFormatException ex){}
    }
    /**
     * Test of parseGradientSigns method, of class CommandParser.
     */
    @Test
    public void testParseGradientSigns() {        
        System.out.println("parseGradientSigns");        
        char[] expResult = {' ','.', ',',':',';','x','X','&','@'};
        char[] result = CommandParser.parseGradientSigns(commmands[1]);
        assertArrayEquals(expResult, result);        
    } 
    
    @Test
    public void testParseGradientSignsEmpty() {        
        try{
            char[] result = CommandParser.parseGradientSigns(commmandsWrongNum[1]);
            fail();
        }catch (IllegalArgumentException ex){}        
    }

    /**
     * Test of parseGradientParams method, of class CommandParser.
     */
    @Test
    public void testParseGradientParams() {
        System.out.println("parseGradientParams");        
        int[] expResult = {20, 15, 20};
        int[] result = CommandParser.parseGradientParams(commmands[2]);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testParseGradientParamsException() {         
        try{
            int[] result = CommandParser.parseGradientParams(commmandsE[2]);
            fail();
        }catch (NumberFormatException ex){}
    }
        

    /**
     * Test of parseGradientType method, of class CommandParser.
     */
    @Test
    public void testParseGradientType() {
        System.out.println("parseGradientType");        
        String expResult = "radial";
        String result = CommandParser.parseGradientType(commmands[2]);
        assertEquals(expResult, result);
    }
    
}
