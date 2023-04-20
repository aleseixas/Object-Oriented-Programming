public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;
    //construtor 
    public Cliente(String nome, String cpf, int idade, String dataNascimento, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    //getters e setters
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getdataNascismento(){
        return dataNascimento;
    }

    public void setdataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    //funções 
    public String toString(){
        String valor = "\nNOME:" + nome + "\nCPF:" + cpf + "\nDATA:" + dataNascimento + "\n IDADE:" + idade + "\nENDEREÇO" + endereco;
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
    if (digito_2 != ((int)cpf.charAt(10) - 48)){
        return false;
    }
    //passou por todos procecessos
    return true;
    }
}