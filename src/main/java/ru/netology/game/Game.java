package ru.netology.game;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    protected List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }


    public int findById(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int round(String playerName1, String playerName2) {
        int player1 = findById(playerName1);
        int player2 = findById(playerName2);

        if (player1 == -1) {
            throw new NotRegisteredException(playerName1 + " не зарегестрирован");
        }
        if (player2 == -1) {
            throw new NotRegisteredException(playerName2 + "не зарегестрирован");
        }

        int strengthPlayer1 = players.get(player1).getStrength();
        int strengthPlayer2 = players.get(player2).getStrength();

        if (strengthPlayer1 == strengthPlayer2) {
            return 0;
        }

        if (strengthPlayer1 > strengthPlayer2) {
            return 1;
        }
        return 2;
    }
}