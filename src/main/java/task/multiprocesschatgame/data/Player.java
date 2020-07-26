/* GaripT created on 26.07.2020 */
package task.multiprocesschatgame.data;

import java.util.concurrent.BlockingQueue;

import task.multiprocesschatgame.service.ChatService;

import static java.lang.System.out;

/**
 * @author GaripT
 * receives and sends messages
 * if instance is initiator, it also initiates the messaging process
 */
public final class Player implements Runnable {

    private final String name;
    
    private final String message;

    private final Boolean initiator;

    private Integer messageCount = 0;

    private final BlockingQueue<String> sent;
    private final BlockingQueue<String> received;

    public Player(String name, String message, Boolean initiator, BlockingQueue<String> sent, BlockingQueue<String> received) {
        this.name = name;
        this.message = message;
        this.initiator = initiator;
        this.sent = sent;
        this.received = received;
    }

    /**
     * puts message to the ArrayBlockingQueue
     */
    private void sendInitMessage(String message) {
        try {
            sent.put(message);
            out.println(this + ": sent message '" + message + "'");
        } catch (InterruptedException interrupted) {
        }
    }

    private void send(String message) {
        String reply = message + " " + messageCount;
        try {
            // Puts message to ArrayBlockingQueue, waits if it is full
            sent.put(reply);
            out.println(this.name + ": sent message '" + reply + "'");
        } catch (InterruptedException interrupted) {
        }
    }
    
    public void registerToChatRoom(ChatService service) {
		if(service.getInitiator() == null) {
			service.setInitiator(this);
			System.out.println("Player " + this + " registered...");
 		} else if(service.getReceiver() == null) {
			service.setReceiver(this);
			System.out.println("Player " + this + " registered...");
		} 		
	}

    /**
     * gets message from the ArrayBlockingQueue
     * @return returns message from queue
     */
    private String receive() {
        try {
            // Gets message from ArrayBlockingQueue, waits if queue is empty
            String message = received.take();

            messageCount = messageCount + 1;
            out.println(this.name + ": received message '" + message + "'");
            return message;
        } catch (InterruptedException e) {
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        if (initiator) {
            sendInitMessage(message);
        }
        while (true) {
            if (messageCount <= 9) {
                String receivedMessage = receive();
                send(receivedMessage);
            } else {
                break;
            }
        }
    }

}
