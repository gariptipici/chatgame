/* GaripT created on 26.07.2020 */

package task.singleprocesschatgame.service;

import task.singleprocesschatgame.data.Player;

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
	
	public Player createPlayer(String name) {
		System.out.println("Player " + name + " is created...");
		return new Player(name);
	}
}
