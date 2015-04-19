/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FileLoader;

import commands.FileLoader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author orsag
 */
public class FileLoaderTest {
    
    public FileLoaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    public void testLoadFileToLines() {
        String[] result = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\radial1.txt");
        assertEquals("40 30",result[0]);
        assertEquals(" .,:;xX&@",result[1]);
        assertEquals("radial 20 15 20",result[2]);
    }
    
    @Test
    public void testLoadFileNumberOfLines() {
        String[] result = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\radial1.txt");
        assertEquals(3,result.length);
    }
    
    @Test
    public void testLoadFileEmpty() {
        String[] result = FileLoader.loadFileToLines("src\\Files\\GradientTestCommands\\FileLoaderTestEmpty.txt");
        assertNull(result);
    }
    
}
