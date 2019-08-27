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
public class CamaroteInferior extends VIP{
    
    private String localizacao;
    
    public CamaroteInferior(double adicional, double valor, String localizacao) {
        super(adicional, valor);
        this.localizacao = localizacao;
    }
    
    public void imprimeLocalizacao(){
        System.out.println(this.localizacao);
    }
    
}
