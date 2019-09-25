package Views;

import Controller.Controller;
import Models.ProposalCombination;

import java.util.Scanner;

public class ProposalCombinationView {

    private Controller controller;

    public ProposalCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void read(){
        Scanner scanner = new Scanner(System.in);
        String string;
        do {
            string = scanner.nextLine();
        }while (!this.controller.isValid(string));
    }

    public ProposalCombination getProposalCombination(){
        return this.controller.getProposalCombination();
    }

    public void write(int position){
        System.out.print(this.controller.getProposalCombination(position) + "->");
    }
}
