import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            game();
            System.out.println("\nQuieres volver a jugar?: 1-SI 2.-NO");
            opc = sc.nextInt();
        }while(opc != 2);
    }

    //Funcion principal del juego
    private static void game(){
        //Palabras a adivinar
        List<String> lista = Arrays.asList("uunouu","uunouu","uunouu","uunouu");
        List letras_correctas = new ArrayList();
        List letras_incorrectas = new ArrayList();
        int intentos = 6;
        int aciertos = 0;
        boolean juego_terminado = false;

        do {
            //visualizacion del juego
            System.out.println("***********************************");
            String palabra = elegir_palabra1(lista);
            int letras_unicas = elegir_palabra2(palabra);
            System.out.println("letras incorrectas: " + letras_incorrectas);
            System.out.println("Vidas: " + intentos);
            System.out.println("***********************************\n");
            mostras_nuevo_tablero(palabra,letras_correctas);

            List<Object> getList = chequear_letra(pedir_letra(), palabra, intentos, aciertos, letras_correctas, letras_incorrectas, letras_unicas);
            Object intento = getList.get(0);
            intentos = (int) intento;
            Object terminado = getList.get(1);
            Object acierto = getList.get(2);
            aciertos = (int) acierto;

            juego_terminado = (boolean) terminado;

        } while (juego_terminado != true);

    }

    //Funcion para elegir la palabra aleatoriamente
    private static String elegir_palabra1(List<String> lista) {
        Random aleatorio = new Random();
        int nAleatorio = aleatorio.nextInt(lista.size());
        String palabra_elegida = lista.get(nAleatorio);
        return palabra_elegida;
    }

    //Funcion para la longitud de la palabra quitando los caracteres repetidos
    private static int elegir_palabra2(String palabra) {
        char[] abecedario = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int[] contadores = new int[abecedario.length];

        for (int i = 0; i < palabra.length(); i++) {
            //Obtenemos posicion en abecedario y aumentamos la equivalente en contadores
            char caracter = palabra.toLowerCase().charAt(i);
            for (int j = 0; j < abecedario.length; j++) {
                if (caracter == abecedario[j])
                    contadores[j]++;
            }
        }
        int letras_unicas=0;
        //Caracteres contados, comprobamos que contadores son distintos de 0 e informarmos
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] > 0) {
                letras_unicas++;
            }
        }
        return letras_unicas;
    }

    //Funcion para pedir la letra al usuario
    private static String pedir_letra() {
        boolean es_valida = false;
        String abecdeario = "abcdefghijklmnñopqrstuvwxyz";
        Scanner scan = new Scanner(System.in);

        String letra_elegida = "";

        do{
            System.out.println("Introduce un letra: ");
            letra_elegida = scan.next();
            letra_elegida = letra_elegida.toLowerCase();
            //Comprobamos que el usuario halla escogido correctamente la letra
            if(abecdeario.contains(letra_elegida) && (letra_elegida.length() == 1)){
                es_valida = true;
            }
            else{
                System.out.println("No has elegido una letra correcta");
            }
        }while(es_valida != true);
        return letra_elegida;
    }

    //Funcion donde se va a ir mostrando los cambios que vayan ocurriendo en el juego
    private static void mostras_nuevo_tablero(String palabra_elegida, List<String>letras_correctas){
        List lista_oculta = new ArrayList();
        //Creamos un ciclo for para recorrer toda la palabra letra por letra
        for (String l: palabra_elegida.split("")){
            if(letras_correctas.contains(l)){
                lista_oculta.add(l);
            }
            else{
                lista_oculta.add("_");
            }
        }

        System.out.println(" ".concat(String.valueOf(lista_oculta)));
    }

    //Funcion para comprobar lo ocurridos el la funcion pasada
    private static List<Object> chequear_letra(String letra_elegida, String palabra_oculta, int vidas, int coincidencias, List<String>letras_correctas, List<String>letras_incorrectas,int letras_unicas){
        boolean fin = false;
        //Comprobamos que la letra escogida se encuentre el la pabra escogida aleatoriamente
        if(palabra_oculta.contains(letra_elegida)){
            letras_correctas.add(letra_elegida);
            coincidencias+=1;
        }
        else{
            letras_incorrectas.add(letra_elegida);
            vidas-=1;
        }
        if(vidas == 0){
            fin = perder(palabra_oculta);
        }
        else if(coincidencias == letras_unicas){
            fin = ganar(palabra_oculta,letras_correctas);
        }

        return Arrays.asList(vidas,fin,coincidencias);
    }

    //Funcion para cunado hallamos perdido
    public static Boolean perder(String palabra){
        System.out.println("Te has quedado sin vidas");
        System.out.println("La paralabra oculta era: " + palabra);
        return true;
    }

    //Funcion de ganar
    public static Boolean ganar(String palabra_descubierta, List<String>letras_correctas){
        mostras_nuevo_tablero(palabra_descubierta,letras_correctas);
        System.out.println("Felicitaciones has encontrado la palabra!!!!");
        return true;
    }
}