
package Model;

public class Pessoa_Model {
    private String nome;
    private String senha;

    public Pessoa_Model(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Pessoa_Model() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa_Model{" + "nome=" + nome + ", senha=" + senha + '}';
    }

    
}

