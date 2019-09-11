import java.util.Scanner;
import java.lang.Character;

public class Mastermind {

    public static void main(String[] args) {

        int attempt = 0;
        Scanner scanner = new Scanner(System.in);
        SecretCombination secretCombination = new SecretCombination();
        ProposalCombination[] proposalsCombination = new ProposalCombination[10];
        Result[] results = new Result[10];
        ProposalCombination proposalCombination = new ProposalCombination();
        Result result = new Result();

        do {

            System.out.println("---------------------------\nMastermind. \nThe secret is****. \nLet's get started.\n---------------------------");
            do {

                do {
                    System.out.println("***Attempt " + (attempt + 1 )+ "***");
                    System.out.println("Propose a combination: ");
                } while (!proposalCombination.isValid(scanner.nextLine()));

                result.setDead(secretCombination, proposalCombination);
                result.setWounded(secretCombination, proposalCombination);
                proposalsCombination[attempt] = proposalCombination;
                results[attempt] = result;

                for (int i = 0; i < results.length; i++) {
                    results[i].printResult();
                }

                attempt++;

            } while (attempt < 10 && !result.isWinner(secretCombination));

            if (result.isWinner(secretCombination)) {
                System.out.println("¡Has ganado!");
            } else {
                System.out.println("¡Has perdido! El secreto era: " + secretCombination.toString());
            }

            System.out.println("¿Deseas seguir jugando? S/N:");
            attempt = 0;

        } while (Character.toLowerCase(scanner.nextLine().charAt(0)) == 's');

        scanner.close();

    }

}
