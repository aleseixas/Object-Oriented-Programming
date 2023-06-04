import java.util.ArrayList;
import java.util.Calendar;

public class Seguradora {
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList <Seguro> listaSeguros;
    private ArrayList <Cliente> listaClientes; 
    //construtor 
    public Seguradora(String nome,String cnpj, String telefone, String email, String endereco){
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        listaClientes = new ArrayList<>();
        listaSeguros = new ArrayList<>();
    }

    //getters e setters
    public ArrayList<Seguro> getListaseguro(){
        return listaSeguros;
    }

    public void setListaseguro(ArrayList<Seguro> listaSeguros){
        this.listaSeguros = listaSeguros;
    }

    public String getCNPJ(){
        return cnpj;
    }

    public void setCNPJ(String cnpj){
        this.cnpj = cnpj;
    }

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

    public ArrayList <Cliente> getlistaClientes(){
        return listaClientes;
    }

    public void setlistaCliente(ArrayList <Cliente> listaClientes){
        this.listaClientes = listaClientes;
    }

    //funções 
    public static Seguradora cadastrarCliente(Cliente cliente , ArrayList<Seguradora> s , String cnpj){
        for (int k = 0 ; k < s.size(); k++){
            if(s.get(k).getNome().equals(cnpj)){
                s.get(k).getlistaClientes().add(cliente);
                return s.get(k);
            }
        }
        Seguradora nenhuma = null;
        return nenhuma;
    }

    public static boolean removeCliente(ArrayList <Seguradora> s ,String cpfj){
        for(int k = 0 ; k < s.size() ; k++){
            for(Seguro seguro : s.get(k).getListaseguro()) {
                if(seguro instanceof SeguroPF){
                    SeguroPF seguroPF = (SeguroPF) seguro;
                    if (seguroPF.getCliente().getCPF().equals(cpfj)){
                        s.get(k).getlistaClientes().remove(seguroPF.getCliente());
                        return true;
                    }
                }
                else{
                    SeguroPJ seguroPJ = (SeguroPJ) seguro;
                    if(seguroPJ.getCliente().getCNPJ().equals(cpfj)){
                        s.get(k).getlistaClientes().remove(seguroPJ.getCliente());
                        return true;
                    }
                }
            }
        }
        return false;
        
    }

    public static SeguroPF gerarSeguroPF(Calendar dataFim, Calendar dataInicio, Seguradora seguradora, int valorMensal, Veiculo veiculo, ClientePF cliente){
       SeguroPF seguro = new SeguroPF(dataFim, dataInicio, seguradora, valorMensal, veiculo, cliente);
        seguradora.getListaseguro().add(seguro);;
        return seguro;
    }

    public static SeguroPJ gerarSeguroPJ(Calendar dataFim, Calendar dataInicio, Seguradora seguradora, int valorMensal, Frota frota, ClientePJ cliente){
        SeguroPJ seguro = new SeguroPJ(dataFim, dataInicio, seguradora, valorMensal, frota, cliente);
        seguradora.getListaseguro().add(seguro);;
        return seguro;
    }

    public static boolean cancelarSeguro(int id,Seguradora seguradora){
        //busca através de id
        for (int k = 0 ; k < seguradora.getListaseguro().size() ; k++){
            if(seguradora.getListaseguro().get(k).getID() == id){
                seguradora.getListaseguro().remove(k);
                return true;
            }
        }
        return false;

    }

    public static boolean removeSinistro(ArrayList <Seguradora> s ,String id){
        int num = Integer.parseInt(id);
        for(int k = 0 ; k < s.size() ; k++ ){
            for(int j = 0 ; j < s.get(k).getListaseguro().size(); j++){
               if(s.get(k).getListaseguro().get(j).getID() == num){
                    s.get(k).getListaseguro().remove(j);
                    return true;
               }
            }
        }
        return false;
        
    }

    public static boolean getSinistroPorCliente(String cpfj , Seguradora s){
        for(Seguro seguro : s.getListaseguro()) {
            if(seguro instanceof SeguroPF){
                SeguroPF seguroPF = (SeguroPF) seguro;
                if (seguroPF.getCliente().getCPF().equals(cpfj)){
                    System.out.println(seguroPF.getListaSinistro());
                    return true;
                }
            }
            else{
                SeguroPJ seguroPJ = (SeguroPJ) seguro;
                if(seguroPJ.getCliente().getCNPJ().equals(cpfj)){
                    System.out.println(seguroPJ.getListaSinistro());
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getSeguroPorCliente(String cpfj , Seguradora s){
        for(Seguro seguro : s.getListaseguro()) {
            if(seguro instanceof SeguroPF){
                SeguroPF seguroPF = (SeguroPF) seguro;
                if (seguroPF.getCliente().getCPF().equals(cpfj)){
                    System.out.println(seguroPF);
                    return true;
                }
            }
            else{
                SeguroPJ seguroPJ = (SeguroPJ) seguro;
                if(seguroPJ.getCliente().getCNPJ().equals(cpfj)){
                    System.out.println(seguroPJ);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean listarClientesPFPJ(ArrayList<Seguradora> s,String cnpj ,int tipocliente){
        for(int k = 0 ; k < s.size() ; k++){
            if (s.get(k).getCNPJ().equals(cnpj)){
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

    public static boolean listarSegurosSeguradora(ArrayList<Seguradora> s , String cnpj){
        for(int k = 0 ; k < s.size() ; k++ ){
            if(s.get(k).getCNPJ().equals(cnpj)){
                for(int j = 0 ; j < s.get(k).getListaseguro().size(); j++){
                    System.out.println(s.get(k).getListaseguro().get(j));
                }
                return true;
            }
        }
        return false;
    }


    public static double calcularReceita(String cnpj, ArrayList<Seguradora> s) {
        double soma = 0;
        for (int j = 0 ; j < s.size() ; j++){
            if (s.get(j).getCNPJ().equals(cnpj)){
                for (Seguro seguro : s.get(j).getListaseguro()){
                    soma += seguro.getValorMensal();
                }
            }
        }
        return soma;
    }

   
    public String listarCliente(){
        String s = "";
        for (int k = 0 ; k < listaClientes.size() ; k++){
            s += listaClientes.get(k).getNome() + "\n";
        }
        return s;
    }

    public String listarSeguro(){
        String s = "";
        for (int k = 0 ; k < listaSeguros.size() ; k++){
            s += listaSeguros.get(k).getID() + "\n";
        }
        return s;
    }


    @Override
    public String toString() {
        String valor = "Nome: " + nome +  "\nCNPJ: " + cnpj + "\nTelefone: " + telefone + "\nEmail: " + email + "\nEndereco: " + endereco +"\nLista de Seguros: " + listarSeguro() +"\nLista de Clientes: " + listarCliente() ;
        return valor;
    }


}


