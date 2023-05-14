    import java.util.ArrayList;
import java.util.Calendar;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Calendar dataFundacao;
    private int qtdeFuncionarios;
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cnpj , Calendar dataFundacao,int qtdeFuncionarios){
        super(nome,endereco,listaVeiculos);
        this.dataFundacao = dataFundacao;
        this.cnpj = cnpj;
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

    //funções
    @Override
    public String toString(){
        String valor = "\nNOME:" + getNome() +  "\nENDEREÇO:" + getEndereco() + "\nLISTA VEÍCULOS:" + getlistaVeiculos() +"\nCNPJ:"+ cnpj +"\nDATA FUNDAÇÃO:"+ dataFundacao;
        return valor;
    }

    public double calculaScore(){
        return CalcSeguro.VALOR_BASE.getFator() * (1 + (qtdeFuncionarios)/100 ) * getlistaVeiculos().size();
    }
    
}
