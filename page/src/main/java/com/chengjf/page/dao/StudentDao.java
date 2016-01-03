package com.chengjf.page.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chengjf.page.model.Student;

public class StudentDao {

	public StudentDao() {
	}

	public List<Student> getAllStudents() {
		SqlSession openSession = DaoFactory.getInstance().getFactory()
				.openSession();
		List<Student> list = openSession.selectList("selectAllStudents");
		openSession.close();
		return list;
	}
}
