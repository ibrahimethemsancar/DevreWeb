package com.devre.devreweb.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class BaseEntity {
    private Date createDate;
    private Date updateDate;
    private Long createdByUserId;
}
