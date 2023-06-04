import java.util.Calendar;
import java.util.ArrayList;

public class Condutor{
    private final String  cpf;
    private String nome;
    private Calendar dataNascimento ;
    private String email;
    private String telefone;
    private String endereco;
    private ArrayList<Sinistro> listasinistro;

    public Condutor(String nome, String email, String telefone, String endereco,String cpf , Calendar dataNascimento){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        listasinistro = new ArrayList<>();;
        this.cpf = cpf ;
        this.dataNascimento = dataNascimento;    
    }

    public String getCPF(){
        return cpf;
    }

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



    public ArrayList<Sinistro> getlistaSinistros(){
        return listasinistro;
    }

    public void setlistaSinistros(ArrayList<Sinistro> listasinistro){
        this.listasinistro = listasinistro;
    }
    
    public Calendar getdataNascimento(){
        return dataNascimento;
    }

    public void setdataNascimento(Calendar dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getdataTelefone(){
        return telefone;
    }

    public void setdataTelefone(String telefone){
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        String valor = "\nNOME:" + nome +  "\nCPF:" + cpf + "\nDATA NASCIMENTO:" + dataNascimento+"\nEMAIL:"+ email + "\nTELEFONE:" + telefone + "\nENDEREÇO:" + endereco + "LISTA SINISTROS:" + listasinistro.toString();
        return valor;
    }

    public void adicionarSinistro(Sinistro a){
        listasinistro.add(a);
    
    }

    public int qntsinistro(){
        return listasinistro.size();
    }

    public void listarSinistro(){
        for(Sinistro s: listasinistro){
            System.out.println(s);
        }
    }
    
}