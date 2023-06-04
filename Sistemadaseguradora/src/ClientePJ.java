import java.util.ArrayList;
import java.util.Calendar;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Calendar dataFundacao;
    private ArrayList<Frota> listafrota;
    private int qtdeFuncionarios;
    public ClientePJ(String nome, String endereco,String email,String telefone, String cnpj , Calendar dataFundacao,int qtdeFuncionarios){
        super(nome,endereco,email,telefone);
        this.dataFundacao = dataFundacao;
        this.cnpj = cnpj;
        listafrota = new ArrayList<>();;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    
    //gets e sets
    public String getCNPJ(){
        return cnpj;
    }

    public Calendar getdataFundacao(){
        return dataFundacao;
    }

    public void setdataFundacao(Calendar dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    public void setListaFrota(ArrayList<Frota> listafrota){
        this.listafrota = listafrota;
    }

    public ArrayList<Frota> getListaFrotas(){
        return listafrota;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //funções
    @Override
    public String toString(){
        String valor = super.toString() + "\nCNPJ:"+ cnpj +"\nDATA FUNDAÇÃO:"+ dataFundacao + "LISTA FROTA:" + listafrota.toString();
        return valor;
    }

    public boolean cadastrarFrota(Frota f){
        listafrota.add(f);
        return true;
    }

    public boolean atualizarFrota(Frota f){
        listafrota.remove(f);
        return true;
    }

    public boolean getVeiculosporFrota(String placa){
        for(Frota f : listafrota){
            for(Veiculo v : f.getListaVeiculos()){
                if(v.getPlaca() == placa){
                    System.out.println(v);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean listarFrota(){
        boolean entrou = false;
        for(Frota frota : listafrota){
            System.out.println(frota);
            entrou = true;
        }
        return entrou;
    }


}
