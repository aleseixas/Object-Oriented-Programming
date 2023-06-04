import java.util.Calendar;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private final String  cpf ;
    private String genero;
    private Calendar dataNascimento ;
    private String educacao;
    private ArrayList<Veiculo> listaVeiculos;

    public ClientePF(String nome, String email,String telefone, String genero, String endereco, String educacao,String cpf , Calendar dataNascimento){
        super(nome,endereco,telefone,email);
        this.educacao = educacao;
        this.genero = genero;
        this.cpf = cpf ;
        this.dataNascimento = dataNascimento;    
        listaVeiculos = new ArrayList<>();;
    }

    //gets e sets
    public String getEducacao(){
        return educacao;
    }

    public void setEducaocao(String educacao){
        this.educacao = educacao;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public ArrayList<Veiculo> getlistaVeiculos(){
        return listaVeiculos;
    }

    public void setlistaVeiculos(ArrayList<Veiculo> listaVeiculos){
        this.listaVeiculos = listaVeiculos;
    }

    public String getCPF(){
        return cpf;
    }

    public Calendar getdataNascimento(){
        return dataNascimento;
    }

    public void setdataNascimento(Calendar dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    //funções
    @Override
    public String toString(){
        String valor = super.toString() + "\nEDUCAÇÃO:" + educacao + "\nGÊNERO:" + genero + "\nLISTA VEÍCULOS:" + listaVeiculos.toString() + "\nCPF:"+ cpf +"\nDATA NASCIMENTO"+ dataNascimento;
        return valor;
    }

    public boolean cadastrarVeiculo(Veiculo v){
        listaVeiculos.add(v);
        return true;
    }

    public boolean removerVeiculo(Veiculo v){
        listaVeiculos.remove(v);
        return true;
    }
    
    public boolean listarCarro(){
        boolean entrou = false;
        for(Veiculo carro : listaVeiculos){
            System.out.println(carro);
            entrou = true;
        }
        return entrou;
    }


}
