// package com.herring.oauth2.config.redis;
//
// /*
// @(#)herring   2021-02-03
//
// Copyright (c) 2011-2021 杭州湖畔网络技术有限公司
// 保留所有权利
// 本软件为杭州湖畔网络技术有限公司所有及包含机密信息，须遵守其相关许可证条款进行使用。
// Copyright (c) 2011-2021 HUPUN Network Technology CO.,LTD.
// All rights reserved.
// This software is the confidential and proprietary information of HUPUN
// Network Technology CO.,LTD("Confidential Information").  You shall not
// disclose such Confidential Information and shall use it only in
// accordance with the terms of the license agreement you entered into with HUPUN.
// Website：http://www.hupun.com
// */
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.security.oauth2.provider.token.TokenStore;
// import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
// import javax.annotation.Resource;
//
// /**
//  * @author: Jackey 2021/2/3
//  */
// @Configuration
// public class RedisTokenStoreConfig {
//
//     @Resource
//     private RedisConnectionFactory redisConnectionFactory;
//
//     @Bean
//     public TokenStore redisTokenStore() {
//         return new RedisTokenStore(redisConnectionFactory);
//     }
//
// }