import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ArquivoClientePJ implements I_Arquivo {

    public String lerArquivo() throws Exception {
        String valor = "";
        String caminho = "lab06-seguradora_arquivos_v2/clientesPJ.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
		    String linha;
            //CNPJ_CLIENTE,NOME_CLIENTE,TELEFONE,ENDERECO,EMAIL_CLIENTE,DATA_FUND,CODE_FROTA
            while( (linha = br.readLine()) != null){
                System.out.println(linha);
                String[] campos = linha.split(",");
                String cnpj = campos[0];
                String nome = campos[1];
                String telefone = campos[2];
                String endereco = campos[3];
                String email = campos[4];
                String data_fundacao = campos[5];
                String code_frota = campos[6];
                System.out.println("CNPJ: " + cnpj);
                System.out.println("NOME: " + nome);
                System.out.println("TELEFONE: " + telefone);
                System.out.println("ENDEREÇO: " + endereco );
                System.out.println("EMAIL " + email);
                System.out.println("DATA FUNDAÇÃO: " + data_fundacao);
                System.out.println("CÓDIGO FROTA: " + code_frota);
                System.out.println();
		}
	}

        catch(IOException e){
            System.out.println("TENTE NOVAMENTE!");
            valor = "ERRO:" + e.getMessage();
            }
        return valor;
	}

    

    public boolean  gravarArquivo(String dados){
        String caminho = "lab06-seguradora_arquivos_v2/clientesPJ.csv";
        try(BufferedWriter br = new BufferedWriter(new FileWriter(caminho))){
		    br.write(dados);
            br.write("\n");
            return true;
		}
        catch(IOException e){
            System.out.println("TENTE NOVAMENTE!");
            System.out.println("ERRO:" + e.getMessage());
            return false;
            }
    }
    
}