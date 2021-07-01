package com.bootjdbc.demo.pojo;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @author
 * @date2021/6/2 14:55
 */
public class Family {
    @Indexed
    private String type;
    @Indexed
    private String userName;

    public Family(String type, String userName) {
        this.type = type;
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Family{" +
                "type='" + type + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
