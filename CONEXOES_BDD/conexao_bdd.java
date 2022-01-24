package CONEXOES_BDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexao_bdd {
    private static String url = "jdbc:postgresql://200.18.128.54/aula";
    private static String usuario = "aula";
    private static String senha = "aula";
    
    private static Connection CONEXAO = null;
    
    public static Connection getConexao(){
        try {
            if(conexao_bdd.CONEXAO == null){
                conexao_bdd.CONEXAO = DriverManager.getConnection(url, usuario, senha);
            } 
            return CONEXAO;
        }
        catch (SQLException ex) {
            Logger.getLogger(conexao_bdd.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de conexão ao banco de dados!" + ex.getMessage());
        }
        return null;
    }
} 

