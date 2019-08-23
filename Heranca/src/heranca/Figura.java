/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heranca;

/**
 *
 * @author 3086926
 */
public abstract class Figura {
    protected int x;
    protected int y;
    
    Figura(){}
    
    Figura(int x, int y){
        this.x = x;
        this.y = y;
    }
    public double distanciaOrigem(){
        return Math.sqrt(Math.pow(this.x-0, 2) + Math.pow(this.y-0, 2));
    }
    
    abstract public double comprimento();
    abstract public double area();
    
}
