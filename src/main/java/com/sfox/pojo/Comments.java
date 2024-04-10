package com.sfox.pojo;
import lombok.Data;

import java.sql.Date;

/**
 *  评论区
 */
@Data
public class Comments {
    private int CommentID;
    private int UserID;
    private int VideoID;
    private String CommentContent;
    private Date CommentDate;
}
