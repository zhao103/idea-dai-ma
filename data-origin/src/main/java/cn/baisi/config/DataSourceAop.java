package cn.baisi.config;

import cn.baisi.aop.DynamicDataSourceHandler;
import cn.baisi.note.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

//这是一个切面类
@Aspect
@Component
public class DataSourceAop {
    @Around("execution(* cn.baisi.mapper.*.*(..))")
    public Object surround(ProceedingJoinPoint proceedingJoinPoint){
        //获取方法签名
        Signature signature1 = proceedingJoinPoint.getSignature();
        MethodSignature signature = (MethodSignature)signature1 ;
        //获取目标方法
        Method method = signature.getMethod();
        //获取到目标方法上注解的属性
        DataSource annotation = method.getAnnotation(DataSource.class);

        if(annotation == null){
            //获取接口的描述符
            Class declaringType = signature1.getDeclaringType();
            //获取到接口上面的DataSource注解
           annotation = (DataSource) declaringType.getAnnotation(DataSource.class);

        }
        String key = annotation.value().name();
        //将获取到的key传入
        DynamicDataSourceHandler.setDynamicDataSourceHandler(key);
        //调目标方法
        Object proceed = null;
        try {
           proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            DynamicDataSourceHandler.reovm();
        }
        return proceed;
    }

}
