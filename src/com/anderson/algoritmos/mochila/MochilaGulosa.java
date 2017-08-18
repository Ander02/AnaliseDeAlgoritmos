package com.anderson.algoritmos.mochila;

/**
 *
 * @author Anderson
 */
public class MochilaGulosa {

    static int[] valores = {12, 8, 3};
    static int[] pesos = {4, 2, 2};
    static int pesoMaximo = 4;

    //Otimizar o peso em relação ao valor dos itens
    public static boolean[] problemaDaMochila(int[] valoresItens, int[] pesosItens, int pesoMaximo) {

        if (valoresItens.length == pesosItens.length) {

            int pesoAcumulado = 0;
            int valorAcumulado = 0;

            int quantidadeDeItens = valoresItens.length;
            boolean[] solucao = new boolean[quantidadeDeItens];

            int i = 0;
            //Enquanto a mochila ainda tem espaço e não percorreu todos os itens
            while (pesoAcumulado < pesoMaximo && i < quantidadeDeItens) {

                double densidadeMelhorOpcao = 0;
                int indiceMelhorOpcao = 0;

                //seleciona a melhor opcao
                for (int j = 0; j < quantidadeDeItens; j++) {
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

                    //torna essa opção inválida pois já foi adicionada
                    pesosItens[indiceMelhorOpcao] *= -1;
                    valoresItens[indiceMelhorOpcao] *= -1;
                } else {
                    //torna essa opção inválida pois não cabe na mochila
                    pesosItens[indiceMelhorOpcao] *= -1;
                    valoresItens[indiceMelhorOpcao] *= -1;
                }
                i++;
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

        boolean[] resp = problemaDaMochila(valores, pesos, pesoMaximo);

        for (int i = 0; i < resp.length; i++) {
            System.out.println(i + " " + resp[i]);
        }

    }

}
