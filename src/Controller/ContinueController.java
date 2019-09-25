package Controller;

import Models.Game;

public class ContinueController extends Controller {

    public ContinueController(Game game) {
        super(game);
    }

    public boolean isFinished() {
        return this.game.isFinished();
    }

    public void nextAttempt(){
        this.game.nextAttempt();
    }

    public void saveAttempt(){
        this.game.saveAttempt();
    }

}
