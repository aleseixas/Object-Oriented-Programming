import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static Cliente coletardados(){
        Scanner scan = new Scanner(System.in);
        System.out.println("SEJA BEM VINDO A 'SEIXAS SEGUROS'!, DIGITE ALGUM NÚMERO PARA:");
        int valor;
        String nome , endereco;
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        while(true){
            System.out.println("1-PARA CADASTRA PESSOA FÍSICA");
            System.out.println("2-PARA CADASTRAR PESSOA JURÍDICA");
            System.out.println("3-PARA ENTRAR EM CONTATO CONOSOCO");
            System.out.println("4-ENDEREÇO DA AGÊNCIA MAIS PRÓXIMA");
            System.out.println("5-PARA ENCERRAR ESSA SESSÃO");
            valor = scan.nextInt();
            if (valor == MenuOperacoes.CADASTRAR.getOperacao()){
                //variaveis
                String educacao , genero, classeEconomica , cpf;
                Calendar hoje = Calendar.getInstance() , datanascimento = Calendar.getInstance();
                //dados relacionados a strings
                System.out.println("DIGITE O NOME:");
                nome = scan.next();
                System.out.println("EDUCAÇÃO:");
                educacao = scan.next();
                System.out.println("GENERO:");
                genero = scan.next();
                System.out.println("ENDEREÇO:");
                endereco = scan.next();
                System.out.println("SUA CLASSE ECONÔMICA:");
                classeEconomica = scan.next();
                System.out.println("CPF:");
                cpf = scan.next();
                //datas
                System.out.println("DIA DO SEU ANIVERSÁRIO");
                int dia_n= scan.nextInt();
                System.out.println("MÊS DO SEU ANIVERSÁRIO");
                int mes_n = scan.nextInt();
                System.out.println("ANO DO SEU ANIVERSÁRIO");
                int ano_n = scan.nextInt();
                int dia_L = hoje.get(Calendar.DAY_OF_MONTH);
                int mes_L = hoje.get(Calendar.MONTH) - 1;
                int ano_L = hoje.get(Calendar.YEAR);
                hoje.set(Calendar.YEAR, ano_L);
                hoje.set(Calendar.MONTH,mes_L);
                hoje.set(Calendar.DAY_OF_MONTH, dia_L);
                datanascimento.set(Calendar.YEAR, ano_n);
                datanascimento.set(Calendar.MONTH,mes_n);
                datanascimento.set(Calendar.DAY_OF_MONTH, dia_n);
                //pegando a lista de carro
                System.out.println("QUANTOS CARROS VOCÊ TEM?:");
                int n = scan.nextInt();
                for(int k = 0  ; k < n ; k++ ){
                    System.out.println("PLACA DO CARRO:");
                    String placa = scan.next();
                    System.out.println("MARCA DO CARRO:");
                    String marca = scan.next();
                    System.out.println("MODELO DO CARRO:");
                    String modelo = scan.next();
                    System.out.println("ANO DO CARRO:");
                    int anofabricacao = scan.nextInt();
                    Veiculo v = new Veiculo(placa,marca,modelo,anofabricacao);
                    veiculos.add(v);
                }
                Cliente novoCliente = new ClientePF(nome, educacao, hoje, genero, endereco, classeEconomica, veiculos, cpf, datanascimento);
                scan.close();
                return novoCliente;
            }

            if(valor == 2){
                String  cnpj;
                Calendar dataFundacao = Calendar.getInstance();
                //strings 
                System.out.println("DIGITE O NOME:");
                nome = scan.next();
                System.out.println("CNPJ:");
                cnpj = scan.next();
                System.out.println("ENDEREÇO:");
                endereco = scan.next();
                //data 
                System.out.println("DIA DO SEU ANIVERSÁRIO");
                int dia_f= scan.nextInt();
                System.out.println("MÊS DO SEU ANIVERSÁRIO");
                int mes_f = scan.nextInt();
                System.out.println("ANO DO SEU ANIVERSÁRIO");
                int ano_f = scan.nextInt();
                dataFundacao.set(Calendar.YEAR, ano_f);
                dataFundacao.set(Calendar.MONTH,mes_f);
                dataFundacao.set(Calendar.DAY_OF_MONTH, dia_f);
                //pegando a lista de carro
                System.out.println("QUANTOS CARROS VOCÊ TEM?:");
                int n = scan.nextInt();
                for(int k = 0  ; k < n ; k++ ){
                    System.out.println("PLACA DO CARRO:");
                    String placa = scan.next();
                    System.out.println("MARCA DO CARRO:");
                    String marca = scan.next();
                    System.out.println("MODELO DO CARRO:");
                    String modelo = scan.next();
                    System.out.println("ANO DO CARRO:");
                    int anofabricacao = scan.nextInt();
                    Veiculo v = new Veiculo(placa,marca,modelo,anofabricacao);
                    veiculos.add(v);
                }
                Cliente novoCliente = new ClientePJ(nome, endereco, veiculos, cnpj, dataFundacao);
                scan.close();
                return novoCliente;
            }

            if(valor == 3){
                System.out.println("OPS....ESTAMOS FORA DE AR, ENTRE EM CONTATO CONOSCO EM BREVE PELO NÚMERO 19 718201813");
            }

            if(valor == 4){
                System.out.println("A AGÊNCIA MAIS PRÓXIMA DE VOCÊ FICA : RUA ALBERT EINSTEIN, 777");
            }

            if (valor == 5){
                System.out.println("ESPERAMOS QUE TENHAMOS RESOLVIDO SEU PROBLEMA,ATÉ A PRÓXIMA!");
                Cliente novoCliente = new Cliente(null, null, null);
                scan.close();
                return novoCliente;
            }
        }
    }

    public static void main(String[] args){
        //instanciando
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Veiculo v = new Veiculo("12091jsql", "CITROEN", "C4", 0);
        veiculos.add(v);
        //adicionei os veiculos nos clientes aqui e instanciei a seguradora
        ClientePJ cliente2 = new ClientePJ("joao", "sla", veiculos, "13.849.353/0001-02", null);
        ClientePF cliente1 = new ClientePF("diego", "graduado", null,"masculino", "sla", "rico", veiculos, "1923013012", null);
        Sinistro sinistro1 = new Sinistro(null, null, null, v, cliente2);
        ArrayList<Sinistro> s =new ArrayList<>();
        s.add(sinistro1);
        ArrayList<Cliente> clientes =new ArrayList<>();
        ClientePF cliente3 = new ClientePF("ale", "graduado", null,"masculino", "sla", "medio", veiculos, "1i2139313", null);
        Seguradora Seixas = new Seguradora("Seixas Seguro", "19 291310312", "seixas@hotmail.com", "sla", s, clientes);
        Cliente novoCliente = new Cliente(null, null, null);
        //funções na main tostriing
        System.out.println(novoCliente.toString()+"\n");
        System.out.println(v.toString()+"\n");
        System.out.println(cliente1.toString()+"\n");
        System.out.println(cliente2.toString()+"\n");
        System.out.println(sinistro1.toString()+"\n");
        System.out.println(Seixas.toString()+"\n");

        //validação cpf e cnpj
        System.out.println(ClientePF.validarCPF(cliente1.getCPF())+"\n");
        System.out.println(ClientePJ.validarCNPJ(cliente2.getCNPJ())+"\n");

        //cadastrar e remover cliente
        System.out.println(Seguradora.cadastrarCliente(cliente3, Seixas.getlistaClientes())+"\n");
        System.out.println(Seixas.getlistaClientes()+"\n");
        System.out.println(Seguradora.removeCliente(cliente3.getNome(), Seixas.getlistaClientes(),Seixas.getlistaSinistros())+"\n");
        System.out.println(Seixas.getlistaClientes()+"\n");

        //cadastrando pelo menos 2 clientes
        System.out.println(Seguradora.cadastrarCliente(cliente1, Seixas.getlistaClientes())+"\n");
        System.out.println(Seixas.getlistaClientes()+"\n");
        System.out.println(Seguradora.cadastrarCliente(cliente2, Seixas.getlistaClientes())+"\n");
        System.out.println(Seixas.getlistaClientes()+"\n");

        //gerando sinistro e visualizando sinsitro
        Seguradora.gerarSinistro("10122013", "slaaa", Seixas, v, cliente1);
        Seguradora.visualizarSinistro(cliente1.getNome(), Seixas);
        System.out.println("\n");
        //listando listasinistro e listaclientes em função no nome de liente
        Seguradora.listarSinistro(Seixas);
        System.out.println("\n");
        Seguradora.listarClientes(Seixas);

        //coletando dados
        novoCliente = coletardados();
        
    }
}
