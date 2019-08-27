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
public class CamaroteSuperior extends VIP{
    
    private double adicionalCamarote;

    public double getAdicionalCamarote() {
        return adicionalCamarote;
    }

    public void setAdicionalCamarote(double adicionalCamarote) {
        this.adicionalCamarote = adicionalCamarote;
    }
    
    public CamaroteSuperior(double adicional, double valor, double adicionalCamarote) {
        super(adicional, valor);
        this.adicionalCamarote = adicionalCamarote;
    }
    
    public void imprimeValor(){
        System.out.println(this.getValor() + this.getAdicional() + this.adicionalCamarote);
    }
    
}
