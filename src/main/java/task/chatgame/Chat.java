/* GaripT created on 26.07.2020 */

package task.chatgame;

import task.chatgame.data.Player;
import task.chatgame.service.ChatService;
import task.chatgame.service.PlayerService;

public class Chat {
    private Chat() {
    }

    public static void runInSameProcess(String player1Name, String Player2Name, String message) {
    	
        PlayerService playerService = PlayerService.getInstance();
        Player initiator = playerService.createPlayer(player1Name);
        Player receiver = playerService.createPlayer(Player2Name);
        
        ChatService chatRoom = new ChatService();
        chatRoom.registerPlayer(initiator);
        chatRoom.registerPlayer(receiver);
        
        chatRoom.startChat(message);
        
        
    }
}
