package ru.sbt.hw5.terminal;

/**
 * Created by Артем on 05.08.2016.
 */
public class PinValidator {

    private final int pin;
    private boolean isCorrectPin;
    private int wrongTries;

    PinValidator(int pin) {
        this.pin = pin;
        this.isCorrectPin = false;
        this.wrongTries = 0;
    }

    public PinValidator() {
        this.pin = 1111;
        this.isCorrectPin = false;
        this.wrongTries = 0;
    }

    public void insertPin(int newPin) {
        if (!(this.pin == newPin)) {
            wrongTries++;
            if (wrongTries == 3) {
                this.wrongTries = 0;
                throw new AccountBannedException("Wrong pin! Account banned!\n");
            }
            throw new TerminalException("Wrong pin! Wrong tries: " + (this.wrongTries) + "!\n");
        } else isCorrectPin = true;
    }


    public boolean isPinInserted() {
        return isCorrectPin;
    }
}
