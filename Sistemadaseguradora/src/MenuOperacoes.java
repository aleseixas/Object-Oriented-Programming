public enum MenuOperacoes {
    CADASTRAR (1) ,
    LISTAR (2),
    EXCLUIR (3) ,
    GERARSINISTRO(4) ,
    TRANSFERIRSEGURO(5) ,
    CALCULARRECEITASEGURADORA(6) ,
    SAIR (0),
    CADASTRAPFPJ(1),
    CADASTRAVEICULO(2),
    CADASTRASEGURADORA(3),
    VOLTARC(4),
    listarPFPJporseguradora(1),
    listarSINISTROseguradora(2),
    listarSINISTROcliente(3),
    listarVEICULOcliente(4),
    listarVEICULOseguradora(5),
    VOLTARL(6),
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