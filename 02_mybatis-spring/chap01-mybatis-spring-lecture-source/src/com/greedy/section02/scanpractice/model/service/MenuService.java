package com.greedy.section02.scanpractice.model.service;

import java.util.List;

import com.greedy.section02.scanpractice.model.dto.MenuDTO;


public interface MenuService {

	List<MenuDTO> findAllMenus();
}
