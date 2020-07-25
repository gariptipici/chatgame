/* GaripT created on 26.07.2020 */
package task.concurrentchatgame;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Chat {

    private Chat() {
    }

    public static void runInDifferentProcesses() {
    	System.out.println("\nChat in different processes started...");
        // Used 1 item-sized ArrayBlockingQueues to hold sent and received messages considering thread-safety
        BlockingQueue<String> sent = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> received = new ArrayBlockingQueue<>(1);

        Player initiator = new Player("initiator", true, sent, received);
        Player receiver = new Player("receiver", false, received, sent);

        new Thread(initiator).start();
        new Thread(receiver).start();
    }
}

