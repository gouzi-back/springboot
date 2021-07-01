package com.bootjdbc.demo.controller;/**
 * @Auther:haha
 * @Date:2021/4/23 - 04 - 23 16:41
 * @Description:com.hyy.controller
 * @Version: 1.0
 */

import org.springframework.stereotype.Controller;

/**
 * IndexController
 * <功能详细描述>
 *
 * @author
 * @version [版本号, 2021/4/23 16:41]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class IndexController {

        public String index(){
            return "index";
        }
}
