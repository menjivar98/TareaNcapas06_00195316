package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Controller
public class MainController {
	
	@Autowired
	private ContribuyenteDAO contribuyenteDAO;
	
	@RequestMapping("/contribuyente")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = contribuyenteDAO.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes",contribuyentes);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping("/mostrarContribuyente")
	public ModelAndView findOne(@RequestParam(value="codigo")int id) {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = null;
		try {
			contribuyente = contribuyenteDAO.findOne(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("contribuyente");
		
		return mav;
	}
	
}
