package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Util.UtilManagePDF;
import com.example.demo.model.Intestazione;


@Controller
@RequestMapping("lotteriascontrini")
public class MainController {

	@Autowired 
	Intestazione intestazione;
	Logger logger = LoggerFactory.getLogger(MainController.class);
	@GetMapping("homepage")
	public ModelAndView home(@ModelAttribute String messaggio) {
		Map<String, Object> myMap=new HashMap<>();
		myMap.put("dataCorrente", intestazione.getDataCorrente());
		myMap.put("mioNome", intestazione.getCognome()+" "+intestazione.getNome());
		myMap.put("lingua", intestazione.getLingua());
		myMap.put("messaggio", messaggio);
		return new ModelAndView("home", myMap);
	}
	
	@GetMapping("scaricaEstrazioniPDF")
	public void scaricaEstrazioni(HttpServletResponse response) throws Exception {
		StringBuilder localFile=new StringBuilder();
		if (UtilManagePDF.scaricaFile(localFile)) {
			logger.warn("File pdf = "+localFile.toString());
			List<String> estrazioni=UtilManagePDF.Leggi(localFile.toString());
			logger.warn("File scaricato correttamente");
			logger.warn(estrazioni.toString());
		}
		try {
			response.sendRedirect("localhost:8080/lotteriascontrini/homepage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
