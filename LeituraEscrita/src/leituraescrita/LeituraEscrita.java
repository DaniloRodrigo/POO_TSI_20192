/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituraescrita;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 3086926
 */
public class LeituraEscrita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
            BufferedReader br = new BufferedReader(new FileReader("numeros.txt")); 
            while(br.ready()){ 
                String linha = br.readLine(); 
                System.out.println(linha); 
            } 
            br.close(); 

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
}
