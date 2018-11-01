package jp.co.rakus.Form;

/**
 * 洋服検索のフォーム.
 * 
 * @author kento.uemura
 *
 */
public class ClothesShopForm {
	/** 性別 */
	private Integer gender;
	/** 服の色 */
	private String color;
	
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
