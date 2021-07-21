package com.bootjdbc.demo.util;/**
 * @Auther: hyy
 * @Date:2021/7/7 - 07 - 07 9:01
 * @Description:com.bootjdbc.demo.util
 * @Version: 1.0
 */

import java.util.UUID;

/**
 *@author
 *@date2021/7/7 9:01
 *
 *
 */
public class UUIDUtil {
    public static String getUUID(){
     return  UUID.randomUUID().toString().replace("-", "");

    }
}
