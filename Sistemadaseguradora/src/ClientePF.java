import java.util.Calendar;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private final String  cpf ;
    private String genero;
    private Calendar dataNascimento ;
    private String educacao;
    private Calendar dataLicenca;
    private String classeEconomica;

    public ClientePF(String nome, String educacao, Calendar dataLicenca, String genero, String endereco, String classeEconomica,ArrayList<Veiculo> listaVeiculos ,String cpf , Calendar dataNascimento){
        super(nome,endereco,listaVeiculos);
        this.educacao = educacao;
        this.dataLicenca = dataLicenca;
        this.classeEconomica = classeEconomica;
        this.genero = genero;
        this.cpf = cpf ;
        this.dataNascimento = dataNascimento;    
    }

    //gets e sets
    public Calendar getdataLicenca(){
        return dataLicenca;
    }

    public void setdataLicenca(Calendar dataLicenca){
        this.dataLicenca = dataLicenca;
    }

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

    public String getclasseEconomica(){
        return classeEconomica;
    }

    public void setclasseEconomica(String classeEconomica){
        this.classeEconomica = classeEconomica;
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
        String valor = "\nNOME:" + getNome() +  "\nENDEREÇO:" + getEndereco() + "\nEDUCAÇÃO:" + educacao + "\nDATA LICENÇA:" + dataLicenca + "\nGÊNERO:" + genero + "\nCLASSE ECONOMICA:" + classeEconomica + "\nLISTA VEÍCULOS:" + getlistaVeiculos() + "\nCPF:"+ cpf +"\nDATA NASCIMENTO"+ dataNascimento;
        return valor;
    }

    public double calculaScore(){
        Calendar hoje = Calendar.getInstance();      
        long diferenca = hoje.getTimeInMillis() - dataNascimento.getTimeInMillis();
        //convertendo os milissegundos em anos, OBS:365.25 ocorre pensando nos anos bissextos
        int idade = (int) (diferenca/1000 *  36000 * 24 * 365.25);
        //as condições da idade visam no maior valor
        if ( idade <= 30 && idade >= 18 ){
            return CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_18_30.getFator() * getlistaVeiculos().size();
        }
        else if ( idade > 30 && idade < 60 ){
            return CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_30_60.getFator() * getlistaVeiculos().size();
        }
        else if ( idade >= 60 ){
            return CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_60_90.getFator() * getlistaVeiculos().size();
        }
        //menores de 18 retorna 0 , já que não podem ter seguro
        return 0;

    }

}
