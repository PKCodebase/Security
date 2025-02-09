package com.security.Security.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    //GIVING PERMISSION TO ALL hTTP Request

    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       httpSecurity
               //With csrf disable we can perform all the operation
               .csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(request -> request
                       .requestMatchers("/user/**").permitAll()
                       .anyRequest().authenticated())
               //.formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults());
                return httpSecurity.build();

     }

     @Bean
     public UserDetailsService userDetailsService(){
         UserDetails user = User.withUsername("kaushik")
                 .password("{noop}password")
                 .roles("USER")
                 .build();
         return new InMemoryUserDetailsManager(user);
             }


             public AuthenticationProvider authenticationProvider(){
                 DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
                 provider.setUserDetailsService(userDetailsService);
                 provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
                 return provider;
             }

}
