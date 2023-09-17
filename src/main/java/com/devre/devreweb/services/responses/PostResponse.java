package com.devre.devreweb.services.responses;

import com.devre.devreweb.entities.Comment;
import com.devre.devreweb.entities.Image;
import com.devre.devreweb.entities.PostImage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PostResponse {
    public String title;
    public int categoryId;
    public String categoryName;
    public Set<PostImage> postImageHashSet = new HashSet<>();
    public String firstName;
    public String lastName;
    //TODO: metatitle olacak mı? list mi olacak?
    public String metaTitle;

}
