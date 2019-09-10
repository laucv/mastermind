import java.util.Scanner;
import java.lang.Character;

public class Juego {

    private char[] colores = {'r', 'b', 'y', 'g', 'o', 'p'};

    public void iniciarJuego() {

        Scanner teclado = new Scanner(System.in);
        int intento = 1;
        CombinacionSecreta combinacionSecreta = new CombinacionSecreta();
        CombinacionPropuesta combinacionPropuesta = new CombinacionPropuesta();

        do {
            combinacionSecreta.setSecreto(colores);
            System.out.println("---------------------------\nBienvenido a Mastermind. \nEl secreto es ****. \nComencemos.\n---------------------------");

            do {

                do {
                    System.out.println("***Intento " + intento + "***");
                    System.out.println("Introduce tu predicción: ");
                } while (!combinacionPropuesta.comprobarCondicionesCombinacionPropuesta(teclado.nextLine(), colores, combinacionPropuesta, combinacionSecreta));
                combinacionPropuesta.setHeridos(0);
                combinacionPropuesta.setMuertos(0);

                combinacionPropuesta.comprobarMuertos(combinacionPropuesta, combinacionSecreta);
                combinacionPropuesta.comprobarHeridos(combinacionPropuesta, combinacionSecreta);

                System.out.println("Hay " + combinacionPropuesta.getMuertos() + " muertos");
                System.out.println("Hay " + combinacionPropuesta.getHeridos() + " heridos");
                intento++;

            } while (intento <= 10 && !combinacionPropuesta.comprobarCombinacionPropuesta(combinacionPropuesta, combinacionSecreta));

            if (combinacionPropuesta.comprobarCombinacionPropuesta(combinacionPropuesta, combinacionSecreta)) {
                System.out.println("¡Has ganado!");
            } else {
                System.out.println("¡Has perdido! El secreto era: " + combinacionSecreta.toString());
            }

            System.out.println("¿Deseas seguir jugando? S/N:");
            intento = 1;
        } while (Character.toLowerCase(teclado.nextLine().charAt(0)) == 's');

        teclado.close();

    }
}
