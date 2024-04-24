package org.rio.interfaces;

import org.rio.entities.Message;
import org.rio.records.messages.CreateMessageRequest;
import org.rio.records.messages.UpdateMessageRequest;

import java.util.List;

public interface IMessageService {
    Message createMessage(CreateMessageRequest request);

    Message updateMessage(String messageId, UpdateMessageRequest request);

    Message getMessage(String id);

    List<Message> getUnreadMessages(String userId);

    List<Message> getAllMessagesForUser(String userId);
}
