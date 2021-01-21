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

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author: Jackey 2020/12/22
 */
@Service
public class OrderService {

    @SentinelResource(value = "sayHello", fallback = "sayHelloFail")
    public String sayHello() {
        return "Hello, World!";
    }

    public String sayHelloFail() {
        return "I am sorry!";
    }

}