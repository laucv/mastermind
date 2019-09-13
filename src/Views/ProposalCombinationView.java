package Views;

import Models.ProposalCombination;

import javax.swing.*;
import java.util.Scanner;

public class ProposalCombinationView {
    private ProposalCombination proposalCombination;

    public ProposalCombinationView(ProposalCombination proposalCombination) {
        this.proposalCombination = proposalCombination;
    }

    public void read(){
        Scanner scanner = new Scanner(System.in);
        String string;
        do {
            string = scanner.nextLine();
        }while (!proposalCombination.isValid(string));
    }

    public ProposalCombination getProposalCombination(){
        return this.proposalCombination;
    }

    public void write(){
        System.out.println(this.proposalCombination + "->");
    }
}
