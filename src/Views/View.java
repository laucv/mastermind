package Views;

import Models.Game;

import java.util.Scanner;

public class View {

    private Game game;

    public View(Game game) {
        this.game = game;
    }

    public void initGameView() {
        boolean resume;
        do {
            this.start();
            boolean finished;
            do {
                this.continueGame();
                finished = this.game.isFinished();
                this.game.nextAttempt();
            } while (!finished && this.game.getAttempt() < 10);
            this.finishedGame(finished);
            resume = this.resume();
            if (resume) {
                this.game.clear();
            }
        } while (resume);
    }

    private void start() {
        new GameView(this.game).writeStartGame();
    }

    private void continueGame() {
        GameView gameView = new GameView(this.game);
        gameView.writeAttempt();
        gameView.readAttempt();
        gameView.setNewAttempt();
        this.game.playAttempt();
        gameView.writeResults();
    }

    private boolean resume() {
        System.out.println("Would you like to play again? Y/N");
        return Character.toLowerCase(new Scanner(System.in).nextLine().charAt(0)) == 'y';
    }

    private void finishedGame(boolean finished){
        if(finished){
            System.out.println("You win!");
        } else{
            System.out.println("You lose!");
        }
    }
}
