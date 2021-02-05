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
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @author: Jackey 2020/12/22
 */
@RestController
@RequestMapping
public class HelloController {

    @Resource
    private OrdersService ordersService;
    @Resource
    private ProductClient productClient;
    @Resource
    private MemberClient memberClient;
    @Resource
    private MessageProducer messageProducer;

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

    @RequestMapping("/message")
    public void message() throws Exception {
        messageProducer.run("");
    }

    @GetMapping(value = "/info")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object info(Authentication authentication) {
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        return details.getTokenValue();
    }

    @GetMapping(value = "/info/jwt")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object jwtParser(Authentication authentication) {
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        String jwtToken = details.getTokenValue();
        Claims claims = Jwts.parser()
                .setSigningKey("sign-8888".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims;
    }

}