package com.chengjf.page.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DaoFactory {

	private SqlSessionFactory factory;

	private static final Logger logger = Logger.getLogger(DaoFactory.class
			.getName());

	private static DaoFactory instance = null;

	private DaoFactory() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			this.factory = builder.build(inputStream);
		} catch (IOException e) {
			logger.severe("mybatis-config.xml配置文件读取出错！");
			logger.severe(e.toString());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static DaoFactory getInstance() {
		if (instance == null) {
			synchronized (DaoFactory.class) {
				if (instance == null) {
					instance = new DaoFactory();
				}
			}
		}
		return instance;
	}

	public SqlSessionFactory getFactory() {
		return factory;
	}
}
