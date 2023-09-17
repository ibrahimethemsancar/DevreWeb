package com.devre.devreweb.services.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfiguration  {

/*    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/newuser").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST,"/newuser/*").permitAll()
                .antMatchers(HttpMethod.GET,"/master/*").permitAll()
                .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
                .anyRequest().authenticated()
    }*/
}