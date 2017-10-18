import com.google.common.base.Joiner;

/**
 * Created by anastasia on 17/10/2017.
 */
public class Main {

    public static void main(String[] args) {
        String[] queenSongs = {"Brighton Rock", null, "Bohemian Rhapsody", "Show must go on", null, "The game"};
        String joined = Joiner.on(", ").skipNulls().join(queenSongs);

        System.out.println("My favorite Queen songs are: " + joined);
    }

}
