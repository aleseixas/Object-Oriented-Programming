import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void coletardados(ArrayList<Seguradora> s){
        Scanner scan = new Scanner(System.in);
        System.out.println("SEJA BEM VINDO A 'SEIXAS SEGUROS'!, DIGITE ALGUM NÚMERO PARA:");
        int valor;
        String nome , endereco;
        while(true){
            System.out.println("1 - CADASTRAR");
            System.out.println("2 - LISTAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - GERAR SINISTRO");
            System.out.println("5 - GERAR SEGURO");
            System.out.println("6 - CALCULAR RECEITA DA SEGURADORA");
            System.out.println("0 - SAIR");
            valor = Integer.parseInt(scan.nextLine());
            if (valor == MenuOperacoes.CADASTRAR.getOperacao()){
                //variaveis
                System.out.println("1 - CADASTAR CLIENTE PF/PJ");
                System.out.println("2 - CADASTRAR VEÍCULO");
                System.out.println("3 - CADASTRAR FROTA");
                System.out.println("4 - VOLTAR AO MENU PRINCIPAL");
                valor = Integer.parseInt(scan.nextLine());;
                Seguradora s_cliente = null;
                if(valor == MenuOperacoes.CADASTRAPFPJ.getOperacao()){
                    System.out.println("1 - PF");
                    System.out.println("2 - PJ");
                    valor = Integer.parseInt(scan.nextLine());;
                    if(valor == 1){
                        String educacao , genero, telefone , cpf , email;
                        Calendar hoje = Calendar.getInstance() , datanascimento = Calendar.getInstance();
                        String seguradora_cliente;
                        System.out.println("DIGITE A CNPJ DE SUA SEGURADORA :");
                        seguradora_cliente = scan.nextLine();
                        while(Validacao.validarCNPJ(seguradora_cliente)== false){
                            System.out.println("CNPJ INVÁLIDA,FAVOR DIGITE NOVAMENTE:");
                            seguradora_cliente = scan.nextLine();
                        }
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
                        System.out.println("TELEFONE DE CONTATO:");
                        telefone = scan.nextLine();
                        System.out.println("EMAIL DE CONTATO:");
                        email = scan.nextLine();
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
                    ClientePF novoCliente = new ClientePF(nome, email, telefone, genero, endereco, educacao, cpf, datanascimento);
                    Seguradora.cadastrarCliente(novoCliente, s, seguradora_cliente);
                }
                else{
                    String  cnpj,telefone,email;
                    Calendar dataFundacao = Calendar.getInstance();
                    int qtdeFuncionarios;
                    String seguradora_cliente;
                    System.out.println("DIGITE A CNPJ DE SUA SEGURADORA:");
                    seguradora_cliente = scan.nextLine();
                    while(Validacao.validarCNPJ(seguradora_cliente) == false){
                        System.out.println("CNPJ INVÁLIDA,FAVOR DIGITE NOVAMENTE:");
                        seguradora_cliente = scan.nextLine();
                    }
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
                    System.out.println("TELEFONE DE CONTATO:");
                    telefone = scan.nextLine();
                    System.out.println("EMAIL DE CONTATO:");
                    email = scan.nextLine();
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
                    Cliente novoCliente = new ClientePJ(nome, endereco, endereco, seguradora_cliente, cnpj, dataFundacao, qtdeFuncionarios);
                    s_cliente = Seguradora.cadastrarCliente(novoCliente, s, seguradora_cliente);
            }
        }
            
            if(valor == MenuOperacoes.CADASTRAVEICULO.getOperacao()){
                System.out.println("DIGITE SEU CPF:");
                String cpf = scan.nextLine();
                while(Validacao.validarCPF(cpf) == false){
                    System.out.println("CPF INVÁLIDO,DIGITE SEU CPF NOVAMENTE:");
                    cpf = scan.nextLine();
                }
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
                    for(Cliente cliente : s.get(k).getlistaClientes()) {
                        if(cliente instanceof ClientePF){
                            ClientePF clientePF = (ClientePF) cliente;
                            if (clientePF.getCPF().equals(cpf)){
                                achou = true;
                                clientePF.cadastrarVeiculo(v);
                                break busca;
                            }
                        }
                        else{
                            ClientePJ clientePJ = (ClientePJ) cliente;
                            if(clientePJ.getCNPJ().equals(cpf)){
                                achou = false;
                                break busca;
                            }
                        }
                    }
                }
    
                if(achou == true){
                    System.out.println("VEÍCULO REGISTRADO COM SUCESSO");
                }
                else{
                    System.out.println("CLIENTE NÃO ENCONTRADO NOS BANCOS DE DADOS(OBS: PARA CADASTRAR VEÍCULOS EM CNPJ É ATRAVÉS DE FROTAS)");
                }
            }

            else if(valor == MenuOperacoes.CADASTRAFROTA.getOperacao()){ 
                System.out.println("DIGITE SEU CNPJ:");
                String cnpj = scan.nextLine();
                while(Validacao.validarCNPJ(cnpj) == false){
                    System.out.println("CNPJ INVÁLIDO,DIGITE SEU CNPJ NOVAMENTE:");
                    cnpj = scan.nextLine();
                }
                String senha;
                System.out.println("FAÇA UMA SENHA PARA SUA FROTA:");
                senha = scan.nextLine();
                Frota f = new Frota(senha);
                System.out.println("QUANTOS CARROS VOCÊ DESEJA CADASTRAR NESSA FROTA?:");
                int n_carros = Integer.parseInt(scan.nextLine());
                for (int k = 0 ; k < n_carros ; k++){
                    System.out.println("PLACA DO CARRO:");
                    String placa = scan.nextLine();
                    System.out.println("MARCA DO CARRO:");
                    String marca = scan.nextLine();
                    System.out.println("MODELO DO CARRO:");
                    String modelo = scan.nextLine();
                    System.out.println("ANO DO CARRO:");
                    int anofabricacao = Integer.parseInt(scan.nextLine());
                    Veiculo v = new Veiculo(placa,marca,modelo,anofabricacao);
                    f.addVeiculo(v);
                }
                Boolean achou = false;
                busca:
                for (int k = 0 ; k < s.size() ; k++){
                    for(Cliente cliente : s.get(k).getlistaClientes()) {
                        if(cliente instanceof ClientePF){
                            ClientePF clientePF = (ClientePF) cliente;
                            if (clientePF.getCPF().equals(cnpj)){
                                achou = false;
                                break busca;
                            }
                        }
                        else{
                            ClientePJ clientePJ = (ClientePJ) cliente;
                            if(clientePJ.getCNPJ().equals(cnpj)){
                                achou = true;
                                clientePJ.cadastrarFrota(f);
                                break busca;
                            }
                        }
                    }
                }
                if(achou == true){
                    System.out.println("FROTA REGISTRADO COM SUCESSO");
                }
                else{
                    System.out.println("CLIENTE NÃO ENCONTRADO NOS BANCOS DE DADOS(OBS: PARA CADASTRAR VEÍCULOS EM CPF É ATRAVÉS DE VEÍCULOS)");
                }
            }
            
            else if(valor == MenuOperacoes.VOLTARC.getOperacao()){
                continue;
            }
        }
    

            else if(valor == MenuOperacoes.LISTAR.getOperacao()){
                System.out.println("1 - LISTAR CLIENTE(PF/PJ) POR SEGURADORA");
                System.out.println("2 - LISTAR SEGUROS POR SEGURADORA");
                System.out.println("3 - LISTAR SINISTROS POR CLIENTE");
                System.out.println("4 - LISTAR VEÍCULO POR CLIENTE");
                System.out.println("5 - VOLTAR AO MENU PRINCIPPAL");
                valor = Integer.parseInt(scan.nextLine());
                if (valor == MenuOperacoes.listarPFPJporseguradora.getOperacao()){
                    System.out.println("CNPJ DA SEGURADORA:");
                    String cnpj = scan.nextLine();
                    while(Validacao.validarCNPJ(cnpj) == false){
                        System.out.println("CNPJ INVÁLIDO,DIGITE SEU CNPJ NOVAMENTE:");
                        cnpj = scan.nextLine();
                    }
                    System.out.println("DIGITE 1-PF OU 2-PJ:");
                    valor = Integer.parseInt(scan.nextLine());
                    if(valor == 1){
                        Boolean existe = Seguradora.listarClientesPFPJ(s, cnpj, valor);
                        if(existe == false){
                            System.out.println("ESSA SEGURADORA NÃO EXISTE NO NOSSO BANCO DE DADOS");
                        }
                    }
                    else{
                        Boolean existe = Seguradora.listarClientesPFPJ(s, cnpj, valor);
                        if(existe == false){
                            System.out.println("ESSA SEGURADORA NÃO EXISTE NO NOSSO BANCO DE DADOS");
                        }
                    }
                }

                else if(valor == MenuOperacoes.listarSINISTROseguradora.getOperacao()){
                    System.out.println("CNPJ DA SEGURADORA:");
                    String cnpj = scan.nextLine();
                    String existe = "";
                    while(Validacao.validarCNPJ(cnpj) == false){
                        System.out.println("CNPJ INVÁLIDO,DIGITE SEU CNPJ NOVAMENTE:");
                        cnpj = scan.nextLine();
                    }
                    for (int k = 0 ; k < s.size() ; k++){
                        if(s.get(k).getCNPJ().equals(cnpj)){
                            existe = s.get(k).listarSeguro();
                        }
                    }

                    if(existe == ""){
                        System.out.println("ESSA SEGURADORA NÃO EXISTE NO NOSSO BANCO DE DADOS");
                    }
                }

                else if(valor == MenuOperacoes.listarSEGUROcliente.getOperacao()){
                    System.out.println("SEU CPF/CNPJ:");
                    String cpf_cnpj = scan.nextLine();
                    Boolean existe = false;
                    while(Validacao.validarCNPJ(cpf_cnpj) == false && Validacao.validarCPF(cpf_cnpj) ){
                        System.out.println("CNPJ/CPF INVÁLIDO,DIGITE SEU CNPJ/CPF NOVAMENTE:");
                        cpf_cnpj = scan.nextLine();
                    }
                    System.out.println("CNPJ DA SEGURADORA:");
                    String cnpj = scan.nextLine();
                    while(Validacao.validarCNPJ(cnpj) == false){
                        System.out.println("CNPJ INVÁLIDO,DIGITE SEU CNPJ NOVAMENTE:");
                        cnpj = scan.nextLine();
                    }
                    for(int k = 0 ; k < s.size() ; k++){
                        if(s.get(k).getCNPJ().equals(cnpj)){
                            existe = Seguradora.getSeguroPorCliente(cpf_cnpj, s.get(k));
                        }
                    }
                    if(existe == false){
                        System.out.println("ESSE SEGURO NÃO EXISTE REGISTRADO DESSE CLIENTE");
                    }
                }

                else if(valor == MenuOperacoes.listarSINISTROcliente.getOperacao()){
                    System.out.println("SEU CPF/CNPJ:");
                    String cpf_cnpj = scan.nextLine();
                    Boolean existe = false;
                    while(Validacao.validarCNPJ(cpf_cnpj) == false && Validacao.validarCPF(cpf_cnpj) ){
                        System.out.println("CNPJ/CPF INVÁLIDO,DIGITE SEU CNPJ/CPF NOVAMENTE:");
                        cpf_cnpj = scan.nextLine();
                    }
                    System.out.println("CNPJ DA SEGURADORA:");
                    String cnpj = scan.nextLine();
                    while(Validacao.validarCNPJ(cnpj) == false){
                        System.out.println("CNPJ INVÁLIDO,DIGITE SEU CNPJ NOVAMENTE:");
                        cnpj = scan.nextLine();
                    }
                    for(int k = 0 ; k < s.size() ; k++){
                        if(s.get(k).getCNPJ().equals(cnpj)){
                            existe = Seguradora.getSinistroPorCliente(cpf_cnpj, s.get(k));
                        }
                    }  
                    if(existe == false){
                        System.out.println("ESSE CLIENTE NÃO HÁ VEÍCULOS");
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
                    System.out.println("SEU CPF/CNPJ:");
                    String cpf_cnpj = scan.nextLine();
                    Boolean existe = false;
                    while(Validacao.validarCNPJ(cpf_cnpj) == false && Validacao.validarCPF(cpf_cnpj) == false){
                        System.out.println("CNPJ/CPF INVÁLIDO,DIGITE SEU CNPJ/CPF NOVAMENTE:");
                        cpf_cnpj = scan.nextLine();
                    }
                    Boolean encontrou = Seguradora.removeCliente(s,cpf_cnpj);
                    if(encontrou == true){
                        System.out.println("CLIENTE REMOVIDO COM SUCESSO");
                    }
                    else{
                        System.out.println("ESSE CLIENTE NÃO EXISTE NO BANCO DE DADOS");
                    }
                }

                if(valor == MenuOperacoes.excluirVEICULO.getOperacao()){
                    Boolean encontrou = false;
                    System.out.println("CNPJ DA SEGURADORA:");
                    String cnpj = scan.nextLine();
                    while(Validacao.validarCNPJ(cnpj) == false){
                        System.out.println("CNPJ INVÁLIDO,DIGITE SEU CNPJ NOVAMENTE:");
                        cnpj = scan.nextLine();
                    }  
                    System.out.println("SEU CPF/CNPJ:");
                    String cpf_cnpj = scan.nextLine();
                    Boolean existe = false;
                    while(Validacao.validarCNPJ(cpf_cnpj) == false && Validacao.validarCPF(cpf_cnpj) == false){
                        System.out.println("CNPJ/CPF INVÁLIDO,DIGITE SEU CNPJ/CPF NOVAMENTE:");
                        cpf_cnpj = scan.nextLine();
                    }
                    System.out.println("PLACA DO CARRO/ID FROTA:");
                    nome = scan.nextLine();
                    for(int k = 0 ; k < s.size() ; k++){
                        if(s.get(k).getCNPJ().equals(cnpj)){
                            for(Cliente cliente : s.get(k).getlistaClientes()) {
                                if(cliente instanceof ClientePF){
                                    ClientePF clientePF = (ClientePF) cliente;
                                    if (clientePF.getCPF().equals(cpf_cnpj)){
                                        for(int j = 0 ; j < clientePF.getlistaVeiculos().size() ; j++){
                                            if(clientePF.getlistaVeiculos().get(j).getPlaca().equals(nome)){
                                                clientePF.getlistaVeiculos().remove(j);
                                                encontrou = true;
                                            }
                                        }
                                    }
                                }
                                else{
                                    ClientePJ clientePJ = (ClientePJ) cliente;
                                    if(clientePJ.getCNPJ().equals(cpf_cnpj)){
                                        for(int j = 0 ; j < clientePJ.getListaFrotas().size() ; j++){
                                            if(clientePJ.getListaFrotas().get(j).getCode().equals(nome)){
                                                clientePJ.getListaFrotas().remove(j);
                                                encontrou = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                     }
                    if(encontrou == true){
                        System.out.println("VEÍCULO REMOVIDO COM SUCESSO");
                    }
                    else{
                        System.out.println("ESSE VEÍCULO NÃO EXISTE NO BANCO DE DADOS");
                    }
                }

                if(valor == MenuOperacoes.excluirSINISTRO.getOperacao()){
                    System.out.println("ID DO SINISTRO:");
                    String id = scan.nextLine();
                    Boolean encontrou = Seguradora.removeSinistro(s, id);
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
                Seguradora s1 = null;
                Boolean c1 = false;
                Boolean v1 = false;
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
                System.out.println("DIGITE A CNPJ DA SEGURADORA:");
                String cnpj = scan.nextLine();
                while(Validacao.validarCNPJ(cnpj) == false){
                    System.out.println("CNPJ INVÁLIDO,DIGITE A CNPJ NOVAMENTE:");
                    cnpj = scan.nextLine();
                }  
                System.out.println("DIGITE O CPF/CNPJ DO CLIENTE:");
                String cpf_cnpj = scan.nextLine();
                while(Validacao.validarCNPJ(cpf_cnpj) == false && Validacao.validarCPF(cpf_cnpj) == false ){
                    System.out.println("CNPJ/CPF INVÁLIDO,DIGITE SEU CNPJ/CPF NOVAMENTE:");
                    cpf_cnpj = scan.nextLine();
                }
                System.out.println("DIGITE O NOME DA PLACA/CODIGO:");
                String placa = scan.nextLine();
                //busca 
                for(int k = 0; k < s.size() ; k++){
                    if(s.get(k).getCNPJ().equals(cnpj)){
                        s1 = s.get(k);
                        for(Cliente cliente : s.get(k).getlistaClientes()) {
                            if(cliente instanceof ClientePF){
                                ClientePF clientePF = (ClientePF) cliente;
                                if (clientePF.getCPF().equals(cpf_cnpj)){
                                    c1  = true;
                                    for(int j = 0 ; j < clientePF.getlistaVeiculos().size() ; j++){
                                        if(clientePF.getlistaVeiculos().get(j).getPlaca().equals(placa)){
                                            v1 = true;
                                        }
                                    }
                                }
                            }
                            else{
                                ClientePJ clientePJ = (ClientePJ) cliente;
                                if(clientePJ.getCNPJ().equals(cpf_cnpj)){
                                    c1 = true;
                                    for(int j = 0 ; j < clientePJ.getListaFrotas().size() ; j++){
                                        if(clientePJ.getListaFrotas().get(j).getCode().equals(placa)){
                                            v1 = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(s1.getNome() == null ){
                    System.out.println("SEGURADORA NÃO ENCOTRADO, FAVOR TENTAR NOVAMENTE");
                }
                else if(c1 == false){
                    System.out.println("CLIENTE NÃO ENCOTRADO, FAVOR TENTAR NOVAMENTE");
                }
                else if (v1 == false){
                    System.out.println("VEÍCULO NÃO ENCOTRADO, FAVOR TENTAR NOVAMENTE");
                }
                else{
                    Seguro.gerarSinistro(dataAcidente, local, null, null);
                    System.out.println("SINISTRO GERADO COM SUCESSO!");
                }

            }

            else if (valor == MenuOperacoes.GERARSEGURO.getOperacao()){
                //variaveis
                Calendar hoje = Calendar.getInstance();
                //gerando seguro
                System.out.println("DIGITE O CPF/CNPJ DO CLIENTE:");
                String cpf_cnpj = scan.nextLine();
                while(Validacao.validarCNPJ(cpf_cnpj) == false && Validacao.validarCPF(cpf_cnpj) == false ){
                    System.out.println("CNPJ/CPF INVÁLIDO,DIGITE SEU CNPJ/CPF NOVAMENTE:");
                    cpf_cnpj = scan.nextLine();
                }
                System.out.println("DIGITE A CNPJ DA SEGURADORA:");
                String cnpj = scan.nextLine();
                while(Validacao.validarCNPJ(cnpj) == false){
                    System.out.println("CNPJ INVÁLIDO,DIGITE A CNPJ NOVAMENTE:");
                    cnpj = scan.nextLine();
                }  
                System.out.println("DIGITE O ID/PLACA:");
                String placa_id = scan.nextLine();

                for(int k = 0; k < s.size() ; k++){
                    if(s.get(k).getCNPJ().equals(cnpj)){
                        for(Cliente cliente : s.get(k).getlistaClientes()) {
                            if(cliente instanceof ClientePF){
                                ClientePF clientePF = (ClientePF) cliente;
                                if (clientePF.getCPF().equals(cpf_cnpj)){
                                    for(int j = 0 ; j < clientePF.getlistaVeiculos().size() ; j++){
                                        if(clientePF.getlistaVeiculos().get(j).getPlaca().equals(placa_id)){
                                            Veiculo v1 = clientePF.getlistaVeiculos().get(j);
                                            Seguradora.gerarSeguroPF(hoje, null, s.get(k), valor, v1, clientePF);
                                            System.out.println("SEGURO GERADO COM SUCESSO");
                                        }
                                    }
                                }
                            }
                            else{
                                ClientePJ clientePJ = (ClientePJ) cliente;
                                if(clientePJ.getCNPJ().equals(cpf_cnpj)){
                                    for(int j = 0 ; j < clientePJ.getListaFrotas().size() ; j++){
                                        if(clientePJ.getListaFrotas().get(j).getCode().equals(placa_id)){
                                            Frota f1 = clientePJ.getListaFrotas().get(j);
                                            Seguradora.gerarSeguroPJ(hoje, null, s.get(k), valor, f1, clientePJ);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            
            else if (valor == MenuOperacoes.CALCULARRECEITASEGURADORA.getOperacao()){
                System.out.println("QUAL É A CNPJ DA SEGURADORA VOCÊ QUER SABER A RECEITA?:");
                String cnpj = scan.nextLine();
                while(Validacao.validarCNPJ(cnpj) == false){
                    System.out.println("CNPJ INVÁLIDO,DIGITE A CNPJ NOVAMENTE:");
                    cnpj = scan.nextLine();
                }  
                System.out.println("A RECEITA DA SEGURADORA É : " + Seguradora.calcularReceita(cnpj, s));
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
        ArrayList <Seguradora> lista = new ArrayList<>();
        //datas
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(2000, Calendar.AUGUST, 25);
        Calendar dataFundacao = Calendar.getInstance();
        dataFundacao.set(2005, Calendar.JANUARY, 1); 
        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(2023, Calendar.JANUARY, 1); 
        Calendar dataFim = Calendar.getInstance();
        dataFim.set(2024, Calendar.JANUARY, 1);
        Calendar dataSinistro = Calendar.getInstance();
        dataSinistro.set(2023, Calendar.JANUARY, 15);
        //instanciando
        Seguradora s1 = new Seguradora("Daniel seguros","90.901.597/0001-38", "1291931031", "alkeqow1@sla", "rua eintein");
        Seguradora s2 = new Seguradora("Porto Seguro", "51.012.942/0001-20", "291031381", "siqheqie@sqokeq", "rua mario natividade");
        ClientePF cf = new ClientePF("Ana Oliveira", "ana@email.com","123456789", "Feminino", "Rua D, 1011", "Ensino Médio", "46417742857", dataNascimento);
        ClientePJ cp = new ClientePJ("Empresa ABC", "Avenida X, 123", "empresa@abc.com", "987654321", "90.901.597/0001-38", dataFundacao, 100);
        Condutor c = new Condutor("João Silva", "joao@email.com","123456789", "Rua A, 123", "472.031.490-21", dataNascimento);
        Veiculo v1 = new Veiculo("ABC1234", "Fiat", "Uno", 2020);
        Veiculo v2 = new Veiculo("DEF5678", "Volkswagen", "Gol", 2018);
        Veiculo v3 = new Veiculo("GHI9012", "Ford", "Focus", 2019);
        SeguroPF seguropf = new SeguroPF(dataFim, dataInicio, s1, 500,v1,cf);
        SeguroPJ seguroPJ = new SeguroPJ(dataFim, dataInicio, s2, 1000, null, cp);
        Sinistro sinistro1 = new Sinistro(dataSinistro, "Rua A, 123", seguropf, c);
        Sinistro sinistro2 = new Sinistro(dataSinistro, "Rua B, 456", seguropf, c);
        Sinistro sinistro3 = new Sinistro(dataSinistro, "Rua C, 789", seguropf, c);
        Frota f = new Frota("woqwnqeq");
        SeguroPJ seguropj = new SeguroPJ(dataFim, dataInicio, s2, 0, f, cp);
        //adicionando itens
        lista.add(s2);
        lista.add(s1);
        f.addVeiculo(v1);
        f.addVeiculo(v3);
        s1.getlistaClientes().add(0, cp);
        s1.getlistaClientes().add(0, cf);
        s2.getlistaClientes().add(0, cp);
        s2.getlistaClientes().add(0, cf);
        s1.getListaseguro().add(0, seguroPJ);
        s2.getListaseguro().add(0, seguropf);
        cf.getlistaVeiculos().add(0, v3);
        cf.getlistaVeiculos().add(v2);
        cp.getListaFrotas().add(f);
        c.getlistaSinistros().add(0, sinistro3);
        c.getlistaSinistros().add(sinistro1);
        seguropf.getListaCondutor().add(0, c);
        seguroPJ.getListaCondutor().add(0, c);
        seguroPJ.getListaSinistro().add(0, sinistro3);
        seguropf.getListaSinistro().add(sinistro2);
        //chamando os toostrings
        System.out.println(s1.toString());
        System.out.println(c.toString());
        System.out.println(cp.toString());
        System.out.println(cf.toString());
        System.out.println(v2.toString());
        System.out.println(sinistro2.toString());
        System.out.println(seguropf.toString());
        System.out.println(seguropj.toString());
        System.out.println(f.toString());
        //chamando os metodos seguradora
        System.out.println(s1.listarCliente());
        SeguroPF seguropf2 = Seguradora.gerarSeguroPF(dataFim, dataInicio, s1, 0, v3, cf);
        SeguroPJ seguropj2  = Seguradora.gerarSeguroPJ(dataFim, dataInicio, s2, 0, f, cp);
        System.out.println(Seguradora.cadastrarCliente(cf, lista,"90901597000138"));
        System.out.println(Seguradora.cadastrarCliente(cp, lista,"90901597000138"));
        System.out.println(Seguradora.cancelarSeguro(102981313, s2));
        System.out.println(Seguradora.getSeguroPorCliente("472.031.490-21", s1));
        System.out.println(Seguradora.getSinistroPorCliente("472.031.490-21", s1));
        Seguradora.removeCliente(lista, "472.031.490-21");
        System.out.println(Seguradora.calcularReceita("90901597000138", lista));
        //metodos frota
        f.addVeiculo(v3);
        f.addVeiculo(v2);
        f.removeVeiculo(v3);
        //chamando metodos cliente
        cf.cadastrarVeiculo(v3);
        cf.removerVeiculo(v3);
        cp.cadastrarFrota(f);
        cp.getVeiculosporFrota("ABC1234");
        cp.atualizarFrota(f);
        //chamando metodos seguro
        seguropf.autorizarCondutor(c);
        seguropf.desautorizarCondutor(c);
        seguropf2.autorizarCondutor(c);
        seguropj2.autorizarCondutor(c);
        seguropf.calcularValor();
        seguroPJ.calcularValor();
        Sinistro sinistro4 = Seguro.gerarSinistro(dataSinistro, "akskoqw", seguropf, c);
        //condutor
        c.adicionarSinistro(sinistro1);
        c.adicionarSinistro(sinistro2);
        c.adicionarSinistro(sinistro3);
        c.adicionarSinistro(sinistro4);
        //coletando dados
        coletardados(lista);
        }
}
