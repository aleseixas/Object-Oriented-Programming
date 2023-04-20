public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    
    public Veiculo(String placa , String marca , String modelo, int anoFabricacao){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }
    
    //set e gets
    public void setPlaca(String placa){
        this.placa = placa;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setanoFabricacao(int anoFabricacao){
        this.anoFabricacao = anoFabricacao;
    }
    
    public String getPlaca(){
        return placa;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getanoFabricao(){
        return anoFabricacao;
    }

    //funções
    @Override
    public String toString(){
        String valor = "\nPLACA:" + placa +  "\nMARCA:" + anoFabricacao + "\nMODELO:" + modelo +"\nANO FABRICAÇÃO:"+ anoFabricacao;
        return valor;
    }

}
