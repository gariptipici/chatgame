/* GaripT created on 26.07.2020 */

package task.singleprocesschatgame.data;


import static java.lang.System.out;

/**
 * @author GaripT
 * receives and sends messages
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
     *
     * Here I applied a recursive strategy for messaging process.
     * sendMessage method calls receiveMessage method of receiver instance.
     */
    public void sendMessage(String message, Player to) {
        out.println(this.name + ": sent message '" + message + "'");
        to.receiveMessage(message, this);
    }

    /**
     * Here applied a recursive strategy for messaging process.
     * receiveMessage method calls receiveMessage method of receiver instance.
     *
     * @param message to be received
     * @param from sender instance
     */
    public void receiveMessage(String message, Player from) {
        out.println(this.name + ": received message '" + message + "'");
        messageCount++;
        if (messageCount <= 10)
            sendMessage(message + " " + messageCount, from);
    }
    
    @Override
    public String toString() {
        return name;
    }
}