package com.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated()).httpBasic(withDefaults());
        http
//                .csrf().disable().//disabling CSRF
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().//disabling CSRF
                authorizeRequests()
//                .antMatchers("/test/test_1", "/test/test_2").permitAll()
//                .antMatchers(HttpMethod.GET, "/test/**").permitAll()
                .antMatchers( "/signin").permitAll()
                .antMatchers(HttpMethod.GET, "/test/**").hasRole("NORMAL")
                .antMatchers(HttpMethod.GET, "/coursemanager/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/coursemanager/**").hasRole("ADMIN") // Either disable CSRF or enable POST mapping
                .anyRequest()
                .authenticated()
                .and()
//                .httpBasic();
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/submit")
                .defaultSuccessUrl("/coursemanager/courses");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Jim").password(this.passwordEncoder().encode("jim")).roles("NORMAL");
        auth.inMemoryAuthentication().withUser("Jane").password(this.passwordEncoder().encode("jane")).roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();//for no encoding
        return new BCryptPasswordEncoder(10);
    }
}
