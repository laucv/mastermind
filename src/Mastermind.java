import Controller.Controller;
import Controller.Logic;
import Views.ControlView;
import Views.View;

public class Mastermind {

    private Logic logic;
    private View view;

    private Mastermind() {
        this.logic = new Logic();
        this.view = new ControlView();
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

    public void play() throws NullPointerException{
        Controller controller;
        try{
            do {
                controller = this.logic.getController();
                this.view.interact(controller);
            } while (controller != null);
        }catch (NullPointerException e){
        }

    }

}
