package MODELO;

public class Ficha_de_Anamnese {
    private String Historico_Familiar;
    private String Habitos_de_Vida;
    private String Habitos_Alimentares;
    private String Avaliações_Laboratoriais;
    private String Avaliacoes_Antopometricas; 

    public Ficha_de_Anamnese(String Historico_Familiar, String Habitos_de_Vida, String Habitos_Alimnetares, String Avaliações_Laboratoriais, String Avaliacoes_Antopometricas) {
        this.Historico_Familiar = Historico_Familiar;
        this.Habitos_de_Vida = Habitos_de_Vida;
        this.Habitos_Alimentares = Habitos_Alimnetares;
        this.Avaliações_Laboratoriais = Avaliações_Laboratoriais;
        this.Avaliacoes_Antopometricas = Avaliacoes_Antopometricas;
    }

    public Ficha_de_Anamnese() {
    this.Historico_Familiar = "";
        this.Habitos_de_Vida = "";
        this.Habitos_Alimentares = "";
        this.Avaliações_Laboratoriais = "";
        this.Avaliacoes_Antopometricas = "";
    }

    public String getHistorico_Familiar() {
        return Historico_Familiar;
    }

    public void setHistorico_Familiar(String Historico_Familiar) {
        this.Historico_Familiar = Historico_Familiar;
    }

    public String getHabitos_de_Vida() {
        return Habitos_de_Vida;
    }

    public void setHabitos_de_Vida(String Habitos_de_Vida) {
        this.Habitos_de_Vida = Habitos_de_Vida;
    }

    public String getHabitos_Alimentares() {
        return Habitos_Alimentares;
    }

    public void setHabitos_Alimentares(String Habitos_Alimentares) {
        this.Habitos_Alimentares = Habitos_Alimentares;
    }

    public String getAvaliações_Laboratoriais() {
        return Avaliações_Laboratoriais;
    }

    public void setAvaliações_Laboratoriais(String Avaliações_Laboratoriais) {
        this.Avaliações_Laboratoriais = Avaliações_Laboratoriais;
    }

    public String getAvaliacoes_Antopometricas() {
        return Avaliacoes_Antopometricas;
    }

    public void setAvaliacoes_Antopometricas(String Avaliacoes_Antopometricas) {
        this.Avaliacoes_Antopometricas = Avaliacoes_Antopometricas;
    }

    @Override
    public String toString() {
        return Historico_Familiar + "|" + Habitos_de_Vida + "|" + Habitos_Alimentares + "|" + Avaliações_Laboratoriais + "|" + Avaliacoes_Antopometricas;
    }
    
}



