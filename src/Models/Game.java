package Models;

import Views.ProposalCombinationView;

public class Game {
    private SecretCombination secretCombination;
    private ProposalCombination[] proposalsCombination;
    private Result[] results;
    private int attempt;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposalsCombination = new ProposalCombination[10];
        this.results = new Result[10];
        for (int i = 0; i < 10; i++) {
            this.proposalsCombination[i] = new ProposalCombination();
            this.results[i] = new Result();
        }
        this.attempt = 0;
    }

    public boolean isFinished() {
        return this.secretCombination.isWinner(this.results[this.getAttempt()]);
    }

    public void saveAttempt() {
        this.secretCombination.setDead(this.proposalsCombination[attempt], this.results[attempt]);
        this.secretCombination.setWounded(this.proposalsCombination[attempt], this.results[attempt]);
    }

    public SecretCombination getSecretCombination() {
        return secretCombination;
    }

    public void setNewProposalCombination(int attempt, ProposalCombination proposalCombination) {
        this.proposalsCombination[attempt].colors = proposalCombination.colors;
    }

    public Result[] getResults() {
        return this.results;
    }

    public int getAttempt() {
        return this.attempt;
    }

    public ProposalCombination[] getProposalsCombination() {
        return this.proposalsCombination;
    }

    public void nextAttempt() {
        this.attempt++;
    }

}

