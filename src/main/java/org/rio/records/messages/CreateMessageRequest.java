package org.rio.records.messages;

public record CreateMessageRequest(
        String from,
        String to,
        String text
) {
}
