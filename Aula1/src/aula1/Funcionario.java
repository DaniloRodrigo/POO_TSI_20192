

package aula1;

public class Funcionario {
    private String nome;
    private String cpf;
    private int idade;
    private double salario;
  
    Funcionario(String nome, String cpf, int idade, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public void reclamarDoSalario(){
        System.out.println("Meu salario é baixo");
    }
    
    public double salarioIdeal(){
        return this.salario * 2;
    }
    
    public double getSalario(){
        return this.salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setSalario(double novoSalario){
        if(novoSalario > 0){
            this.salario = novoSalario;
        }else{
            System.out.println("Salario inválido!");
        }
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", salario=" + salario + '}';
    }
    
   
}
