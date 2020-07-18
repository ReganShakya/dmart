/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mart.auth.configuration;

import com.web.mart.auth.handler.LoginSuccessHandler;
import com.web.mart.auth.service.UserAuthService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author regan
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private UserAuthService userAuthService;
    
    @Autowired
    private LoginSuccessHandler successHandler;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginProcessingUrl("/signin")
                .loginPage("/login").failureUrl("/login/login-error")
                .usernameParameter("username").passwordParameter("password")
                .successHandler(successHandler).permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/login/logout"))
                .logoutSuccessUrl("/login").permitAll()
                .invalidateHttpSession(true);
        
        http
            .rememberMe()
            .tokenValiditySeconds(2592000)
            .rememberMeParameter("checkRememberMe").userDetailsService(userAuthService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /*BCryptPasswordEncoder encoder=getPasswordEncoder();
       String userSql="select username,password,status"
               + " from tbl_users where username=?";
       String roleSql="select r.role_name,u.username from mst_roles r "
               + "join tbl_users u on u.role_id=r.id "
               + "where u.username=?";
       auth.jdbcAuthentication()
               .passwordEncoder(encoder)
               .usersByUsernameQuery(userSql)
               .authoritiesByUsernameQuery(roleSql)
               .dataSource(dataSource);*/
       
       
       //In memory login
       /*BCryptPasswordEncoder encoder = getPasswordEncoder();
       auth.inMemoryAuthentication()
               .passwordEncoder(encoder)
               .withUser("admin")
               .password(encoder.encode("admin1234"))
               .authorities("ADMIN");*/
       
       
       auth.authenticationProvider(getAuthProvider());
       
    }
    
    @Bean
    public DaoAuthenticationProvider getAuthProvider(){
        DaoAuthenticationProvider provider=
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getPasswordEncoder());
        provider.setUserDetailsService(userAuthService);
        return provider;
    }
    
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
    return new BCryptPasswordEncoder();
    }
}
