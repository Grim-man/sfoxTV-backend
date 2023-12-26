package com.sfox.pojo;
import lombok.Data;

import java.sql.Date;

/**
 *  用户收藏
 */
@Data
public class Favorites {
    private int FavoritesID;
    private int UserID;
    private int VideoID;
    private Date FavoritesDate;
}
