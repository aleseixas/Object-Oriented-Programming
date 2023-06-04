import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

abstract class Seguro{

    public int randomId(){
        Random random = new Random();
        int numero = random.nextInt(10000000);
        return numero;
    }

    private final int id;
    private Calendar dataInicio;
    private Calendar dataFim;
    private Seguradora seguradora;
    private  ArrayList<Sinistro> listasinistro;
    private ArrayList<Condutor> listacondutor;
    private int valorMensal;

    Seguro(Calendar dataFim,Calendar dataInicio,Seguradora seguradora,int valorMensal){
        this.id = randomId();
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.seguradora = seguradora;
        listasinistro = new ArrayList<>();
        listacondutor = new ArrayList<>();
        this.valorMensal = valorMensal;
    }

    
    public int getID(){
        return id;
    }

    public Calendar getDataInicio(){
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio){
        this.dataInicio = dataInicio;
    }


    public Calendar getDataFim(){
        return dataFim;
    }

    public void setEndereco(Calendar dataFim){
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistro() {
        return listasinistro;
    }

    public void setListaSinistro(ArrayList<Sinistro> listasinistro) {
        this.listasinistro = listasinistro;
    }

    public ArrayList<Condutor> getListaCondutor() {
        return listacondutor;
    }

    public void setListaCondutor(ArrayList<Condutor> listacondutor) {
        this.listacondutor = listacondutor;
    }

    public int getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    @Override
    public String toString() {
        String valor = "\nID:" + id + "\nDATA INICIO:" + dataInicio + "\nDATA FIM:" + dataFim + "\nSEGURADORA" + seguradora.getNome() +"\nLISTA SINISTRO:" + listasinistro.toString() + "\nLISTA CONDUTOR" + listacondutor.toString() +"\nVALOR MENSAL:" + valorMensal;
        return valor;
    }

    public boolean desautorizarCondutor(Condutor c){
        if(listacondutor.contains(c)){
            listacondutor.remove(c);
            return true;
        }
        else{
            return false;
        }

    }

    public boolean autorizarCondutor(Condutor c){
        if(listacondutor.contains(c)){
            return false;
        }
        else{
            listacondutor.add(c);
            return true;
        }
    }

    public abstract double calcularValor();

    public static Sinistro gerarSinistro(Calendar data , String endereco , Seguro seguro ,Condutor condutor){
        Sinistro sinistro = new Sinistro(data, endereco, seguro, condutor);
        seguro.getListaSinistro().add(sinistro);
        return sinistro;
    }

    public boolean listarSinistro(){
        boolean entrou = false;
        for(Sinistro s: listasinistro){
            System.out.println(s);
            entrou = true;
        }
        return entrou;
    }

    public boolean listarCondutores(){
        boolean entrou = false;
        for(Condutor c : listacondutor){
            System.out.println(c);
            entrou = true;
        }
        return entrou;
    }


}
