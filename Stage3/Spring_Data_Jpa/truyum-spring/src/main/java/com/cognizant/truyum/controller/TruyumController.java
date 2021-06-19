package com.cognizant.truyum.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuRepository;
import com.cognizant.truyum.service.menuItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TruyumController {
	@Autowired
	private menuItemService service;
	
	@Autowired
	private MenuRepository repo;
	
	
	
//	@GetMapping("/save")
//	public String save() {
//			MenuItem item1 = new MenuItem(1, "Sandwich", 99f, true, new Date("15/03/2017"), "Main Course", true);
//			MenuItem item2 = new MenuItem(2, "Burger", 129f, true, new Date("23/12/2017"), "Main Course", false);
//			MenuItem item3 = new MenuItem(3, "Pizza", 149f, true, new Date("21/08/2018"), "Main Course", false);
//			MenuItem item4 = new MenuItem(4, "French Fries", 57f, false, new Date("02/07/2017"), "Starters", true);
//			MenuItem item5 = new MenuItem(5, "Chocolate Brownie", 32f, true, new Date("02/11/2022"), "Dessert", true);
//			List<MenuItem> list = Arrays.asList(item1,item2, item3,item4,item5);
//			repo.saveAll(list);
//			return "Hello";
//	}
	
	@GetMapping("/menuAdmin")
	public ModelAndView getMenuItemListAdmin(ModelMap model){
		//return new ResponseEntity<List<MenuItem>>(service.getMenuItemListAdmin(), HttpStatus.OK);
		model.put("menu_list", service.getMenuItemListAdmin());
		ModelAndView mav= new ModelAndView("menu-item-list-admin");
		return mav;
	}
	
	@GetMapping("/menuCustomer")
	public ModelAndView getMenuItemListCustomer(ModelMap model){
		//return new ResponseEntity<List<MenuItem>>(service.getMenuItemListCustomer(), HttpStatus.OK);
		model.put("menu_list", service.getMenuItemListCustomer());
		ModelAndView mav= new ModelAndView("menu-item-list-customer");
		return mav;
	}
	
	@GetMapping("/editOrder")
	public ModelAndView editMenuItemListAdmin(@RequestParam long id, ModelMap map,@ModelAttribute MenuItem menuItem, BindingResult res) {
		MenuItem item=service.getMenuItem(id);
		map.put("item", item);
		ModelAndView mav=new ModelAndView("edit-menu-item");
		return mav;
	}
	
	@PostMapping("/editOrder")
	public ModelAndView savingEditDetails(@ModelAttribute MenuItem menuItem, BindingResult res) {
		log.info("START");
		ModelAndView mav=new ModelAndView("edit-menu-item");
		if(res.hasErrors())
			return mav;
		log.info(menuItem.toString());
		MenuItem item=service.modifyMenuItem(menuItem);
		if(item==null)
			return mav;
		mav=new ModelAndView("edit-menu-item-status");
		return mav;
	}
}
