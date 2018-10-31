package jp.co.rakus.domain;

public class Hotel {
	private String hotelName;
	private String nearestStation;
	private Integer price;
	public Hotel() {}
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
