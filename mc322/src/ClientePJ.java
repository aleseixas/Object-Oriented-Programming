    import java.util.ArrayList;
import java.util.Calendar;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Calendar dataFundacao;
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos , String cnpj , Calendar dataFundacao ){
        super(nome,endereco,listaVeiculos);
        this.dataFundacao = dataFundacao;
        this.cnpj = cnpj;
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

    public static boolean validarCNPJ(String cnpj){
        //variáveis
        int contador = 0, resto_divisao = 0 , digito_1 = 0 , digito_2 = 0;
        //retirando letras e deixando só números
        cnpj = cnpj.replaceAll("[^0-9]", "");
        //verificando o tamanho
        if (cnpj.length() < 14)
            return false;
        //conferindo se todos os dígitos são iguais
        for (int k = 0 ; k < 14 ; k++){
            if(cnpj.charAt(k) == cnpj.charAt(0))
                contador++;
        }
        if(contador == 14)
            return false;
        //dígitos verificadores
        contador = 0;
        for (int j = 0 ; j < 12 ; j++){
            if (j <= 3){
                contador += ((int)cnpj.charAt(j) - 48) * (5 - j);
            }
            else{
                contador += ((int)cnpj.charAt(j) - 48) * (13 - j);
            }
        }
        resto_divisao = contador % 11;
        if (resto_divisao < 2){
            digito_1 = 0;
        }
        else{
            digito_1 = 11 - resto_divisao;
        }
        if (digito_1 != ((int)cnpj.charAt(12) - 48)){
            return false;
        }
        //verificando o dígito 2
        contador = 0;
        for (int j = 0 ; j < 13 ; j++){
            if (j <= 4){
                contador += ((int)cnpj.charAt(j) - 48) * (6 - j);
            }
            else{
                contador += ((int)cnpj.charAt(j) - 48) * (14 - j);
            }
        }
        resto_divisao = contador % 11;
        if (resto_divisao < 2){
            digito_2 = 0;
        }
        else{
            digito_2 = 11 - resto_divisao;
        }
        if (digito_2 != ((int)cnpj.charAt(13) - 48)){
            return false;
        }
        //passou por todos procecessos
        return true;
    }
}
