import java.util.Scanner;
import java.util.Random;
import java.lang.Character;

public class Mastermind {

    public static void main(String[] args) {
        char[] secreto = new char[4];
        char[] colores = {'r', 'b', 'y', 'g', 'o', 'p'};
        char[] prediccion = new char[4];
        char[] propuesta = new char[4];
        String prediccionString;
        Scanner teclado = new Scanner(System.in);
        int intento = 1;
        boolean correcto;
        boolean ganador = false;
        char seguir;
        int muertos = 0;
        int heridos = 0;
        Combinacion combinacion = new Combinacion(secreto, colores, propuesta, muertos, heridos);

        do {
            combinacion.secreto = generarSecreto(colores);

            System.out.println("---------------------------\nBienvenido a Mastermind. \nEl secreto es ****. \nComencemos.\n---------------------------");

            while (intento <= 10 && !ganador) {
                do {
                    System.out.println("***Intento " + intento + "***");
                    System.out.println("Introduce tu predicción: ");
                    prediccionString = teclado.nextLine();
                    correcto = true;
                    if(prediccionString.length() != secreto.length){
                        correcto = false;
                        System.out.println("Solo puedes introducir cuatro colores.");
                    }
                    for (int i = 0; i < prediccion.length && correcto; i++) {
                        combinacion.propuesta[i]= prediccionString.charAt(i);
                        correcto = false;
                        for (int j = 0; j < colores.length; j++) {
                            if (combinacion.propuesta[i] == combinacion.colores[j]) {
                                correcto = true;
                            }
                        }
                    }
                    if (!correcto) {
                        System.out.println("Los colores válidos son: r, g, y, b, o, p.");
                    }

                    if (combinacion.propuesta[0] == combinacion.propuesta[1] || combinacion.propuesta[0] == combinacion.propuesta[2] ||
                            combinacion.propuesta[0] == combinacion.propuesta[3] || combinacion.propuesta[1] == combinacion.propuesta[2] ||
                            combinacion.propuesta[1] == combinacion.propuesta[3] || combinacion.propuesta[2] == combinacion.propuesta[3]){
                        correcto = false;
                        System.out.println("No puedes repetir colores.");
                    }

                } while (!correcto);

                //comprobacion muertos
                for (int i = 0; i < combinacion.secreto.length; i++) {
                    if (combinacion.secreto[i] == combinacion.propuesta[i]) {
                        combinacion.muertos++;
                    }
                }
                //comprobar ganador
                if (combinacion.muertos == combinacion.secreto.length) {
                    System.out.println("¡Has ganado!");
                    ganador = true;
                }

                if (!ganador) {
                    //comprobacion heridos
                    for (int i = 0; i < combinacion.secreto.length; i++) {
                        for (int j = 0; j < combinacion.secreto.length; j++) {
                            if (combinacion.secreto[i] == combinacion.propuesta[j]) {
                                combinacion.heridos++;
                            }
                        }
                    }
                    combinacion.heridos = combinacion.heridos - combinacion.muertos;
                    System.out.println("Hay " + combinacion.muertos + " muertos");
                    System.out.println("Hay " + combinacion.heridos + " heridos");
                    intento++;
                    combinacion.muertos = 0;
                    combinacion.heridos = 0;
                }

            }

            if (!ganador) {
                System.out.println("¡Has perdido! El secreto era: " + combinacion.getSecreto().toString());
            }

            System.out.println("¿Deseas seguir jugando? S/N:");
            seguir = teclado.nextLine().charAt(0);
            intento = 1;
            ganador = false;
        } while (Character.toLowerCase(seguir) == 's');
    }

    private static char[] generarSecreto(char[] colores) {
        char[] secreto = new char[4];
        int random;
        char[] copiaColores = new char[colores.length];
        for (int i = 0; i < colores.length; i++) {
            copiaColores[i] = colores[i];
        }
        Random rand = new Random();

        for (int i = 0; i < secreto.length; i++) {
            random = rand.nextInt(copiaColores.length - i);
            secreto[i] = copiaColores[random];
            for (int j = random; j < copiaColores.length - 1; j++) {
                copiaColores[j] = copiaColores[j + 1];
            }
        }
        return secreto;
    }

}
