package Views;

import Models.Result;

public class ResultView {

    private Result result;

    public ResultView(Result result){
        this.result = result;
    }

    public void write(){
        System.out.print("Dead: " + this.result.getDead());
        System.out.print(" & Wounded: " + this.result.getWounded());
        System.out.println("");
    }
}
