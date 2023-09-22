package cn.baise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@EnableWebSecurity
public class MySecurityConfig  extends WebSecurityConfigurerAdapter{
    //extends WebSecurityConfigurerAdapter
    //放行的方法 在 这个方法的参数上
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //放行的方法
        http.authorizeRequests()
                //设置路径为所有的路径   访问者的角色任意即可   hasRole("vip1")设置访问者的角色
                .antMatchers("/**").permitAll();
        http.formLogin(formLogin->
                formLogin
                        //指定登录接口
                        .loginProcessingUrl("/login").permitAll()
                        //登录成功处理器
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                                response.setContentType("text/html;charset=UTF-8");
                                response.getWriter().write("loginOK");
                            }
                        })
                        //登录失败处理器
                        .failureHandler(new AuthenticationFailureHandler() {
                            @Override
                            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                                response.setContentType("text/html;charset=UTF-8");
                                response.getWriter().write("loginERRER");
                                System.out.print("登录异常信息:");
                                exception.printStackTrace();
                            }
                        })
        );
        //跨域漏洞防御：关闭
        //
        //http.csrf(Customizer.withDefaults());
        //http.csrf(e->e.disable());
        http.csrf(csrf->csrf.disable());//跨域漏洞防御：关闭
        http.cors().configurationSource(corsConfigurationSource());//跨域拦截 关闭
        //登出
        //http.logout(logout->logout.invalidateHttpSession(true));
    }

    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("huyuhan").password(new BCryptPasswordEncoder().encode("123456")).roles("root");
//    }

    /*@Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests(authorizeHttpRequests ->
                    authorizeHttpRequests
                            .requestMatchers().permitAll()
                            .anyRequest().authenticated()
            );


        }*/
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
