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
public interface IGradient {
    
    public double getDistanceFromCenter(int x, int y);
    
    public char selectSign(double distance);
}
