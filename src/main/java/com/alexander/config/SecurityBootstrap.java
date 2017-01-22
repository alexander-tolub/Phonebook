package com.alexander.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by alex on 20.01.2017.
 */
public class SecurityBootstrap extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected boolean enableHttpSessionEventPublisher()
    {
        return true;
    }

}
