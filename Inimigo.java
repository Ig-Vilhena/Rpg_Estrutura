import java.util.UUID;

public class Inimigo extends Personagens {

    private String tipoInimigo;

    public Inimigo(String nome, int nivel, int vidaMaxima, int vidaAtual, int manaMaxima, int manaAtual, String tipoInimigo) {
        super(nome, nivel, vidaMaxima, vidaAtual, manaMaxima, manaAtual);
        this.tipoInimigo = tipoInimigo;
    }

    public String getTipoInimigo() {
        return tipoInimigo;
    }

    public void setTipoInimigo(String tipoInimigo) {
        this.tipoInimigo = tipoInimigo;
    }

    @Override
    public String getTipo() {
        return "Inimigo";
    }

    @Override
    public String toString() {
        return "[Inimigo] " + getNome() + " | Nível: " + getNivel() + " | Vida: " + getVidaAtual() + "/" + getVidaMaxima();
    }
}
