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
        int contadorMuertos = 0;
        for (int i = 0; i < secretCombination.getSecret().length; i++) {
            if (secretCombination.getSecret()[i] == proposalCombination.colors()[i]) {
                contadorMuertos++;
            }
        }
        this.setMuertos(contadorMuertos);
    }

    public void setWounded(SecretCombination secretCombination, ProposalCombination proposalCombination) {
        int contadorHeridos = 0;
        for (int i = 0; i < secretCombination.getSecret().length; i++) {
            for (int j = 0; j < secretCombination.getSecret().length; j++) {
                if (secretCombination.getSecret()[i] == proposalCombination.colors()[j]) {
                    contadorHeridos++;
                }
            }
        }
        this.setWounded(contadorHeridos- this.getDead());
    }

    public int getWounded() {
        return wounded;
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
}
