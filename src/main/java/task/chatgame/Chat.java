/* GaripT created on 26.07.2020 */

package task.chatgame;

public class Chat {
    private Chat() {
    }

    public static void runInSameProcess() {
    	System.out.println("Chat in same process started...");
        Player initiator = new Player("initiator");
        Player receiver = new Player("receiver");
        initiator.sendMessage("hey", receiver);
    }
}
