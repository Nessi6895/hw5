package ru.sbt.hw5.terminal;

import java.util.Scanner;

/**
 * Created by Артем on 05.08.2016.
 */
public class TerminalImpl implements Terminal {


    private final TerminalServer terminalServer;
    private final PinValidator pinValidator;

    public TerminalImpl() {
        this.terminalServer = new TerminalServer();
        this.pinValidator = new PinValidator();
        Scanner sc = new Scanner(System.in);
        while (!pinValidator.isPinInserted()) {
            System.out.println("Insert pin:");
            try {
                pinValidator.insertPin(sc.nextInt());
            } catch (AccountBannedException e) {
                System.out.println(e.getMessage());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException w) {
                }
            } catch (TerminalException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void putMoney(int num) {
        try {
            if (num % 100 == 0) {
                terminalServer.putMoney(num);
            } else {
                System.out.println("The sum must be divisible by 100!\n");
            }
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getMoney(int num) {
        try {
            if (num % 100 == 0) {
                terminalServer.getMoney(num);
            } else {
                System.out.println("The sum must be divisible by 100!\n");
            }
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printStatus() {
        try {
            System.out.println("Money remained: " + terminalServer.getAccountStatus() + "\n");
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void work() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Print 1 to put money.\nPrint 2 to get money.\nPrint 3 to get account status.\nPrint 9 to exit.\nPrint 0 to see this message again.");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Print sum.");
                    putMoney(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Print sum.");
                    getMoney(sc.nextInt());
                    break;
                case 3:
                    this.printStatus();
                    break;
                case 9:
                    System.out.println("Good bye!");
                    return;
            }
        }
    }
}
