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
public class Heranca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Retangulo ret = new Retangulo(2, 6, 10, 5);
        Quadrado quad = new Quadrado(6, 8, 5);
        Circulo circ = new Circulo(8, 10, 2.5);
        
        System.out.println("Distância");
        System.out.println(ret.distanciaOrigem());
        System.out.println(quad.distanciaOrigem());
        System.out.println(circ.distanciaOrigem());
        
        System.out.println("Comprimento");
        System.out.println(ret.comprimento());
        System.out.println(quad.comprimento());
        System.out.println(circ.comprimento());
        
        System.out.println("Área");
        System.out.println(ret.area());
        System.out.println(quad.area());
        System.out.println(circ.area());
  
    }
    
}
