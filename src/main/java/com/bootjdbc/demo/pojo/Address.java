package com.bootjdbc.demo.pojo;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @author
 * @date2021/6/2 14:54
 */

public class Address {
    @Indexed
    private String city;
    @Indexed
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
