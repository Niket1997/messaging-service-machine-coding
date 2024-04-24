package org.rio.repositories;

import org.rio.entities.Message;
import org.rio.entities.User;
import org.rio.excetions.messages.MessageExistsException;
import org.rio.excetions.messages.MessageNotFoundException;
import org.rio.interfaces.repositories.IMessageRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MessageRepository implements IMessageRepository {
    Map<String, Message> messages;

    public MessageRepository() {
        this.messages = new HashMap<>();
    }

    @Override
    public Message createMessage(Message message) {
        if (messages.containsKey(message.getId())) throw new MessageExistsException("message already exists");
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message updateMessage(Message message) {
        if (!messages.containsKey(message.getId())) throw new MessageNotFoundException("message not found");
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message getMessage(String messageId) {
        if (!messages.containsKey(messageId)) throw new MessageNotFoundException("message not found");
        return messages.get(messageId);
    }

    @Override
    public List<Message> getUnreadMessages(String userId) {
        List<Message> unreadMessageList = new ArrayList<>();

        for (Message message : messages.values()) {
            if (message.getTo().getId().equals(userId) && !message.isRead()) {
                unreadMessageList.add(message);
            }
        }
        return unreadMessageList;
    }

    @Override
    public List<Message> getAllMessages(String userI) {
        return null;
    }
}
