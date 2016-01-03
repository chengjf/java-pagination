package com.chengjf.page.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chengjf.page.model.Student;

public interface StudentMapper {
	
	@Select("select * from student")
	List<Student> selectAll();
}
