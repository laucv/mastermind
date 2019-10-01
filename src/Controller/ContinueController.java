package Controller;

import Models.Game;
import Models.State;
import Views.ProposalCombinationView;

public class ContinueController extends Controller {

    public ContinueController(Game game, State state) {
        super(game, state);
    }

    public void nextAttempt() {
        this.game.nextAttempt();
    }

    public void saveAttempt() {
        this.game.saveAttempt();
    }

    public void setNewProposalCombination(ProposalCombinationView proposalCombinationView) {
        this.game.setNewProposalCombination(this.game.getAttempt(), proposalCombinationView.getProposalCombination());
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
