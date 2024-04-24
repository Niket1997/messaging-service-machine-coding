package org.rio.interfaces.repositories;

import org.rio.entities.Message;

import java.util.List;

public interface IMessageRepository {
    Message createMessage(Message message);

    Message updateMessage(Message message);

    Message getMessage(String messageId);

    List<Message> getUnreadMessages(String userId);

    List<Message> getAllMessages(String userI);

}
