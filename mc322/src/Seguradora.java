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
        this.listaClientes = listaClientes;
        this.listaSinistros = listaSinistros;
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
    public static boolean cadastrarCliente(Cliente cliente , ArrayList<Cliente> lista){
        //verificando se o cliente já não foi cadastrado
        for (int k = 0 ; k < lista.size() ; k++){
            if (lista.get(k) == cliente)
                return false;
        }
         //todos os dados estão inseridos
         if (cliente.getNome() != null || cliente.getlistaVeiculos() != null || cliente.getEndereco() != null ){
            lista.add(cliente);
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean removeCliente(String cliente , ArrayList<Cliente> lista){
        for(int k = 0 ; k < lista.size() ; k++){
            if(lista.get(k).getNome() == cliente){
                lista.remove(k);
                return true;
            }
        }
        return false;
    }

    public static boolean gerarSinistro(String data , String endereco , Seguradora seguradora , Veiculo veiculo, Cliente cliente){
        if(data == null || endereco == null )
            return false;
        else{
            Sinistro s = new Sinistro(data, endereco, seguradora, veiculo, cliente);
            seguradora.getlistaSinistros().add(s);
            return true;
        }
    }

    public static boolean visualizarSinistro(String cliente , Seguradora s){
        for (int k = 0 ; k < s.getlistaSinistros().size() ; k++){
            if (s.getlistaSinistros().get(k).getCliente().getNome() == cliente){
                System.out.println(s.getlistaSinistros().get(k));
                return true;
            }
        }
        return false;
    }

    public static boolean listarClientes(Seguradora s){
        if(s.getlistaClientes() == null){
            return false;
        }
        for(int k = 0 ; k < s.getlistaClientes().size() ; k++){
            System.out.println(s.getlistaClientes().get(k).getNome());
        }
        return true;
    }

    public static boolean listarSinistro(Seguradora s){
        if(s.getlistaSinistros() == null){
            return false;
        }
        for(int k = 0 ; k < s.getlistaSinistros().size() ; k++){
            System.out.println(s.getlistaSinistros().get(k).getId());
        }
        return true;
    }


}


