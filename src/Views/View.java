package Views;

import Controller.ContinueController;
import Controller.ResumeController;
import Controller.StartController;

import java.util.Scanner;

public class View {

    private StartController startController;
    private ContinueController continueController;
    private ResumeController resumeController;

    public View(StartController startController, ContinueController continueController, ResumeController resumeController) {
        this.startController = startController;
        this.continueController = continueController;
        this.resumeController = resumeController;
    }

    public void initGameView() {
        boolean resume;
        do {
            this.start();
            boolean finished;
            do {
                this.continueGame();
                finished = continueController.isFinished();
                continueController.nextAttempt();
            } while (!finished && continueController.getAttempt() < 10);
            this.finishedGame(finished);
            resume = this.resume();
            if (resume) {
                resumeController.resume();
            }
        } while (resume);
    }

    private void start() {
        new GameView(this.startController).writeStartGame();
    }

    private void continueGame() {
        GameView gameView = new GameView(this.continueController);
        gameView.writeAttempt();
        continueController.readAttempt();
        gameView.setNewAttempt();
        continueController.saveAttempt();
        gameView.writeResults();
    }

    private boolean resume() {
        System.out.println("Would you like to play again? Y/N");
        return Character.toLowerCase(new Scanner(System.in).nextLine().charAt(0)) == 'y';
    }

    private void finishedGame(boolean finished){
        if(finished){
            System.out.println("You win!");
        } else{
            System.out.println("You lose!");
            resumeController.writeSecretCombination();
        }
    }
}
