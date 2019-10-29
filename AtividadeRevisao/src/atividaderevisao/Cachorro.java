/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividaderevisao;

/**
 *
 * @author 3086926
 */
public class Cachorro extends Animal{
    private String raca;

    public Cachorro(String raca, String nome, double peso) {
        super(nome, peso);
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getRaca();
    }

    
    
    
}
