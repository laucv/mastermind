package Views;

import Controller.Controller;
import Controller.ControllerVisitor;

public abstract class View implements ControllerVisitor {

    public abstract void interact(Controller controller);
}
