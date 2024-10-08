public class Carro extends Veiculo{
    private int numeroPortas;

    public String getTipo() {
        return "CARRO";
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }
    
    public String toString() {

        String descricao = super.toString();
        return descricao + " - N. de portas: " + this.getNumeroPortas();
    }
}
