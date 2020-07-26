/* GaripT created on 26.07.2020 */
package task.multiprocesschatgame;


import task.multiprocesschatgame.data.Player;
import task.multiprocesschatgame.service.ChatService;

/**
 * 
 * @author GaripT
 * Main class of chat from different processes task
 *
 */
public class Chat {

    private Chat() {
    }

    /**
     * Main method of chat from different processes task
     * 
     * @param player1Name name of first player
     * @param Player2Name name of second player
     * @param message message to be sent
     */
    public static void runInDifferentProcesses(String player1Name, String Player2Name, String message) {
    	
    	ChatService chatRoom = new ChatService();
    	
        Player initiator = new Player(player1Name, message, true);
        Player receiver = new Player(Player2Name, message, false);
        
        initiator.registerToChatRoom(chatRoom);
        receiver.registerToChatRoom(chatRoom);
        
        chatRoom.startChat(message);
        
    }
}

