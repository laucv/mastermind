package Models;

import java.util.ArrayList;
import java.util.Random;

public class SecretCombination extends Combination {

    public SecretCombination() {
        this.colors = new Color[4];
        this.setSecret();
    }

    public boolean isWinner(Result result){
        return result.getDead() == this.colors.length;
    }

    public void setDead(ProposalCombination proposalCombination, Result result){
        int countDead = 0;
        for(int i = 0; i < this.colors.length; i++){
            if(this.colors[i] == proposalCombination.getColor(i)){
                countDead++;
            }
        }
        result.setDead(countDead);
    }

    public void setWounded(ProposalCombination proposalCombination, Result result){
        int woundedCount = 0;
        for (int i = 0; i < this.colors.length; i++) {
            for (int j = 0; j < proposalCombination.colors.length; j++) {
                if (this.colors[i] == proposalCombination.getColor(j)) {
                    woundedCount++;
                }
            }
        }
        result.setWounded(woundedCount - result.getDead());
    }

    public void setSecret() {
        int random;
        ArrayList<Color> copiaColores = new ArrayList<Color>();
        for (Color color : Color.values()) {
            copiaColores.add(color);
        }
        Random rand = new Random();

        for (int i = 0; i < this.colors.length; i++) {
            random = rand.nextInt(copiaColores.size());
            this.colors[i] = copiaColores.get(random);
            copiaColores.remove(random);
        }
    }
}
