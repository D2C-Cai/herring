package com.herring.product.interceptor;

/*
@(#)herring   2021-02-04
 
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

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Jackey 2021/2/4
 */
public class TokenRelayRequestInterceptor implements RequestInterceptor {

    public static final String AUTH_TOKEN = "Authorization";

    @Override
    public void apply(RequestTemplate template) {
        // 获取该次请求得token 将token传递
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader(AUTH_TOKEN);
        if (StringUtils.isNotBlank(token)) {
            template.header(AUTH_TOKEN, token);
        }
    }

}