/* GaripT created on 26.07.2020 */

package task.singleprocesschatgame.model;


import static java.lang.System.out;

import task.singleprocesschatgame.service.ChatService;

/**
 * @author GaripT
 * receives and sends messages via ChatService
 */
public final class Player {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    private Integer messageCount = 0;

    /**
     * @param message message to be sent
     * @param to receiver instance
     * @param service chatroom to send message
     *
     * Here I applied a recursive strategy for messaging process.
     * sendMessage method calls receiveMessage method of receiver instance.
     */
    public void sendMessage(String message, Player to, ChatService service) {
        out.println(this.name + ": sent message '" + message + "'");
        service.deliver(message, this, to);
    }

    /**
     * Here applied a recursive strategy for messaging process.
     * receiveMessage method calls receiveMessage method of receiver instance.
     *
     * @param message to be received
     * @param from sender instance
     * @param service chatroom to send message
     */
    public void receiveMessage(String message, Player from, ChatService service) {
        out.println(this.name + ": received message '" + message + "'");
        messageCount++;
        if (messageCount <= 10)
            sendMessage(message + " " + messageCount, from, service);
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
    
    @Override
    public String toString() {
        return name;
    }
}