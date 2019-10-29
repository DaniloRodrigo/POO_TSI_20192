
package atividaderevisao;

public class Peixe extends Animal{
    private String tipoHabitat;
    
    public Peixe(String tipoHabitat, String nome, double peso){
        super(nome, peso);
        this.tipoHabitat = tipoHabitat;
    }

    public String getTipoHabitat() {
        return tipoHabitat;
    }

    public void setTipoHabitat(String tipoHabitat) {
        this.tipoHabitat = tipoHabitat;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getTipoHabitat();
    }
    
    
}
