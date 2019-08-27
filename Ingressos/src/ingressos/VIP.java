/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingressos;

/**
 *
 * @author 3086926
 */
public class VIP extends Ingresso{
    private double adicional;

    public VIP(double adicional, double valor) {
        super(valor); // Esse comando super chama o construtor da classe pai passando como paremetro o valor
        this.adicional = adicional;
    }

    public double getAdicional() {
        return adicional;
    }

    public void setAdicional(double adicional) {
        this.adicional = adicional;
    }

    public void imprimeValor(){
        System.out.println(this.getValor() + this.adicional);
    }
    
}
