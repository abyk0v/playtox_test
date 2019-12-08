package ru.playtox.app.java;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс реализует функционал по пареллельному, атомарному переводу средст
 * с одного счета на другой.
 *
 * + дополнительный функцион по контролю за "временем выполнения" программы
 */
public class TransferService {

    private static Integer count = 0;
    private static final Logger logger = LogManager.getLogger(TransferService.class);


    synchronized public void transfer(Integer money, Account fromAccount,
                                                     Account toAccount) {
        if (fromAccount.getMoney() >= money) {
            fromAccount.setMoney(fromAccount.getMoney() - money);
            toAccount.setMoney(toAccount.getMoney() + money);
            count++;
            logger.info("Transfering Money: ("+money+") " + fromAccount.toString() +"("+fromAccount.getMoney()+")" + " -> " + toAccount.toString()+"("+toAccount.getMoney()+")" +", count=" + count);
        }
        else
            logger.info("Transfering Money: interrupt, too less money");

        // HardCode. Завершение работы программы после 30 транзакций
        if (count == 30) {
            logger.info("Number of transactions reached 30. The application closes");
            System.exit(0);
        }
    }
}
