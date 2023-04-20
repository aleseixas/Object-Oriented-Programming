import java.util.Calendar;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private final String  cpf ;
    private String genero;
    private Calendar dataNascimento ;
    private String educacao;
    private Calendar dataLicenca;
    private String classeEconomica;

    public ClientePF(String nome, String educacao, Calendar dataLicenca, String genero, String endereco, String classeEconomica,ArrayList<Veiculo> listaVeiculos , String cpf , Calendar dataNascimento){
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

    public static boolean validarCPF(String cpf){
        //variáveis
        int contador = 0, resto_divisao = 0 , digito_1 = 0 , digito_2 = 0;
        //retirando letras e deixando só números
        cpf = cpf.replaceAll("[^0-9]", "");
        //verificando o tamanho
        if (cpf.length() < 11)
            return false;
        //conferindo se todos os dígitos são iguais
        for (int k = 0 ; k < 11 ; k++){
            if(cpf.charAt(k) == cpf.charAt(0))
                contador++;
        }
        if(contador == 11)
            return false;
        //dígitos verificadores
        contador = 0;
        for (int j = 0 ; j < 9 ; j++){
            contador += ((int)cpf.charAt(j) - 48) * (10- j);
        }
        resto_divisao = contador % 11;
        if (resto_divisao < 2){
            digito_1 = 0;
        }
        else{
            digito_1 = 11 - resto_divisao;
        }
        if (digito_1 != ((int)cpf.charAt(9) - 48)){
            return false;
        }
        //verificando o dígito 2
        contador = 0;
        for (int j = 0 ; j < 10 ; j++){
            contador += ((int)cpf.charAt(j) - 48) * (11- j);
        }
        resto_divisao = contador % 11;
        if (resto_divisao < 2){
            digito_2 = 0;
        }
        else{
            digito_2 = 11 - resto_divisao;
        }
        if (digito_2 != ((int)cpf.charAt(13) - 48)){
            return false;
        }
        //passou por todos procecessos
        return true;
        }

}
