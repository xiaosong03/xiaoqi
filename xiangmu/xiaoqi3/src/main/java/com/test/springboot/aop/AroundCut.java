package com.test.springboot.aop;

import com.test.springboot.utils.VerifyUtil;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.utils.result.code.Code;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class AroundCut {
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//    public static final String POINT_CUT = "execution(* com.test.springboot.controller.UserController.*(..)) || " +
//            "execution(* com.test.springboot.controller.CourseController.*(..))";
//
//
//
//    @Around(AroundCut.POINT_CUT)
//    public DataResult checkToken(ProceedingJoinPoint pjp) throws Throwable {
//        //获取token
//        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Token");
//        return (DataResult) pjp.proceed();
//
//    }
}
