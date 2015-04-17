/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asciigradientgenerator;

/**
 *
 * @author admin
 */
public class GradientRadial {

    
    private int centerx;
    private int centery;
    private int gradientRadius;
    private char[] signs;
    
    public GradientRadial(int centerx, int centery, int gradientRadius, char[] signs) {
        this.centerx = centerx;
        this.centery = centery;
        this.gradientRadius = gradientRadius;
        this.signs = signs;
    }
    
    public double getDistanceFromCenter(int x, int y){
        int dx = x - centerx;
        int dy = y - centery;
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance;
    }
    
            
    public char selectSign(double distance){
        int numberOfSigns = signs.length;
        if(distance > gradientRadius){
            return signs[numberOfSigns - 1];
        }
        return signs[(int)(distance * (numberOfSigns - 1) / gradientRadius)];
    }
    
    
}
