package ru.playtox.app.java;

import java.util.Random;
import java.util.UUID;

/**
 * Класс в который вынесены за hardcode-ые случайные значения
 * используемые в программе
 */
public class RandomFactory {
    private static Random random = new Random();

    // Случайное число от 1 до 3000
    public static Integer getRandomMoneyForTransfer() {
        return random.nextInt(3000) + 1;
    }

    // Заснуть на случайный промежуток времени, 1000-2000 мс
    public static Integer getRandomTimeout() {
        return random.nextInt(1000) + 1001;
    }

    // Уникальный идентификатор в строковом формате
    public static String getRandomID() {
        return UUID.randomUUID().toString();
    }
}
