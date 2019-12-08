package ru.playtox.app.java;

public class Account {
    private String id;
    private Integer money;

    public Account(String id, Integer money) {
        this.id = id;
        this.money = money;
    }

    @Override
    public String toString() {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
