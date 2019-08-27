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
public class Quadrado extends Retangulo{
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    Quadrado() {
    }
    
    Quadrado(double lado){
        this.lado = lado;
        this.setAltura(lado);
        this.setComprimento(lado);
    }
    
    Quadrado(int x, int y, double lado){
        this.setX(x);
        this.setY(y);      
        this.lado = lado;
        this.setAltura(lado);
        this.setComprimento(lado);
    }
}
