package com.replicacia.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class JwtAuthSecurityConfig extends WebSecurityConfigurerAdapter {

  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final UserDetailsService jwtUserDetailsService;
  private final JwtRequestFilter jwtRequestFilter;

  @Autowired
  public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
    // configure AuthenticationManager so that it knows from where to load
    // user for matching credentials
    // Use BCryptPasswordEncoder
    auth.userDetailsService(this.jwtUserDetailsService).passwordEncoder(this.passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(final HttpSecurity httpSecurity) throws Exception {

    httpSecurity.headers().frameOptions().disable();
    httpSecurity.cors();
    httpSecurity
            .csrf().disable()
            .authorizeRequests()
            // Permit static resources and index page
            .antMatchers("/", "/index.html", "/static/**", "/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()

            // Secure all other endpoints
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // Add a filter to validate the tokens with every request, but skip static paths
    httpSecurity.addFilterBefore(this.jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
  }

}
