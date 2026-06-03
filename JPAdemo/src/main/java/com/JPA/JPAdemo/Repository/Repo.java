package com.JPA.JPAdemo.Repository;

import com.JPA.JPAdemo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<Student,Integer> {
    List<Student> findByTechAndRno(String tech, Integer rno);

    List<Student> findByTech(String tech);
    @Query(nativeQuery = true,
            value= "SELECT * FROM student where name=:name And tech=:tech")
    List<Student> findByNameAndTech(@Param("name") String name, @Param("tech") String tech);

    @Query("SELECT ss from Student ss WHERE ss.name='aswini'")
    List<Student>findbyName(String name);
}
