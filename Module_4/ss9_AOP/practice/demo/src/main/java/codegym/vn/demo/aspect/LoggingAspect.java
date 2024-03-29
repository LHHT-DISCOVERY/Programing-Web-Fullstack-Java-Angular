package codegym.vn.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    // tạo biến logger để ghi cái log nó ra
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    // định nghĩa một cái method pointcut sau đó dùng advice để khai báo advice với method đó
    // bỏ ở service (Hoặc repository cx đc ) . có .. nghĩa là tất cả những cái method
    // trong BookServiceImpl sew theo phương thức này
    @Pointcut("execution(* codegym.vn.demo.service.BookServiceImpl.*(..))")
    public void bookService(){};

    // khai báo before nghĩa là trc khi chạy cái đó thì nó sẽ làm
    // sẽ gọi method trên là bookService()
//    @Before("bookService()")
    // tạo method mới và để Join point vào
    // lấy method chuẩn bị gọi nó ra thông qua joint point bằng string
    // sẽ trả về đúng method mà joint sẽ gọi
    @Before("bookService()")
    public void getLog(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before: Call " + methodName);
    }

    // advice là phương thức getLogAfter, loại advice là After Advice
    // join point là phương thức getList() trong class BookServiceImpl
    // point cut là phương thức getList() trong class BookServiceImpl
    @After("execution(* codegym.vn.demo.service.BookServiceImpl.getList())")
    public void getLogAfter(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: End call " + methodName);
    } //weave

    // advice chính là phương thức getLogAround(), loại advice là Around Advice
    // point cut refer method bookservice => "execution(* codegym.vn.demo.service.BookService.*(..))"
    // từ cái execution trên => join point là các phương thức trong class BookServiceImpl => có 7 join point
    // point cut cách để xác định 7 join point
    @Around("bookService()")
    public Object getLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Around: Begin call " + methodName);
        Object result = joinPoint.proceed(); //getList()
        logger.info("Around: End call " + methodName);
        return result;
    }

    @AfterReturning("execution(* codegym.vn.demo.service.BookServiceImpl.fi*(..))")
    public void getLogAfterRunning(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After returning: End call " + methodName);
    }
}
