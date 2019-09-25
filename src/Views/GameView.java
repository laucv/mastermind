package Views;

import Controller.Controller;

public class GameView {

    private Controller controller;
    private ProposalCombinationView proposalCombinationView;

    public GameView (Controller controller){
        this.controller = controller;
        proposalCombinationView = new ProposalCombinationView(controller);
    }

    public void writeStartGame(){
        System.out.println("--------------------------------\n         Mastermind");
        new SecretCombinationView(controller.getSecretCombination()).write();
        System.out.println("--------------------------------");
    }

    public void writeAttempt(){
        System.out.println("***Attempt " + (controller.getAttempt() + 1) + "***");
        System.out.println("Propose a combination: ");
    }

    public void setNewAttempt(){
        controller.setNewProposalCombination(controller.getAttempt(), controller.getProposalCombination());
    }

    public void writeResults(){
        System.out.println("Previusly results: \n");
        for (int i = 0; i < controller.getAttempt() + 1; i++){
            proposalCombinationView.write(i);
            new ResultView(controller.getResults()[i]).write();
        }
        System.out.println("********************");
    }
}
