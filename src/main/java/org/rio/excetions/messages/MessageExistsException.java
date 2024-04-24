package org.rio.excetions.messages;

public class MessageExistsException extends RuntimeException{
    public MessageExistsException(String message) {
        super(message);
    }
}
