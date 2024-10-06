import java.util.ArrayList;
import java.util.List;

public class ServiceVeiculo {
    private List<Veiculo> frota = new ArrayList<>();

    public void save(Veiculo veiculo) throws Exception {
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty())
            throw new Exception("Não é permitido cadastrar veículos sem marca");
        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty())
            throw new Exception("Não é permitido cadastrar veículos sem modelo");
        if (veiculo.getAno() == 0)
            throw new Exception("Não é permitido cadastrar veículos com ano 0");
        if (veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty())
            throw new Exception("Não é permitido cadastrar um veículo sem a placa");
        for (Veiculo veiculoFrota : frota) {
            if (veiculoFrota.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) 
                throw new Exception("Já existe um veículo cadastrado com essa placa");
        }
        
        frota.add(veiculo);
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
            throw new Exception("Nenhum veículo encontrado com a placa informada");
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
