package com.practice2.demo.Service;
import com.practice2.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class StudentService {

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1,"dhivya","springboot"),
            new Student(3,"abc","react")
    ));
    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudentById(int rollno) {
        int index=0;
        boolean flag = true;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getRno()==rollno){
                index = i;
                flag = false;
            }
        }
        if(flag) return new Student(0,"","");
        else{
                return students.get(index);
        }
    }

    public void addStudent(Student std) {
        students.add(std);
    }

    public String updateStudent(Student std) {
        int index=0;
        boolean flag = false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getRno()== std.getRno()){
                index = i;
                flag=true;
                break;
            }
        }
        if(flag){
            students.set(index,std);
            return "Successfully updated";
        }
        students.add(std);
        return "Student not found and added as new student";
    }

    public String deleteStudent(int roll) {
        int index=0;
        boolean flag=true;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getRno()==roll){
                index=i;
                flag=false;
                break;
            }
        }
        if(flag) return "No such data";
        else{
            students.remove(index);
            return "Delete Successful";
        }
    }
}