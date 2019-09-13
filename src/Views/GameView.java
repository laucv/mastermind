package Views;

import Models.Game;
import Models.ProposalCombination;

public class GameView {

    Game game;
    ProposalCombinationView proposalCombinationView;

    public GameView(Game game) {
        this.game = game;
    }

    public void writeStartGame(){
        System.out.println("--------------------------------\n         Mastermind");
        new SecretCombinationView(this.game.getSecretCombination()).write();
        System.out.println("--------------------------------");
    }

    public void writeAttempt(){
        System.out.println("***Attempt " + (this.game.getAttempt() + 1) + "***");
        System.out.println("Propose a combination: ");
    }

    public void readAttempt(){
        proposalCombinationView = new ProposalCombinationView(new ProposalCombination());
        proposalCombinationView.read();
    }

    public void setNewAttempt(){
        this.game.setNewProposalCombination(this.game.getAttempt(), proposalCombinationView.getProposalCombination());
    }

    public void writeResults(){
        System.out.println("Previusly results: \n");
        for (int i = 0; i < this.game.getAttempt() + 1; i++){
            new ProposalCombinationView(this.game.getProposalsCombination()[i]).write();
            new ResultView(this.game.getResults()[i]).write();
        }
        System.out.println("********************");
    }
}
