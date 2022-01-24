package DAO;
import MODELO.Nutricionista;
import CONEXOES_BDD.conexao_bdd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NutricionistaDAO {
    public boolean inserirNutricionistaDAO (Nutricionista a){ 
        try{
            
            String SQL = "INSERT INTO mariaclara_faria.nutricionista (nome, telefone, endereço, email) VALUES (?,?,?,?)";
                
            Connection conectar = conexao_bdd.getConexao();
            PreparedStatement comandoSQL = conectar.prepareStatement(SQL);
            comandoSQL.setString(1, a.getNome());
            comandoSQL.setString(2, a.getTelefone());
            comandoSQL.setString(3, a.getEndereço());
            comandoSQL.setString(4, a.getemail());
            int retorno = comandoSQL.executeUpdate();
            
            conectar.close();
            if(retorno>0){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NutricionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<Nutricionista> ln(){
        try {
            String SQL = "SELECT nome, telefone, endereço, email FROM mariaclara_faria.nutricionista";
            List<Nutricionista> ListaN = new ArrayList<Nutricionista>();
            Connection conectar = conexao_bdd.getConexao();
            PreparedStatement pre = conectar.prepareStatement(SQL);
            ResultSet Resul = pre.executeQuery();

            while (Resul.next()){
                Nutricionista n = new Nutricionista();
                n = this.PegaDados(Resul);
                ListaN.add(n);
            }
            return ListaN;
        } catch (SQLException ex) {
            Logger.getLogger(NutricionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Nutricionista PegaDados(ResultSet resultado){
        try {
            Nutricionista n = new Nutricionista();
            n.setNome(resultado.getString("nome"));
            n.setTelefone(resultado.getString("telefone"));
            n.setEndereço(resultado.getString("endereço"));
            n.setemail(resultado.getString("email"));

            return n;
        } catch (SQLException ex) {
            Logger.getLogger(NutricionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Nutricionista ConsultaN(Nutricionista nDados){
        try {
            String SQL = "SELECT * FROM mariaclara_faria.nutricionista";
            Connection conexao = conexao_bdd.getConexao();
            String Filtro ="";
            
            if(nDados != null && nDados.getNome()!= null && !nDados.getNome().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND nome ilike '%"+nDados.getNome()+"%'";
                }
                else{
                Filtro = " WHERE nome ilike '%" + nDados.getNome() +"%'";
                }
            }         
             if(nDados != null && nDados.getTelefone()!= null && !nDados.getTelefone().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND telefone ilike '%"+nDados.getTelefone()+"%'";
                }
                else{
                Filtro = " WHERE telefone ilike '%" + nDados.getTelefone() + "%'";
                }
            } 
             if(nDados != null && nDados.getEndereço()!= null && !nDados.getEndereço().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND endereço ilike '%"+nDados.getEndereço()+"%'";
                }
                else{
                Filtro = " WHERE endereço ilike '%" + nDados.getEndereço() + "%'";
                }
            } 
            
              if(nDados != null && nDados.getemail()!= null && !nDados.getemail().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND email ilike '%"+nDados.getemail()+"%'";
                }
                else{
                Filtro = " WHERE email ilike '%" + nDados.getemail()+"%'";
                }
            }
              
            PreparedStatement pre = conexao.prepareStatement(SQL + Filtro);         
            ResultSet Resul = pre.executeQuery();
            
            if(Resul.next()){
               Nutricionista ln = new Nutricionista();
                ln = this.PegaDados(Resul);
                return ln;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(NutricionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Nutricionista ConsultN(String email){
         try {
            String SQL = "SELECT email, nome, telefone, endereço FROM mariaclara_faria.nutricionista WHERE email = ?";
            
            Connection conexao = conexao_bdd.getConexao();
            PreparedStatement pre = conexao.prepareStatement(SQL);
            pre.setString(1, email);
            ResultSet Resul = pre.executeQuery();
            
           if (Resul.next()){
                Nutricionista nt = new Nutricionista();
                nt = this.PegaDados(Resul);
                return nt;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(NutricionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     
    }
    public boolean ATUALIZAR_NUTIRICIONISTA(Nutricionista Dadosn){
        try {
            String SQL = "UPDATE mariaclara_faria.nutricionista SET nome = ?, telefone = ?, endereço = ? WHERE email = ?";
            Connection conexao = conexao_bdd.getConexao();
              PreparedStatement comando = conexao.prepareStatement(SQL);

             comando.setString(1, Dadosn.getNome());
              comando.setString(2, Dadosn.getTelefone());
               comando.setString(3, Dadosn.getEndereço());
               comando.setString(4, Dadosn.getemail());

             int retornar = comando.executeUpdate();
             if (retornar > 0){
                   return true;
                }


        } catch (SQLException ex) {
            Logger.getLogger(NutricionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}