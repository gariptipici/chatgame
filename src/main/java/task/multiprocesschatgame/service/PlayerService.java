/* GaripT created on 26.07.2020 */

package task.multiprocesschatgame.service;

import java.util.concurrent.BlockingQueue;

import task.multiprocesschatgame.data.Player;

public class PlayerService {
	private static PlayerService service;
	
	private PlayerService() {
	}
	
	public static PlayerService getInstance() {
		if(service == null) {
			service = new PlayerService();
		}
		return service;
	}
	
	public Player createPlayer(String name, Boolean initiator, BlockingQueue<String> sent, BlockingQueue<String> received) {
		System.out.println("Player " + name + " is created...");
		return new Player(name, initiator, sent, received);
	}
}
