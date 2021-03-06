package com.cognizant.truyum.dao;

import java.util.List;
import java.util.Optional;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();

	public MenuItem modifyMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(long menuItemId);
}
