import java.util.ArrayList;
import java.util.List;

public class ServiceVeiculo {
    private List<Veiculo> frota = new ArrayList<>();

    public Veiculo save(Veiculo veiculo) {
        
        frota.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> findAll() {
        return frota;
    }

    public Veiculo findByPlaca(String placa) throws Exception {
        Veiculo veiculoRet = null;
        for (Veiculo veiculo : frota) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculoRet = veiculo;
                break;
            }
        }
        if (veiculoRet == null)
            throw new Exception("Veículo não encontrado com a placa informada");
        return veiculoRet;
    }
    public void removerPorPlaca(String placa) throws Exception{
        boolean veiculoRemovido = false;
        for (Veiculo veiculo : frota) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculoRemovido = true;
                frota.remove(veiculo);
                break;
            }
        }
        if (!veiculoRemovido)
            throw new Exception("Livro não encontrado com este título");
    }
}
