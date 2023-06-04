import java.util.Random;
import java.util.Calendar;

public class Sinistro {
    private final int id;
    private Calendar data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;

    public int randomId(){
        Random random = new Random();
        int numero = random.nextInt(10000000);
        return numero;
    }

    public Sinistro(Calendar data, String endereco , Seguro seguro , Condutor condutor){
        this.id = randomId();
        this.endereco = endereco;
        this.data = data;
        this.condutor = condutor;
        this.seguro = seguro;
    }

    //set e get
    public int getId(){
        return id;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Seguro getSeguro(){
        return seguro;
    }

    public void setSeguro(Seguro seguro){
        this.seguro = seguro;
    }

    public Condutor getCondutor(){
        return condutor;
    }

    public void setCondutor(Condutor condutor){
        this.condutor = condutor;
    }


    public void setData(Calendar data){
        this.data = data;
    }

    public Calendar getData(){
        return data;
    }

    //funções
    @Override
    public String toString(){
        String valor = "\nID:" + id +  "\nENDEREÇO:" + endereco + "\nDATA:" + data +"\nCONDUTOR:"+ condutor.getNome() + "\nSEGURO:" + seguro.getID();
        return valor;
    }
    
}
