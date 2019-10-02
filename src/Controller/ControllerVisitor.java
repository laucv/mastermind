package Controller;

public interface ControllerVisitor {

    void visit(StartController startController);

    void visit(ContinueController moveController);

    void visit(ResumeController resumeController);
}