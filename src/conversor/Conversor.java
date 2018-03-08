/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *
 * @author Marcos
 */
public class Conversor {

    private final String[] milharRomano = {"M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM"};
    private final String[] centenaRomano = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private final String[] dezenaRomano = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private final String[] unidadeRomano = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private final char[] numerosDecimais = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private String numConvertidoRomano = "";
    private int numConvertidoArabico;
    private int op;
    char[] numVetor;
    int quantidadeCasasNum;

    public String converterArabicoParaRomano(String numInserido) {
        this.resetarConversão();

        numVetor = numInserido.toCharArray();
        quantidadeCasasNum = numVetor.length;

        switch (quantidadeCasasNum) {
            case 1:
                converteUnidade();
                break;

            case 2:
                converteDezena();
                converteUnidade();
                break;

            case 3:
                converteCentena();
                converteDezena();
                converteUnidade();
                break;

            case 4:
                converteMilhar();
                converteCentena();
                converteDezena();
                converteUnidade();
                break;
        }

        return numConvertidoRomano;
    }

    public void converteUnidade() {
        for (int i = 0; i < 9; i++) {
            if (numVetor[numVetor.length - 1] == numerosDecimais[i]) {
                op = i;
                numConvertidoRomano += unidadeRomano[op];
            }
        }
    }

    public void converteDezena() {
        for (int i = 0; i < 9; i++) {
            if (numVetor[numVetor.length - 2] == numerosDecimais[i]) {
                op = i;
                numConvertidoRomano += dezenaRomano[op];
            }
        }
    }

    public void converteCentena() {
        for (int i = 0; i < 9; i++) {
            if (numVetor[numVetor.length - 3] == numerosDecimais[i]) {
                op = i;
                numConvertidoRomano += centenaRomano[op];
            }
        }
    }

    public void converteMilhar() {
        for (int i = 0; i < 9; i++) {
            if (numVetor[numVetor.length - 4] == numerosDecimais[i]) {
                op = i;
                numConvertidoRomano += milharRomano[op];
            }
        }
    }

    public String converterRomanoParaArabico(String numInserido) {
        this.resetarConversão();

        numVetor = numInserido.toCharArray();
        quantidadeCasasNum = numVetor.length;

        int ultimoDigito = 0;
        int penultimoDigito = 0;

        for (int i = 1; i < numVetor.length; i++) {
            switch (numVetor[numVetor.length - i]) {
                case 'I':
                    ultimoDigito = 1;
                    break;
                case 'V':
                    ultimoDigito = 5;
                    break;
                case 'X':
                    ultimoDigito = 10;
                    break;
                case 'L':
                    ultimoDigito = 50;
                    break;
                case 'C':
                    ultimoDigito = 100;
                    break;
                case 'D':
                    ultimoDigito = 500;
                    break;
                case 'M':
                    ultimoDigito = 1000;
                    break;
                default:
                    break;
            }
            switch (numVetor[numVetor.length - (i + 1)]) {
                case 'I':
                    penultimoDigito = 1;
                    break;
                case 'V':
                    penultimoDigito = 5;
                    break;
                case 'X':
                    penultimoDigito = 10;
                    break;
                case 'L':
                    penultimoDigito = 50;
                    break;
                case 'C':
                    penultimoDigito = 100;
                    break;
                case 'D':
                    penultimoDigito = 500;
                    break;
                case 'M':
                    penultimoDigito = 1000;
                    break;
                default:
                    break;
            }
            if (ultimoDigito > penultimoDigito) {
                numConvertidoArabico += (ultimoDigito - penultimoDigito);
                i++;
            } else {
                numConvertidoArabico += ultimoDigito;
            }
        }
        switch (numVetor[0]) {
            case 'I':
                numConvertidoArabico += 1;
                break;
            case 'V':
                numConvertidoArabico += 5;
                break;
            case 'X':
                numConvertidoArabico += 10;
                break;
            case 'L':
                numConvertidoArabico += 50;
                break;
            case 'C':
                numConvertidoArabico += 100;
                break;
            case 'D':
                numConvertidoArabico += 500;
                break;
            case 'M':
                numConvertidoArabico += 1000;
                break;
            default:
                break;
        }
        return "" + numConvertidoArabico;
    }

    public void resetarConversão() {
        this.numConvertidoArabico = 0;
        this.numConvertidoRomano = "";
        this.numVetor = null;
        this.op = 0;
        this.quantidadeCasasNum = 0;
    }
}
