import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void shouldFindByNameCorrectIfHasPlayer() {
        Player mashaPlayer = new Player(1, "Masha", 1);

        Game game = new Game();

        game.register(mashaPlayer);

        Player expected = mashaPlayer;
        Player actual = game.findByName("Masha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameCorrectPlayerNotFound() {
        Player mashaPlayer = new Player(1, "Masha", 1);

        Game game = new Game();

        game.register(mashaPlayer);

        Player expected = null;
        Player actual = game.findByName("Sasha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisterCorrect() {
        Player sashaPlayer = new Player(1, "Sasha", 1);

        Game game = new Game();

        game.register(sashaPlayer);

        Player expected = sashaPlayer;
        Player actual = game.findByName("Sasha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfBothPlayersNotRegistered() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Sasha");
        });
    }

    @Test
    public void shouldThrowExceptionIfFirstPlayerNotRegistered() {
        Player sashaPlayer = new Player(1, "Sasha", 1);

        Game game = new Game();

        game.register(sashaPlayer);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Sasha");
        });
    }

    @Test
    public void shouldThrowExceptionIfSecondPlayerNotRegistered() {
        Player mashaPlayer = new Player(1, "Masha", 1);

        Game game = new Game();

        game.register(mashaPlayer);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Sasha");
        });
    }

    @Test
    public void shouldOutputCorrectRoundResultIfStrengthEquals() {
        Player mashaPlayer = new Player(1, "Masha", 5);
        Player sashaPlayer = new Player(2, "Sasha", 5);

        Game game = new Game();

        game.register(mashaPlayer);
        game.register(sashaPlayer);

        int expected = 0;
        int actual = game.round("Masha", "Sasha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldOutputCorrectRoundResultIfFirstPlayerStronger() {
        Player mashaPlayer = new Player(1, "Masha", 50);
        Player sashaPlayer = new Player(2, "Sasha", 5);

        Game game = new Game();

        game.register(mashaPlayer);
        game.register(sashaPlayer);

        int expected = 1;
        int actual = game.round("Masha", "Sasha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldOutputCorrectRoundResultIfSecondPlayerStronger() {
        Player mashaPlayer = new Player(1, "Masha", 50);
        Player sashaPlayer = new Player(2, "Sasha", 500);

        Game game = new Game();

        game.register(mashaPlayer);
        game.register(sashaPlayer);

        int expected = 2;
        int actual = game.round("Masha", "Sasha");

        Assertions.assertEquals(expected, actual);
    }
}
