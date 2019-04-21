package com.springsecurity.springsecurity.Config;

import com.springsecurity.springsecurity.Service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationSuccess authenticationSuccess;

    @Autowired
    LogoutSuccess logoutSuccess;

    @Autowired
    DataSource dataSource;


@Autowired
     UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder)throws Exception {
        managerBuilder
                /*.inMemoryAuthentication()
                .withUser("user").password("pass").roles("USER")
                .and()
                //.withUser("user2").password("pass2").roles("ADMIN");
                .withUser("user2").password("pass2").roles("USER");*/
                .userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/home/**").hasAuthority("ROLE_USER")
                    // .antMatchers("/home/**").hasAuthority("ROLE_USER")

                //.antMatchers("/home/**").hasRole("ADMIN")
                .antMatchers("/register/**").permitAll()
                .antMatchers("/registerUser/**").permitAll()

                .antMatchers("/registerConfirmation/**").permitAll()

                .antMatchers("/home/**").hasRole("USER")
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()

                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())


              //  .tokenValiditySeconds(3600)
                //Change Cookie Name
               // .rememberMeCookieName("my-cookie")
                // Change Parameter for cookie
               // .rememberMeParameter("remember-me")

                .and()
                .formLogin()
                .successHandler(authenticationSuccess)

                .loginPage("/login").permitAll()
                .loginProcessingUrl("/loginUrl")

                .and()
                /*.logout().permitAll().logoutRequestMatcher(new AndRequestMatcher("/logout","GET"));*/
                .logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                .logoutSuccessHandler(logoutSuccess);
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}
