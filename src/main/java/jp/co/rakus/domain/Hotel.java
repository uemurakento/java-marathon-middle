package jp.co.rakus.domain;

/**
 * ホテル情報を表すドメイン.
 * 
 * @author kento.uemura
 *
 */
public class Hotel {
	/** ホテル名 */
	private String hotelName;
	/** 最寄り駅 */
	private String nearestStation;
	/** 値段 */
	private Integer price;

	public Hotel() {
	}

	public Hotel(String hotelName, String nearestStation, Integer price) {
		super();
		this.hotelName = hotelName;
		this.nearestStation = nearestStation;
		this.price = price;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
