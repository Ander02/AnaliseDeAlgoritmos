package com.anderson.algoritmos.mochila;

/**
 *
 * @author T94
 */
public class MochilaBacktracking {

    /*A fins de simplificar o problema definiu-se o método como void e as variáveis como static*/
    static int[] valor = {11, 10, 5};//
    static int[] peso = {19, 10, 9};
    static int pesoMax = 20;//kg
    static boolean[] solucao = new boolean[valor.length];
    static boolean[] solucaoAtual = new boolean[valor.length];
    static int p = 0; // massa na bolsa
    static int v = 0; // valor na bolsa

    //Método que resolve o problema da mochila aplicando backtracking
    public static void mochila(int i) {

        solucao = solucaoAtual.clone();

        /*
            //ordena os arrays por valor crescente
            for (int ult = valor.length - 1; ult >= 0; ult--) {
                for (int j = 0; j < ult; j++) {
                    if (valor[j] <= valor[j + 1]) {
                        int aux = valor[j];
                        valor[j] = valor[j + 1];
                        valor[j + 1] = aux;

                        aux = peso[j];
                        peso[j] = peso[j + 1];
                        peso[j + 1] = aux;
                    }
                }
        }*/
        //Enquanto cabem itens na mochila e existem elementos a serem testados
        while (p < pesoMax && i >= 0) {

            if (p + peso[i] <= pesoMax) {

                solucaoAtual[i] = true;
                p += peso[i];
                v += valor[i];

                if (i < valor.length) {
                    mochila(i - 1);

                    solucaoAtual[i] = false;
                    p -= peso[i];
                    v -= valor[i];
                    //Remove o registro quando método voltar
                }

            }
            i--;
        }

        int valorFinal = 0;
        int pesoFinal = 0;
        for (int j = 0; j < solucao.length; j++) {
            if (solucao[j]) {
                valorFinal += valor[j];
                pesoFinal += peso[j];
            }
        }
        System.out.println(v);
        System.out.println(valorFinal);
        if (v <= valorFinal) {
//            solucao = solucaoAtual.clone();
            v = valorFinal;
            p = pesoFinal;
        } else {
            solucao = solucaoAtual.clone();
        }
        
        System.out.println("P\t V\t B");
        for (int j = 0; j < solucaoAtual.length; j++) {
            System.out.print(peso[j] + "\t ");
            System.out.print(valor[j] + "\t ");
            System.out.print(solucaoAtual[j] + "\t \n");
        }
        System.out.println("Peso na Mochila: " + p);
        System.out.println("Valor na Mochila: " + v);
        System.out.println("");
    }

    public static void main(String args[]) {
        mochila(solucao.length - 1);

        System.out.println("Solucão Final");
        System.out.println("P\t V\t B");
        for (int j = 0; j < solucao.length; j++) {
            System.out.print(peso[j] + "\t ");
            System.out.print(valor[j] + "\t ");
            System.out.print(solucao[j] + "\t \n");
        }
        System.out.println("Valor Solução " + v);
        System.out.println("Peso Solução " + p);
    }
}
