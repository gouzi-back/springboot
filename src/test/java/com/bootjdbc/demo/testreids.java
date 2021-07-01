package com.bootjdbc.demo;/**
 * @Auther:haha
 * @Date:2021/6/27 - 06 - 27 23:11
 * @Description:com.bootjdbc.demo
 * @Version: 1.0
 */


import com.bootjdbc.demo.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.util.Calendar;

/**
 * testreids
 * <功能详细描述>
 *
 * @author 周宇峰
 * @version [版本号, 2021/6/27 23:11]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
public class testreids {

    public String dateTime(){
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        //Date date=new Date();
        //String time= sdf.format(date);
        String time=null;
        Calendar calendar=Calendar.getInstance();
        int weekDay=calendar.get(Calendar.DAY_OF_WEEK)-1;
        switch(weekDay){
            case 0:
                time="星期天";
                break;
            case 1:
                time="星期一";
                break;
            case 2:
                time="星期二";
                break;
            case 3:
                time="星期三";
                break;
            case 4:
                time="星期四";
                break;
            case 5:
                time="星期五";
                break;
            case 6:
                time="星期六";
                break;
            default:
                time="发生异常";
                break;
        }
        return time;
    }
    public static void main(String[] args) {

     //   //连接本地的 Redis 服务
     //Jedis jedis = new Jedis("192.168.201.128");
     //   // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
     //    jedis.auth("1234");
     //   System.out.println("连接成功");
     //   //查看服务是否运行
     //   System.out.println("服务正在运行: "+jedis.ping());
        String time=null;
        Calendar calendar=Calendar.getInstance();
        int weekDay=calendar.get(Calendar.DAY_OF_WEEK)-1;
        switch(weekDay){
            case 0:
                time="星期天";
                break;
            case 1:
                time="星期一";
                break;
            case 2:
                time="星期二";
                break;
            case 3:
                time="星期三";
                break;
            case 4:
                time="星期四";
                break;
            case 5:
                time="星期五";
                break;
            case 6:
                time="星期六";
                break;
            default:
                time="发生异常";
                break;
        }
        System.out.println(time);
    }

}
