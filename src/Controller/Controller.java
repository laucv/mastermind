package Controller;

import Models.Game;
import Models.ProposalCombination;
import Models.SecretCombination;
import Views.ProposalCombinationView;
import Views.SecretCombinationView;

public class Controller {

    final Game game;

    public Controller(Game game) {
        this.game = game;
    }

    public void setNewProposalCombination(int attempt, ProposalCombination proposalCombination) {
        this.game.setNewProposalCombination(attempt, proposalCombination);
    }

    public SecretCombination getSecretCombination() {
        return this.game.getSecretCombination();
    }

    public int getAttempt() {
        return this.game.getAttempt();
    }

    public void readAttempt() {
        ProposalCombinationView proposalCombinationView = new ProposalCombinationView(new Controller(this.game));
        proposalCombinationView.read();
        this.game.setNewProposalCombination(this.game.getAttempt(), proposalCombinationView.getProposalCombination());
    }

    public ProposalCombination getProposalCombination() {
        return this.game.getProposalsCombination()[this.game.getAttempt()];
    }

    public ProposalCombination getProposalCombination(int position) {
        return this.game.getProposalsCombination()[position];
    }

    public boolean isValid(String string) {
        return this.getProposalCombination().isValid(string);
    }

    public int getDead(int position){
        return this.game.getResults()[position].getDead();
    }

    public int getWounded(int position){
        return this.game.getResults()[position].getWounded();
    }

    public void writeSecretCombination(){
        new SecretCombinationView(new Controller(this.game)).writeSecret();
    }
}
