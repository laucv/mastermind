import Models.Game;
import Views.View;

public class Mastermind {

    private Game game;
    private View view;

    private Mastermind(){
        this.game = new Game();
        this.view = new View(game);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

    public void play(){
        view.initGameView();
    }

}
