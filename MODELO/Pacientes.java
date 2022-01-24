package MODELO;

public class Pacientes {
    private String Sexo;
    private String Nome;
    private String Idade;
    private String Telefone;
    private String email; 
    private String Cpf;

    public Pacientes(String Sexo, String Nome, String Idade, String Telefone, String email, String Cpf) {
        this.Sexo = Sexo;
        this.Nome = Nome;
        this.Idade = Idade;
        this.Telefone = Telefone;
        this.email = email;
        this.Cpf = Cpf;
    }

    public Pacientes() {
    this.Sexo = "";
        this.Nome = "";
        this.Idade = "";
        this.Telefone = "";
        this.email = "";
        this.Cpf = "";
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String Idade) {
        this.Idade = Idade;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
}
}

