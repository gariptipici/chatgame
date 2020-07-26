/* GaripT created on 26.07.2020 */

package task.singleprocesschatgame.factory;

import task.singleprocesschatgame.model.Player;

/**
 * 
 * @author GaripT
 * Creates players
 * Applied factory design pattern
 *
 */
public class PlayerFactory {
	private static PlayerFactory instance;
	
	private PlayerFactory() {
	}
	
	public static PlayerFactory getInstance() {
		if(instance == null) {
			instance = new PlayerFactory();
		}
		return instance;
	}
	
	public Player createPlayer(String name) {
		System.out.println("Player " + name + " is created...");
		return new Player(name);
	}
}
