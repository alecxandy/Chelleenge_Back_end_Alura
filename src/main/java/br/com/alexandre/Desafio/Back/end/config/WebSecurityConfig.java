package br.com.alexandre.Desafio.Back.end.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {//configuração depreciada

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()//basico
                .and()//unir configurações
                .authorizeHttpRequests()//autorizar requisição
                .anyRequest().authenticated()//para todas as requisições atutenticat
                .and()
                .csrf().disable();//disabilitando o csrf
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
