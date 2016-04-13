package devplanet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-13.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .formLogin()
                    .loginPage("/")
                .and()
                    .logout()
                    .deleteCookies("SESSION")
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                .and()
                    .authorizeRequests()
                    .antMatchers("/user/**/**").authenticated()
                    .anyRequest().permitAll();
    }
}
