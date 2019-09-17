
package banco;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;


public class Banco {

    public static void main(String[] args) {
        Conta conta = new Conta(1000);
        try{
          conta.sacar(-1000); 
          System.out.println("Valor sacado");
        }catch(ValorNegativoException e){
          System.out.println(e.getMessage());
        }catch(SaldoInsuficienteException e){
          System.out.println(e.getMessage());
        }
    }
    
}
