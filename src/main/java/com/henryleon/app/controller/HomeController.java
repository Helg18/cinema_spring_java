package com.henryleon.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.henryleon.app.model.Pelicula;

@Controller
public class HomeController {
	
	private SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<Pelicula> peliculas = getlista();
		
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaActual", formatDate.format(new Date()));
		
		return "home";
		
	}
	
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fechaActual) {
		System.out.println(idPelicula);
		System.out.println(fechaActual);
		String titulopelicula = "Rescatando al soldado Ryan.";
		int duracion = 136;
		double precioEntrada = 50.25;
		
		model.addAttribute("titulo", titulopelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precioEntrada", precioEntrada);
	
		
		return "detail";
	}
	
	private List<Pelicula> getlista() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> list = null;
		try {
			list = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("El motorizado fantasma");
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Accion");
			pelicula1.setDuracion(136);
			pelicula1.setFechaEstreno(formatter.parse("03-11-2007"));

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Rango, el camaleon");
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setDuracion(120);
			pelicula2.setImage("estreno1.png");
			pelicula2.setFechaEstreno(formatter.parse("28-10-2009"));

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Los recuerdos de ella");
			pelicula3.setClasificacion("C");
			pelicula3.setGenero("Romance");
			pelicula3.setDuracion(145);
			pelicula3.setImage("estreno2.png");
			pelicula3.setFechaEstreno(formatter.parse("12-05-2012"));
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Star wars");
			pelicula4.setClasificacion("A");
			pelicula4.setGenero("Romance");
			pelicula4.setDuracion(106);
			pelicula4.setImage("estreno3.png");
			pelicula4.setFechaEstreno(formatter.parse("05-05-2018"));
			pelicula4.setStatus("Inactiva");
			

			list.add(pelicula1);
			list.add(pelicula2);
			list.add(pelicula3);	
			list.add(pelicula4);	
			
			return list;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
}
