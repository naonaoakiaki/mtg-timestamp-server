package com.example.entity;

import lombok.AllArgsConstructor;

/**
 * Created by naonaoakiaki on 2017/05/06.
 */
@AllArgsConstructor
public class SlackPayload {
    private String channel;
    private String username;
    private String text;
    private String icon_emoji;
}
