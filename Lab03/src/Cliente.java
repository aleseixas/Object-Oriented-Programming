import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    //construtor 
    public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos){
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
    }

    public Cliente(String string, String string2, int i, String string3, String string4) {
    }

    //getters e setters
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }


    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }



    public ArrayList<Veiculo> getlistaVeiculos(){
        return listaVeiculos;
    }

    public void setlistaVeiculos(ArrayList<Veiculo> listaVeiculos){
        this.listaVeiculos = listaVeiculos;
    }
    
    //funções 
    @Override
    public String toString(){
        //String nome, String educacao, Date dataLicenca, String genero, String endereco, String classeEconomica,List<Veiculo> listaVeiculos
        String valor = "\nNOME:" + nome +  "\nENDEREÇO:" + endereco + "\nLISTA VEÍCULOS:" + listaVeiculos;
        return valor;
    }

    public Object getCpf() {
        return null;
    }

}