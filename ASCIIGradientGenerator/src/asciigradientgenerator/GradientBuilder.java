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
public class GradientBuilder {
    public static IGradient build(String gradientType, int[] params, char[] signs){
        switch(gradientType){
            case "linear":
                if(params.length != 4){
                    throw new IllegalArgumentException("Wrong number of gradient params");
                }
                
                IGradient gl = new GradientLinear(params[0], params[1], params[2], params[3], signs);
                return gl;
            case "radial":
                if(params.length != 3){
                    throw new IllegalArgumentException("Wrong number of gradient params");
                }
                IGradient gr = new GradientRadial(params[0], params[1], params[2], signs);
                return gr;
            default:
                return null;
        }        
    }
}
