import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;
import ru.netology.game.Game;

public class GameTest {
    Game game = new Game();

    Player one = new Player(01, "Alex", 19);
    Player two = new Player(02, "Ivan", 17);
    Player three = new Player(03, "Petya", 22);
    Player four = new Player(04, "Roma", 19);
    Player five = new Player(05, "Vasya", 20);


    @Test
    public void prizePlaceOfTheParticipant() {
        game.register(three);
        game.register(five);

        int actual = game.round("Petya", "Vasya");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prizePlaceOfTheParticipant2() {
        game.register(one);
        game.register(four);

        int actual = game.round("Alex", "Roma");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void prizePlaceOfTheParticipant3() {
        game.register(two);
        game.register(three);

        int actual = game.round("Ivan", "Petya");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void registrationStatusOfTheParticipant() {
        game.register(one);
        game.register(four);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Roma");
        });
    }

    @Test
    public void registrationStatusOfTheParticipant2() {
        game.register(one);
        game.register(two);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "Vasya");
        });
    }
}