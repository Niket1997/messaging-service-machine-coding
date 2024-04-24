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
1. User, UserService, UserController, UserRepository
2. Message, MessageService, MessageController, MessageRepository

### User 
User:
1. id - user provided
2. name
3. created_at (metadata)

UserController:
1. UserService
2. CRUD over users

UserService:
1. UserRepository
2. CRUD over user

UserRepository:
1. Map<String, User> users
2. CRUD over users

### Message
Message:
1. UUID id
2. User from
2. User to
3. String text
4. int createdAt
5. boolean isRead -> update by client

MessageController:
1. MessageService
2. CRUD over messages
3. getUnreadMessagesAPI

MessageService:
1. MessageRepository
2. CRUD APIs
3. getUnreadMessagesAPI

MessageRepository:
1. Map<String, Message> messages
2. CRUD over messages
3. getUnreadMessagesAPI
