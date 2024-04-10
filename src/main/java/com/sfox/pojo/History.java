package com.sfox.pojo;
import lombok.Data;

import java.sql.Date;

/**
 *  历史观看记录
 */
@Data
public class History {
    private int HistoryID;
    private int UserID;
    private int VideoID;
    private Date PlayDate;
}
