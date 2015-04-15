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
    
    public GradientRadial(int centerx, int centery, int gradientRadius) {
        this.centerx = centerx;
        this.centery = centery;
        this.gradientRadius = gradientRadius;
    }
    
    public double getDistanceFromCenter(int x, int y){
        int dx = x - centerx;
        int dy = y - centery;
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance;
    }
    
    
}
