//Codigo Hecho por: ZAMORA DE LA ROSA ISAY GERARDO

import java.util.Scanner;
import java.text.DecimalFormat; //Esta libreria que sirve para limitar el numero de decimales o quitar los 0 excedentes
public class Main{

    public static void main(String[] args) {
        int filas = 0, columnas = 0, filas1 = 0, columnas1 = 0, otra = 0, parametro=0;
        float aux=0, det=0, temp=0, det1=0, escalar=0;
        do{
            Scanner entrada = new Scanner(System.in);
            DecimalFormat formato2 = new DecimalFormat("#.##");//Linea para definir decimales o en su defecto quitar los ceros.
            System.out.println("\t\tCALCULADORA DE MATRICES");
            System.out.println("Primer Matriz");
            System.out.println("Ingrese las columas que desea agregar: ");
            columnas = entrada.nextInt();
            System.out.println("Ingrese las filas que desea agregar: ");
            filas = entrada.nextInt();
            float numeros [][] = new float [filas][columnas];
            System.out.print("Relle la matriz\n");
            for(int j = 0; j < filas; j++){
                for(int i=0; i < columnas; i++){
                    System.out.print("Matriz[" + j + "][" + i + "]: ");
                    numeros[j][i] = entrada.nextInt();
                }
            }
            System.out.print("La Primer Matriz es: \n");
            for(int j = 0; j < filas; j++){
                for(int i = 0; i < columnas; i++){
                    System.out.print("[" +formato2.format(numeros[j][i])+ "]"); //Forma de imprimir para quitar decimales exedentes.
                }
                System.out.println(" ");
            }
            System.out.println("Segunda Matriz");
            System.out.println("Ingrese las columas que desea agregar: ");
            columnas1 = entrada.nextInt();
            System.out.println("Ingrese las filas que desea agregar: ");
            filas1 = entrada.nextInt();
            float numerosc [][] = new float [filas][columnas];
            if(filas==filas1 && columnas==columnas1){
                float numeros1 [][] = new float [filas][columnas];
                System.out.print("Relle la matriz\n");
                for(int j = 0; j < filas; j++){
                    for(int i=0; i < columnas; i++){
                        System.out.print("Matriz[" + j + "][" + i + "]: ");
                        numeros1[j][i] = entrada.nextInt();
                    }
                }
                System.out.print("La Segunda Matriz es: \n");
                for(int j = 0; j < filas; j++){
                    for(int i = 0; i < columnas; i++){
                        System.out.print("[" +formato2.format(numeros1[j][i])+ "]");
                    }
                    System.out.println(" ");
                }
                System.out.println("\nOperaciones Para realizar:\n1.-Suma\n2.-Resta\n3.-Multiplicacion\n4.-Matriz Transpuesta\n5.-Matriz Inversa\n6.-Determinante\n7.-Matriz elevada al cuadrado\n8.-Matriz multiplicada por un escalar\n");
                System.out.println("Escoga Una Operacion: ");
                parametro = entrada.nextInt();
                switch(parametro){
                    case 1:
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                numerosc[j][i]=numeros[j][i]+numeros1[j][i];
                            }
                        }
                        System.out.println("La Suma de las matrices es:");
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                System.out.print("[" +formato2.format(numerosc[j][i])+ "]");
                            }
                            System.out.println("");
                        }
                        break;
                    case 2:
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                numerosc[j][i]=numeros[j][i]-numeros1[j][i];
                            }
                        }
                        System.out.println("La Resta de las matrices es:");
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                System.out.print("[" +formato2.format(numerosc[j][i])+ "]");
                            }
                            System.out.println("");
                        }
                        break;
                    case 3:
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                numerosc[j][i]=numeros[j][i]*numeros1[j][i];
                            }
                        }
                        System.out.println("La Multiplicacion de las matrices es:");
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                System.out.print("[" + formato2.format(numerosc[j][i]) + "]");
                            }
                            System.out.println("");
                        }
                        break;
                    case 4:
                        for(int j = 0; j < filas; j++){
                            for(int i = 0; i < columnas; i++){
                                aux = numeros[j][i];
                                numeros[j][i]=numeros[i][j];
                                numeros[i][j]=aux;
                            }
                        }
                        System.out.println("La Matriz transpuesta de la Primera Matriz es: ");
                        for(int j = 0; j < filas; j++){
                            for(int i = 0; i < columnas; i++){
                                System.out.print("["+formato2.format(numeros[j][i])+"]");
                            }
                            System.out.println("");
                        }
                        for(int j = 0; j < filas; j++){
                            for(int i = 0; i < columnas; i++){
                                aux = numeros1[j][i];
                                numeros1[j][i]=numeros1[i][j];
                                numeros1[i][j]=aux;
                            }
                        }
                        System.out.println("La Matriz transpuesta de la Segunda Matriz es: ");
                        for(int j = 0; j < filas; j++){
                            for(int i = 0; i < columnas; i++){
                                System.out.print("["+formato2.format(numeros1[j][i])+"]");
                            }
                            System.out.println("");
                        }
                        break;
                    case 5:
                        if(columnas == 2 && filas==2 && columnas1 == 2 && filas1== 2){
                            det = (numeros[0][0] * numeros[1][1]) - (numeros[0][1] * numeros[1][0]);
                            temp = numeros[0][0];
                            numeros[0][0] = numeros[1][1];
                            numeros[1][1] = temp;
                            numeros[0][1] = - numeros[0][1];
                            numeros[1][0] = - numeros[1][0];
                            System.out.println("\nLa inversa de la Primera Matriz de 2x2: ");
                            for(int j = 0; j < 2; j++) {
                                for(int i = 0; i < 2; i++){
                                    System.out.print("["+formato2.format((numeros[j][i]/det)) + "]");
                                }
                                System.out.println("");
                            }
                            det1 = (numeros1[0][0] * numeros1[1][1]) - (numeros1[0][1] * numeros1[1][0]);
                            temp = numeros1[0][0];
                            numeros1[0][0] = numeros1[1][1];
                            numeros1[1][1] = temp;
                            numeros1[0][1] = - numeros1[0][1];
                            numeros1[1][0] = - numeros1[1][0];
                            System.out.println("\nLa inversa de la Segunda Matriz de 2x2: ");
                            for(int j = 0; j < 2; j++) {
                                for(int i = 0; i < 2; i++){
                                    System.out.print("["+formato2.format((numeros1[j][i]/det1)) + "]");
                                }
                                System.out.println("");
                            }
                        }
                        else if(columnas == 3 && filas==3 && columnas1 == 3 && filas1== 3){
                            for(int i = 0; i < 3; i++)
                                det = det + (numeros[0][i] * (numeros[1][(i+1)%3] * numeros[2][(i+2)%3] - numeros[1][(i+2)%3] * numeros[2][(i+1)%3]));
                            System.out.println("\nLa Matriz Inversa De la Primera Matriz es: ");
                            for(int i = 0; i < 3; ++i) {
                                for(int j = 0; j < 3; ++j){
                                    System.out.print("["+formato2.format(((numeros[(j+1)%3][(i+1)%3] * numeros[(j+2)%3][(i+2)%3]) - (numeros[(j+1)%3][(i+2)%3] * numeros[(j+2)%3][(i+1)%3]))/ det) + "]");
                                }
                                System.out.println(" ");
                            }
                            for(int i = 0; i < 3; i++)
                                det1 = det1 + (numeros1[0][i] * (numeros1[1][(i+1)%3] * numeros1[2][(i+2)%3] - numeros1[1][(i+2)%3] * numeros1[2][(i+1)%3]));
                            System.out.println("\nLa Matriz Inversa De la Primera Matriz es: ");
                            for(int i = 0; i < 3; ++i) {
                                for(int j = 0; j < 3; ++j){
                                    System.out.print("["+formato2.format(((numeros1[(j+1)%3][(i+1)%3] * numeros1[(j+2)%3][(i+2)%3]) - (numeros1[(j+1)%3][(i+2)%3] * numeros1[(j+2)%3][(i+1)%3]))/ det1) + "]");
                                }
                                System.out.println(" ");
                            }
                        }
                        else{
                            System.out.println("Lo siento solo puedo resolver la inversa de una matriz de 2x2 y 3x3 :c");
                        }
                        break;
                    case 6:
                        if(columnas == 2 && filas==2 && columnas1 == 2 && filas1== 2){
                            System.out.println("Determinante de la Primera Matriz es: ");
                            for(int i = 0; i < 2; ++i){
                                for(int j = 0; j < 2; ++j){
                                    det = (numeros[0][0] * numeros[1][1]) - (numeros[0][1] * numeros[1][0]);
                                }
                            }
                            System.out.println("La determinante es: " + det);
                            System.out.println("Determinante de la Segunda Matriz es: ");
                            for(int i = 0; i < 2; ++i){
                                for(int j = 0; j < 2; ++j){
                                    det1 = (numeros1[0][0] * numeros1[1][1]) - (numeros1[0][1] * numeros1[1][0]);
                                }
                            }
                            System.out.println("La determinante es: " + det1);
                        }
                        else if(columnas == 3 && filas==3 && columnas1 == 3 && filas1== 3){
                            System.out.println("Determiante de la Primera Matriz");
                            for(int i = 0; i < 3; i++){
                                det = det + (numeros[0][i] * (numeros[1][(i+1)%3] * numeros[2][(i+2)%3] - numeros[1][(i+2)%3] * numeros[2][(i+1)%3]));
                            }
                            System.out.println("La Determinante es: " + det);
                            System.out.println("Determiante de la Segunda Matriz");
                            for(int i = 0; i < 3; i++){
                                det1 = det1 + (numeros1[0][i] * (numeros1[1][(i+1)%3] * numeros1[2][(i+2)%3] - numeros1[1][(i+2)%3] * numeros1[2][(i+1)%3]));
                            }
                            System.out.println("La Determinante es: " + det1);
                        }
                        else{
                            System.out.println("Lo siento solo puedo resolver la determinante de una matriz de 2x2 y 3x3 :c");
                        }
                        break;
                    case 7:
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                numerosc[j][i]=numeros[j][i]*numeros[j][i];
                            }
                        }
                        System.out.println("La Primera Matriz Elavdo al cuadrado es: ");
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                System.out.print("[" +formato2.format(numerosc[j][i])+ "]");
                            }
                            System.out.println("");
                        }
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                numerosc[j][i]=numeros1[j][i]*numeros1[j][i];
                            }
                        }
                        System.out.println("La Primera Matriz Elavdo al cuadrado es: ");
                        for(int j=0; j< filas; j++){
                            for(int i=0; i< columnas; i++){
                                System.out.print("[" +formato2.format(numerosc[j][i])+ "]");
                            }
                            System.out.println("");
                        }
                        break;
                    case 8:
                        System.out.print("Introduce el numero: ");
                        escalar = entrada.nextFloat();
                        System.out.println("La Primer Matriz Multiplicada por el escalar es: ");
                        for(int j = 0; j < filas; j++){
                            for(int i = 0; i < columnas; i++){
                                numeros[j][i]*=escalar;
                            }
                        }
                        for(int j = 0; j < filas; j++){
                            for(int i = 0; i < columnas; i++){
                                System.out.print("["+formato2.format(numeros[j][i])+"]");
                            }
                            System.out.println("");
                        }
                        System.out.println("La Segunda Matriz Multiplicada por el escalar es: ");
                        for(int j = 0; j < filas; j++){
                            for(int i = 0; i < columnas; i++){
                                numeros1[j][i]*=escalar;
                            }
                        }
                        for(int j = 0; j < filas; j++){
                            for(int i = 0; i < columnas; i++){
                                System.out.print("["+formato2.format(numeros1[j][i])+"]");
                            }
                            System.out.println("");
                        }
                        System.out.println("Escalar");
                        break;
                    default:
                        System.out.println("Ese caso no existe");
                        break;
                }
            }
            else{
                System.out.print("Lo sentimos para realizar las operaciones se requieren que las matrices tengan las mismas dimensiones.\nPor su compresion gracias :)");
            }
            System.out.println("\n¿Quieres repetir el programa?: 1.-Si Cualquier numero.-No");
            otra = entrada.nextInt();
        }while(otra == 1);
    }
}