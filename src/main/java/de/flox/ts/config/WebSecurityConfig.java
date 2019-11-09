package de.flox.ts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import de.flox.ts.utils.LoginValues;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	/*http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/error", "/error").permitAll()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    	
        http.authorizeRequests().antMatchers("/login*").permitAll();*/
    	http.authorizeRequests().antMatchers("/", "/home").permitAll().anyRequest().fullyAuthenticated().and().formLogin()
        .loginPage("/login").defaultSuccessUrl("/welcome").failureUrl("/login?error").permitAll().and()
        .logout().permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
    	LoginValues login = new LoginValues();
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username(login.getUsername())
                .password(login.getPassword())
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
    
	@Override
    public void configure(WebSecurity web){
    	
		web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/scripts/**");
        web.ignoring().antMatchers("/images/**");
    	
    }
}