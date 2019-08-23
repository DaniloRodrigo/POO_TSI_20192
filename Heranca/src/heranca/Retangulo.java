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
public class Retangulo extends Figura{
    protected double comprimento;
    protected double altura;

    Retangulo() {
    }
    
    Retangulo(double altura, double comprimento){
        this.altura = altura;
        this.comprimento = comprimento;
    }
    
    Retangulo(int x, int y, double altura, double comprimento){
        this.x = x;
        this.y = y;       
        this.altura = altura;
        this.comprimento = comprimento;
    }
    
    @Override
    public double comprimento() {
        return this.comprimento;
    }

    @Override
    public double area() {
        return this.comprimento * this.altura;
    }
    
}
