import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    //Funcion para mostrar el menu de juego
    private static void menu() {
        int opc;
        do{
        Scanner scan = new Scanner(System.in);
        System.out.println("HOLA!!!\nEs juego es llamado adivina el numero\nTines dos modos de juego presiona: \n" +
                "1.-Adivina el numero entre 0 - 100 y tienes 8 intentos para adivinar cual crees que es el numero\n" +
                "2.-Adivina el numero entre 0 - 50 y tienes 5 intentos para adivinar cual crees que es el numero" +
                "\n3.-Salir");
        opc = scan.nextInt();
            if(opc==1){
                game1();
            }
            else if(opc==2){
                game2();
            }
        }while(opc != 3);
    }

    //Funcion para el mode de juego 1
    private static void game1() {
        Random random = new Random();
        //Creamos un numero aleatorio entre el 1-100
        int n = random.nextInt(100);
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        String nombre = scan.next();
        System.out.println("Hola " + nombre + " he pensado un numero entre el 1 y el 100\nTienes solo 8 intentos para adivinarlo cual crees que es el numero");
        int i=0;
        while(i < 8){
            System.out.println("Ingrese un numero: ");
            int numero = scan.nextInt();
            i++;
            if(numero < 0 || numero > 100){
                System.out.println("No se puede elegir un numero menor al 0 y mayor al 100");
            }
            else if (numero < n){
                System.out.println("Ha elegido un numero menor al numero secreto");
            }
            else if (numero > n){
                System.out.println("Ha elegido un numero mayor al numero secreto");
            }
            else{
                System.out.println("FELICIDADES\nHas acertado al numero secreto y te tomo " + i + " intentos");
                break;
            }
        }
        if(i == 8) {
            System.out.println("\nLo siento se han agotado los intentos\nEl numero secreo era " + n);
        }
    }

    //Funcion para el modo de juego 2
    private static void game2() {
        Random random = new Random();
        int n = random.nextInt(50);
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        String nombre = scan.next();
        System.out.println("Hola " + nombre + " he pensado un numero entre el 1 y el 50\nTienes solo 5 intentos para adivinarlo cual crees que es el numero");
        int i=1;
        for(i=1; i<6; i++){
            System.out.println("Ingrese un numero: ");
            int numero = scan.nextInt();
            if(numero < 0 || numero > 50){
                System.out.println("No se puede elegir un numero menor al 0 y mayor al 50");
            }
            else if (numero < n){
                System.out.println("Ha elegido un numero menor al numero secreto");
            }
            else if (numero > n){
                System.out.println("Ha elegido un numero mayor al numero secreto");
            }
            else{
                System.out.println("FELICIDADES\nHas acertado al numero secreto y te tomo " + i + " intentos");
                break;
            }
        }
        if(i == 6) {
            System.out.println("\nLo siento se han agotado los intentos\nEl numero secreo era " + n);
        }
    }
}


