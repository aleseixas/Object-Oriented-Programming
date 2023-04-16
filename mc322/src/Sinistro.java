import java.util.Random;

public class Sinistro {
    private final int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    public int randomId(){
        Random random = new Random();
        int numero = random.nextInt(10000000);
        return numero;
    }

    public Sinistro(String data, String endereco , Seguradora seguradora , Veiculo veiculo, Cliente cliente){
        this.id = randomId();
        this.endereco = endereco;
        this.data = data;
        this.seguradora = seguradora;
        this.cliente = cliente;
        this.veiculo = veiculo;
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

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Seguradora getSeguradora(){
        return seguradora;
    }

    public void setSeguradorqa(Seguradora seguradora){
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }


    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }

    //funções
    @Override
    public String toString(){
        String valor = "\nID:" + id +  "\nENDEREÇO:" + endereco + "\nDATA:" + data +"\nCLIENTE:"+ cliente + "\nSEGURADORA:" + seguradora + "\nVEICULO:" + veiculo;
        return valor;
    }
}
