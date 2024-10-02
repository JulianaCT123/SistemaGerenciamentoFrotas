import java.util.Comparator;
import java.util.Scanner;

public class ViewCadVeiculo {
    private static ServiceVeiculo service = new ServiceVeiculo();
    static Scanner input = new Scanner(System.in);

    public static void limparTela() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void aguardarEnter() {
        System.out.print("Pressione Enter para continuar...");
        input.nextLine();
    }

    public static void listar() {
        limparTela();
        var veiculos = service.findAll();
        veiculos.sort(Comparator.comparing(Veiculo::getMarca));

        System.out.println("====== Lista de Veiculos ======");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.toString());
            System.out.println("----------------------");
        }
        aguardarEnter();
    }

    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.print(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("ERRO. Valor informado deve ser um número Inteiro");
            }
        } while (!entradaValida);
        return valor;
    }

    private static void removerPorPlaca() {
        limparTela();
        listar();
        System.out.println("REMOÇÂO DE VEÍCULO");

        System.out.println("Infirme a placa do veículo que deseja REMOVER: ");
        String placa = input.nextLine();
        try {
            service.removerPorPlaca(placa);
            System.out.println("Veículo removido!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        aguardarEnter();
    }

    public static void cadastrar() {
        limparTela();
        Veiculo novoVeiculo = null;
        System.out.println("====== CADASTRAR VEÍCULO ======");
        int tipoVeiculo;
        do{
            tipoVeiculo = inputNumerico("Qual tipo de veículo: (1) Carro - (2) Moto ");
            if (tipoVeiculo == 1 ) {
                novoVeiculo = new Carro();
            } else if (tipoVeiculo == 2){
                novoVeiculo = new Moto();
            }else{
                System.out.println("Opção Invalida!");
            }
        } while (novoVeiculo == null);
        System.out.print("Informe a marca: ");
        String marca = input.nextLine();
        novoVeiculo.setMarca(marca);

        System.out.print("Informe o modelo: ");
        novoVeiculo.setModelo(input.nextLine());

        int ano = inputNumerico("Informe o ano: ");
        novoVeiculo.setAno(ano);

        System.out.print("Informe a placa: ");
        String placa = input.nextLine();
        novoVeiculo.setPlaca(placa);
        
        if (tipoVeiculo == 1) {
            // adicionar
        } else if (tipoVeiculo == 2) {
            // adicionar
        }

        service.save(novoVeiculo);

        aguardarEnter();
    }

    public static void pesquisarPorPlaca () {
        // adicionar
    }

    public static void main(String[] args) {
        String menu = """
                SISTEMA DE GERENCIAMENTO DE FROTAS
                Menu de Opções:
                1 - Cadastrar novo Veículo;
                2 - Listar todos Veículos cadastrados;
                3 - Pesquisar Veículo pela placa;
                4 - Remover Veículo;
                0 - Sair;

                Digite a opção desejada: """;
        int opcao;
        do {
            limparTela();
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    System.out.println("VOLTE SEMPRE!!!");
                    break;
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();    
                    break;
                case 3:
                    pesquisarPorPlaca();
                    break;
                case 4:
                    removerPorPlaca();
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    aguardarEnter();
                    break;
            }
        } while (opcao != 0);
    }

}
