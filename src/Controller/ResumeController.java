package Controller;

import Models.Game;
import Views.SecretCombinationView;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public void resume() {
        this.game.clear();
    }

    public void writeSecretCombination(){
        new SecretCombinationView(new ResumeController(this.game)).writeSecret();
    }

}
