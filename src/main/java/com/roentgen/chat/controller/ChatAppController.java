package com.roentgen.chat.controller;

import com.roentgen.chat.model.Chat;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatAppController {


  @MessageMapping("/chat_register")
  @SendTo("/topic/go_public")
  public Chat register (@Payload Chat chat, SimpMessageHeaderAccessor headerAccessor) {
    headerAccessor.getSessionAttributes().put("user", chat.getSender());
    return chat;
  }

  @MessageMapping("/chat_sender")
  @SendTo("/topic/go_public")
  public Chat sendMessage (@Payload Chat chat) {
    return chat;
  }

}
