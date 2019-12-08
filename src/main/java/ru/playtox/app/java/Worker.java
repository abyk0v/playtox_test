package ru.playtox.app.java;

/**
 * Класс осуществляет запрос по переводу случайной суммы с одного счета на другой,
 * через случайные промежутки времени
 */
public class Worker implements Runnable {

    private Account fromAccount, toAccount;
    private TransferService transferService;

    public Worker(Account fromAccount, Account toAccount,
                  TransferService transferService) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transferService = transferService;
    }

    public void run() {
        try
        {
            while (true) {
                transferService.transfer(RandomFactory.getRandomMoneyForTransfer(),
                                         fromAccount,
                                         toAccount);
                Thread.sleep( RandomFactory.getRandomTimeout() );
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
