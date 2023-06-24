import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ArquivoVeículo implements I_Arquivo {

    public String lerArquivo() throws Exception {
        String valor = "";
        String caminho = "lab06-seguradora_arquivos_v2/veiculos.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
		    String linha;
            //PLACA,MARCA,MODELO,ANO_FAB
            while( (linha = br.readLine()) != null){
                System.out.println(linha);
                String[] campos = linha.split(",");
                String placa = campos[0];
                String marca = campos[1];
                String modelo = campos[2];
                String ano_fab = campos[3];
                System.out.println("PLACA: " + placa);
                System.out.println("MARCA: " + marca);
                System.out.println("MODELO: " + modelo);
                System.out.println("ANO FABRICAÇÃO: " + ano_fab);
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
        String caminho = "lab06-seguradora_arquivos_v2/veiculos.csv";
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


