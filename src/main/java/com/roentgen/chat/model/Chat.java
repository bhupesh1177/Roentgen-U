package com.roentgen.chat.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Chat {
  private String content;
  private String sender;
  private MessageType type;

  public enum MessageType {
    CHAT, LEAVE, JOIN
  }
}
