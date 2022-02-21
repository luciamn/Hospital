package es.cesar.hospital.seguridad;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfPersonal extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsServicePersonal userDetailsServicePersonal;

    @Autowired
    private UserDetailsServicePaciente userDetailsServicePaciente;

    @Bean
    public BCryptPasswordEncoder passwordEncoderPaciente(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoderPersonal(){
        return new BCryptPasswordEncoder();
    }

    public String Paciente = null;
    public String Personal = null;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth.userDetailsService(userDetailsServicePaciente).passwordEncoder(passwordEncoderPaciente());
            auth.userDetailsService(userDetailsServicePersonal).passwordEncoder(passwordEncoderPersonal());

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
                    .logoutSuccessUrl("/public/indexPersonal")
                    .and()
                    .formLogin()
                    .loginPage("/auth/loginPaciente")
                    .defaultSuccessUrl("/private/indexPaciente", true)
                    .failureUrl("/auth/loginPaciente?error=true")
                    .loginProcessingUrl("/auth/loginPaciente-post")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/logoutPaciente")
                    .logoutSuccessUrl("/public/indexPaciente");


        }
    }


