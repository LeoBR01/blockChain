
package blockchain;

public class Usuario {
    private String nome;
    private int id;
    private String cpf;

    public Usuario(String nome, int id, String cpf) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void mostrarDados(){
        System.out.println("Dados do Usuário: "
                + "Nome: " + this.getNome() + " |"
                + " id: " + this.getId() + " |"
                + " CPF: " + this.getCpf());
    }
           
    
}
