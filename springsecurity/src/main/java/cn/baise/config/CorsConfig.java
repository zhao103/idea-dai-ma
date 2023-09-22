//package cn.baise.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOriginPatterns("*")
//                //设置方法
//                .allowedMethods("GET","POST","PUT","DELETE")
//                //设置是否可以携带cookie
//                .allowCredentials(true)
//                .maxAge(3600)
//                .allowedHeaders("*");
//    }
//}
