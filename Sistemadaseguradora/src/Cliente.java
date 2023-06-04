abstract class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    //construtor 
    public Cliente(String nome, String endereco,String email , String telefone ){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
    
    //getters e setters
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
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



    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    //funções 
    @Override
    public String toString(){
        //String nome, String educacao, Date dataLicenca, String genero, String endereco, String classeEconomica,List<Veiculo> listaVeiculos
        String valor = "\nNOME:" + nome +  "\nENDEREÇO:" + endereco + "\nTELEFONE:" + telefone + "\nEMAIL" + email;
        return valor;
    }

    public double calculaScore(){
        return 0;
    }
}