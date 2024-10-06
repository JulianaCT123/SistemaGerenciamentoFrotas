public class Moto extends Veiculo{
    private boolean partidaEletrica;

    public String getTipo() {
        return "MOTO";
    }

    public boolean isPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }
    
    public String toString() {
        String descricao = super.toString();
        String partida;
        if (this.partidaEletrica)
            partida = "Sim";
        else 
            partida = "Não";
        return descricao + "\nPartida Eletrica: " + partida;
    }
}
