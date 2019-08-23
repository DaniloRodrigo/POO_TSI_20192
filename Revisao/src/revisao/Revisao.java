/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisao;

/**
 *
 * @author 3086926
 */
public class Revisao {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        Genero romance = new Genero("Romance", "Água com açucar");
        
        Livro livro1 = new Livro("Harry Potter", "JK", "Legal", 1995, 30.5, romance);
        Livro livro2 = new Livro("Introdução a algoritmos", "Cormen", "Tenso", 1900, 130.5, romance);        
        
        Avaliacao boa = new Avaliacao("Danilo", "da@da.com", "Boaa", 10);
        Avaliacao ruim = new Avaliacao("Lucas", "da@da.com", "Ruim", 5);
        
        livro1.listarAvaliacoes();
        livro1.addAvaliacao(boa);
        livro1.addAvaliacao(ruim);
        livro1.listarAvaliacoes();
    }
    
}
