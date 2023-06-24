import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ArquivoSinistro implements I_Arquivo {

    public String lerArquivo() throws Exception {
        String valor = "";
        String caminho = "lab06-seguradora_arquivos_v2/sinistro.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
		    String linha;
            //ID,DATA,ENDERECO,CONDUTOR,SEGURO
            while( (linha = br.readLine()) != null){
                System.out.println(linha);
                String[] campos = linha.split(",");
                String id = campos[0];
                String data = campos[1];
                String endereco = campos[2];
                String condutor = campos[3];
                String seguro = campos[4];
                System.out.println("ID: " + id);
                System.out.println("DATA: " + data);
                System.out.println("ENDEREÇO: " + endereco);
                System.out.println("CONDUTOR: " + condutor);
                System.out.println("SEGURO: " + seguro);
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
        String caminho = "lab06-seguradora_arquivos_v2/sinistro.csv";
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
