//package com.apexcrud.usercrud.aop;
//
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.apexcrud.usercrud.entity.AuditLog;
//import com.apexcrud.usercrud.repository.AuditLogRepository;
//
//import java.time.LocalDateTime;
//
//@Aspect
//@Component
//public class AuditLoggingAspect {
//
//    @Autowired
//    private AuditLogRepository auditLogRepository;
//
//    @Before("execution(* com.example.repository.*.save(..))")
//    public void logBeforeSave(JoinPoint joinPoint) {
//        Object entity = joinPoint.getArgs()[0];
//        AuditLog log = new AuditLog();
//        log.setOperation("CREATE/UPDATE");
//        log.setEntityName(entity.getClass().getSimpleName());
//        log.setEntityId(getEntityId(entity)); 
//        log.setTimestamp(LocalDateTime.now());
//        log.setPerformedBy("SYSTEM");
//        auditLogRepository.save(log);
//    }
//
//    @AfterReturning("execution(* com.example.repository.*.delete(..))")
//    public void logAfterDelete(JoinPoint joinPoint) {
//        Object entity = joinPoint.getArgs()[0];
//        AuditLog log = new AuditLog();
//        log.setOperation("DELETE");
//        log.setEntityName(entity.getClass().getSimpleName());
//        log.setEntityId(getEntityId(entity)); 
//        log.setTimestamp(LocalDateTime.now());
//        log.setPerformedBy("SYSTEM");
//        auditLogRepository.save(log);
//    }
//
//    private String getEntityId(Object entity) {
//        // Implement logic to extract entity ID from the entity
//        return "id";
//    }
//}
