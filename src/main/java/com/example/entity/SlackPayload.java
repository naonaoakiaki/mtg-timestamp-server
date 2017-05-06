package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

/**
 * Created by naonaoakiaki on 2017/05/06.
 */
@AllArgsConstructor
public class SlackPayload{
    @JsonProperty
    private String channel;
    @JsonProperty
    private String username;
    @JsonProperty
    private String text;
    @JsonProperty
    private String icon_emoji;
}
