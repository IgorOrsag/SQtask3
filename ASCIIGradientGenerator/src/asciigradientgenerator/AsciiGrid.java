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
public class AsciiGrid {

    public AsciiGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
    }
    private int width;
    private int height;
    
    public char[][] grid;
    
    public char[][] fillGrid(GradientRadial gr){
        char[][] canvasGrid = new char[height][width];
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                double distance = gr.getDistanceFromCenter(x,y);
                //char asciiChar = ColorManager.getASCII(distance)
                canvasGrid[y][x]='*';
                System.out.print(canvasGrid[y][x]);
            }
            System.out.println("");
        }
    return canvasGrid;
    }
    
}
