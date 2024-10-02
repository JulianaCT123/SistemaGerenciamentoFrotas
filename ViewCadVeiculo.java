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
        veiculos.sort(Comparator.comparing(Veiculo:: getMarca));

        System.out.println("====== Lista de Veiculos ======");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.toString());
            System.out.println("----------------");
        }
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
    public static void cadastrar() {
        limparTela();
        Veiculo novoVeiculo = null;
        System.out.println("CADASTRAR VEICULO");
        int tipoVeiculo;
        do{
            tipoVeiculo = inputNumerico("carro 1 ou moto 2");
            if (tipoVeiculo ==1) {
                novoVeiculo = new Carro();
            } else if (tipoVeiculo == 2){
                novoVeiculo = new Moto();
            }else{
                System.out.println("Opção");
            }
        } while (novoVeiculo == null);
        System.out.println("informe a marca do veiculo ");
        String marca = input.nextLine();
        novoVeiculo.setMarca(marca);

        System.out.println("informe o modelo");
        novoVeiculo.setModelo(input.nextLine());

        int ano = inputNumerico("informe o ano: ");
        novoVeiculo.setAno(ano);

        System.out.println("informe a placa: ");
        String placa = input.nextLine();
        novoVeiculo.setPlaca(placa);
        




        
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
                Digite a opção desejada:  
                """;
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
                    
                    break;
                case 4:
                    
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    aguardarEnter();
                    break;
            }
        } while (opcao != 0);
    }
}
