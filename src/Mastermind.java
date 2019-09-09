import java.util.Scanner;
import java.util.Random;

public class Mastermind {

    public static void main(String[] args) {
        char secreto[];
        char colores[] = {'r', 'b', 'y', 'g', 'o', 'p'};
        char[] prediccion = new char[4];
        String prediccionString;
        Scanner teclado = new Scanner(System.in);
        int intento = 1;
        boolean correcto;
        boolean ganador = false;

        secreto = generarSecreto(colores);

        System.out.println("---------------------------\nBienvenido a Mastermind. \nEl secreto es ****. \nComencemos.\n---------------------------");

        while (intento <= 10 && !ganador) {
            do {
                System.out.println("***Intento " + intento + "***");
                System.out.println("Introduce tu predicción: ");
                prediccionString = teclado.nextLine();
                correcto = true;
                for (int i = 0; i < prediccion.length && correcto; i++) {
                    prediccion[i] = prediccionString.charAt(i);
                    correcto = false;
                    for (int j = 0; j < colores.length; j++) {
                        if (prediccion[i] == colores[j]) {
                            correcto = true;
                        }
                    }
                }
                if(!correcto){
                    System.out.println("Valor introducido incorrecto, los valores válidos son: r, g, y, b, o, p.");
                }
            } while (!correcto);

            //comprobacion negros
            int negros = 0;
            for (int i = 0; i < secreto.length; i++) {
                if (secreto[i] == prediccion[i]) {
                    negros++;
                }
            }
            if (negros == secreto.length) {
                System.out.println("¡Has ganado!");
                ganador = true;
            }

            if(!ganador){
                //comprobacion blancos
                int blancos = 0;
                for (int i = 0; i < secreto.length; i++) {
                    for (int j = 0; j < secreto.length; j++) {
                        if (secreto[i] == prediccion[j]) {
                            blancos++;
                        }
                    }
                }
                blancos = blancos - negros;
                System.out.println("Hay " + negros + " negros");
                System.out.println("Hay " + blancos + " blancos");
                intento++;
            }

        }
        if(!ganador){
            System.out.println("¡Has perdido! El secreto era: " + secreto);
        }
    }

    public static char[] generarSecreto(char[] colores){
        char[] secreto = new char[4];
        int random;
        char[] copiaColores = new char[colores.length];
        for (int i =0; i<colores.length; i++){
            copiaColores[i] = colores[i];
        }
        Random rand = new Random();

        for (int i = 0; i < secreto.length; i++){
            random = rand.nextInt(copiaColores.length - i);
            secreto[i] = copiaColores[random];
            for (int j = random; j < copiaColores.length - 1; j++){
                copiaColores[j] = copiaColores[j + 1];
            }
        }
        return secreto;
    }

}
