package ru.uoles.proj.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.uoles.proj.websocket.Message;

@Controller
public class ChatWebSocketController {

    @MessageMapping("/send")
    @SendTo("/queue/chat")
    public Message greeting(Message message) {
        return message;
    }
}
