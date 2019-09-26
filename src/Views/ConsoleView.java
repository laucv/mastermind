package Views;

import Controller.ContinueController;
import Controller.ResumeController;
import Controller.StartController;

import java.util.Scanner;

public class ConsoleView extends View {

    public ConsoleView(StartController startController, ContinueController continueController, ResumeController resumeController) {
        super(startController, continueController, resumeController);
    }

    @Override
    public void continueGame() {
        this.continueController.writeAttempt();
        this.continueController.readAttempt();
        this.continueController.setNewAttempt();
        this.continueController.saveAttempt();
        this.continueController.writeResults();
    }

    @Override
    public void start(){
        new GameView(this.startController).writeStartGame();
    }

    @Override
    public boolean resume(){
        System.out.println("Would you like to play again? Y/N");
        return Character.toLowerCase(new Scanner(System.in).nextLine().charAt(0)) == 'y';
    }
}
