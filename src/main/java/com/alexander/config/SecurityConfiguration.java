package com.alexander.config;

import com.alexander.services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;

/**
 * Created by alex on 20.01.2017.
 */
@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = UserDetailsServiceImpl.class)
@EnableGlobalMethodSecurity(
        jsr250Enabled = true, securedEnabled = true, prePostEnabled = true
)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Inject
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder builder)
            throws Exception
    {
        builder
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity security)
    {
        security.ignoring().antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/errorPage");
    }
    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        security.exceptionHandling().accessDeniedPage("/errorPage");
        security
                .authorizeRequests()
                .antMatchers("/registration/**").permitAll()
                .antMatchers("/updatePhones/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/**").hasAuthority("ROLE_USER")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout").logoutSuccessUrl("/login?loggedOut")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .permitAll()
                .and().sessionManagement()
                .sessionFixation().changeSessionId()
                .maximumSessions(1).maxSessionsPreventsLogin(true)
                .and().and().rememberMe().key("site");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder encoder() throws Exception
    {
        return new BCryptPasswordEncoder(4);
    }

}