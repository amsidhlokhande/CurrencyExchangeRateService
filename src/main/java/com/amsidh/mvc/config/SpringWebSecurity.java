package com.amsidh.mvc.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SpringWebSecurity extends WebSecurityConfigurerAdapter {

    private final Environment environment;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests().antMatchers(getPermitAllUrls()).permitAll().anyRequest().authenticated()
                .and().httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/

        http.authorizeRequests().anyRequest().permitAll().and().httpBasic().disable().csrf().disable();

    }

    /*private String[] getPermitAllUrls() {
        String[] propertiesSkipped = environment.getProperty("skip.spring.security.urls", String[].class);
        Arrays.asList(Objects.requireNonNull(propertiesSkipped)).forEach(prop -> System.out.print(prop + ", "));
        return propertiesSkipped;
    }*/

}
