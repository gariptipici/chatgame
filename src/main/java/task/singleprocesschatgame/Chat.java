/* GaripT created on 26.07.2020 */

package task.singleprocesschatgame;

import task.singleprocesschatgame.model.Player;
import task.singleprocesschatgame.service.ChatService;

/**
 * 
 * @author GaripT
 * Main class of chat from same process task
 *
 */
public class Chat {
    private Chat() {
    }

    /**
     * Main method of chat from same process task
     * 
     * @param player1Name name of first player
     * @param Player2Name name of second player
     * @param message message to be sent
     */
    public static void runInSameProcess(String player1Name, String Player2Name, String message) {
    	
        Player initiator = new Player(player1Name);
        Player receiver = new Player(Player2Name);
        
        ChatService chatRoom = new ChatService();
        
        initiator.registerToChatRoom(chatRoom);
        receiver.registerToChatRoom(chatRoom);
        
        chatRoom.startChat(message);
        
        
    }
}
