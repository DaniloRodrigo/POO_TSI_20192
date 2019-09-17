/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

// import SaldoInsuficienteExeception;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;


public class Conta{
  double saldo;

  Conta(double saldo){
    this.saldo = saldo;
  }

  public void sacar(double valor) throws SaldoInsuficienteException, ValorNegativoException{
    if(valor < 0){
      throw new ValorNegativoException();
    }else if(valor <= this.saldo){
      this.saldo -= valor;
    }else{
      throw new SaldoInsuficienteException();
    } 
  } 
}
