import java.util.Random;

public class Sinistro {
    private int id;
    private String data;
    private String endereco;

    public int randomId(){
        Random random = new Random();
        int numero = random.nextInt(10000000);
        return numero;
    }

    public Sinistro(String data, String endereco){
        this.id = randomId();
        this.endereco = endereco;
        this.data = data;
    }

    //set e get
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }
}
