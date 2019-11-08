package com.johnpantoja.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.johnpantoja.entity.PointSale;
import com.johnpantoja.entity.User;
import com.johnpantoja.entity.Visit;
import com.johnpantoja.service.PointSaleService;
import com.johnpantoja.service.UserService;
import com.johnpantoja.service.VisitService;

@Controller
public class InicioController {

	@Autowired
	PointSaleService pointSaleService;

	@Autowired
	VisitService visitService;

	@Autowired
	UserService userService;

	@GetMapping(value = { "", "/", "login" })
	public String inicio() {

		return "login";
	}

	@GetMapping("/listaPuntosDeVenta")
	public String index(Model model) throws Exception {

		model.addAttribute("pointSaleList", pointSaleService.getAllPointSale());

		return "listaPuntosDeVenta";
	}

	@GetMapping("/crearPuntoDeVenta")
	public String login2() {

		return "crearPuntoDeVenta";
	}

	@PostMapping("/crearPuntoDeVenta")
	public String signupAction(@ModelAttribute("userForm") PointSale pointSale, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		try {

			pointSaleService.createPointSale(pointSale);

			if (result.hasErrors()) {

				return "redirect:crearPuntoDeVenta";
			}
			redirectAttributes.addFlashAttribute("message", "Registro Exitoso ");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success alert-dismissible");

		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("message", "Ocurrio un error intente nuevamente");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger alert-dismissible ");

		}

	
		return "redirect:crearPuntoDeVenta";
	}

	@GetMapping("/visitasPuntoDeVentas")
	public String visitasPuntoDeVentas(Model model) throws Exception {

		model.addAttribute("pointSaleList", pointSaleService.getAllPointSale());

		return "visitasPuntoDeVentas";
	}

	@GetMapping("/listaVisitasRealizadas")
	public String listaVisitasRealizadas(Model model) throws Exception {

		model.addAttribute("visitList", visitService.getAllVisit());

		model.addAttribute("pointSaleList", pointSaleService.getAllPointSale());

		return "listaVisitasRealizadas";
	}

	@PostMapping("/crearVisita")
	public String crearVisita(@ModelAttribute("userForm") Visit visit, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		try {

			visit.setUser(userService.getLoggedUser());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			visitService.createVisit(visit);

			if (result.hasErrors()) {

				return "redirect:visitasPuntoDeVentas";
			}
			redirectAttributes.addFlashAttribute("message", "Registro Exitoso ");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success alert-dismissible");

		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("message", "Ocurrio un error intente nuevamente " + e);
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger alert-dismissible ");

		}

		return "redirect:visitasPuntoDeVentas";
	}

}
