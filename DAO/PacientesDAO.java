package DAO;
import MODELO.Pacientes;
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

public class PacientesDAO {
    public boolean inserirPacientesDAO (Pacientes a){ 
        try{
            
            String SQL = "INSERT INTO mariaclara_faria.pacientes (sexo, nome, idade, telefone, email, Cpf) VALUES (?,?,?,?,?,?)";
                
            Connection conectar = conexao_bdd.getConexao();
            PreparedStatement comandoSQL = conectar.prepareStatement(SQL);
            comandoSQL.setString(1, a.getSexo());
            comandoSQL.setString(2, a.getNome());
            comandoSQL.setString(3, a.getIdade());
            comandoSQL.setString(4, a.getTelefone());
            comandoSQL.setString(5, a.getemail());
            comandoSQL.setString(6, a.getCpf());
            int retorno = comandoSQL.executeUpdate();
            
            conectar.close();
            if(retorno>0){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<Pacientes> pa(){
        try {
            String SQL = "SELECT sexo, nome, idade, telefone, email, Cpf FROM mariaclara_faria.pacientes";
            List<Pacientes> ListaP = new ArrayList<Pacientes>();
            Connection conectar = conexao_bdd.getConexao();
            PreparedStatement pre = conectar.prepareStatement(SQL);
            ResultSet Resul = pre.executeQuery();

            while (Resul.next()){
                Pacientes p = new Pacientes();
                p = this.PegaDados(Resul);
                ListaP.add(p);
            }
            return ListaP;
        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Pacientes PegaDados(ResultSet resultado){
        try {
            Pacientes P = new Pacientes();
            P.setSexo(resultado.getString("sexo"));
            P.setNome(resultado.getString("nome"));
            P.setIdade(resultado.getString("idade"));
            P.setTelefone(resultado.getString("telefone"));
            P.setemail(resultado.getString("email"));
            P.setCpf(resultado.getString("Cpf"));
            return P;
        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Pacientes ConsultaP(Pacientes pDados){
        try {
            String SQL = "SELECT * FROM mariaclara_faria.pacientes";
            Connection conexao = conexao_bdd.getConexao();
            String Filtro ="";
            
            if(pDados != null && pDados.getSexo()!= null && !pDados.getSexo().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND sexo ilike '%"+pDados.getSexo()+"%'";
                }
                else{
                Filtro = " WHERE sexo ilike '%" + pDados.getSexo() +"%'";
                }
            }         
             if(pDados != null && pDados.getNome()!= null && !pDados.getNome().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND nome ilike '%"+pDados.getNome()+"%'";
                }
                else{
                Filtro = " WHERE nome ilike '%" + pDados.getNome() + "%'";
                }
            }
            if(pDados != null && pDados.getIdade()!= null && !pDados.getIdade().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND idade ilike '%"+pDados.getIdade()+"%'";
                }
                else{
                Filtro = " WHERE idade ilike '%" + pDados.getIdade() + "%'";
                }
            } 
              if(pDados != null && pDados.getTelefone()!= null && !pDados.getTelefone().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND telefone ilike '%"+pDados.getTelefone()+"%'";
                }
                else{
                Filtro = " WHERE telefone ilike '%" + pDados.getTelefone()+"%'";
                }
            }
               if(pDados != null && pDados.getemail()!= null && !pDados.getemail().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND email ilike '%"+pDados.getemail()+ "%'";
                }
                else{
                Filtro = " WHERE email ilike '%" + pDados.getemail() + "%'";
                }
            }
                if(pDados != null && pDados.getCpf()!= null && !pDados.getCpf().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND Cpf ilike '%"+pDados.getemail()+ "%'";
                }
                else{
                Filtro = " WHERE Cpf ilike '%" + pDados.getemail() + "%'";
                }
            }
               
            PreparedStatement pre = conexao.prepareStatement(SQL + Filtro);         
            ResultSet Resul = pre.executeQuery();
            
            if(Resul.next()){
               Pacientes pa = new Pacientes();
               pa = this.PegaDados(Resul);
                return pa;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Pacientes ConsultaP(String Cpf){
         try {
            String SQL = "SELECT Cpf, sexo, nome, idade, telefone, email FROM mariaclara_faria.pacientes WHERE Cpf = ?";
            
            Connection conexao = conexao_bdd.getConexao();
            PreparedStatement pre = conexao.prepareStatement(SQL);
            pre.setString(1, Cpf);
            ResultSet Resul = pre.executeQuery();
            
           if (Resul.next()){
                Pacientes pa = new Pacientes();
                pa = this.PegaDados(Resul);
                return pa;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     
    }
    public boolean ATUALIZAR_PACIENTES(Pacientes Dadosp){
        try {
            String SQL = "UPDATE mariaclara_faria.pacientes SET sexo = ?, nome = ?, idade = ? telefone = ?, email = ? WHERE Cpf = ?";
            Connection conexao = conexao_bdd.getConexao();
              PreparedStatement comando = conexao.prepareStatement(SQL);

             comando.setString(1, Dadosp.getSexo());
              comando.setString(2, Dadosp.getNome());
               comando.setString(3, Dadosp.getIdade());
                comando.setString(4, Dadosp.getTelefone());
                  comando.setString(5, Dadosp.getemail());
                  comando.setString(6, Dadosp.getCpf());

             int retornar = comando.executeUpdate();
             if (retornar > 0){
                   return true;
                }


        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
