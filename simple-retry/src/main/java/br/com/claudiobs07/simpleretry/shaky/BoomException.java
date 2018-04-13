package br.com.claudiobs07.simpleretry.shaky;

public class BoomException extends RuntimeException {

    BoomException(String message) {
        super(message);
    }
}
