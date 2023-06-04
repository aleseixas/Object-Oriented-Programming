public enum MenuOperacoes {
    CADASTRAR (1) ,
    LISTAR (2),
    EXCLUIR (3) ,
    GERARSINISTRO(4) ,
    GERARSEGURO(5) ,
    CALCULARRECEITASEGURADORA(6) ,
    SAIR (0),
    CADASTRAPFPJ(1),
    CADASTRAVEICULO(2),
    CADASTRAFROTA(3),
    VOLTARC(4),
    listarPFPJporseguradora(1),
    listarSINISTROseguradora(2),
    listarSINISTROcliente(3),
    listarSEGUROcliente(4),
    VOLTARL(5),
    excluirCLIENTE(1),
    excluirVEICULO(2),
    excluirSINISTRO(3),
    VOLTARE(4);


    public final int operacao ;

    MenuOperacoes ( int operacao ) {
    this . operacao = operacao ;
    }

    public int getOperacao () {
    return this . operacao ;
    }
}