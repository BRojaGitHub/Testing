package com.roja.demo.controller;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.roja.demo.dao.AlienRepo;
import com.roja.demo.model.Alien;

//DB
//url : http://localhost:8080/h2-console/
//select * from alien

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
		/*System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findebySorted("Java"));*/
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
		return "editAlienJump.jsp";
	}
}

