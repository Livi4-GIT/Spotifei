
package SpotDAO;
import Model.Pessoa_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class SpotDAO {
    private Connection conn;
    
    public SpotDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Pessoa_Model pessoa) throws SQLException{
        String sql = "select * from pessoas where nome = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getNome());
        statement.setString(2, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
        
    }
    
    public void inserir(Pessoa_Model pessoa) throws SQLException{
        String sql = "insert into pessoas (nome, senha) values ('" +
                    pessoa.getNome() + "','" +
                    pessoa.getSenha() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void atualizar(Pessoa_Model pessoa) throws SQLException{
        String sql = "update pessoas set senha = ? where nome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getSenha());
        statement.setString(2, pessoa.getNome());
        statement.execute();
        conn.close();
    }
    
    public void remover(Pessoa_Model pessoa) throws SQLException{
        String sql = "delete from pessoas where nome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getNome());
        statement.execute();
        conn.close();
        
    }
}

