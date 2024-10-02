public class Moto extends Veiculo{
    private boolean partidaEletrica;

    public boolean isPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }
    
    public String toString() {
        String descricao = super.toString();
        return descricao + "\nPartida Eletrica: " + this.isPartidaEletrica();
    }
}
