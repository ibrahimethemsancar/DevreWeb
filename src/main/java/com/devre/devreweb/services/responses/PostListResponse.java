package com.devre.devreweb.services.responses;

import com.devre.devreweb.entities.PostImage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PostListResponse {
    private Long postId;
    private String title;
    private PostImage postImage;
    private String writerName;
    private Date date;
}
