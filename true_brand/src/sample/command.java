package sample;
// this command is the blue-print and will be taken to create object or action that need to be implemented or execute when call.
public interface command {
    void execute();
    void unexecute();
}
