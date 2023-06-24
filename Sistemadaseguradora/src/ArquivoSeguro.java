import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ArquivoSeguro implements I_Arquivo {

    public String lerArquivo() throws Exception {
        String valor = "";
        String caminho = "lab06-seguradora_arquivos_v2/seguro.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
		    String linha;
            //ID,DATA_INICIO,DATA_FIM,SEGURADORA,VALOR_MENSAL
            while( (linha = br.readLine()) != null){
                System.out.println(linha);
                String[] campos = linha.split(",");
                String id = campos[0];
                String data_inicio = campos[1];
                String data_fim = campos[2];
                String seguradora = campos[3];
                String valor_mensal = campos[4];
                System.out.println("ID: " + id);
                System.out.println("DATA INICIO: " + data_inicio);
                System.out.println("DATA FIM: " + data_fim);
                System.out.println("SEGURADORA: " + seguradora);
                System.out.println("VALOR MENSAL: " + valor_mensal);
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
        String caminho = "lab06-seguradora_arquivos_v2/seguro.csv";
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
