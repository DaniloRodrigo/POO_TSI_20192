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
    protected double lado;
    Quadrado() {
    }
    
    Quadrado(double lado){
        this.lado = lado;
        this.altura = lado;
        this.comprimento = lado;
    }
    
    Quadrado(int x, int y, double lado){
        this.x = x;
        this.y = y;       
        this.lado = lado;
        this.altura = lado;
        this.comprimento = lado;
    }
}
