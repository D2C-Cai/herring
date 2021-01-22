package com.herring.orders;

/*
@(#)herring   2020-12-22
 
Copyright (c) 2011-2020 杭州湖畔网络技术有限公司 
保留所有权利 
本软件为杭州湖畔网络技术有限公司所有及包含机密信息，须遵守其相关许可证条款进行使用。
Copyright (c) 2011-2020 HUPUN Network Technology CO.,LTD.
All rights reserved.
This software is the confidential and proprietary information of HUPUN
Network Technology CO.,LTD("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into with HUPUN.
Website：http://www.hupun.com
*/

import com.herring.member.MemberClient;
import com.herring.product.ProductClient;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Jackey 2020/12/22
 */
@RestController
@RequestMapping("/orders")
public class HelloController {

    @Resource
    private OrdersService ordersService;
    @Resource
    private ProductClient productClient;
    @Resource
    private MemberClient memberClient;

    @Trace(operationName = "orders.hello()")
    @RequestMapping("/hello")
    public String hello() {
        String product = productClient.service();
        String member = memberClient.service();
        return ordersService.sayHello() + product + member;
    }

    @RequestMapping("/service")
    public String service() {
        return ordersService.sayHello();
    }

}