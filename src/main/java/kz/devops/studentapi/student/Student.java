package kz.devops.studentapi.student;
import jakarta.persistence.*;
@Entity @Table(name="students")
public class Student {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(nullable=false, unique=true) private String email;
 private String course;
 protected Student() {}
 public Student(String name, String email, String course) { this.name=name; this.email=email; this.course=course; }
 public Long getId(){return id;} public String getName(){return name;} public String getEmail(){return email;} public String getCourse(){return course;}
 public void setName(String name){this.name=name;} public void setEmail(String email){this.email=email;} public void setCourse(String course){this.course=course;}
}
