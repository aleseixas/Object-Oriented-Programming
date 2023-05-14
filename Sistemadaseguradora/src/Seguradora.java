import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList <Sinistro> listaSinistros;
    private ArrayList <Cliente> listaClientes; 
    //construtor 
    public Seguradora(String nome, String telefone, String email, String endereco,ArrayList <Sinistro> listaSinistros,ArrayList <Cliente> listaClientes){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = new ArrayList<>();
        this.listaSinistros = new ArrayList<>();
    }

    //getters e setters
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }


    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public ArrayList <Sinistro> getlistaSinistros(){
        return listaSinistros;
    }

    public void setlistaSinistro(ArrayList <Sinistro> listaSinistros){
        this.listaSinistros = listaSinistros;
    }

    public ArrayList <Cliente> getlistaClientes(){
        return listaClientes;
    }

    public void setlistaCliente(ArrayList <Cliente> listaClientes){
        this.listaClientes = listaClientes;
    }

    //funções 
    public static Seguradora cadastrarCliente(Cliente cliente , ArrayList<Seguradora> s , String seguradora){
        for (int k = 0 ; k < s.size(); k++){
            if(s.get(k).getNome().equals(seguradora)){
                s.get(k).getlistaClientes().add(cliente);
                return s.get(k);
            }
        }
        Seguradora nenhuma = new Seguradora(null, null, null, null, null, null);
        return nenhuma;
    }

    public static boolean removeCliente(ArrayList <Seguradora> s ,String nomeCliente){
        for(int k = 0 ; k < s.size() ; k++ ){
            for(int j = 0 ; j < s.get(k).getlistaClientes().size(); j++){
                if(nomeCliente.equals(s.get(k).getlistaSinistros().get(j).getCliente().getNome())){
                    s.get(k).getlistaClientes().remove(j);
                    return true;
                }
            }
        }
        return false;
        
    }

    public static boolean removeVeiculo(ArrayList <Seguradora> s ,String placaVeiculo){
        for(int k = 0 ; k < s.size() ; k++ ){
            for(int j = 0 ; j < s.get(k).getlistaClientes().size(); j++){
                for(int f = 0 ; f < s.get(k).getlistaClientes().get(j).getlistaVeiculos().size() ; f++){
                    if(placaVeiculo.equals(s.get(k).getlistaClientes().get(j).getlistaVeiculos().get(f).getPlaca())){
                        s.get(k).getlistaClientes().get(j).getlistaVeiculos().remove(f);
                        return true;
                    }
                }
            }
        }
        return false;
        
    }

    public static boolean removeSinistro(ArrayList <Seguradora> s ,String id){
        int num = Integer.parseInt(id);
        for(int k = 0 ; k < s.size() ; k++ ){
            for(int j = 0 ; j < s.get(k).getlistaSinistros().size(); j++){
               if(s.get(k).getlistaSinistros().get(j).getId() == num){
                    s.get(k).getlistaSinistros().remove(j);
                    return true;
               }
            }
        }
        return false;
        
    }

    public static boolean gerarSinistro(String data , String endereco , Seguradora seguradora , Veiculo caroo, Cliente cliente){
        Sinistro sinistro = new Sinistro(data, endereco, seguradora, caroo, cliente);
        seguradora.getlistaSinistros().add(sinistro);
        return true;
    }

    public static boolean visualizarSinistro(String cliente , Seguradora s){
        for (int k = 0 ; k < s.getlistaSinistros().size() ; k++){
            if (s.getlistaSinistros().get(k).getCliente().getNome().equals(cliente)){
                System.out.println(s.getlistaSinistros().get(k));
                return true;
            }
        }
        return false;
    }

    public static boolean listarClientesPFPJ(ArrayList<Seguradora> s,String nome ,int tipocliente){
        for(int k = 0 ; k < s.size() ; k++){
            if (s.get(k).getNome().equals(nome)){
                for(int j = 0 ; j < s.get(k).getlistaClientes().size() ; j++ ){
                    if(tipocliente == 1 && s.get(k).getlistaClientes().get(j) instanceof ClientePF){
                        System.out.println(s.get(k).getlistaClientes().get(j));
                    }
                    else if (tipocliente == 2 && s.get(k).getlistaClientes().get(j) instanceof ClientePJ){
                        System.out.println(s.get(k).getlistaClientes().get(j));
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean listarSinistrosSeguradora(ArrayList<Seguradora> s , String nome){
        for(int k = 0 ; k < s.size() ; k++ ){
            if(s.get(k).getNome().equals(nome)){
                for(int j = 0 ; j < s.get(k).getlistaSinistros().size(); j++){
                    System.out.println(s.get(k).getlistaSinistros().get(j));
                }
                return true;
            }
        }
        return false;
    }

    public static boolean listarSinistrosCliente(ArrayList<Seguradora> s , String nomeCliente){
        for(int k = 0 ; k < s.size() ; k++ ){
            for(int j = 0 ; j < s.get(k).getlistaSinistros().size(); j++){
                if(s.get(k).getlistaSinistros().get(j).getCliente().getNome().equals(nomeCliente)){
                    System.out.println(s.get(k).getlistaSinistros().get(j));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean listarVeiculoCliente(ArrayList<Seguradora> s , String nomeCliente){
        for(int k = 0 ; k < s.size() ; k++ ){
            for(int j = 0 ; j < s.get(k).getlistaSinistros().size(); j++){
                if(s.get(k).getlistaSinistros().get(j).getCliente().getNome().equals(nomeCliente)){
                    System.out.println(s.get(k).getlistaClientes().get(j).getlistaVeiculos());
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean listarVeiculoSeguradora(ArrayList<Seguradora> s , String nomeSeguradora){
        for(int k = 0 ; k < s.size() ; k++ ){
            if(s.get(k).getNome().equals(nomeSeguradora)){
                for(int j = 0 ; j < s.get(k).getlistaClientes().size(); j++){
                    System.out.println(s.get(k).getlistaClientes().get(j).getlistaVeiculos());
                }
                return true;
            }
        }
        return false;
    }

    
    public void calcularPrecoSeguroCliente(Cliente c){  
        double valor = c.calculaScore() * (1 + listaSinistros.size());
        c.setValorSeguro(valor);
    }

    public static double calcularReceita(String seguradora, ArrayList<Seguradora> s) {
        double soma = 0;
        for (int j = 0 ; j < s.size() ; j++){
            if (s.get(j).getNome().equals(seguradora)){
                for (int k = 0 ; k < s.get(j).getlistaClientes().size() ; k++){
                    soma += s.get(j).getlistaClientes().get(k).getValorSeguro();
                }
            }
        }
        return soma;
    }

    public static void Tranferirseguro(String seguradora ,String cliente1 , String cliente2 , ArrayList<Seguradora> s){
        ArrayList<Veiculo> carrostransferidos = new ArrayList<>();
        Cliente a = new Cliente(null, null, null);
        Cliente b = new Cliente(null, null, null);
        Seguradora seguradora1 = new Seguradora(null, null, null, null, null, null);
        for(int k = 0 ; k < s.size() ; k++){
            if(s.get(k).getNome().equals(seguradora)){
                seguradora1 = s.get(k);
                for(int j = 0 ; j < s.get(k).getlistaClientes().size() ; j++){
                    if(s.get(k).getlistaClientes().get(j).getNome().equals(cliente1)){
                        b = s.get(k).getlistaClientes().get(j);
                        carrostransferidos.addAll(s.get(k).getlistaClientes().get(j).getlistaVeiculos());
                        s.get(k).getlistaClientes().get(j).getlistaVeiculos().clear();
                    }
                }
            }
        }
        for(int k = 0 ; k < s.size() ; k++){
            if(s.get(k).getNome().equals(seguradora)){
                for(int j = 0 ; j < s.get(k).getlistaClientes().size() ; j++){
                    if(s.get(k).getlistaClientes().get(j).getNome().equals(cliente2)){
                        a = s.get(k).getlistaClientes().get(j);
                    }
                }
            }
        }

        for(int f = 0 ; f < carrostransferidos.size() ; f++){
            a.getlistaVeiculos().add(carrostransferidos.get(f));
        }

        //alterando os valores
        seguradora1.calcularPrecoSeguroCliente(a);
        seguradora1.calcularPrecoSeguroCliente(b);

    }

}


