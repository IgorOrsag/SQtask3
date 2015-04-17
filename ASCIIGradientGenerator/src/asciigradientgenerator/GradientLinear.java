/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asciigradientgenerator;

/**
 *
 * @author orsag
 */
public class GradientLinear implements IGradient{

    
    private int startx;
    private int starty;
    private int endx;
    private int endy;
    private char[] signs;
    private double normb;
    
    public GradientLinear(int startx, int starty, int endx, int endy, char[] signs) {
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
        this.signs = signs;
    }
    
    @Override
    public double getDistanceFromCenter(int x, int y){
        double centerStartDistx = startx - x;
        double centerStartDisty = starty - y;
        
        double startEndDistx = startx - endx;
        double startEndDisty = starty - endy;
        
        this.normb = Math.sqrt(startEndDistx * startEndDistx + startEndDisty * startEndDisty);
        
        double ubx = startEndDistx / normb;
        double uby = startEndDisty / normb;
        //double distance = (ubx * centerStartDistx) + (uby * centerStartDisty);
        double distance = (centerStartDistx * startEndDistx + centerStartDisty * startEndDisty) / normb;
        return distance;
    }
    
            
    @Override
    public char selectSign(double distance){
        if(this.normb == 0.0){
            return '\0';
        }
        int numberOfSigns = signs.length;
        if(distance < 0){
            return signs[0];
        }else if(distance > normb){
            
            return signs[numberOfSigns - 1];
        }else{
            return signs[(int)(distance * (numberOfSigns - 1) / normb)];
        }        
    }
}
