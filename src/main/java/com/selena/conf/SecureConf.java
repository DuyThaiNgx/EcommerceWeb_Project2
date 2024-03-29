package com.selena.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.selena.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecureConf extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests() // bắt đầu cấu hình: tất cả các requests từ
                // trình duyệt đều được bắt trong hàm này

                //cho phép các request static resources không bị ràng buộc(permitAll)
                .antMatchers("/css/**", "/js/**", "/upload/**", "/img/**", "/login", "/logout").permitAll() // Cho phép tất cả các request tới các đường dẫn tĩnh như CSS,
                // JavaScript, hình ảnh và các trang đăng nhập/logout được truy cập mà không cần xác thực.


                //các request kiểu: "/admin/" là phải đăng nhập (authenticated)
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN") //
                .and()

                //cấu hình trang đăng nhập
                // /login: một request trong LoginController
                .formLogin().loginPage("/login").loginProcessingUrl("/login_processing_url")
                //Xác định lớp xử lý thành công sau khi đăng nhập thành công.
                .successHandler(new UrlAuthenticationSuccessHandler())
				//Chuyển đến đến http://localhost:8080/login?login_error=true nếu đăng nhập thất bại
                .failureUrl("/login?login_error=true")

                .and()

                //cấu hình request mapping cho phần logout, chuyển hướng đến home khi logout
                .logout().logoutUrl("/logout").logoutSuccessUrl("/home").invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400);
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(4));
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder(4).encode("123456"));
        System.out.println(new BCryptPasswordEncoder(4).encode("guest"));
    }

}
