import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Character;

public class Mastermind {

    public static void main(String[] args) {

        int turn = 0;
        Scanner scanner = new Scanner(System.in);
        SecretCombination secretCombination = new SecretCombination();
        ArrayList<ProposalCombination> proposalsCombination = new ArrayList<>();
        ArrayList<Result> results = new ArrayList<>();
        ProposalCombination proposalCombination = new ProposalCombination();
        Result result = new Result();

        do {

            System.out.println("---------------------------\nBienvenido a Mastermind. \nEl secreto es ****. \nComencemos.\n---------------------------");
            do {

                do {
                    System.out.println("***Intento " + (turn + 1 )+ "***");
                    System.out.println("Introduce tu predicción: ");
                } while (!proposalCombination.isValid(scanner.nextLine()));

                result.setDead(secretCombination, proposalCombination);
                result.setWounded(secretCombination, proposalCombination);
                System.out.println("Hay " + result.getDead() + " muertos");
                System.out.println("Hay " + result.getWounded() + " heridos");
                turn++;

            } while (turn < 10 && !result.isWinner(secretCombination));

            if (result.isWinner(secretCombination)) {
                System.out.println("¡Has ganado!");
            } else {
                System.out.println("¡Has perdido! El secreto era: " + secretCombination.toString());
            }

            System.out.println("¿Deseas seguir jugando? S/N:");
            turn = 0;

        } while (Character.toLowerCase(scanner.nextLine().charAt(0)) == 's');

        scanner.close();

    }

}
