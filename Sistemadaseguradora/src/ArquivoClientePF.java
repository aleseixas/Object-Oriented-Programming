import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ArquivoClientePF implements I_Arquivo {

    public String lerArquivo() throws Exception {
        String valor = "";
        String caminho = "lab06-seguradora_arquivos_v2/clientesPF.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
		    String linha;
            //CPF_CLIENTE,NOME_CLIENTE,TELEFONE_CLIENTE,ENDERECO_CLIENTE,EMAIL_CLIENTE,SEXO,ENSINO,DATA_NASCIMENTO,PLACA_VEICULO_CLIENTE1
            while( (linha = br.readLine()) != null){
                System.out.println(linha);
                String[] campos = linha.split(",");
                String cpf = campos[0];
                String nome = campos[1];
                String telefone = campos[2];
                String endereco = campos[3];
                String email = campos[4];
                String sexo = campos[5];
                String ensino = campos[6];
                String data_nascimento = campos[7];
                String placa_veiculo = campos[8];
                System.out.println("CPF: " + cpf);
                System.out.println("NOME: " + nome);
                System.out.println("TELEFONE: " + telefone);
                System.out.println("ENDEREÇO: " + endereco );
                System.out.println("EMAIL " + email);
                System.out.println("SEXO: " + sexo);
                System.out.println("ENSINO: " + ensino);
                System.out.println("DATA NASCIMENTO: " +  data_nascimento);
                System.out.println("PLACA DO VEÍCULO: "+ placa_veiculo);;
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
        String caminho = "lab06-seguradora_arquivos_v2/clientesPF.csv";
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
