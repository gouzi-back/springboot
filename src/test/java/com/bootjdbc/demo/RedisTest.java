package com.bootjdbc.demo;

import com.bootjdbc.demo.util.RedisUtils;
import jdk.nashorn.internal.ir.CatchNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hyy
 * @date2021/6/2 15:02
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    private final static Logger logger= LoggerFactory.getLogger(RedisTest.class);


    @Test
    public void cheShi(){

        ////连接本地的 Redis 服务
        //Jedis jedis = new Jedis("192.168.201.128");
        //// 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        //jedis.auth("1234");
        //System.out.println("连接成功");
        ////查看服务是否运行
        //System.out.println("服务正在运行: "+jedis.ping());
        if (redisUtils.hasKey("hyy")){
            String v= redisUtils.get("hyy");
            logger.info("=================有该keys==================值为"+v);
            redisUtils.getAndSet("hyy",dateTime());
            String up=redisUtils.get("hyy");
            logger.info("=================更新后的keys=================="+up);
        }else{
            logger.info("==================没有该keys===================");
        }



    }

    @Test
    public void set(){
//        if (redisUtils.hasKey("setJiHe")){
//            System.out.println("该key存在了");
//        }else {
//            redisUtils.sAdd("setJiHe","张家港","常熟","昆山");
//            System.out.println(redisUtils.sSize("setJiHe"));
//        }
//        redisUtils.sAdd("setJiHe","张家港","常熟","昆山");
//        redisUtils.setMembers("setJiHe").stream().forEach(System.out::print);


        redisUtils.zAdd("zSet","南京",1);
        redisUtils.zAdd("zSet","苏州",2);
        redisUtils.zAdd("zSet","无锡",3);
        redisUtils.zRangeWithScores("zSet",0,10).stream().forEach(System.out::println);


    }


    private String dateTime(){
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


}
