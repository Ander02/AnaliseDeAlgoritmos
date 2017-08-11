package com.anderson.algoritmos;

import java.util.Arrays;

/**
 *
 * @author Anderson
 */
public class MochilaGulosa {

    static int[] valores = {10, 8, 3};
    static int[] pesos = {3, 2, 1};
    static int pesoMaximo = 4;

    //Otimizar o peso em relação ao valor dos itens
    public static boolean[] problemaDaMochila(int[] valoresItens, int[] pesosItens, int pesoMaximo, boolean[] solucaoAnterior) {

        if (valoresItens.length == pesosItens.length) {

            int pesoAcumulado = 0;
            int valorAcumulado = 0;

            int quantidadeDeItens = valoresItens.length;
            boolean[] solucao = new boolean[quantidadeDeItens];

            int i = quantidadeDeItens - 1;
            //Enquanto a mochila ainda tem espaço e não percorreu todos os itens
            while (pesoAcumulado < pesoMaximo && i >= 0) {

                double densidadeMelhorOpcao = 0;
                int indiceMelhorOpcao = 0;

                //seleciona a melhor opcao
                for (int j = 0; j < pesosItens.length; j++) {
                    if (pesosItens[j] > 0 && valoresItens[j] > 0) {
                        double densidadeValorPeso = (double) valoresItens[j] / pesosItens[j];
                        if (densidadeValorPeso >= densidadeMelhorOpcao) {
                            densidadeMelhorOpcao = densidadeValorPeso;
                            indiceMelhorOpcao = j;
                        }
                    }
                }

                //se o item cabe na mochila e é válido
                if (pesosItens[indiceMelhorOpcao] <= (pesoMaximo - pesoAcumulado) && pesosItens[indiceMelhorOpcao] > 0) {
                    solucao[indiceMelhorOpcao] = true;

                    pesoAcumulado += pesosItens[indiceMelhorOpcao];
                    valorAcumulado += valoresItens[indiceMelhorOpcao];

                    //torna essa opção inválida para próximas consultas
                    pesosItens[indiceMelhorOpcao] *= -1;
                    valoresItens[indiceMelhorOpcao] *= -1;

                } else if (solucaoAnterior != null ) {
                    int valorAcumuladoSolucaoAnterior = 0;
                    for (int j = 0; j < solucaoAnterior.length; j++) {
                        if (solucaoAnterior[j] == true) {
                            valorAcumuladoSolucaoAnterior += valoresItens[j];
                        }
                    }
                    valorAcumuladoSolucaoAnterior *= -1;

                    if (valorAcumulado <= valorAcumuladoSolucaoAnterior) {
                        valorAcumulado = valorAcumuladoSolucaoAnterior;
                        solucao = solucaoAnterior;
                    } else {
                        System.out.println("Chamada Recursiva");
                        problemaDaMochila(valoresItens, pesosItens, pesoMaximo, solucao);
                    }
                } else {
                    problemaDaMochila(valoresItens, pesosItens, pesoMaximo, solucao);
                }
                i--;
            }
            System.out.println("Peso Acumulado: " + pesoAcumulado);
            System.out.println("Valor Acumulado: " + valorAcumulado);
            System.out.println("");
            return solucao;
        }

        //se os arrays tiverem tamanhos diferentes
        return null;
    }

    public static void main(String[] args) {

        boolean[] resp = problemaDaMochila(valores, pesos, pesoMaximo, null);

        for (int i = 0; i < resp.length; i++) {
            System.out.println(i + " " + resp[i]);
        }

    }

}
