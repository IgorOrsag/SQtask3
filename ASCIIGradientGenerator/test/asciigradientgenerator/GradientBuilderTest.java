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
 * @author admin
 */
public class GradientBuilderTest {
    
    public GradientBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.commmandsWrongNum = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\radial1WN.txt");
    }
    private String[] commmandsWrongNum;
    
    @After
    public void tearDown() {
    }

    /**
     * Test of build method, of class GradientBuilder.
     */
    @Test
    public void testBuildLinear() {
        
        String gradientType = "linear";
        int[] params = {30, 30, 0, 0};
        char[] signs = {'a', 'b'};
        
        IGradient gr = GradientBuilder.build(gradientType, params, signs);
        
        boolean isRightInstance = false;
        if(gr instanceof GradientLinear){
            isRightInstance = true;
        }
        assertEquals(true, isRightInstance);
        
    }
    
    @Test
    public void testBuildRadial() {
        String gradientType = "radial";
        int[] params = {30, 30, 2, };
        char[] signs = {'a', 'b'};
        
        IGradient gr = GradientBuilder.build(gradientType, params, signs);
        
        boolean isRightInstance = false;
        if(gr instanceof GradientRadial){
            isRightInstance = true;
        }
        assertEquals(true, isRightInstance);
    }
    
    @Test
    public void testBuildRadialGradientParamsArgumentException() {  
        int[] params = CommandParser.parseGradientParams(commmandsWrongNum[2]);
        String type = CommandParser.parseGradientType(commmandsWrongNum[2]);
        char[] signs = {'a', 'b'};
         
        try{
            GradientBuilder.build(type, params, signs);
            fail();
        }catch (IllegalArgumentException ex){}
    }
    
    @Test
    public void testBuildLinearGradientParamsArgumentException() {        
        int[] params = CommandParser.parseGradientParams(commmandsWrongNum[2]);
        String type = "linear";
        char[] signs = {'a', 'b'};
         
        try{
            GradientBuilder.build(type, params, signs);
            fail();
        }catch (IllegalArgumentException ex){}
    }
    
    
}
