/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisao;

import java.util.ArrayList;

/**
 *
 * @author 3086926
 */
public class Livro {
    String titulo;
    String autor;
    String descricao;
    int ano;
    double preco;
    Genero genero;
    ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    public Livro(String titulo, String autor, String descricao, int ano, double preco, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
        this.ano = ano;
        this.preco = preco;
        this.genero = genero;
    }
    
    public void listarAvaliacoes(){
        if(!this.avaliacoes.isEmpty()){
            for(int i = 0; i < this.avaliacoes.size(); i++){
                System.out.println(this.avaliacoes.get(i).avaliacao);
            }
        }else{
            System.out.println("Sem avaliações até o momento!");
        }
               
    }
    
    public void addAvaliacao(Avaliacao a){
        this.avaliacoes.add(a);
    }
    
    
}
