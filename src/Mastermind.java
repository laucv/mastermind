import Controller.ContinueController;
import Controller.ResumeController;
import Controller.StartController;
import Models.Game;
import Views.GameView;
import Views.View;

public class Mastermind {

    private Game game;
    private View view;
    private StartController startController;
    private ContinueController continueController;
    private ResumeController resumeController;

    private Mastermind() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.continueController = new ContinueController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = new View(startController, continueController, resumeController);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

    public void play() {
        view.initGameView();
    }

}
