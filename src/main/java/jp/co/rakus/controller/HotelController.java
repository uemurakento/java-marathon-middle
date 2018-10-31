package jp.co.rakus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.Form.HotelSerchForm;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@RequestMapping("/")
	public String index() {
		return "hotel";
	}
	
	public String serch(@Validated HotelSerchForm form,BindingResult result,Model model) {
		return "";
	}
}
