package com.herring.orders;

/*
@(#)herring   2021-01-22
 
Copyright (c) 2011-2021 杭州湖畔网络技术有限公司 
保留所有权利 
本软件为杭州湖畔网络技术有限公司所有及包含机密信息，须遵守其相关许可证条款进行使用。
Copyright (c) 2011-2021 HUPUN Network Technology CO.,LTD.
All rights reserved.
This software is the confidential and proprietary information of HUPUN
Network Technology CO.,LTD("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into with HUPUN.
Website：http://www.hupun.com
*/

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Jackey 2021/1/22
 */
@Service
public class MessageProducer implements CommandLineRunner {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(String... args) throws Exception {
        rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
    }

}