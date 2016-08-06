package ru.sbt.hw5.terminal;

/**
 * Created by Артем on 05.08.2016.
 */
public class TerminalServer {

    private int money;

    public TerminalServer(int money) {
        this.money = money;
    }

    public TerminalServer() {
        new TerminalServer(0);
    }

    public boolean isConnected() {
        if (Math.random() < 0.5) {
            return true;
        } else {
            throw new TerminalException("Can't connect to server.\nTry again later.\n");
        }
    }


    public void getMoney(int sum) {
        try {
            isConnected();
        } catch (TerminalException e) {
            throw new TerminalException(e.getMessage());
        }
        if (money > sum) {
            this.money -= sum;
            System.out.println("Successful!\n");
        } else {
            throw new TerminalException("Not enough money!\n");
        }

    }

    public void putMoney(int sum) {
        try {
            isConnected();
        } catch (TerminalException e) {
            throw new TerminalException(e.getMessage());
        }
        this.money += sum;
        System.out.println("Successful!\n");
    }

    public int getAccountStatus() {
        try {
            isConnected();
        } catch (TerminalException e) {
            throw new TerminalException(e.getMessage());
        }
        return this.money;
    }
}
