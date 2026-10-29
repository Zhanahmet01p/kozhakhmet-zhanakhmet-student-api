package kz.devops.studentapi.student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController @RequestMapping("/api/students")
public class StudentController {
 private final StudentRepository repository;
 public StudentController(StudentRepository repository){this.repository=repository;}
 @GetMapping public List<Student> getAll(){return repository.findAll();}
 @GetMapping("/{id}") public Student getById(@PathVariable Long id){return repository.findById(id).orElseThrow(()->new StudentNotFoundException(id));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED)
 public Student create(@RequestBody StudentRequest r){
  if(repository.existsByEmail(r.email())) throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");
  return repository.save(new Student(r.name(),r.email(),r.course()));
 }
 @PutMapping("/{id}") public Student update(@PathVariable Long id,@RequestBody StudentRequest r){
  Student s=repository.findById(id).orElseThrow(()->new StudentNotFoundException(id));
  if(!s.getEmail().equals(r.email())&&repository.existsByEmail(r.email())) throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");
  s.setName(r.name()); s.setEmail(r.email()); s.setCourse(r.course()); return repository.save(s);
 }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
 public void delete(@PathVariable Long id){Student s=repository.findById(id).orElseThrow(()->new StudentNotFoundException(id)); repository.delete(s);}
 public record StudentRequest(String name,String email,String course){}
}
