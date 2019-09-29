package Views;

import Controller.ContinueController;
import Controller.ResumeController;
import Controller.StartController;

public abstract class View {

    protected StartController startController;
    protected ContinueController continueController;
    protected ResumeController resumeController;

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

    public abstract void start();

    public abstract void continueGame();

    public abstract boolean resume();

    private void finishedGame(boolean finished){
        if(finished){
            System.out.println("You win!");
        } else{
            System.out.println("You lose!");
            this.resumeController.writeSecretCombination();
        }
    }
}
