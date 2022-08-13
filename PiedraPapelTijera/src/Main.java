import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int opc;
        do{
            System.out.println(jugar());
            System.out.println("Quieres volver a jugar?: 1.-SI 2.-NO:  ");
            opc = sc.nextInt();
        }while(opc == 1);
        System.out.println("Gracias por Jugar");
    }


    //Funcion principal del juego
    private static String jugar() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escoge");
            System.out.println("'r' - Para roca (piedra)");
            System.out.println("'p' - Para papel");
            System.out.println("'t' - Para tijeras");
            char usuario = sc.next().charAt(0);

            //Se selecciona aleatoriamente r (roca,piedra) - p (papel) - t (tijera)
            Random random = new Random();
            String setOfCharacters = "rpt";
            int randomInt = random.nextInt(setOfCharacters.length());
            char maquina = setOfCharacters.charAt(randomInt);

            //Comprobamos que el usuario halla elegido un caracter valido
            if (usuario == 'r' || usuario == 'p' || usuario == 't') {
                if (usuario == maquina) {
                    return "Usted escogio:" + usuario + " y la maquina tambien escogio " + maquina + " por lo tanto es un EMPATE";
                }

                if (victoria(usuario, maquina)) {
                    return "Usted escogio: " + usuario + " y la maquina escogio " + maquina + " por lo tanto GANO";
                }

                return "Usted escogió: " + usuario + " y la maquina escogió " + maquina + " por lo tanto PERDIO";
            }
            System.out.println("NO es valida su entrada. Escoja una opcion valida ");
            return setOfCharacters;
        }
    }

    //Funcion para comprobar si hemos ganado o perdido
    private static boolean victoria(char jugador, char oponente) {
        return (jugador == 'r' && oponente == 't') || (jugador == 't' && oponente == 'p') || (jugador == 'p' && oponente == 'r');
    }
}
