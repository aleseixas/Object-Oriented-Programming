import java.util.ArrayList;
public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    Frota(String code){
        this.code = code;
        listaVeiculos = new ArrayList<>();;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public String toString() {
        String valor = "\nCODE:" + code + "\nLISTA VEICULOS:" + listaVeiculos.toString();
        return valor;
    }

    public boolean removeVeiculo(Veiculo v){
        if(listaVeiculos.contains(v)){
            listaVeiculos.remove(v);
            return true;
        }
        else{
            return false;
        }

    }

    public boolean addVeiculo(Veiculo v){
        listaVeiculos.add(0, v);
        return true;
    }

    public void atualizarFrota(int operacao , Veiculo v){
        //operacao 1 remove , operacao 2 add veiculo e operacao 3 remove a frota inteira
        if(operacao == 1){
            removeVeiculo(v);
        }
        else if (operacao == 2){
            addVeiculo(v);
        }
        else if (operacao == 3){
            listaVeiculos.clear();
        }
    }

    public void listarCarro(){
        for(Veiculo carro: listaVeiculos){
            System.out.println(carro);
        }
    }


}
