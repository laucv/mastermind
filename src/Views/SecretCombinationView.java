package Views;

import Controller.Controller;

public class SecretCombinationView {

    private Controller controller;

    public SecretCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void writeHiddenSecret() {
        System.out.println("The secret combination is: ****");
    }

    public void writeSecret() {
        System.out.println("The secret combination was: " + this.controller.getSecretCombination() + "\n");
    }
}
