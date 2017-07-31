package com.example.demo.panda_channel.db.collection;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 闫雨婷 on 2017/7/31.
 */

@Entity
public class Collection {
    @Id
    private Long id;
    @Property(nameInDb = "title")
    private String title;
    @Property(nameInDb = "img")
    private String img;
    @Property(nameInDb = "date")
    private String date;
    @Generated(hash = 1342781808)
    public Collection(Long id, String title, String img, String date) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.date = date;
    }
    @Generated(hash = 1149123052)
    public Collection() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
}
