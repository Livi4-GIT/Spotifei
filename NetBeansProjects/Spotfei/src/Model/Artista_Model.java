package Model;

public class Artista_Model extends Pessoa_Model {
    private String nome;
    private String senha;
    
    public Artista_Model(String nome, String senha){
        super(nome, senha);    
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
        return "Artista_Model{" + "nome=" + nome + ", senha=" + senha + '}';
    }


    
}  