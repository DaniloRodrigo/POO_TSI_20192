
package atividaderevisao;

import javax.swing.JOptionPane;

public class AtividadeRevisao {

    public static void main(String[] args) {
        Peixe p = new Peixe("Lago", "Tilapia", 1);
        Cachorro c = new Cachorro("Vira-lata", "Zeus", 20);
        
        System.out.println(p);
        
        JOptionPane.showMessageDialog(null, "Messagem", "Titulo", 3);
    }
    
}
