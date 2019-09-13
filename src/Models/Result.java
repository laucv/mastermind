package Models;

public class Result {

    private int wounded;

    private int dead;

    public Result() {
        this.wounded = 0;
        this.dead = 0;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public void setWounded(int wounded) {
        this.wounded = wounded;
    }

    public int getDead() {
        return dead;
    }

    public int getWounded() {
        return wounded;
    }

}
