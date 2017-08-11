package com.anderson.util;

/**
 *
 * @author Anderson
 */
public class Busca {
    
     /**
     *
     * @param arrayOrdenado
     * @param valor
     * @return
     */
    public static int buscarInt(int arrayOrdenado[], int valor) {
        int inicio = 0;
        int fim = arrayOrdenado.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (arrayOrdenado[meio] == valor) {
                return meio;
            }
            if (arrayOrdenado[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    /**
     *
     * @param arrayOrdenado
     * @param valor
     * @return
     */
    public static int buscarDouble(double arrayOrdenado[], double valor) {
        int inicio = 0;
        int fim = arrayOrdenado.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (arrayOrdenado[meio] == valor) {
                return meio;
            }
            if (arrayOrdenado[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    /**
     *
     * @param array1
     * @param array2
     * @param opcao
     * @return
     */
    public static boolean ordenaArraysInt(int array1[], int array2[], int opcao) {

        if (array1.length == array2.length) {

            switch (opcao) {

                case 0: {
                    //ordena por array1 crescente
                    for (int ult = array1.length - 1; ult >= 0; ult--) {
                        for (int i = 0; i < ult; i++) {
                            if (array1[i] >= array1[i + 1]) {
                                int aux = array1[i];
                                array1[i] = array1[i + 1];
                                array1[i + 1] = aux;

                                aux = array2[i];
                                array2[i] = array2[i + 1];
                                array2[i + 1] = aux;
                            }
                        }
                    }

                    break;
                }
                case 1: {
                    //ordena por array1 decrescente
                    for (int ult = array1.length - 1; ult >= 0; ult--) {
                        for (int i = 0; i < ult; i++) {
                            if (array1[i] <= array1[i + 1]) {
                                int aux = array1[i];
                                array1[i] = array1[i + 1];
                                array1[i + 1] = aux;

                                aux = array2[i];
                                array2[i] = array2[i + 1];
                                array2[i + 1] = aux;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    //ordena por array2 crescente
                    for (int ult = array1.length - 1; ult >= 0; ult--) {
                        for (int i = 0; i < ult; i++) {
                            if (array2[i] >= array2[i + 1]) {
                                int aux = array1[i];
                                array1[i] = array1[i + 1];
                                array1[i + 1] = aux;

                                aux = array2[i];
                                array2[i] = array2[i + 1];
                                array2[i + 1] = aux;
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    //ordena por array2 decrescente
                    for (int ult = array1.length - 1; ult >= 0; ult--) {
                        for (int i = 0; i < ult; i++) {
                            if (array2[i] <= array2[i + 1]) {
                                int aux = array1[i];
                                array1[i] = array1[i + 1];
                                array1[i + 1] = aux;

                                aux = array2[i];
                                array2[i] = array2[i + 1];
                                array2[i + 1] = aux;
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    //ordena por densidade array1/array2 crescente
                    for (int ult = array1.length - 1; ult >= 0; ult--) {
                        for (int i = 0; i < ult; i++) {
                            if (array2[i] != 0 && array2[i + 1] != 0) {
                                double densidadeI = (float) array1[i] / array2[i];
                                double densidadeII = (float) array1[i + 1] / array2[i + 1];
                                if (densidadeI >= densidadeII) {
                                    int aux = array1[i];
                                    array1[i] = array1[i + 1];
                                    array1[i + 1] = aux;

                                    aux = array2[i];
                                    array2[i] = array2[i + 1];
                                    array2[i + 1] = aux;
                                }
                            } else {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    //ordena por densidade array1/array2 decrescente
                    for (int ult = array1.length - 1; ult >= 0; ult--) {
                        for (int i = 0; i < ult; i++) {
                            if (array2[i] != 0 && array2[i + 1] != 0) {
                                double densidadeI = (float) array1[i] / array2[i];
                                double densidadeII = (float) array1[i + 1] / array2[i + 1];
                                if (densidadeI <= densidadeII) {
                                    int aux = array1[i];
                                    array1[i] = array1[i + 1];
                                    array1[i + 1] = aux;

                                    aux = array2[i];
                                    array2[i] = array2[i + 1];
                                    array2[i + 1] = aux;
                                }
                            } else {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 6: {
                    //ordena por densidade array2/array1 crescente
                    for (int ult = array1.length - 1; ult >= 0; ult--) {
                        for (int i = 0; i < ult; i++) {
                            if (array1[i] != 0 && array1[i + 1] != 0) {
                                double densidadeI = (float) array2[i] / array1[i];
                                double densidadeII = (float) array2[i + 1] / array1[i + 1];
                                if (densidadeI >= densidadeII) {
                                    int aux = array1[i];
                                    array1[i] = array1[i + 1];
                                    array1[i + 1] = aux;

                                    aux = array2[i];
                                    array2[i] = array2[i + 1];
                                    array2[i + 1] = aux;
                                }
                            } else {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 7: {
                    //ordena por densidade array2/array1 decrescente
                    for (int ult = array1.length - 1; ult >= 0; ult--) {
                        for (int i = 0; i < ult; i++) {
                            if (array1[i] != 0 && array1[i + 1] != 0) {
                                double densidadeI = (float) array2[i] / array1[i];
                                double densidadeII = (float) array2[i + 1] / array1[i + 1];
                                if (densidadeI <= densidadeII) {
                                    int aux = array1[i];
                                    array1[i] = array1[i + 1];
                                    array1[i + 1] = aux;

                                    aux = array2[i];
                                    array2[i] = array2[i + 1];
                                    array2[i + 1] = aux;
                                }
                            } else {
                                return false;
                            }
                        }
                    }
                    break;
                }
                default: {
                    //Opção inválida
                    return false;
                }
            }
            //saiu do switch
            return true;
        }
        //arrays de tamanhos diferentes
        return false;
    }
    
}
