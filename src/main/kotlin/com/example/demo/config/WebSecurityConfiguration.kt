package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            //.csrf().disable()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/client").permitAll()
            .antMatchers("/supp").permitAll()
            .antMatchers("/uploadStatus").permitAll()
            .antMatchers("/upload").permitAll()
            .antMatchers(HttpMethod.POST, "/upload").permitAll()
            //.anyRequest().authenticated()
            .antMatchers("/client").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .permitAll()
            .and()
            .logout()
            .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
            .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler())

    }
    @Bean
    fun accessDeniedHandler(): AccessDeniedHandler {
        return CustomAccessDeniedHandler()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        val passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

        auth
            .inMemoryAuthentication()
            .withUser("user")
            .password(passwordEncoder.encode("1234"))
            .roles("USER")
            .and()
            .withUser("gestionnaire")
            .password(passwordEncoder.encode("1234"))
            .roles("USER", "ADMIN")
    }

    fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("*")
    }
}
