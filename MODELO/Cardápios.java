package MODELO;

public class Cardápios {
    private String  Jejum_Intermitente;
    private String Substituicoes;
    private String Dietas_Subterraneas; 

    public Cardápios(String Jejum_Intermitente, String Substituicoes, String Dietas_Subterraneas) {
        this.Jejum_Intermitente = Jejum_Intermitente;
        this.Substituicoes = Substituicoes;
        this.Dietas_Subterraneas = Dietas_Subterraneas;
    }

    public Cardápios() {
    this.Jejum_Intermitente = "";
        this.Substituicoes = "";
        this.Dietas_Subterraneas = "";
    }

    public String getJejum_Intermitente() {
        return Jejum_Intermitente;
    }

    public void setJejum_Intermitente(String Jejum_Intermitente) {
        this.Jejum_Intermitente = Jejum_Intermitente;
    }

    public String getSubstituicoes() {
        return Substituicoes;
    }

    public void setSubstituicoes(String Substituicoes) {
        this.Substituicoes = Substituicoes;
    }

    public String getDietas_Subterraneas() {
        return Dietas_Subterraneas;
    }

    public void setDietas_Subterraneas(String Dietas_Subterraneas) {
        this.Dietas_Subterraneas = Dietas_Subterraneas;
    }

    @Override
    public String toString() {
        return Jejum_Intermitente + "|" + Substituicoes + "|" + Dietas_Subterraneas + '|';
    }
}

    

