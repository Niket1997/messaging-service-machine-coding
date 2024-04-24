package org.rio.services;

import org.rio.entities.Message;
import org.rio.entities.User;
import org.rio.excetions.messages.MessageNotFoundException;
import org.rio.interfaces.IMessageService;
import org.rio.records.messages.CreateMessageRequest;
import org.rio.records.messages.UpdateMessageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService implements IMessageService {
    Map<String, Message> messages;
    UserService userService;

    public MessageService(UserService userService) {
        this.userService = userService;
        messages = new HashMap<>();
    }

    @Override
    public Message createMessage(CreateMessageRequest request) {
        // add validations -> check if both from & to users exists
        User from = userService.getUser(request.from());
        User to = userService.getUser(request.to());

        // create message
        Message message = new Message(from, to, request.text());
        messages.put(message.getId(), message);
        return message;
    }

    @Override
    public Message updateMessage(String messageId, UpdateMessageRequest request) {
        if (!messages.containsKey(messageId)) throw new MessageNotFoundException("message not found");
        Message message = messages.get(messageId);
        message.setRead(true);
        return message;
    }

    @Override
    public Message getMessage(String id) {
        if (!messages.containsKey(id)) throw new MessageNotFoundException("message not found");
        return messages.get(id);
    }

    @Override
    public List<Message> getUnreadMessages(String userId) {
        User user = userService.getUser(userId);
        List<Message> unreadMessageList = new ArrayList<>();

        for (Message message : messages.values()) {
            if (message.getTo().equals(user) && !message.isRead()) {
                unreadMessageList.add(message);
            }
        }
        return unreadMessageList;
    }

    @Override
    public List<Message> getAllMessagesForUser(String userId) {
        // TODO: add get all messages API
        return null;
    }
}
