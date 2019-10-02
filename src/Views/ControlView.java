package Views;

import Controller.ContinueController;
import Controller.Controller;
import Controller.ResumeController;
import Controller.StartController;


import java.util.Scanner;

public class ControlView extends View {

    static final int POSICION_REAL = 9;

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startController.start();
        new GameView(startController).writeStartGame();
    }

    @Override
    public void visit(ResumeController resumeController) {
        resumeController.resume(dialogue());
    }


    private void finishedGame(boolean finished, ContinueController continueController) {
        if (finished) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
            new SecretCombinationView(continueController).writeSecret();
        }
    }


    private boolean dialogue() {
        System.out.println("Would you like to play again? Y/N");
        return Character.toLowerCase(new Scanner(System.in).nextLine().charAt(0)) == 'y';
    }

    @Override
    public void visit(ContinueController continueController) {
        GameView gameView = new GameView(continueController);
        boolean finished;
        gameView.writeAttempt();
        continueController.setNewProposalCombination(new ProposalCombinationView(continueController).readProposalCombination());
        gameView.setNewAttempt();
        continueController.saveAttempt();
        gameView.writeResults();
        finished = continueController.isFinished();
        continueController.nextAttempt();
        if (finished || continueController.getAttempt() > POSICION_REAL) {
            this.finishedGame(finished, continueController);
            continueController.next();
        }

    }
}
