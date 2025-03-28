// classe publica contendo o mesmo nome do arquivo.java
//metodo main necessário chamar para executar uma classe.
// classe system para output e input
public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello Word!");
        String primeiroNome = "Juliana";
        String segundoNome = "Nunes";
        String nomeCompleto = nomeCompleto(primeiroNome, segundoNome);
        System.out.println(nomeCompleto);

        final String BR = "Brasil";
        //final não permite alterações;
        int ano = 2025;
        ano = 2026;
        double PI = 3.14;
        int ANO_2000 = 2000;
        int numero$um = 1;
        int numero1 = 1;
        boolean vOuF = true;
        //camelCase normalmente ou UPERCASE caso a variável vá receber valor imutável.
        // _ ou $ ou numero de 0 a 9.
        // unicas dentro de escopo
        // as variáveis são compostas por tipo (podendo ser uma classe) nomeBemDefinido = atribuição (ou sem)]
        String [] emails = {"ashdhask.gmail.com", "jdkakj.hotmail.com"};
        // metodos: tipoDeRetorno nomeDefinidoInfinitivo (parametros opcionais) ex: int somar (num1, num2)
        //pode receber como parâmetros tipos diferentes e retornar qualquer tipo
    }
    public static String nomeCompleto (String primeiroNome, String segundoNome){
        return "Resultado do método: " + primeiroNome.concat(" ").concat(segundoNome);
    }
}