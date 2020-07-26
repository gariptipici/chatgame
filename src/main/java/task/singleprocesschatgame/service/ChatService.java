/* GaripT created on 26.07.2020 */

package task.singleprocesschatgame.service;

import task.singleprocesschatgame.model.Player;

public class ChatService {
	
	private Player initiator; 
	private Player receiver;
	
	public void startChat(String message) {
		if(initiator == null || receiver == null) {
			System.out.println("Not enough players registered to chat...");
			return;
		}
    	System.out.println("Chat in same process started...");
        initiator.sendMessage(message, receiver, this);
        System.out.println("Chat in same process finished...");
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

	public void deliver(String message, Player from, Player to) {
		to.receiveMessage(message, from, this);
		
	}
	
	
	
	

}
