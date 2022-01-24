package DAO;
import MODELO.Cardápios;
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

public class CardápiosDAO {
    public boolean inserirCardapiosDAO (Cardápios a){ 
        try{
            
            String SQL = "INSERT INTO mariaclara_faria.cardapios (jejum_intermitente, substituicoes, dieta_subterranea) VALUES (?,?,?)";
                
            Connection conectar = conexao_bdd.getConexao();
            PreparedStatement comandoSQL = conectar.prepareStatement(SQL);
            comandoSQL.setString(1, a.getJejum_Intermitente());
            comandoSQL.setString(2, a.getSubstituicoes());
            comandoSQL.setString(3, a.getDietas_Subterraneas());
            int retorno = comandoSQL.executeUpdate();
            
            conectar.close();
            if(retorno>0){
                return true;
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(CardápiosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
public List<Cardápios> lc(){
        try {
            String SQL = "SELECT jejum_intermitente, substituicoes, dieta_subterranea FROM mariaclara_faria.cardapios";
            List<Cardápios> listaDeCardápios = new ArrayList<Cardápios>();
            Connection conectar = conexao_bdd.getConexao();
            PreparedStatement pre = conectar.prepareStatement(SQL);
            ResultSet Resul = pre.executeQuery();
            
            while(Resul.next()){
                Cardápios atual = new Cardápios();
                atual = this.pegaDados(Resul);
                listaDeCardápios.add(atual);
            }
            return listaDeCardápios;
        } catch (SQLException ex) {
            Logger.getLogger(CardápiosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}

private Cardápios pegaDados(ResultSet resultado){
        try {
            Cardápios c = new Cardápios();
            c.setJejum_Intermitente(resultado.getString("jejum_intermitente"));
            c.setSubstituicoes(resultado.getString("substituicoes"));
            c.setDietas_Subterraneas(resultado.getString("dieta_subterranea"));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CardápiosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
public Cardápios ConsultaC(Cardápios c_Dados){
        try {
            String SQL = "SELECT * FROM mariaclara_faria.cardapios";
            Connection conexao = conexao_bdd.getConexao();
            String Filtro ="";
            
            if(c_Dados != null && c_Dados.getJejum_Intermitente()!= null && !c_Dados.getJejum_Intermitente().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND jejum_intermitente ilike '%"+c_Dados.getJejum_Intermitente()+"%'";
                }
                else{
                Filtro = " WHERE jejum_intermitente ilike '%" + c_Dados.getJejum_Intermitente() +"%'";
                }
            }         
             if(c_Dados != null && c_Dados.getSubstituicoes()!= null && !c_Dados.getSubstituicoes().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND substituicoes ilike '%"+c_Dados.getSubstituicoes()+"%'";
                }
                else{
                Filtro = " WHERE substituicoes ilike '%" + c_Dados.getSubstituicoes() + "%'";
                }
            }
            if(c_Dados != null && c_Dados.getDietas_Subterraneas()!= null && !c_Dados.getDietas_Subterraneas().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND dieta_subterranea ilike '%"+c_Dados.getDietas_Subterraneas()+"%'";
                }
                else{
                Filtro = " WHERE dieta_subterranea ilike '%" + c_Dados.getDietas_Subterraneas()+ "%'";
                }
            } 
            
            PreparedStatement pre = conexao.prepareStatement(SQL + Filtro);         
            ResultSet Resul = pre.executeQuery();
            
            if(Resul.next()){
               Cardápios lc = new Cardápios();
                lc = this.pegaDados(Resul);
                return lc;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(CardápiosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Cardápios Consultatual(String dieta_subterranea){
         try {
            String SQL = "SELECT jejum_intermitente, substituicoes, dieta_subterranea FROM mariaclara_faria.cardapios WHERE dieta_subterranea = ?";
            
            Connection conexao = conexao_bdd.getConexao();
            PreparedStatement pre = conexao.prepareStatement(SQL);
            pre.setString(1, dieta_subterranea);
            ResultSet Resul = pre.executeQuery();
            
           if (Resul.next()){
                Cardápios ca_ = new Cardápios();
                ca_ = this.pegaDados(Resul);
                return ca_;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(CardápiosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     
    }
    public boolean ATUALIZAR_CARDÁPIOS(Cardápios Dadosc_a){
        try {
            String SQL = "UPDATE mariaclara_faria.cardapios SET jejum_interitente = ?, substituicoes = ? WHERE dieta_subterranea = ?";
            Connection conexao = conexao_bdd.getConexao();
              PreparedStatement comando = conexao.prepareStatement(SQL);

             comando.setString(1, Dadosc_a.getJejum_Intermitente());
              comando.setString(2, Dadosc_a.getSubstituicoes());
               comando.setString(3, Dadosc_a.getDietas_Subterraneas());

             int retornar = comando.executeUpdate();
             if (retornar > 0){
                   return true;
                }


        } catch (SQLException ex) {
            Logger.getLogger(CardápiosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}