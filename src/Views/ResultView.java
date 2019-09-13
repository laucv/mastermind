package Views;

import Models.Result;

public class ResultView {

    private Result result;

    public ResultView(Result result){
        this.result = result;
    }

    public void write(){
        System.out.println("Dead: " + this.result.getDead());
        System.out.println("Wounded: " + this.result.getWounded());
    }
}
