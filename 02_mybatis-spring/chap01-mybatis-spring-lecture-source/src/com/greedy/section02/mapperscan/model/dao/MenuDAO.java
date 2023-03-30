package com.greedy.section02.mapperscan.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.section02.mapperscan.model.dto.MenuDTO;

@Mapper
public interface MenuDAO {
	
	List<MenuDTO> selectMenuList();
}
