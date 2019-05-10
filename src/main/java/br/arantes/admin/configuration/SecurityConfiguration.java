package br.arantes.admin.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home").permitAll().antMatchers("/").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/home").permitAll().and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
				.logoutSuccessUrl("/login");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserDetailsService service = userDetailsService();
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
}
