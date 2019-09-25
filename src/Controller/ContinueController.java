package Controller;

import Models.Game;
import Views.GameView;
import Views.ProposalCombinationView;

public class ContinueController extends Controller {

    public ContinueController(Game game) {
        super(game);
    }

    public boolean isFinished() {
        return this.game.isFinished();
    }

    public void nextAttempt() {
        this.game.nextAttempt();
    }

    public void saveAttempt() {
        this.game.saveAttempt();
    }

    public void readAttempt() {
        ProposalCombinationView proposalCombinationView = new ProposalCombinationView(new Controller(this.game));
        proposalCombinationView.read();
        this.game.setNewProposalCombination(this.game.getAttempt(), proposalCombinationView.getProposalCombination());
    }

    public void writeAttempt() {
        new GameView(new Controller(this.game)).writeAttempt();
    }

    public void setNewAttempt() {
        new GameView(new Controller(this.game)).setNewAttempt();
    }

    public void writeResults() {
        new GameView(new Controller(this.game)).writeResults();
    }


}
