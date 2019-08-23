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
public class Circulo extends Figura{
    
    protected double raio;
    
    Circulo(){
    }
    
    Circulo(double raio){
        this.raio = raio;
    }
    
    Circulo(int x, int y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    @Override
    public double comprimento() {
        return 2 * Math.PI * this.raio;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }
    
}
