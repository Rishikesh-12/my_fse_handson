package com.cognizant.truyum.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuRepository;

@Service
public class menuItemService {
	@Autowired
	@Qualifier("menu")
	private MenuItemDao menuItemDao;
//	@Autowired
//	private MenuRepository repo;
	

	public List<MenuItem> getMenuItemListAdmin() {
		// repo.saveAll(menuItemDao.getMenuItemListAdmin());
		return menuItemDao.getMenuItemListAdmin();
	}

	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();
	}

	public MenuItem modifyMenuItem(MenuItem menuItem) {
		return menuItemDao.modifyMenuItem(menuItem);
	}

	public MenuItem getMenuItem(long menuItemId) {
		return menuItemDao.getMenuItem(menuItemId);
	}
}
