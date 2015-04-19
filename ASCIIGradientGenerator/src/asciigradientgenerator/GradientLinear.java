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
    private double radius;   
    
    public GradientLinear(int startx, int starty, int endx, int endy, char[] signs) {
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
        this.signs = signs;
    }
    
    
    
    public double getRadius() {
        return radius;
    }
    
    public int getStartx() {
        return startx;
    }

    public int getStarty() {
        return starty;
    }

    public int getEndx() {
        return endx;
    }

    public int getEndy() {
        return endy;
    }

    public char[] getSigns() {
        return signs;
    }
    
    public void evalRadius(){
        double startEndDistx = startx - endx;
        double startEndDisty = starty - endy;
        this.radius = Math.sqrt(Math.pow(startEndDistx, 2) + Math.pow(startEndDisty, 2));
    }
    
    @Override
    public double getDistanceFromCenter(int x, int y){
        double startEndDistx = startx - endx;
        double startEndDisty = starty - endy;
        this.radius = Math.sqrt(Math.pow(startEndDistx, 2) + Math.pow(startEndDisty, 2));
        
        
        double centerStartDistx = startx - x;
        double centerStartDisty = starty - y;
        /**
        double startEndDistx = startx - endx;
        double startEndDisty = starty - endy;
        **/
        double dist = (startEndDistx * x + startEndDisty * y + (Math.pow(startx, 2) + Math.pow(starty, 2) - (startx * endx) - (starty * endy)));
        /**dist /= radius;
        
        this.normb = Math.sqrt(startEndDistx * startEndDistx + startEndDisty * startEndDisty);
        
        double ubx = startEndDistx / normb;
        double uby = startEndDisty / normb;
        //double distance = (ubx * centerStartDistx) + (uby * centerStartDisty);
        double distance = (centerStartDistx * startEndDistx + centerStartDisty * startEndDisty) / normb;
        return distance;
                **/
        return dist;
    }
    
            
    @Override
    public char selectSign(double distance){
        
        double dist = distance/this.radius;
        int index = (int)(dist * signs.length);
        return signs[Math.max(0, Math.min(index, signs.length - 1))];
        
                /**
        if(distance < 0){
            return signs[0];
        }else if(distance > radius)
            return signs[signs.length - 1];
        else
            return signs[(int)(distance * (signs.length - 1)/radius)];
            * * **/
    }
}
