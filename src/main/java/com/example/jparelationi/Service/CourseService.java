package com.example.jparelationi.Service;

import com.example.jparelationi.ApiExption.ApiExaption;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.CourseRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public void addCourse(Course course){

        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course course1=courseRepository.findCourseById(id);
        if(course1==null){
            throw new ApiExaption("Course not found");
        }
      course1.setName(course.getName());
        courseRepository.save(course1);
    }

    public void deleteCourse(Integer id){
        Course c=courseRepository.findCourseById(id);
        if(c==null){
            throw new ApiExaption("product not found");
        }
        courseRepository.delete(c);
    }
//Assign
        public void courseAssignToTeacher(Integer course,Integer teacher){
       Course course1=courseRepository.findCourseById(course);
        Teacher teacher1=teacherRepository.findTeacherById(teacher);
        if(course1==null||teacher1==null){
            throw new ApiExaption("Course or teacher not found");
        }
        course1.setTeacher(teacher1);
        courseRepository.save(course1);


    }


}
