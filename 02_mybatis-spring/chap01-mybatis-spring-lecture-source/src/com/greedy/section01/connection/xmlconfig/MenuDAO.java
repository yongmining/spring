package com.greedy.section01.connection.xmlconfig;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public interface MenuDAO {
	
	List<MenuDTO> selectAllMenuList(SqlSessionTemplate sqlSession);
}
