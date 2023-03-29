package com.greedy.section01.connection.javaconfig;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("menuDAO")
public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<MenuDTO> selectAllMenuList(SqlSessionTemplate sqlSession) {
		
		
		return sqlSession.selectList("MenuMapper.selectMenuList");
	}

}
