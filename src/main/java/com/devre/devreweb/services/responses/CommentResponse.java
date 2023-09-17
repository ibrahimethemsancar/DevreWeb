package com.devre.devreweb.services.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponse {
    public Long commentId;
    public String text;
    public String userFirstName;
    public String userLastName;
}
