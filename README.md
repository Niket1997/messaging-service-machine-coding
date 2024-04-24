## Question
Design a simple peer-to-peer messaging server where a user can be registered with a unique human readable username and they can start messaging other users.

Functional Requirements :
1. Create a new user on the server
2. Send a new message
3. Fetch unread messages
4. Get chat history with a specific user (Optional)
   Question: Do we need to update message

Create backend APIs and required logic for the above requirements


Most important requirement - A running code which has all the basic functional
requirements

## Objects
1. User
2. Message
3. ChatServer


User:
1. id - user provided
2. name
3. created_at (metadata)

UserController:
1. HashMap<String, User> users
2. CRUD over users

Message:
1. UUID id
2. User from
2. User to
3. String text
4. int createdAt
5. boolean isRead -> update by client

MessageController:
1. Map<String, Message> messages
2. CRUD over messages
3. UserController uc
4. markRead

// not needed
MessageView:
1. List<Message> sent;
2. List<Received> received

ChatServer:
1. UserController uc
