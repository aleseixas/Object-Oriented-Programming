public class Main {
    public static void main(String[] args){
        Cliente Seixas = new Cliente("ale","46417742857",19,"15082003","rua sla");
        Seguradora portoseguro = new Seguradora("porto","19991736762","sla@gmail","rua teste");
        Sinistro local = new Sinistro("19291012","qualquer lugar");
        Veiculo nivus = new Veiculo("21ja1k","wolksvagem","nivus");
        System.out.println(Cliente.validarCPF(Seixas.getCpf()));   
        System.out.println(portoseguro.getNome());
        System.out.println(nivus.getPlaca());
        System.out.println(local.getEndereco());
    }
}
