package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.domain.Hotel;

@Repository
@Transactional
public class HotelSerchRepository {
	public static final String TABLE_NAME = "hotels";
	@Autowired
	public NamedParameterJdbcTemplate template;
	public static final RowMapper<Hotel> HOTEL_ROWMAPPER = (rs, i) -> {
		Hotel hotel = new Hotel(rs.getString("hotel_name"),rs.getString("nearest_station"),rs.getInt("price"));
		return hotel;
	};
	
	public List<Hotel> findPrice(Integer price){
		String sql = "SELECT hotel_name,nearest_station,price FROM " + TABLE_NAME + " WHERE price<=:price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotels = template.query(sql, param, HOTEL_ROWMAPPER);
		return hotels;
	}
}
