package jp.co.rakus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.Form.ClothesShopForm;
import jp.co.rakus.domain.Clothes;
import jp.co.rakus.repository.ClothesShopRepository;

/**
 * 洋服情報の検索を行うコントローラー.
 * 
 * @author kento.uemura
 *
 */
@Controller
@RequestMapping("/clothesShop")
public class ClothesShopController {
	@ModelAttribute
	public ClothesShopForm setUpForm() {
		return new ClothesShopForm();
	}
	@Autowired
	private ClothesShopRepository repository;
	
	/**
	 * 初期画面を表示する.
	 * 
	 * @param model モデル
	 * @return 初期画面
	 */
	@RequestMapping("/")
	public String index(Model model) {
		List<String> colorList = new ArrayList<>();
		colorList.add("赤");
		colorList.add("青");
		colorList.add("黄色");
		colorList.add("白");
		model.addAttribute("colorList",colorList);
		return "clothesshop";
	}
	
	/**
	 * 検索結果を表示する
	 * 
	 * @param form 入力フォームの値
	 * @param model モデル
	 * @return indexにフォワード
	 */
	@RequestMapping("/serch")
	public String serch(@Validated ClothesShopForm form, Model model) {
		List<Clothes> chothesList = repository.findClothes(form);
		model.addAttribute("clothesList", chothesList);
		return "forward:/clothesShop/";
	}
}
