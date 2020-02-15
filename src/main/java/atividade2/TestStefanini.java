package atividade2;

import java.util.Scanner;
import java.util.stream.IntStream;

public class TestStefanini {

    public static void main(String[] args) {
        TestStefanini test = new TestStefanini();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um valor para verificação: ");
        int valor = scanner.nextInt();

        boolean t = test.verificarNumeroPrimo(valor);

        System.out.println(t ? "É Primo" : "Não É Primo");
    }

    public boolean verificarNumeroPrimo(int valor) {
        return verificaPrimos(valor);
    }

    private boolean verificaPrimos(int valor) {

        if (valor <= 1) return false; // 0 e 1 NÂO É NÚMERO PRIMO, VALIDAÇÃO INICIAL

        // VERIFICA SE O NÚMERO DO PARAMETRO É UM N° PRIMO
       return !IntStream.rangeClosed(2, valor / 2).anyMatch(i -> valor % i == 0);

    }


}

        /* List<Integer> numeros = new ArrayList();
        List<Integer> primos = new ArrayList();

        boolean retorno = false;

        for (int i = 0; i <= valor; i++) {
            numeros.add(i);
        }

        for (Integer i : numeros) {
            int contador = 0;
            for (int u = 1; u <= i; u++) {
                contador++;
                primos.add(u);
            }
            contador++;
        }
        if (primos.size() == 2) {
            retorno = true;
        } else {
            retorno = false;
        }
        return retorno;*/

    