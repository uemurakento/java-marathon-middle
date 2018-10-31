package jp.co.rakus.Form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 金額を入れるフォーム.
 * 
 * @author kento.uemura
 *
 */
public class HotelSerchForm {
	/** 金額 */
	@Size(min=1,max=10,message="金額は1桁以上10桁以下で入力してください")
	@Pattern("[1-9][0-9]+")
	private Integer price;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
