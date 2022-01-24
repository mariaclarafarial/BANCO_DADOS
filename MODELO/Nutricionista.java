package MODELO;

public class Nutricionista {
    private String Nome;
    private String Telefone;
    private String Endereço;
    private String email; 

    public Nutricionista(String Nome, String Telefone, String Endereço, String email) {
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Endereço = Endereço;
        this.email = email;
    }

    public Nutricionista() {
    this.Nome = "";
    this.Telefone = "";
    this.Endereço = "";
    this.email = "";
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String endereço) {
        this.Endereço = Endereço;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return Nome + "|" + Telefone + "|" + Endereço + "|" + email; 
    }
    
}
