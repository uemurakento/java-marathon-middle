package jp.co.rakus.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.BaseballTeam;
import jp.co.rakus.repository.BaseballTeamRepository;

/**
 * 球団情報を扱うコントローラー.
 * 
 * @author kento.uemura
 *
 */
@Controller
@Transactional
@RequestMapping("/baseballTeam")
public class BaseballTeamController {
	@Autowired
	private ServletContext application;
	@Autowired
	private BaseballTeamRepository repository;
	
	/**
	 * 一覧画面を表示する.
	 * 
	 * @return 一覧画面
	 */
	@RequestMapping("/")
	public String index() {
		if(application.getAttribute("baseballTeams") == null) {
			List<BaseballTeam> baseballTeams = repository.findAll();
			application.setAttribute("baseballTeams", baseballTeams);
		}
		return "baseballteamlist";
	}
	
	/**
	 * 詳細画面を表示する.
	 * 
	 * @param id 指定する主キー
	 * @param model モデル
	 * @return 詳細画面
	 */
	@RequestMapping("/reference")
	public String reference(Integer id,Model model) {
		BaseballTeam baseballTeam = repository.load(id);
		model.addAttribute("baseballTeam",baseballTeam);
		return "reference";
	}
}
