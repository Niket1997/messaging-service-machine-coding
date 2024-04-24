package org.rio.controller;

import org.rio.entities.Message;
import org.rio.interfaces.IMessageService;
import org.rio.records.messages.CreateMessageRequest;
import org.rio.records.messages.UpdateMessageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    IMessageService messageService;

    public MessageController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/v1")
    public Message createMessage(@RequestBody CreateMessageRequest request) {
        return messageService.createMessage(request);
    }

    @PutMapping("/v1/{messageId}")
    Message updateMessage(@RequestBody UpdateMessageRequest request, @PathVariable String messageId) {
        return messageService.updateMessage(messageId, request);
    }

    @GetMapping("/v1/{messageId}")
    Message getMessage(@PathVariable String messageId) {
        return messageService.getMessage(messageId);
    }

    @GetMapping("/v1/unread/{userId}")
    List<Message> getUnreadMessages(@PathVariable String userId) {
        return messageService.getUnreadMessages(userId);
    }

    @GetMapping("/v1")
    List<Message> getAllMessagesForUser(String userId) {
        return messageService.getAllMessagesForUser(userId);
    }
}
