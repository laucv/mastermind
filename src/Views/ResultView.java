package Views;

import Controller.Controller;

public class ResultView {

    private Controller controller;

    public ResultView(Controller controller){
        this.controller = controller;
    }

    public void write(int position){
        System.out.print("Dead: " + this.controller.getDead(position));
        System.out.print(" & Wounded: " + this.controller.getWounded(position));
        System.out.println("");
    }
}
