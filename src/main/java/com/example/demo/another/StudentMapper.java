package com.example.demo.another;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
class Course {
    private String courseName;
    private int sortNo;
    private long id;

}

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "gender.name", target = "gender")
    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "comment", target = "comment", defaultValue = "xxx")
    StudentVO student2StudentVO(Student student);


    List<StudentVO> students2StudentVOs(List<Student> studentList);


    @Mapping(source = "student.gender.name", target = "gender")
    @Mapping(source = "student.birthday", target = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "course.courseName", target = "course")
    StudentVO studentAndCourse2StudentVO(Student student, Course course);

    public static void main(String[] args) {

        Student student = Student.builder().name("小明").age(6).gender(GenderEnum.Male).height(121.1).birthday(new Date()).build();
        System.out.println(student);

        List<Student> list = new ArrayList<>();
        list.add(student);
        List<StudentVO> result = StudentMapper.INSTANCE.students2StudentVOs(list);
        System.out.println(result);

        //这行代码便是实际要用的代码
        StudentVO studentVO = StudentMapper.INSTANCE.student2StudentVO(student);
        System.out.println(studentVO);

        Course course = Course.builder().id(1L).courseName("语文").build();

        StudentVO studentVO1 = StudentMapper.INSTANCE.studentAndCourse2StudentVO(student, course);
        System.out.println(studentVO1);

    }
}