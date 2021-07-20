package net.zamora.exceptions;

public class NotFoundException extends Exception {

    public final String messageId;

    public NotFoundException(String messageId, String message) {
        super(message);
        this.messageId = messageId;
    }
}
