import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ArquivoFrota implements I_Arquivo {

    public String lerArquivo() throws Exception {
        String valor = "";
        String caminho = "lab06-seguradora_arquivos_v2/frotas.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
		    String linha;
            //ID_FROTA,PLACA_VEICULO1,PLACA_VEICULO2,PLACA_VEICULO3
            while( (linha = br.readLine()) != null){
                System.out.println(linha);
                String[] campos = linha.split(",");
                String id = campos[0];
                String placa_veiculo1 = campos[1];
                String placa_veiculo2 = campos[2];
                String placa_veiculo3 = campos[3];
                System.out.println("ID: " + id);
                System.out.println("PLACA VEÍCULO 1: " + placa_veiculo1);
                System.out.println("PLACA VEÍCULO 2: " + placa_veiculo2);
                System.out.println("PLACA VEÍCULO 3: " + placa_veiculo3);
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
        String caminho = "lab06-seguradora_arquivos_v2/frotas.csv";
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
