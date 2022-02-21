package es.cesar.hospital.seguridad;

import es.cesar.hospital.servicio.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfigurationPersonal extends WebSecurityConfigurerAdapter {

    @Autowired
    private PersonalDetailsServiceImpl personalDetailsService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personalDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/auth/**","/public/**","/css/?**","/js/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/loginPersonal")
                .defaultSuccessUrl("/private/indexPersonal", true)
                .failureUrl("/auth/loginPersonal?error=true")
                .loginProcessingUrl("/auth/loginPersonal-post")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logoutPersonal")
                .logoutSuccessUrl("/public/indexPersonal");
    }
}
