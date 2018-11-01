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

/**
 * ホテル情報を検索するリポジトリ.
 * 
 * @author kento.uemura
 *
 */
@Repository
@Transactional
public class HotelSerchRepository {
	public static final String TABLE_NAME = "hotels";
	@Autowired
	public NamedParameterJdbcTemplate template;
	public static final RowMapper<Hotel> HOTEL_ROWMAPPER = (rs, i) -> {
		Hotel hotel = new Hotel(rs.getString("hotel_name"), rs.getString("nearest_station"), rs.getInt("price"));
		return hotel;
	};

	/**
	 * 引数の金額以下のホテルを検索する.
	 * 
	 * @param price
	 *            検索する金額
	 * @return 検索されたホテルをリストに格納して返す 何も検索されなかった場合からのリストを返す
	 */
	public List<Hotel> findPrice(Integer price) {
		String sql = "SELECT hotel_name,nearest_station,price FROM " + TABLE_NAME + " WHERE price<=:price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotels = template.query(sql, param, HOTEL_ROWMAPPER);
		return hotels;
	}
}
