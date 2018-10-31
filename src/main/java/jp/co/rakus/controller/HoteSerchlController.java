package jp.co.rakus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.Form.HotelSerchForm;
import jp.co.rakus.domain.Hotel;
import jp.co.rakus.repository.HotelSerchRepository;

@Controller
@RequestMapping("/hotel")
public class HoteSerchlController {
	@ModelAttribute
	public HotelSerchForm setUpForm() {
		return new HotelSerchForm();
	}
	@Autowired
	private HotelSerchRepository repository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Hotel> hotels = new ArrayList<>();
		model.addAttribute("hotels",hotels);
		return "hotel";
	}
	
	@RequestMapping("/serch")
	public String serch(@Validated HotelSerchForm hotelSerchForm,BindingResult result,Model model) {
		List<Hotel> hotels = repository.findPrice(hotelSerchForm.getPrice());
		model.addAttribute("hotels",hotels);
		for(Hotel hotel:hotels) {
			System.out.println(hotel.getHotelName());
		}
		return "hotel";
	}
}
