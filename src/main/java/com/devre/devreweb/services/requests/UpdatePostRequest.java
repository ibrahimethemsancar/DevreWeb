package com.devre.devreweb.services.requests;

import com.devre.devreweb.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UpdatePostRequest {
    private String title;
    private Integer categoryId;
    public Set<PostImage> postImageHashSet = new HashSet<>();
    private Long userId;
    private String metaTitle;
    private String content;
    private List<PostPostKeyword> postKeywordList = new ArrayList<>();
    private int isActv;
}
