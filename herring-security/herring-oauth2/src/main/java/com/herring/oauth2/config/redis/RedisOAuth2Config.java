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
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
// import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
// import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
// import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
// import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
// import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
// import org.springframework.security.oauth2.provider.token.TokenStore;
//
// import javax.annotation.Resource;
// import javax.sql.DataSource;
//
// /**
//  * @author: Jackey 2021/2/3
//  */
// @Configuration
// @EnableAuthorizationServer
// public class RedisOAuth2Config extends AuthorizationServerConfigurerAdapter {
//
//     @Resource
//     private DataSource dataSource;
//     @Resource
//     private TokenStore redisTokenStore;
//     @Resource
//     private PasswordEncoder passwordEncoder;
//     @Resource
//     private AuthenticationManager authenticationManager;
//     @Resource
//     private UserDetailsService herringUserDetailsService;
//
//     @Override
//     public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//         /**
//          * redis token 方式
//          */
//         endpoints.authenticationManager(authenticationManager)
//                 .userDetailsService(herringUserDetailsService)
//                 .tokenStore(redisTokenStore);
//     }
//
//     @Override
//     public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//         JdbcClientDetailsServiceBuilder jcsb = clients.jdbc(dataSource);
//         jcsb.passwordEncoder(passwordEncoder);
//     }
//
//     @Override
//     public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//         security.allowFormAuthenticationForClients();
//         security.checkTokenAccess("isAuthenticated()");
//         security.tokenKeyAccess("isAuthenticated()");
//     }
//
// }