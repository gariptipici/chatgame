/* GaripT created on 26.07.2020 */

package task.multiprocesschatgame.service;


import task.multiprocesschatgame.data.Player;

public class ChatService {
	
	Player initiator; 
	Player receiver;
	
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
}
