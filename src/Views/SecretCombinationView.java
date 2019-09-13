package Views;

import Models.SecretCombination;

public class SecretCombinationView {

    private SecretCombination secretCombination;

    public SecretCombinationView(SecretCombination secretCombination){
        this.secretCombination = secretCombination;
    }

    public void write(){
        System.out.println("The secret combination is: ****");
    }
}
