package com.greedy.section02.scanpractice.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.section02.scanpractice.model.dto.MenuDTO;



@Mapper
public interface MenuDAO {
	List<MenuDTO> selectMenuList();
}
