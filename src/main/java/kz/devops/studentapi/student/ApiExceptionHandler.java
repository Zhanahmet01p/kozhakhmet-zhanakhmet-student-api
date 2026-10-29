package kz.devops.studentapi.student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(StudentNotFoundException.class)
 public ProblemDetail notFound(StudentNotFoundException e){ProblemDetail p=ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());p.setTitle("Student not found");return p;}
}
