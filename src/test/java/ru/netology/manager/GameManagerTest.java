package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.PlayerData;
import ru.netology.exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameManagerTest {
    GameManager manager = new GameManager();
    PlayerData player1 = new PlayerData(1, "Никита", 95);
    PlayerData player2 = new PlayerData(2, "Олег", 80);
    PlayerData player3 = new PlayerData(3, "Илья", 80);

    @BeforeEach
    void setup() {
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
    }

    @Test
    void shouldFirstPlayerWin() {
        assertEquals(1, manager.round("Никита", "Олег"));
    }

    @Test
    void shouldSecondPlayerWin() {
        assertEquals(2, manager.round("Илья", "Никита"));
    }

    @Test
    void shouldDraw() {
        assertEquals(0, manager.round("Олег", "Илья"));
    }

    @Test
    void shouldThrowNotRegisteredExceptionOne() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("Никита", "Руслан");
        });
    }

    @Test
    void shouldThrowNotRegisteredExceptionTwo() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("Руслан", "Никита");
        });
    }
}
