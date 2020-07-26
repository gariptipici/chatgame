/* GaripT created on 26.07.2020 */
package task.multiprocesschatgame;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import task.multiprocesschatgame.data.Player;
import task.multiprocesschatgame.factory.PlayerFactory;
import task.multiprocesschatgame.service.ChatService;

public class Chat {

    private Chat() {
    }

    public static void runInDifferentProcesses(String player1Name, String Player2Name, String message) {
    	PlayerFactory playerService = PlayerFactory.getInstance();
    	
    	// Used 1 item-sized ArrayBlockingQueues to hold sent and received messages considering thread-safety
        BlockingQueue<String> sent = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> received = new ArrayBlockingQueue<>(1);

    	
        Player initiator = playerService.createPlayer(player1Name, message, true, sent, received);
        Player receiver = playerService.createPlayer(Player2Name, message, false, received, sent);
        
        ChatService chatRoom = new ChatService();
        
        initiator.registerToChatRoom(chatRoom);
        receiver.registerToChatRoom(chatRoom);
        
        chatRoom.startChat(message);
        
    }
}

