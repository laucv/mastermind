public class Result {

    private int wounded;

    private int dead;

    public Result() {
        this.wounded = 0;
        this.dead = 0;
    }

    public boolean isWinner(SecretCombination secretCombination) {
        return this.getDead() == secretCombination.getSecret().length;
    }

    public void setDead(SecretCombination secretCombination, ProposalCombination proposalCombination) {
        int deadCount = 0;
        for (int i = 0; i < secretCombination.getSecret().length; i++) {
            if (secretCombination.getSecret()[i] == proposalCombination.colors()[i]) {
                deadCount++;
            }
        }
        this.setMuertos(deadCount);
    }

    public void setWounded(SecretCombination secretCombination, ProposalCombination proposalCombination) {
        int woundedCount = 0;
        for (int i = 0; i < secretCombination.getSecret().length; i++) {
            for (int j = 0; j < secretCombination.getSecret().length; j++) {
                if (secretCombination.getSecret()[i] == proposalCombination.colors()[j]) {
                    woundedCount++;
                }
            }
        }
        this.setWounded(woundedCount- this.getDead());
    }

    public void setWounded(int heridos) {
        this.wounded = heridos;
    }

    public int getDead() {
        return dead;
    }

    public void setMuertos(int muertos) {
        this.dead = muertos;
    }

    public void printResult(){
        System.out.println("");
    }
}
