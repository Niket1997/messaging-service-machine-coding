package org.rio.services;

import org.rio.entities.Message;
import org.rio.entities.User;
import org.rio.excetions.messages.MessageNotFoundException;
import org.rio.interfaces.IMessageService;
import org.rio.interfaces.IUserService;
import org.rio.interfaces.repositories.IMessageRepository;
import org.rio.records.messages.CreateMessageRequest;
import org.rio.records.messages.UpdateMessageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService implements IMessageService {
    IUserService userService;
    IMessageRepository messageRepository;

    public MessageService(IUserService userService, IMessageRepository messageRepository) {
        this.userService = userService;
        this.messageRepository = messageRepository;
    }

    @Override
    public Message createMessage(CreateMessageRequest request) {
        // add validations -> check if both from & to users exists
        User from = userService.getUser(request.from());
        User to = userService.getUser(request.to());

        // create message
        Message message = new Message(from, to, request.text());
        return messageRepository.createMessage(message);
    }

    @Override
    public Message updateMessage(String messageId, UpdateMessageRequest request) {
        Message message = messageRepository.getMessage(messageId);
        message.setRead(request.isRead());
        return messageRepository.updateMessage(message);
    }

    @Override
    public Message getMessage(String id) {
        return messageRepository.getMessage(id);
    }

    @Override
    public List<Message> getUnreadMessages(String userId) {
        // check if user exists
        userService.getUser(userId);
        return messageRepository.getUnreadMessages(userId);
    }

    @Override
    public List<Message> getAllMessagesForUser(String userId) {
        // TODO: add get all messages API
        return null;
    }
}
