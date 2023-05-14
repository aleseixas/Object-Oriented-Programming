import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void coletardados(ArrayList<Seguradora> s){
        Scanner scan = new Scanner(System.in);
        System.out.println("SEJA BEM VINDO A 'SEIXAS SEGUROS'!, DIGITE ALGUM NÚMERO PARA:");
        int valor;
        String nome , endereco;
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        while(true){
            System.out.println("1 - CADASTRAR");
            System.out.println("2 - LISTAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - GERAR SINISTRO");
            System.out.println("5 - TRANSFERIR SEGURO");
            System.out.println("6 - CALCULAR RECEITA DA SEGURADORA");
            System.out.println("0 - SAIR");
            valor = Integer.parseInt(scan.nextLine());
            if (valor == MenuOperacoes.CADASTRAR.getOperacao()){
                //variaveis
                System.out.println("1 - CADASTAR CLIENTE PF/PJ");
                System.out.println("2 - CADASTRAR VEÍCULO");
                System.out.println("3 - CADASTRAR SEGURADORA");
                System.out.println("4 - VOLTAR AO MENU PRINCIPAL");
                valor = Integer.parseInt(scan.nextLine());;
                Seguradora s_cliente = new Seguradora(null, null, null, null, null, null);
                if(valor == MenuOperacoes.CADASTRAPFPJ.getOperacao()){
                    System.out.println("1 - PF");
                    System.out.println("2 - PJ");
                    valor = Integer.parseInt(scan.nextLine());;
                    if(valor == 1){
                        String educacao , genero, classeEconomica , cpf;
                        Calendar hoje = Calendar.getInstance() , datanascimento = Calendar.getInstance();
                        String seguradora_cliente;
                        System.out.println("QUAL É A SEGURADORA QUE VOCÊ DESEJA:");
                        seguradora_cliente = scan.nextLine();
                        //dados relacionados a strings
                        System.out.println("DIGITE O NOME:");
                        nome = scan.nextLine();
                        while(Validacao.Validarnome(nome) == false){
                            System.out.println("FAVOR DIGITAR O NOME SOMENTE COM LETRAS:");
                            nome = scan.nextLine();
                        }
                        System.out.println("EDUCAÇÃO:");
                        educacao = scan.nextLine();
                        System.out.println("GENERO:");
                        genero = scan.nextLine();
                        System.out.println("ENDEREÇO:");
                        endereco = scan.nextLine();
                        System.out.println("SUA CLASSE ECONÔMICA:");
                        classeEconomica = scan.nextLine();
                        System.out.println("CPF:");
                        cpf = scan.nextLine();
                        while(Validacao.validarCPF(cpf) == false){
                            System.out.println("CPF INVÁLIDO,DIGITE SEU CPF NOVAMENTE:");
                            cpf = scan.nextLine();
                        }
                        //datas
                        System.out.println("DIA DO SEU ANIVERSÁRIO");
                        int dia_n = Integer.parseInt(scan.nextLine());
                        System.out.println("MÊS DO SEU ANIVERSÁRIO");
                        int mes_n = Integer.parseInt(scan.nextLine());
                        System.out.println("ANO DO SEU ANIVERSÁRIO");
                        int ano_n = Integer.parseInt(scan.nextLine());
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
                        int n = Integer.parseInt(scan.nextLine());
                        for(int k = 0  ; k < n ; k++ ){
                            System.out.println("PLACA DO CARRO:");
                            String placa = scan.nextLine();
                            System.out.println("MARCA DO CARRO:");
                            String marca = scan.nextLine();
                            System.out.println("MODELO DO CARRO:");
                            String modelo = scan.nextLine();
                            int anofabricacao = Integer.parseInt(scan.nextLine());
                            Veiculo v = new Veiculo(placa,marca,modelo,anofabricacao);
                            veiculos.add(v);
                    }
                    Cliente novoCliente = new ClientePF(nome, educacao, hoje, genero, endereco, classeEconomica, veiculos, cpf, datanascimento);
                    s_cliente = Seguradora.cadastrarCliente(novoCliente, s, seguradora_cliente);
                    s_cliente.calcularPrecoSeguroCliente(novoCliente);
                
                }
                else{
                    String  cnpj;
                    Calendar dataFundacao = Calendar.getInstance();
                    int qtdeFuncionarios;
                    String seguradora_cliente;
                    System.out.println("QUAL É A SEGURADORA QUE VOCÊ DESEJA:");
                    seguradora_cliente = scan.nextLine();
                    //strings 
                    System.out.println("DIGITE O NOME:");
                    nome = scan.nextLine();
                    while(Validacao.Validarnome(nome) == false){
                        System.out.println("NOME INVÁLIDO, POR FAVOR DIGITE SEU NOME APENAS COM LETRA:");
                        nome = scan.nextLine();
                    }
                    System.out.println("CNPJ:");
                    cnpj = scan.nextLine();
                    while(Validacao.validarCNPJ(cnpj) == false){
                        System.out.println("CNPJ INVÁLIDO, FAVOR DIGITE NOVAMENTE:");
                        cnpj = scan.nextLine();
                    }
                    System.out.println("ENDEREÇO:");
                    endereco = scan.nextLine();
                    //data 
                    System.out.println("DIA DO SEU ANIVERSÁRIO");
                    int dia_f= Integer.parseInt(scan.nextLine());
                    System.out.println("MÊS DO SEU ANIVERSÁRIO");
                    int mes_f = Integer.parseInt(scan.nextLine());
                    System.out.println("ANO DO SEU ANIVERSÁRIO");
                    int ano_f = Integer.parseInt(scan.nextLine());
                    dataFundacao.set(Calendar.YEAR, ano_f);
                    dataFundacao.set(Calendar.MONTH,mes_f);
                    dataFundacao.set(Calendar.DAY_OF_MONTH, dia_f);
                    //quantidade de funcionarios 
                    System.out.println("QUANTIDADES DE FUNCIONÁRIOS:");
                    qtdeFuncionarios = Integer.parseInt(scan.nextLine());;
                    //pegando a lista de carro
                    System.out.println("QUANTOS CARROS VOCÊ TEM?:");
                    int n = Integer.parseInt(scan.nextLine());
                    for(int k = 0  ; k < n ; k++ ){
                        System.out.println("PLACA DO CARRO:");
                        String placa = scan.nextLine();
                        System.out.println("MARCA DO CARRO:");
                        String marca = scan.nextLine();
                        System.out.println("MODELO DO CARRO:");
                        String modelo = scan.nextLine();
                        System.out.println("ANO DO CARRO:");
                        int anofabricacao = Integer.parseInt(scan.nextLine());
                        Veiculo v = new Veiculo(placa,marca,modelo,anofabricacao);
                        veiculos.add(v);
                    }
                    Cliente novoCliente = new ClientePJ(nome, endereco, veiculos, cnpj, dataFundacao, qtdeFuncionarios);
                    s_cliente = Seguradora.cadastrarCliente(novoCliente, s, seguradora_cliente);
                    s_cliente.calcularPrecoSeguroCliente(novoCliente);
            }
        }
            
            if(valor == MenuOperacoes.CADASTRAVEICULO.getOperacao()){
                Cliente p_e = new Cliente(null, null, null);
                System.out.println("DIGITE SEU NOME/EMPRESA:");
                String pessoa_empresa = scan.nextLine();
                System.out.println("PLACA DO CARRO:");
                String placa = scan.nextLine();
                System.out.println("MARCA DO CARRO:");
                String marca = scan.nextLine();
                System.out.println("MODELO DO CARRO:");
                String modelo = scan.nextLine();
                System.out.println("ANO DO CARRO:");
                int anofabricacao = Integer.parseInt(scan.nextLine());
                Veiculo v = new Veiculo(placa,marca,modelo,anofabricacao);
                //procurando o cliente/empresa para cadastrar o carro
                Boolean achou = false;
                busca:
                for (int k = 0 ; k < s.size() ; k++){
                    for(int j = 0 ; j < s.get(k).getlistaClientes().size(); j++){
                        if(s.get(k).getlistaClientes().get(j).getNome().equals(pessoa_empresa)){
                            //adicionando o Veiculo
                            s.get(k).getlistaClientes().get(j).getlistaVeiculos().add(v);
                            p_e = s.get(k).getlistaClientes().get(j);
                            s_cliente = s.get(k);
                            achou = true;
                            break busca;
                        }
                    }
                }
                //recalculando o novo valor
                s_cliente.calcularPrecoSeguroCliente(p_e);
                if(achou == true){
                    System.out.println("VEÍCULO REGISTRADO COM SUCESSO");
                }
                else{
                    System.out.println("CLIENTE NÃO ENCONTRADO NOS BANCOS DE DADOS");
                }
            }

            else if(valor == MenuOperacoes.CADASTRASEGURADORA.getOperacao()){ 
                System.out.println("NOME DA SEGURADORA:");
                nome = scan.nextLine();
                System.out.println("DIGITE O TELEFONE:");
                String telefone = scan.nextLine();
                System.out.println("DIGITE O EMAIL:");
                String email = scan.nextLine();
                System.out.println("DIGITE O ENDEREÇO:");
                endereco = scan.nextLine();
                Seguradora novSeguradora =  new Seguradora(nome, telefone, email, endereco, null, null);
                s.add(novSeguradora);
            }

            else if(valor == MenuOperacoes.VOLTARC.getOperacao()){
                continue;
            }
        }

            else if(valor == MenuOperacoes.LISTAR.getOperacao()){
                System.out.println("1 - LISTAR CLIENTE(PF/PJ) POR SEGURADORA");
                System.out.println("2 - LISTAR SINISTROS POR SEGURADORA");
                System.out.println("3 - LISTAR SINISTROS POR CLIENTE");
                System.out.println("4 - LISTAR VEÍCULO POR CLIENTE");
                System.out.println("5 - LISTAR VEÍCULO POR SEGURADORA");
                System.out.println("6 - VOLTAR AO MENU PRINCIPPAL");
                valor = Integer.parseInt(scan.nextLine());
                if (valor == MenuOperacoes.listarPFPJporseguradora.getOperacao()){
                    System.out.println("NOME DA SEGURADORA:");
                    nome = scan.nextLine();
                    System.out.println("DIGITE 1-PF OU 2-PJ:");
                    valor = Integer.parseInt(scan.nextLine());
                    if(valor == 1){
                        Boolean existe = Seguradora.listarClientesPFPJ(s, nome, valor);
                        if(existe == false){
                            System.out.println("ESSA SEGURADORA NÃO EXISTE NO NOSSO BANCO DE DADOS");
                        }
                    }
                    else{
                        Boolean existe = Seguradora.listarClientesPFPJ(s, nome, valor);
                        if(existe == false){
                            System.out.println("ESSA SEGURADORA NÃO EXISTE NO NOSSO BANCO DE DADOS");
                        }
                    }
                }

                else if(valor == MenuOperacoes.listarSINISTROseguradora.getOperacao()){
                    System.out.println("NOME DA SEGURADORA:");
                    nome = scan.nextLine();
                    Boolean existe = Seguradora.listarSinistrosSeguradora(s,nome);
                    if(existe == false){
                        System.out.println("ESSA SEGURADORA NÃO EXISTE NO NOSSO BANCO DE DADOS");
                    }
                }

                else if(valor == MenuOperacoes.listarSINISTROcliente.getOperacao()){
                    System.out.println("SEU NOME/EMPRESA:");
                    nome = scan.nextLine();
                    Boolean existe = Seguradora.listarSinistrosCliente(s, nome);
                    if(existe == false){
                        System.out.println("ESSE CLIENTE NÃO EXISTE SINISTROS REGISTRADOS DESSE CLIENTE");
                    }
                }

                else if(valor == MenuOperacoes.listarVEICULOcliente.getOperacao()){
                    System.out.println("SEU NOME/EMPRESA:");
                    nome = scan.nextLine();
                    Boolean existe = Seguradora.listarVeiculoCliente(s, nome);
                    if(existe == false){
                        System.out.println("ESSE CLIENTE NÃO HÁ VEÍCULOS");
                    }
                }

                else if(valor == MenuOperacoes.listarVEICULOseguradora.getOperacao()){
                    System.out.println("NOME DA SEGURADORA");
                    nome = scan.nextLine();
                    Boolean existe = Seguradora.listarVeiculoSeguradora(s, nome);
                    if(existe == false){
                        System.out.println("ESSA SEGURADORA NÃO EXISTE NO NOSSO BANCO DE DADOS");
                    }
                }

                else if (valor == MenuOperacoes.VOLTARL.getOperacao()){
                    continue;
                }

            }

            else if(valor == MenuOperacoes.EXCLUIR.getOperacao()){
                System.out.println("1 - Excluir Cliente");
                System.out.println("2 - Excluir Veiculo");
                System.out.println("3 - Excluir Sinistro");
                System.out.println("4 - Voltar");
                valor = Integer.parseInt(scan.nextLine());
                if(valor == MenuOperacoes.excluirCLIENTE.getOperacao()){
                    System.out.println("SEU NOME/EMPRESA:");
                    nome = scan.nextLine();
                    Boolean encontrou = Seguradora.removeCliente(s,nome);
                    if(encontrou == true){
                        System.out.println("CLIENTE REMOVIDO COM SUCESSO");
                    }
                    else{
                        System.out.println("ESSE CLIENTE NÃO EXISTE NO BANCO DE DADOS");
                    }
                }

                if(valor == MenuOperacoes.excluirVEICULO.getOperacao()){
                    System.out.println("PLACA DO CARRO:");
                    nome = scan.nextLine();
                    Boolean encontrou = Seguradora.removeVeiculo(s, nome);
                    if(encontrou == true){
                        System.out.println("VEÍCULO REMOVIDO COM SUCESSO");
                    }
                    else{
                        System.out.println("ESSE VEÍCULO NÃO EXISTE NO BANCO DE DADOS");
                    }
                }

                if(valor == MenuOperacoes.excluirSINISTRO.getOperacao()){
                    System.out.println("ID DO SINISTRO:");
                    nome = scan.nextLine();
                    Boolean encontrou = Seguradora.removeSinistro(s, nome);
                    if(encontrou == true){
                        System.out.println("SINISTRO REMOVIDO COM SUCESSO");
                    }
                    else{
                        System.out.println("ESSE SINISTRO NÃO EXISTE NO BANCO DE DADOS");
                    }
                }

                if(valor == MenuOperacoes.VOLTARE.getOperacao()){
                    continue;
                }
            }

            else if(valor == MenuOperacoes.GERARSINISTRO.getOperacao()){
                Seguradora s1 = new Seguradora(null, null, null, null, null, null);
                Cliente c1 = new Cliente(null, null, null);
                Veiculo v1 = new Veiculo(null, null , null, 0);
                Calendar dataAcidente = Calendar.getInstance();
                System.out.println("DIGITE O DIA DO ACIDENTE:");
                int dia_n= Integer.parseInt(scan.nextLine());
                System.out.println("MÊS DO ACIDENTE:");
                int mes_n = Integer.parseInt(scan.nextLine());
                System.out.println("ANO DO ACIDENTE:");
                int ano_n = Integer.parseInt(scan.nextLine());
                dataAcidente.set(Calendar.YEAR, ano_n);
                dataAcidente.set(Calendar.MONTH,mes_n);
                dataAcidente.set(Calendar.DAY_OF_MONTH, dia_n);
                System.out.println("DIGITE O LOCAL DO ACIDENTE:");
                String local= scan.nextLine();
                System.out.println("DIGITE O NOME DA SEGURADORA:");
                String seguradora = scan.nextLine();
                System.out.println("DIGITE O NOME DO CLIENTE:");
                String cliente = scan.nextLine();
                System.out.println("DIGITE O NOME DA PLACA:");
                String placa = scan.nextLine();
                //busca 
                for(int k = 0; k < s.size() ; k++){
                    if(s.get(k).getNome().equals(seguradora)){
                        s1 = s.get(k);
                        for(int j = 0 ; j < s.get(k).getlistaClientes().size() ; j++){
                            if(s.get(k).getlistaClientes().get(j).getNome().equals(cliente)){
                                c1 = s.get(k).getlistaClientes().get(j);
                                for(int f = 0 ; f < s.get(k).getlistaClientes().get(j).getlistaVeiculos().size() ; f++){
                                    if(s.get(k).getlistaClientes().get(j).getlistaVeiculos().get(f).getPlaca().equals(placa)){
                                        v1 = s.get(k).getlistaClientes().get(j).getlistaVeiculos().get(f);
                                    }
                                }
                            }
                        }
                    }
                }
                if(s1.getNome() == null ){
                    System.out.println("SEGURADORA NÃO ENCOTRADO, FAVOR TENTAR NOVAMENTE");
                }
                else if(c1.getNome() == null ){
                    System.out.println("CLIENTE NÃO ENCOTRADO, FAVOR TENTAR NOVAMENTE");
                }
                else if (v1.getModelo() == null){
                    System.out.println("VEÍCULO NÃO ENCOTRADO, FAVOR TENTAR NOVAMENTE");
                }
                else{
                    Seguradora.gerarSinistro(placa,local, s1, v1, c1);
                    System.out.println("SINISTRO GERADO COM SUCESSO!");
                }

            }

            else if (valor == MenuOperacoes.TRANSFERIRSEGURO.getOperacao()){
                System.out.println("TRANFERIR SEGURO");
                System.out.println("PARA QUAL CLIENTE VOCÊ DESEJA TRANFERIR OS SEGUROS?:");
                String cliente2 = scan.nextLine();
                System.out.println("SEU NOME:");
                nome = scan.nextLine();
                System.out.println("NOME DA SUA SEGURADORA:");
                String seguradora = scan.nextLine();
                Seguradora.Tranferirseguro(seguradora,nome, cliente2, s);
                System.out.println("TRANSFERÊNCIA FEITA COM SUCESSO");

            }
            
            else if (valor == MenuOperacoes.CALCULARRECEITASEGURADORA.getOperacao()){
                System.out.println("DE QUE SEGURADORA VOCÊ QUER SABER A RECEITA?:");
                nome = scan.nextLine();
                System.out.println("A RECEITA DA SEGURADORA É : " + Seguradora.calcularReceita(nome,s));
            } 

            else if (valor == MenuOperacoes.SAIR.getOperacao()){
                System.out.println("ESPERAMOS QUE TENHAMOS RESOLVIDO SEU PROBLEMA,ATÉ A PRÓXIMA!");
                scan.close();
                break;
            }
        }
    }

    public static void main(String[] args){
        //CRIANDO AS LISTAS 
        ArrayList<Veiculo> veiculos1 = new ArrayList<>();
        ArrayList<Veiculo> veiculos2 = new ArrayList<>();
        ArrayList<Seguradora> seguradoras = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Sinistro> sinistros = new ArrayList<>();
        //criando data
        Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, 2022);
        data.set(Calendar.MONTH, 8);
        data.set(Calendar.DAY_OF_MONTH, 15);
        //instanciando
        Veiculo v1 = new Veiculo("15192012", "FORD", "mustang", 2022);
        Veiculo v2 = new Veiculo("SLA151515", "fiat", "pulse", 2023);
        Veiculo v3 = new Veiculo("KKK222211", "porshe", "A4", 2020);
        ClientePF c1 = new ClientePF("ale", "graduado",data, "masculino", "rua poder alem", "medio", veiculos1, "46417742857", data);
        ClientePJ c2 = new ClientePJ("FAE STORE", "Rua padoca vila", veiculos1, "128103102183", data, 10);
        Seguradora s1 = new Seguradora("PORTO SEGURO", "198218201", "alelsq@iqjs", "rau n te interessa", sinistros, clientes);
        Seguradora s2 = new Seguradora("ANEL SEGURO", "198218201", "alelsq@iqjs", "rau n te interessa", sinistros, clientes);
        Sinistro si1 = new Sinistro("1021313","slaaa", s2, v3, c2);
        Sinistro si2 = new Sinistro("31313","slaaa", s1, v2, c1);
        //adicionando valores
        veiculos1.add(v1);
        veiculos1.add(v2);
        veiculos1.add(v3);
        veiculos2.add(v2);
        seguradoras.add(s1);
        seguradoras.add(s2);
        sinistros.add(si1);
        sinistros.add(si2);
        c1.setValorSeguro(100);
        c2.setValorSeguro(200);
        //adicionando veiculo em cada cliente
        c1.setlistaVeiculos(veiculos1);
        c2.setlistaVeiculos(veiculos2);
        //cadastrando PF e PJ na seguradora
        Seguradora.cadastrarCliente(c1, seguradoras,"PORTO SEGURO");
        System.out.println(s1.getlistaClientes().get(0));
        System.out.println("\n");
        Seguradora.cadastrarCliente(c2, seguradoras, "ANEL SEGURO");
        System.out.println(s2.getlistaClientes());
        System.out.println("\n");
        //gera sinistro
        Seguradora.gerarSinistro("0128031","qualquer", s1, v3, c1);
        Seguradora.gerarSinistro("0128031","qualquer", s2, v3, c2);
        Seguradora.gerarSinistro("1021i213", "teste", s2, v3, c2);
        //metodos da classe seguradora,gerarsinistro e cadastrarcliente ja usado
        Seguradora.listarClientesPFPJ(seguradoras,"PORTO SEGURO",1);
        Seguradora.listarClientesPFPJ(seguradoras, "ANEL SEGURO", 2);
        Seguradora.listarSinistrosCliente(seguradoras, "ale");
        Seguradora.listarSinistrosSeguradora(seguradoras, "ANEL SEGURO");
        Seguradora.listarVeiculoCliente(seguradoras, "FAE STORE");
        Seguradora.listarVeiculoSeguradora(seguradoras, "PORTO SEGURO");
        Seguradora.removeCliente(seguradoras, "FAE STORE");
        Seguradora.removeSinistro(seguradoras, "100121"); //funciona apenas com o id
        Seguradora.removeVeiculo(seguradoras, "KKK222211");
        Seguradora.visualizarSinistro("ale", s1);
        Seguradora.cadastrarCliente(c2, seguradoras, "ANEL SEGURO");
        Seguradora.cadastrarCliente(c1, seguradoras, "ANEL SEGURO");
        Seguradora.Tranferirseguro("ANEL SEGURO", "FAE STORE", "ale", seguradoras);
        System.out.println("A RECEITA DA SEGURADORA É : " + Seguradora.calcularReceita("PORTO SEGURO",seguradoras));
        System.out.println("A RECEITA DA SEGURADORA É : " + Seguradora.calcularReceita("ANEL SEGURO",seguradoras));
        //os valores se igualam das duas seguradoras devido a transferencia ir para o cliente ale , que tem nas duas seguradoras e será unico cliente que terá um valor
        //coletando dados
        coletardados(seguradoras);
        
    }
}
