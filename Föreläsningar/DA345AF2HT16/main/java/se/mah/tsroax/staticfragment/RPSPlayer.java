package se.mah.tsroax.staticfragment;

/**
 * Created by tsroax on 30/08/16.
 */
import java.util.Random;

public class RPSPlayer {
    private Random random = new Random();

    public int nextChoice() {
        int choice = random.nextInt(3);
        if(choice == 0) {
            return RPSController.ROCK;
        } else if(choice==1) {
            return RPSController.PAPER;
        } else {
            return RPSController.SCISSORS;
        }
    }
}
