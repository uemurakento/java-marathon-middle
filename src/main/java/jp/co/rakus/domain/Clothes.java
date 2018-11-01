package jp.co.rakus.domain;

/**
 * 洋服を表すドメイン.
 * 
 * @author kento.uemura
 *
 */
public class Clothes {
	/** ジャンル */
	private String genre;
	/** サイズ */
	private String size;
	/** 値段 */
	private Integer price;
	
	public Clothes() {}
	
	public Clothes(String genre, String size, Integer price) {
		this.genre = genre;
		this.size = size;
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
