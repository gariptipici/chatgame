/* GaripT created on 26.07.2020 */
package task;

import static task.chatgame.Chat.runInSameProcess;
import static task.concurrentchatgame.Chat.runInDifferentProcesses;


public class Game {

    public static void main(String... args) {
    	if ("sameprocess".equals(args[0])) {
    		runInSameProcess(args[1], args[2], args[3]);
		} else {
			runInDifferentProcesses();
		}
    }
}