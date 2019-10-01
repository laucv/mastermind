package Views;

import Controller.ContinueController;
import Controller.Controller;
import Controller.ResumeController;
import Controller.StartController;
import Models.Game;

import java.util.Scanner;

public class ControlView extends View {

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
        this.finishedGame(resumeController.isFinished());
        resumeController.resume(dialogue());
    }

    private void finishedGame(boolean finished) {
        if (finished) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }


    public boolean dialogue() {
        System.out.println("Would you like to play again? Y/N");
        return Character.toLowerCase(new Scanner(System.in).nextLine().charAt(0)) == 'y';
    }

    @Override
    public void visit(ContinueController continueController) {
        GameView gameView = new GameView(continueController);
        gameView.writeAttempt();
        continueController.setNewProposalCombination(new ProposalCombinationView(continueController).readProposalCombination());
        gameView.setNewAttempt();
        continueController.saveAttempt();
        gameView.writeResults();
        if (continueController.getAttempt() < 10 && !continueController.isFinished()) {
            continueController.nextAttempt();
        } else {
            continueController.next();
        }
    }
}
