package com.example.demo.another;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "gender.name", target = "gender")
    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    StudentVO student2StudentVO(Student student);


    List<StudentVO> students2StudentVOs(List<Student> studentList);

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

    }
}