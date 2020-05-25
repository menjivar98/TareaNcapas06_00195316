package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@Autowired
	private ImportanciaService importanciasService;
	
	@RequestMapping("/contribuyente")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = contribuyenteService.findAll();
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
			contribuyente = contribuyenteService.findOne(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("contribuyente");
		
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		
		
			mav.setViewName("index");
			contribuyenteService.save(contribuyente);
			List <Contribuyente> contribuyentes = null;
			try {
					contribuyentes = contribuyenteService.findAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("contribuyentes", contribuyentes );
			mav.setViewName("Exito");
			
		
		
		
		
		return mav;
		
	}
	
	@GetMapping("/")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		
		Contribuyente contribuyente = new Contribuyente();
		List <Importancia> importancias = null;
		try {
			importancias = importanciasService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		mav.addObject("importancias", importancias);
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("index");
		return mav;
	}
	
	
}
