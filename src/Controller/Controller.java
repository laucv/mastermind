package Controller;

import Models.Game;
import Models.ProposalCombination;
import Models.SecretCombination;
import Models.State;


public class Controller {

    protected Game game;
    protected State state;

    public Controller(Game game, State state) {
        this.game = game;
        this.state = state;
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

}
