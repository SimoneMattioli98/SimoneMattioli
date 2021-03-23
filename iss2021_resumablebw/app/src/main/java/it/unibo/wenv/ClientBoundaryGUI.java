package it.unibo.wenv;


import it.unibo.annotations.ArilRobotSpec;
import it.unibo.consolegui.ConsoleGui;
import it.unibo.interaction.IssOperations;
import it.unibo.supports.IssCommSupport;
import it.unibo.supports.RobotApplicationStarter;

@ArilRobotSpec
public class ClientBoundaryGUI {
    private RobotInputController controller;
    //Constructor
    public ClientBoundaryGUI(IssOperations rs){
        IssCommSupport rsComm = (IssCommSupport)rs;
        controller = new RobotInputController(rsComm, true, true );
        rsComm.registerObserver( controller );
        System.out.println("ClientBoundaryWebSocketGUI | CREATED with rsComm=" + rsComm);
        new ConsoleGui(controller);
        controller.doBoundary();
    }



    public static void main(String args[]){
        try {
            System.out.println("ClientBoundaryWebsockBasicAsynch | main start n_Threads=" + Thread.activeCount());
            Object appl = RobotApplicationStarter.createInstance(ClientBoundaryGUI.class);
            System.out.println("ClientBoundaryWebsockBasicSynch  | appl n_Threads=" + Thread.activeCount());
            System.out.println("ClientBoundaryWebsockBasicAsynch | main end n_Threads=" + Thread.activeCount());
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}

