import java.util.Calendar;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;
    SeguroPJ(Calendar dataFim,Calendar dataInicio,Seguradora seguradora,int valorMensal,Frota frota,ClientePJ cliente){
        super(dataFim,dataInicio, seguradora, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        String valor = super.toString() + "\nFROTA:" + frota.toString() + "\nCLIENTE:" + cliente.toString();
        return valor;
    }

    public int qntVeiculos(){
        int soma = 0 ;
        for (int k = 0 ; k < cliente.getListaFrotas().size() ; k++){
            soma += cliente.getListaFrotas().get(k).getListaVeiculos().size();
        }
        return soma;
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
        Calendar dataFundacao = cliente.getdataFundacao();      
        long diferenca = hoje.getTimeInMillis() - dataFundacao.getTimeInMillis();
        //convertendo os milissegundos em anos, OBS:365.25 ocorre pensando nos anos bissextos
        int idade = (int) (diferenca/1000 *  36000 * 24 * 365.25);
        return CalcSeguro.VALOR_BASE.getFator() * (cliente.getQtdeFuncionarios() / 10) * (1 + 1 / (qntVeiculos() + 2)) * (1 + 1/(idade+2)) * (2 + super.getListaSinistro().size() / 10) * (5 + sinistroCondutores() / 10);
    }
}
