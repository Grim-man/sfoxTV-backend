package com.sfox.pojo;
import lombok.Data;

import java.sql.Date;

/**
 *  视频信息
 */
@Data
public class Videos {
    private int VideoID;
    private String VideoTitle;
    private String VideoDescription;
    private int UploaderID;
    private Date UploadDate;
    private String VideoURL;
    private int CategoryID;
}
