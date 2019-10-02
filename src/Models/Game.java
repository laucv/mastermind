package Models;

public class Game {
    static final int NUMERO_DE_INTENTOS = 10;
    private SecretCombination secretCombination;
    private ProposalCombination[] proposalsCombination;
    private Result[] results;
    private int attempt;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposalsCombination = new ProposalCombination[NUMERO_DE_INTENTOS];
        this.results = new Result[NUMERO_DE_INTENTOS];
        for (int i = 0; i < NUMERO_DE_INTENTOS; i++) {
            this.proposalsCombination[i] = new ProposalCombination();
            this.results[i] = new Result();
        }
        this.attempt = 0;
    }

    public boolean isFinished() {
        return this.secretCombination.isWinner(this.results[this.attempt]);
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

