package com.roja.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.roja.demo.dao.AlienRepo;
import com.roja.demo.model.Alien;

@Controller
public class AlienController 
{
	@Autowired
	AlienRepo repo;
	
	@GetMapping("/")
	public String home()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "homejump.jsp";
	}
	
	@RequestMapping("/showAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv; 
	}
	
	@RequestMapping("/deleteAlien")
	public ModelAndView deleteAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("deleteAlien.jsp");
		Alien aliend = repo.getOne(aid);
		repo.delete(aliend);
		return mv;
	}
	
	@RequestMapping("/updateAlien")
	public String saveOrUpdateAlien(Alien alienU)
	{
		repo.save(alienU);
		return "editjump.jsp";
	}
}

