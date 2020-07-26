/* GaripT created on 26.07.2020 */
package task.multiprocesschatgame.data;

import java.util.concurrent.BlockingQueue;

import task.multiprocesschatgame.service.ChatService;

import static java.lang.System.out;

/**
 * @author GaripT receives and sends messages if instance is initiator, it also
 *         initiates the messaging process
 */
public final class Player implements Runnable {

	private final String name;

	private final String message;

	private final Boolean initiator;

	private Integer messageCount = 0;

	/**
	 * The queue acts like outbox of initiator and inbox of receiver
	 */
	private BlockingQueue<String> sent;
	
	/**
	 * The queue acts like inbox of initiator and outbox of receiver
	 */
	private BlockingQueue<String> received;

	public Player(String name, String message, Boolean initiator) {
		this.name = name;
		this.message = message;
		this.initiator = initiator;
	}

	/**
	 * puts the initial message to the queue that is the inbox of receiver and also outbox of sender
	 * @param message the initial message
	 */
	private void sendInitMessage(String message) {
		try {
			sent.put(message);
			out.println(this + ": sent message '" + message + "'");
		} catch (InterruptedException interrupted) {
		}
	}

	/**
	 * puts message to the queue that is the inbox of receiver and also outbox of sender
	 * @param message the message to be sent
	 */
	private void send(String message) {
		String reply = message + " " + messageCount;
		try {
			// Puts message to ArrayBlockingQueue, waits if it is full
			sent.put(reply);
			out.println(this.name + ": sent message '" + reply + "'");
		} catch (InterruptedException interrupted) {
		}
	}

	/**
	 * gets message from the queue that is the outbox of receiver and also inbox of sender
	 * 
	 * @return returns message from queue
	 */
	private String receive() {
		try {
			// Gets message from ArrayBlockingQueue, waits if queue is empty
			String message = received.take();

			messageCount = messageCount + 1;
			out.println(this.name + ": received message '" + message + "'");
			return message;
		} catch (InterruptedException e) {
		}
		return null;
	}

	/**
	 * Registers the player to the service
	 * @param service
	 */
	public void registerToChatRoom(ChatService service) {
		sent = service.getSent();
		received = service.getReceived();
		if (service.getInitiator() == null) {
			sent = service.getSent();
			received = service.getReceived();
			service.setInitiator(this);
			System.out.println("Player " + this + " registered...");
		} else if (service.getReceiver() == null) {
			sent = service.getReceived();
			received = service.getSent();
			service.setReceiver(this);
			System.out.println("Player " + this + " registered...");
		}
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void run() {
		if (initiator) {
			sendInitMessage(message);
		}
		while (true) {
			if (messageCount <= 9) {
				String receivedMessage = receive();
				send(receivedMessage);
			} else {
				break;
			}
		}
	}
}
