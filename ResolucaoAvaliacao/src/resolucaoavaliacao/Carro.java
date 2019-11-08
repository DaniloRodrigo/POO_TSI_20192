/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolucaoavaliacao;

/**
 *
 * @author 3086926
 */
public class Carro extends Motorizado{
    
    private int numeroPortas;
    private boolean temTracaiNasQuatro;

    public Carro(int numeroPortas, boolean temTracaiNasQuatro, double cc, int nRodas, String nome, int ano, double valor) {
        super(cc, nRodas, nome, ano, valor);
        this.numeroPortas = numeroPortas;
        this.temTracaiNasQuatro = temTracaiNasQuatro;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public boolean isTemTracaiNasQuatro() {
        return temTracaiNasQuatro;
    }

    public void setTemTracaiNasQuatro(boolean temTracaiNasQuatro) {
        this.temTracaiNasQuatro = temTracaiNasQuatro;
    }

    @Override
    public int pneusQueTemTracao() {
        if(this.temTracaiNasQuatro)
            return 4;
        else
            return 2;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getNumeroPortas() + " " + this.isTemTracaiNasQuatro(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
