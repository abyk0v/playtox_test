package ru.playtox.app.java;

public class Main {
    public static void main(String[] args) {
        TransferService transferService = new TransferService();

        Account account1 = new Account(RandomFactory.getRandomID(), 10000);
        Account account2 = new Account(RandomFactory.getRandomID(), 10000);

        Worker worker1 = new Worker(account1, account2, transferService);
        Thread t1 = new Thread(worker1);
        t1.start();

        Worker worker2 = new Worker(account2, account1, transferService);
        Thread t2 = new Thread(worker2);
        t2.start();
    }
}
