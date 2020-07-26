/* GaripT created on 26.07.2020 */

package task.multiprocesschatgame.service;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import task.multiprocesschatgame.data.Player;

/**
 * 
 * @author GaripT
 * Starts chat process also holds the inbox and outbox
 */
public class ChatService {
	
	private Player initiator; 
	private Player receiver;
	
	// Used 1 item-sized ArrayBlockingQueues to hold sent and received messages considering thread-safety
    private BlockingQueue<String> sent = new ArrayBlockingQueue<>(1);
    private BlockingQueue<String> received = new ArrayBlockingQueue<>(1);

	/**
	 * Chat process is started
	 * @param message
	 */
	public void startChat(String message) {
		if(initiator == null || receiver == null) {
			System.out.println("Not enough player registered to chat...");
			return;
		}
    	System.out.println("Chat in different process started...");

        new Thread(initiator).start();
        new Thread(receiver).start();
        
    }
	
	public Player getInitiator() {
		return initiator;
	}

	public Player getReceiver() {
		return receiver;
	}

	public void setInitiator(Player initiator) {
		this.initiator = initiator;
	}

	public void setReceiver(Player receiver) {
		this.receiver = receiver;
	}

	public BlockingQueue<String> getSent() {
		return sent;
	}

	public BlockingQueue<String> getReceived() {
		return received;
	}
	
	
}
