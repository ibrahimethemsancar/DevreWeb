package com.devre.devreweb.services.requests;

import lombok.Data;

@Data
public class CreateCommentRequest {
    public String text;
    public Long postId;
    public Long userId;
}
