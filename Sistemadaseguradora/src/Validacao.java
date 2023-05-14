public  class Validacao {
    
    public static boolean validarCPF(String cpf){
        //variáveis
        int contador = 0, resto_divisao = 0 , digito_1 = 0 , digito_2 = 0;
        //retirando letras e deixando só números
        cpf = cpf.replaceAll("[^0-9]", "");
        //verificando o tamanho
        if (cpf.length() < 11)
            return false;
        //conferindo se todos os dígitos são iguais
        for (int k = 0 ; k < 11 ; k++){
            if(cpf.charAt(k) == cpf.charAt(0))
                contador++;
        }
        if(contador == 11)
            return false;
        //dígitos verificadores
        contador = 0;
        for (int j = 0 ; j < 9 ; j++){
            contador += ((int)cpf.charAt(j) - 48) * (10- j);
        }
        resto_divisao = contador % 11;
        if (resto_divisao < 2){
            digito_1 = 0;
        }
        else{
            digito_1 = 11 - resto_divisao;
        }
        if (digito_1 != ((int)cpf.charAt(9) - 48)){
            return false;
        }
        //verificando o dígito 2
        contador = 0;
        for (int j = 0 ; j < 10 ; j++){
            contador += ((int)cpf.charAt(j) - 48) * (11- j);
        }
        resto_divisao = contador % 11;
        if (resto_divisao < 2){
            digito_2 = 0;
        }
        else{
            digito_2 = 11 - resto_divisao;
        }
        if (digito_2 != ((int)cpf.charAt(10) - 48)){
            return false;
        }
        //passou por todos procecessos
        return true;
    }

    public static boolean validarCNPJ(String cnpj){
        //variáveis
        int contador = 0, resto_divisao = 0 , digito_1 = 0 , digito_2 = 0;
        //retirando letras e deixando só números
        cnpj = cnpj.replaceAll("[^0-9]", "");
        //verificando o tamanho
        if (cnpj.length() < 14)
            return false;
        //conferindo se todos os dígitos são iguais
        for (int k = 0 ; k < 14 ; k++){
            if(cnpj.charAt(k) == cnpj.charAt(0))
                contador++;
        }
        if(contador == 14)
            return false;
        //dígitos verificadores
        contador = 0;
        for (int j = 0 ; j < 12 ; j++){
            if (j <= 3){
                contador += ((int)cnpj.charAt(j) - 48) * (5 - j);
            }
            else{
                contador += ((int)cnpj.charAt(j) - 48) * (13 - j);
            }
        }
        resto_divisao = contador % 11;
        if (resto_divisao < 2){
            digito_1 = 0;
        }
        else{
            digito_1 = 11 - resto_divisao;
        }
        if (digito_1 != ((int)cnpj.charAt(12) - 48)){
            return false;
        }
        //verificando o dígito 2
        contador = 0;
        for (int j = 0 ; j < 13 ; j++){
            if (j <= 4){
                contador += ((int)cnpj.charAt(j) - 48) * (6 - j);
            }
            else{
                contador += ((int)cnpj.charAt(j) - 48) * (14 - j);
            }
        }
        resto_divisao = contador % 11;
        if (resto_divisao < 2){
            digito_2 = 0;
        }
        else{
            digito_2 = 11 - resto_divisao;
        }
        if (digito_2 != ((int)cnpj.charAt(13) - 48)){
            return false;
        }
        //passou por todos procecessos
        return true;
    }

    public static boolean Validarnome(String nome){
        for (int k = 0 ; k < nome.length() ; k++){
            if(Character.isLetter(nome.charAt(k)) == false && nome.charAt(k) != ' ' ){
                return false;
            }
        }
        return true;
    }
}
