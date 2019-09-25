package Views;

import Controller.Controller;

public class GameView {

    private Controller controller;
    private ProposalCombinationView proposalCombinationView;
    private ResultView resultView;

    public GameView (Controller controller){
        this.controller = controller;
        proposalCombinationView = new ProposalCombinationView(controller);
        resultView = new ResultView(controller);
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
            resultView.write(i);
        }
        System.out.println("********************");
    }
}
