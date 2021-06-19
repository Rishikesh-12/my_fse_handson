package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuRepository;
import com.cognizant.truyum.util.DateUtil;

@Component
@Qualifier("menu")
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	//ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	@Autowired
	private MenuRepository repo;
	//private List<MenuItem> menuItemList = context.getBean("menuItems",ArrayList.class);
	//private List<MenuItem> menuItemList;
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return repo.findAll();
	}

	
	
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemList=repo.findAll();
		List<MenuItem> customerMenuItemList = new ArrayList<MenuItem>();

		for (int i = 0; i < menuItemList.size(); i++) {
			MenuItem menuItem = menuItemList.get(i);
			if ((menuItem.getDateOfLaunch().equals(new Date()) 
					|| menuItem.getDateOfLaunch().before(new Date())) && menuItem.isActive()) {
				customerMenuItemList.add(menuItem);
			}
		}

		return customerMenuItemList;
	}

	

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem=repo.findById(menuItemId).get();
		/*MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItem = menuItemList.get(i);
				break;
			}
		}*/
		return menuItem;
	}

	@Override
	public MenuItem modifyMenuItem(MenuItem menuItem) {
		/*List<MenuItem> menuItemList=repo.findAll();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).equals(menuItem)) {
				menuItemList.set(i, menuItem);
				break;
			}
		}*/
		return repo.save(menuItem);
	}

}
