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
	
	public void registerPlayer(Player player) {
		if(this.initiator == null) {
			this.initiator = player;
			System.out.println("Player " + player + " registered...");
 		} else if(this.receiver == null) {
			this.receiver = player;
			System.out.println("Player " + player + " registered...");
		} else {
			System.out.println("Chat is full...");
		}
			
		
	}
	

}
