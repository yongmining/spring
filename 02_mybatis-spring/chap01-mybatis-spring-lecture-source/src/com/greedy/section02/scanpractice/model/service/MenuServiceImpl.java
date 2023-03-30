package com.greedy.section02.scanpractice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.section02.scanpractice.model.dao.MenuDAO;
import com.greedy.section02.scanpractice.model.dto.MenuDTO;

@Service("menuService1")
public class MenuServiceImpl implements MenuService{
	
	private final MenuDAO menuDAO;
	
	@Autowired
	public MenuServiceImpl(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	
	@Override
	public List<MenuDTO> findAllMenus() {
		
		return menuDAO.selectMenuList();
	}
	
	
}
