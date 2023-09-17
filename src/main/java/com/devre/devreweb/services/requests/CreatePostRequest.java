package com.devre.devreweb.services.requests;

import com.devre.devreweb.entities.Image;
import com.devre.devreweb.entities.PostImage;
import com.devre.devreweb.entities.PostKeyword;
import com.devre.devreweb.entities.PostPostKeyword;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CreatePostRequest {
    public String title;
    public int categoryId;
    public Set<PostImage> postImageHashSet = new HashSet<>();
    public Long userId;
    public String metaTitle;
    public String content;
    public List<PostPostKeyword> postKeywordList = new ArrayList<>();
}
