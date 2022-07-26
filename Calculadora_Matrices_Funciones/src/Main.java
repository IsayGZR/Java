import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int otra=0;
        Scanner entrada = new Scanner(System.in);
        do {
            principal();
            System.out.println("\n¿Quieres repetir el programa?: 1.-Si Cualquier numero.-No");
            otra = entrada.nextInt();
        }while(otra == 1);
    }

    private static void principal() {
        cabecera();
        int filCol = filCol();
        float[][] primeraMatriz = primerMatriz(filCol);
        float[][] segundaMatriz = segundaMatriz(filCol);
        imprimirMatrices(primeraMatriz, segundaMatriz, filCol);
        int opcion = opc();
        operaciones(primeraMatriz, segundaMatriz, filCol, opcion);
    }

    private static void cabecera() {
        System.out.println("\t\t\t\t\t\t\tBIENVENIDO");
        System.out.println("\t\t\t\tA LA CALCULADORA DE MATRICES");
        System.out.println("******************************************************************");
        System.out.println("Nota: Solo se pueden realizar operaciones con matrices cuadradas\n");
    }

    private static int filCol() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese las filas y columnas que desea agregar: ");
        int filcol = entrada.nextInt();
        return filcol;
    }

    private static float[][] primerMatriz(int filcol) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nPrimer Matriz");
        float numeros[][] = new float[filcol][filcol];
        System.out.print("Relle la matriz\n");
        try {
            for (int j = 0; j < filcol; j++) {
                for (int i = 0; i < filcol; i++) {
                    System.out.print("Matriz[" + j + "][" + i + "]: ");
                    numeros[j][i] = entrada.nextInt();
                }
            }
        } catch(Exception e){
        System.out.println("Ingreso un caracter en lugar de un numero por lo tanto" +
                "nose podra hacer ninguna opracion con la primera matriz ");
        }
        return numeros;
    }

    private static float[][] segundaMatriz(int filcol) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nSegunda Matriz");
        float numeros[][] = new float[filcol][filcol];
        System.out.print("Relle la matriz\n");
        try {
            for (int j = 0; j < filcol; j++) {
                for (int i = 0; i < filcol; i++) {
                    System.out.print("Matriz[" + j + "][" + i + "]: ");
                    numeros[j][i] = entrada.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Ingreso un caracter en lugar de un numero por lo tanto" +
                    "nose podra hacer ninguna opracion con la segunda matriz ");
        }
        return numeros;
    }

    private static void imprimirMatrices(float[][] primeraMatriz, float[][] segundaMatriz, int filcol) {
        System.out.println("\nImprimiendo las matrices\n");
        DecimalFormat formato2 = new DecimalFormat("#.##");//Linea para definir decimales o en su defecto quitar los ceros.
        System.out.println("Primera Matriz\n");
        for (int j = 0; j < filcol; j++) {
            for (int i = 0; i < filcol; i++) {
                System.out.print("[" + formato2.format(primeraMatriz[j][i]) + "]");
            }
            System.out.println(" ");
        }
        System.out.println("\nSegunda Matriz\n");
        for (int j = 0; j < filcol; j++) {
            for (int i = 0; i < filcol; i++) {
                System.out.print("[" + formato2.format(segundaMatriz[j][i]) + "]");
            }
            System.out.println(" ");
        }
    }

    private static int opc() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nOperaciones Para realizar:\n1.-Suma\n2.-Resta\n3.-Multiplicacion\n4.-Matriz Transpuesta\n5.-Matriz Inversa\n6.-Determinante\n7.-Matriz elevada al cuadrado\n8.-Matriz multiplicada por un escalar\n");
        System.out.println("Escoga Una Operacion: ");
        int parametro = entrada.nextInt();
        return parametro;
    }
    private static void operaciones(float[][] primeraMatriz, float[][] segundaMatriz, int filCol, int opcion) {
        switch (opcion) {
            case 1:
                suma(primeraMatriz, segundaMatriz, filCol);
                break;
            case 2:
                resta(primeraMatriz, segundaMatriz);
                break;
            case 3:
                multiplicacion(primeraMatriz, segundaMatriz);
                break;
            case 4:
                transpuesta(primeraMatriz, segundaMatriz);
                break;
            case 5:
                inversa(primeraMatriz, segundaMatriz, filCol);
                break;
            case 6:
                determinante(primeraMatriz, segundaMatriz, filCol);
                break;
            case 7:
                elevada(primeraMatriz, segundaMatriz);
                break;
            case 8:
                escalar(primeraMatriz, segundaMatriz);
                break;
            default:
                System.out.println("Ese caso no existe");
                break;
        }

    }

    private static void suma(float[][] primeraMatriz, float[][] segundaMatriz, int filcol) {
        DecimalFormat formato2 = new DecimalFormat("#.##");//Linea para definir decimales o en su defecto quitar los ceros.
        float numerosc[][] = new float[filcol][filcol];
        for (int j = 0; j < filcol; j++) {
            for (int i = 0; i < filcol; i++) {
                numerosc[j][i] = primeraMatriz[j][i] + segundaMatriz[j][i];
            }
        }
        System.out.println("La Suma de las matrices es:");
        for (int j = 0; j < filcol; j++) {
            for (int i = 0; i < filcol; i++) {
                System.out.print("[" + formato2.format(numerosc[j][i]) + "]");
            }
            System.out.println("");
        }
    }

    private static void resta(float[][] primeraMatriz, float[][] segundaMatriz) {
        DecimalFormat formato2 = new DecimalFormat("#.##");//Linea para definir decimales o en su defecto quitar los ceros.
        float numerosc[][] = new float[primeraMatriz.length][primeraMatriz.length];
        for (int j = 0; j < primeraMatriz.length; j++) {
            for (int i = 0; i < primeraMatriz.length; i++) {
                numerosc[j][i] = primeraMatriz[j][i] - segundaMatriz[j][i];
            }
        }
        System.out.println("La Resta de las matrices es:");
        for (int j = 0; j < primeraMatriz.length; j++) {
            for (int i = 0; i < primeraMatriz.length; i++) {
                System.out.print("[" + formato2.format(numerosc[j][i]) + "]");
            }
            System.out.println("");
        }
    }

    private static void multiplicacion(float[][] primeraMatriz, float[][] segundaMatriz) {
        DecimalFormat formato2 = new DecimalFormat("#.##");//Linea para definir decimales o en su defecto quitar los ceros.
        float numerosc[][] = new float[primeraMatriz.length][primeraMatriz.length];
        for (int j = 0; j < primeraMatriz.length; j++) {
            for (int i = 0; i < primeraMatriz.length; i++) {
                numerosc[j][i] = primeraMatriz[j][i] * segundaMatriz[j][i];
            }
        }
        System.out.println("La Multiplicacion de las matrices es:");
        for (int j = 0; j < primeraMatriz.length; j++) {
            for (int i = 0; i < primeraMatriz.length; i++) {
                System.out.print("[" + formato2.format(numerosc[j][i]) + "]");
            }
            System.out.println("");
        }
    }

    private static void transpuesta(float[][] primeraMatriz, float[][] segundaMatriz) {
        DecimalFormat formato2 = new DecimalFormat("#.##");
        System.out.println("La Matriz transpuesta de la Primera Matriz es: ");
        for (int j = 0; j < primeraMatriz.length; j++) {
            for (int i = 0; i < primeraMatriz.length; i++) {
                System.out.print("[" + formato2.format(primeraMatriz[i][j]) + "]");
            }
            System.out.println("");
        }

        System.out.println("La Matriz transpuesta de la Segunda Matriz es: ");
        for (int j = 0; j < segundaMatriz.length; j++) {
            for (int i = 0; i < segundaMatriz.length; i++) {
                System.out.print("[" + formato2.format(segundaMatriz[i][j]) + "]");
            }
            System.out.println("");
        }
    }

    private static void inversa(float[][] primeraMatriz, float[][] segundaMatriz, int filcol) {
        DecimalFormat formato2 = new DecimalFormat("#.##");
        float det = 0, temp = 0, det1 = 0;
        if (filcol == 2) {
            det = (primeraMatriz[0][0] * primeraMatriz[1][1]) - (primeraMatriz[0][1] * primeraMatriz[1][0]);
            temp = primeraMatriz[0][0];
            primeraMatriz[0][0] = primeraMatriz[1][1];
            primeraMatriz[1][1] = temp;
            primeraMatriz[0][1] = -primeraMatriz[0][1];
            primeraMatriz[1][0] = -primeraMatriz[1][0];
            System.out.println("\nLa inversa de la Primera Matriz de 2x2: ");
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < 2; i++) {
                    System.out.print("[" + formato2.format((primeraMatriz[j][i] / det)) + "]");
                }
                System.out.println("");
            }
            det1 = (segundaMatriz[0][0] * segundaMatriz[1][1]) - (segundaMatriz[0][1] * segundaMatriz[1][0]);
            temp = segundaMatriz[0][0];
            segundaMatriz[0][0] = segundaMatriz[1][1];
            segundaMatriz[1][1] = temp;
            segundaMatriz[0][1] = -segundaMatriz[0][1];
            segundaMatriz[1][0] = -segundaMatriz[1][0];
            System.out.println("\nLa inversa de la Segunda Matriz de 2x2: ");
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < 2; i++) {
                    System.out.print("[" + formato2.format((segundaMatriz[j][i] / det1)) + "]");
                }
                System.out.println("");
            }
        } else if (filcol == 3) {
            for (int i = 0; i < 3; i++)
                det = det + (primeraMatriz[0][i] * (primeraMatriz[1][(i + 1) % 3] * primeraMatriz[2][(i + 2) % 3] - primeraMatriz[1][(i + 2) % 3] * primeraMatriz[2][(i + 1) % 3]));
            System.out.println("\nLa Matriz Inversa De la Primera Matriz es: ");
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    System.out.print("[" + formato2.format(((primeraMatriz[(j + 1) % 3][(i + 1) % 3] * primeraMatriz[(j + 2) % 3][(i + 2) % 3]) - (primeraMatriz[(j + 1) % 3][(i + 2) % 3] * primeraMatriz[(j + 2) % 3][(i + 1) % 3])) / det) + "]");
                }
                System.out.println(" ");
            }
            for (int i = 0; i < 3; i++)
                det1 = det1 + (segundaMatriz[0][i] * (segundaMatriz[1][(i + 1) % 3] * segundaMatriz[2][(i + 2) % 3] - segundaMatriz[1][(i + 2) % 3] * segundaMatriz[2][(i + 1) % 3]));
            System.out.println("\nLa Matriz Inversa De la Primera Matriz es: ");
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    System.out.print("[" + formato2.format(((segundaMatriz[(j + 1) % 3][(i + 1) % 3] * segundaMatriz[(j + 2) % 3][(i + 2) % 3]) - (segundaMatriz[(j + 1) % 3][(i + 2) % 3] * segundaMatriz[(j + 2) % 3][(i + 1) % 3])) / det1) + "]");
                }
                System.out.println(" ");
            }
        } else {
            System.out.println("Lo siento solo puedo resolver la inversa de una matriz de 2x2 y 3x3 :c");
        }
    }

    private static void determinante(float[][] primeraMatriz, float[][] segundaMatriz, int filCol) {
        float det = 0, det1 = 0;
        if (filCol == 2) {
            System.out.println("Determinante de la Primera Matriz es: ");
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 2; ++j) {
                    det = (primeraMatriz[0][0] * primeraMatriz[1][1]) - (primeraMatriz[0][1] * primeraMatriz[1][0]);
                }
            }
            System.out.println("La determinante es: " + det);
            System.out.println("Determinante de la Segunda Matriz es: ");
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 2; ++j) {
                    det1 = (segundaMatriz[0][0] * segundaMatriz[1][1]) - (segundaMatriz[0][1] * segundaMatriz[1][0]);
                }
            }
            System.out.println("La determinante es: " + det1);
        } else if (filCol == 3) {
            System.out.println("Determiante de la Primera Matriz");
            for (int i = 0; i < 3; i++) {
                det = det + (primeraMatriz[0][i] * (primeraMatriz[1][(i + 1) % 3] * primeraMatriz[2][(i + 2) % 3] - primeraMatriz[1][(i + 2) % 3] * primeraMatriz[2][(i + 1) % 3]));
            }
            System.out.println("La Determinante es: " + det);
            System.out.println("Determiante de la Segunda Matriz");
            for (int i = 0; i < 3; i++) {
                det1 = det1 + (segundaMatriz[0][i] * (segundaMatriz[1][(i + 1) % 3] * segundaMatriz[2][(i + 2) % 3] - segundaMatriz[1][(i + 2) % 3] * segundaMatriz[2][(i + 1) % 3]));
            }
            System.out.println("La Determinante es: " + det1);
        } else {
            System.out.println("Lo siento solo puedo resolver la determinante de una matriz de 2x2 y 3x3 :c");
        }
    }

    private static void elevada(float[][] primeraMatriz, float[][] segundaMatriz) {
        DecimalFormat formato2 = new DecimalFormat("#.##");
        float numerosc[][] = new float[primeraMatriz.length][primeraMatriz.length];
        for(int j=0; j< primeraMatriz.length; j++){
            for(int i=0; i< primeraMatriz.length; i++){
                numerosc[j][i]=primeraMatriz[j][i]*primeraMatriz[j][i];
            }
        }
        System.out.println("La Primera Matriz Elavdo al cuadrado es: ");
        for(int j=0; j< primeraMatriz.length; j++){
            for(int i=0; i< primeraMatriz.length; i++){
                System.out.print("[" +formato2.format(numerosc[j][i])+ "]");
            }
            System.out.println("");
        }
        for(int j=0; j< segundaMatriz.length; j++){
            for(int i=0; i< segundaMatriz.length; i++){
                numerosc[j][i]=segundaMatriz[j][i]*segundaMatriz[j][i];
            }
        }
        System.out.println("La Primera Matriz Elavdo al cuadrado es: ");
        for(int j=0; j< segundaMatriz.length; j++){
            for(int i=0; i< segundaMatriz.length; i++){
                System.out.print("[" +formato2.format(numerosc[j][i])+ "]");
            }
            System.out.println("");
        }
    }

    private static void escalar(float[][] primeraMatriz, float[][] segundaMatriz) {
        DecimalFormat formato2 = new DecimalFormat("#.##");
        Scanner entrada = new Scanner(System.in);
        float escalar = 0;
        System.out.print("Introduce el numero: ");
        escalar = entrada.nextFloat();
        System.out.println("La Primer Matriz Multiplicada por el escalar " + escalar + " es: ");
        for(int j = 0; j < primeraMatriz.length; j++){
            for(int i = 0; i < primeraMatriz.length; i++){
                primeraMatriz[j][i]*=escalar;
            }
        }
        for(int j = 0; j < primeraMatriz.length; j++){
            for(int i = 0; i < primeraMatriz.length; i++){
                System.out.print("["+formato2.format(primeraMatriz[j][i])+"]");
            }
            System.out.println("");
        }
        System.out.println("La Segunda Matriz Multiplicada por el escalar " + escalar + " es: ");
        for(int j = 0; j < segundaMatriz.length; j++){
            for(int i = 0; i < segundaMatriz.length; i++){
                segundaMatriz[j][i]*=escalar;
            }
        }
        for(int j = 0; j < segundaMatriz.length; j++){
            for(int i = 0; i < segundaMatriz.length; i++){
                System.out.print("["+formato2.format(segundaMatriz[j][i])+"]");
            }
            System.out.println("");
        }
    }
}
