/* GaripT created on 26.07.2020 */

package task.singleprocesschatgame;

import task.singleprocesschatgame.factory.PlayerFactory;
import task.singleprocesschatgame.model.Player;
import task.singleprocesschatgame.service.ChatService;

public class Chat {
    private Chat() {
    }

    public static void runInSameProcess(String player1Name, String Player2Name, String message) {
    	
    	PlayerFactory playerFactory = PlayerFactory.getInstance();
        Player initiator = playerFactory.createPlayer(player1Name);
        Player receiver = playerFactory.createPlayer(Player2Name);
        
        ChatService chatRoom = new ChatService();
        
        initiator.registerToChatRoom(chatRoom);
        receiver.registerToChatRoom(chatRoom);
        
        chatRoom.startChat(message);
        
        
    }
}
