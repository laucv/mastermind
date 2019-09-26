package Controller;

import Models.Game;
import Models.State;
import Views.SecretCombinationView;

public class ResumeController extends Controller {

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    public void resume(boolean newGame) {
        if (newGame) {
            this.game.clear();
            this.state.reset();
        } else {
            this.state.next();
        }
    }

    public void writeSecretCombination(){
        new SecretCombinationView(new ResumeController(this.game)).writeSecret();
    }

}