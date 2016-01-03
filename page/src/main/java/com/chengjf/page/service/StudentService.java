package com.chengjf.page.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chengjf.page.dao.DaoFactory;
import com.chengjf.page.dao.StudentDao;
import com.chengjf.page.mapper.StudentMapper;
import com.chengjf.page.model.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class StudentService {

	public List<Student> getAllStudents() {
		StudentDao dao = new StudentDao();
		return dao.getAllStudents();
	}

	public Page<Student> getStudentPage(int pageNumber) {
		List<Student> dataList = getAllStudents();

		int endIndex = (pageNumber + 1) * 5 > dataList.size() ? dataList.size()
				: (pageNumber + 1) * 5;

		List<Student> subList = dataList.subList(pageNumber * 5, endIndex);
		Page<Student> page = new Page<Student>();
		page.setDataList(subList);
		page.setDataCount(dataList.size());
		page.setPerPageCount(5);
		page.setCurrPageNum(pageNumber);
		return page;
	}

	public PageInfo<Student> getStudentPageInfo(int pageNumber) {
		SqlSession sqlSession = DaoFactory.getInstance().getFactory()
				.openSession();

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		try {
			// pageSize=0的时候查询全部结果
			PageHelper.startPage(pageNumber, 5);
			List<Student> list = studentMapper.selectAll();
			PageInfo<Student> page = new PageInfo<Student>(list);
			return page;
		} finally {
			sqlSession.close();
		}
	}
}
