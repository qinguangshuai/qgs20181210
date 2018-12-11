package com.bw.qgs.qgs20181210.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * date:2018/12/10    19:14
 * author:秦广帅(Lenovo)
 * fileName:User
 */
@Entity(nameInDb = "user_in")
public class User {
 @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "content")   //代表存入数据库
    private String content;
    @Property(nameInDb = "createtime")
    private String createTime;
    @Property(nameInDb = "imageUrls")
    private String imgUrls;
    @Property(nameInDb = "jid")
    private int jid;
    @Property(nameInDb = "uid")
    private int uid;

    private String phone;

    @Generated(hash = 866573503)
    public User(Long id, String content, String createTime, String imgUrls, int jid,
            int uid, String phone) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.imgUrls = imgUrls;
        this.jid = jid;
        this.uid = uid;
        this.phone = phone;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImgUrls() {
        return this.imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public int getJid() {
        return this.jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   

}
