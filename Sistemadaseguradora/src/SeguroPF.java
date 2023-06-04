import java.util.Calendar;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF cliente;
    SeguroPF(Calendar dataFim,Calendar dataInicio,Seguradora seguradora,int valorMensal,Veiculo veiculo, ClientePF cliente){
        super(dataFim, dataInicio, seguradora,valorMensal);
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        String valor = super.toString() + "\nFROTA:" + veiculo.toString() + "\nCLIENTE:" + cliente.toString();
        return valor;
    }

    public int sinistroCondutores(){
        int soma = 0;
        for (int k = 0 ; k < super.getListaCondutor().size() ; k++){
            soma += super.getListaCondutor().get(k).qntsinistro();
        }
        return soma;
    }

    public double calcularValor(){
        Calendar hoje = Calendar.getInstance();
        Calendar dataNascimento = cliente.getdataNascimento();      
        long diferenca = hoje.getTimeInMillis() - dataNascimento.getTimeInMillis();
        //convertendo os milissegundos em anos, OBS:365.25 ocorre pensando nos anos bissextos
        int idade = (int) (diferenca/1000 *  36000 * 24 * 365.25);
        //as condições da idade visam no maior valor
        if ( idade <= 30 && idade >= 18 ){
            return  CalcSeguro.FATOR_18_30.getFator() * CalcSeguro.VALOR_BASE.getFator() * (1 + 1 / (cliente.getlistaVeiculos().size() + 2)) * (2 + super.getListaSinistro().size() / 10) * (5 + sinistroCondutores() / 10);
        }
        else if ( idade > 30 && idade < 60 ){
            return  CalcSeguro.FATOR_30_60.getFator() * CalcSeguro.VALOR_BASE.getFator() * (1 + 1 / (cliente.getlistaVeiculos().size() + 2)) * (2 + super.getListaSinistro().size() / 10) * (5 + sinistroCondutores() / 10);
        }
        else if ( idade >= 60 ){
            return  CalcSeguro.FATOR_60_90.getFator() * CalcSeguro.VALOR_BASE.getFator() * (1 + 1 / (cliente.getlistaVeiculos().size() + 2)) * (2 + super.getListaSinistro().size() / 10) * (5 + sinistroCondutores() / 10);
        }
        //menores de 18 retorna 0 , já que não podem ter seguro
        return 0;

    }
}

