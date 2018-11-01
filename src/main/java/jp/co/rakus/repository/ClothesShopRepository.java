package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.Form.ClothesShopForm;
import jp.co.rakus.domain.Clothes;

/**
 * 洋服検索をするリポジトリ.
 * 
 * @author kento.uemura
 *
 */
@Repository
@Transactional
public class ClothesShopRepository {
	private static final String TABLE_NAME = "shops";
	@Autowired
	public NamedParameterJdbcTemplate template;
	private static final RowMapper<Clothes> CLOTHES_ROWMAPPER = (rs,i) ->{
		Clothes clothes = new Clothes(rs.getString("genre"),rs.getString("color"),rs.getInt("price"));
		return clothes;
	};
	
	/**
	 * 入力されたフォームから一致する洋服のリストを出力する.
	 * 
	 * @param form 入力されたフォーム
	 * @return 検索された洋服情報を格納したリスト
	 * 何も検索されなかった場合は空のリストを返す
	 */
	public List<Clothes> findClothes(ClothesShopForm form){
		String sql = "SELECT genre,color,price FROM "+TABLE_NAME+" WHERE color=:color AND gender=:gender";
		SqlParameterSource param = new MapSqlParameterSource().addValue("color", form.getColor()).addValue("gender", form.getGender());
		List<Clothes> clothesList = template.query(sql, param,CLOTHES_ROWMAPPER);
		return clothesList;
	}

}
