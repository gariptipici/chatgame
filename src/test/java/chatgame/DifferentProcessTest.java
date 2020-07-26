package chatgame;


import org.junit.Before;

import task.multiprocesschatgame.data.Player;
import task.multiprocesschatgame.service.ChatService;

public class DifferentProcessTest {
	
	Player initiator;
	Player receiver;
	ChatService chatRoom;
	String message;
	
	@Before
	public void init() {
		initiator = new Player("initiator", message, true);
		receiver = new Player("receiver", message, false);
		chatRoom = new ChatService();
		initiator.registerToChatRoom(chatRoom);
        receiver.registerToChatRoom(chatRoom);
        message = "hey";
        
	}
	

}

