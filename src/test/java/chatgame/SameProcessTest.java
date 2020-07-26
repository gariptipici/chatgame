package chatgame;


import org.junit.Before;
import org.junit.Test;

import task.singleprocesschatgame.model.Player;
import task.singleprocesschatgame.service.ChatService;

public class SameProcessTest {
	
	Player initiator;
	Player receiver;
	ChatService chatRoom;
	String message;
	
	@Before
	public void init() {
		initiator = new Player("initiator");
		receiver = new Player("receiver");
		chatRoom = new ChatService();
		initiator.registerToChatRoom(chatRoom);
        receiver.registerToChatRoom(chatRoom);
        message = "hey";
        
	}
	
	@Test
	public void testFactory() {
	}
}

