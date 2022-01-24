package DAO;
import MODELO.Ficha_de_Anamnese;
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

public class Ficha_De_AnamneseDAO {
    public boolean inserirFicha_De_AnamneseDAO (Ficha_de_Anamnese a){ 
        try{
            
            String SQL = "INSERT INTO mariaclara_faria.Ficha_De_Anamnese (historico_familiar, habitos_de_vida, habitos_alimentares, avaliacoes_laboratoriais, avaliacoes_antropometricas) VALUES (?,?,?,?,?)";
                
            Connection conectar = conexao_bdd.getConexao();
            PreparedStatement comandoSQL = conectar.prepareStatement(SQL);
            comandoSQL.setString(1, a.getHistorico_Familiar());
            comandoSQL.setString(2, a.getHabitos_de_Vida());
            comandoSQL.setString(3, a.getHabitos_Alimentares());
            comandoSQL.setString(4, a.getAvaliações_Laboratoriais());
            comandoSQL.setString(5, a.getAvaliacoes_Antopometricas());
            int retorno = comandoSQL.executeUpdate();
            
            conectar.close();
            if(retorno>0){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Ficha_De_AnamneseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<Ficha_de_Anamnese> fa(){
        try {
            String SQL = "SELECT historico_familiar, habitos_de_vida, habitos_alimentares, avaliacoes_laboratoriais, avaliacoes_antropometricas FROM mariaclara_faria.ficha_de_anamnese";
            List<Ficha_de_Anamnese> ListaU = new ArrayList<Ficha_de_Anamnese>();
            Connection conectar = conexao_bdd.getConexao();
            PreparedStatement pre = conectar.prepareStatement(SQL);
            ResultSet Resul = pre.executeQuery();

            while (Resul.next()){
                Ficha_de_Anamnese FA = new Ficha_de_Anamnese();
                FA = this.pegaDados(Resul);
                ListaU.add(FA);
            }
            return ListaU;
        } catch (SQLException ex) {
            Logger.getLogger(Ficha_De_AnamneseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Ficha_de_Anamnese pegaDados(ResultSet resultado){
        try {
            Ficha_de_Anamnese FA = new Ficha_de_Anamnese();
            FA.setHistorico_Familiar(resultado.getString("historico_familiar"));
            FA.setHabitos_de_Vida(resultado.getString("habitos_de_vida"));
            FA.setHabitos_Alimentares(resultado.getString("habitos_alimentares"));
            FA.setAvaliações_Laboratoriais(resultado.getString("avaliacoes_laboratoriais"));
            FA.setAvaliacoes_Antopometricas(resultado.getString("avaliacoes_antropometricas"));
            return FA;
        } catch (SQLException ex) {
            Logger.getLogger(Ficha_De_AnamneseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Ficha_de_Anamnese ConsultaA(Ficha_de_Anamnese f_aDados){
        try {
            String SQL = "SELECT * FROM mariaclara_faria.Ficha_De_Anamnese";
            Connection conexao = conexao_bdd.getConexao();
            String Filtro ="";
            
            if(f_aDados != null && f_aDados.getAvaliacoes_Antopometricas()!= null && !f_aDados.getAvaliacoes_Antopometricas().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND avaliacoes_antropometricas ilike '%"+f_aDados.getAvaliacoes_Antopometricas()+"%'";
                }
                else{
                Filtro = " WHERE avaliacoes_antropometricas ilike '%" + f_aDados.getAvaliacoes_Antopometricas() +"%'";
                }
            }         
             if(f_aDados != null && f_aDados.getAvaliações_Laboratoriais()!= null && !f_aDados.getAvaliações_Laboratoriais().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND avaliacoes_laboratoriais ilike '%"+f_aDados.getAvaliações_Laboratoriais()+"%'";
                }
                else{
                Filtro = " WHERE avaliacoes_laboratoriais ilike '%" + f_aDados.getAvaliações_Laboratoriais() + "%'";
                }
            }
            if(f_aDados != null && f_aDados.getHabitos_Alimentares()!= null && !f_aDados.getHabitos_Alimentares().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND habitos_alimentares ilike '%"+f_aDados.getHabitos_Alimentares()+"%'";
                }
                else{
                Filtro = " WHERE habitos_alimentares ilike '%" + f_aDados.getHabitos_Alimentares() + "%'";
                }
            } 
            
              if(f_aDados != null && f_aDados.getHabitos_de_Vida()!= null && !f_aDados.getHabitos_de_Vida().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND habitos_de_vida ilike '%"+f_aDados.getHabitos_de_Vida()+"%'";
                }
                else{
                Filtro = " WHERE habitos_de_vida ilike '%" + f_aDados.getHabitos_de_Vida()+"%'";
                }
            }
               if(f_aDados != null && f_aDados.getHistorico_Familiar()!= null && !f_aDados.getHistorico_Familiar().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND historico_familiar ilike '%"+f_aDados.getHistorico_Familiar()+ "%'";
                }
                else{
                Filtro = " WHERE historico_familiar ilike '%" + f_aDados.getHistorico_Familiar() + "%'";
                }
            }
            PreparedStatement pre = conexao.prepareStatement(SQL + Filtro);         
            ResultSet Resul = pre.executeQuery();
            
            if(Resul.next()){
               Ficha_de_Anamnese fa = new Ficha_de_Anamnese();
                fa = this.pegaDados(Resul);
                return fa;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Ficha_De_AnamneseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Ficha_de_Anamnese ConsultFA(String historico_familiar){
         try {
            String SQL = "SELECT historico_familiar, habitos_de_vida, habitos_alimentares, avaliacoes_laboratoriais, avaliacoes_antropometricas FROM mariaclara_faria.ficha_de_anamnese WHERE historico_familiar = ?";
            
            Connection conexao = conexao_bdd.getConexao();
            PreparedStatement pre = conexao.prepareStatement(SQL);
            pre.setString(1, historico_familiar);
            ResultSet Resul = pre.executeQuery();
            
           if (Resul.next()){
                Ficha_de_Anamnese fa_ = new Ficha_de_Anamnese();
                fa_ = this.pegaDados(Resul);
                return fa_;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Ficha_De_AnamneseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     
    }
    public boolean ATUALIZAR_FICHA(Ficha_de_Anamnese Dadosfa){
        try {
            String SQL = "UPDATE mariaclara_faria.ficha_de_anamnese SET habitos_de_vida = ?, habitos_alimentares = ?, avaliacoes_laboratoriais = ?, avaliacoes_antropometricas = ? WHERE historico_familiar = ?";
            Connection conexao = conexao_bdd.getConexao();
              PreparedStatement comando = conexao.prepareStatement(SQL);

             comando.setString(1, Dadosfa.getHabitos_de_Vida());
              comando.setString(2, Dadosfa.getHabitos_Alimentares());
               comando.setString(3, Dadosfa.getAvaliações_Laboratoriais());
                comando.setString(4, Dadosfa.getAvaliacoes_Antopometricas());
                  comando.setString(5, Dadosfa.getHistorico_Familiar());

             int retornar = comando.executeUpdate();
             if (retornar > 0){
                   return true;
                }


        } catch (SQLException ex) {
            Logger.getLogger(Ficha_De_AnamneseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

    
