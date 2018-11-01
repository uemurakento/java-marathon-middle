package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.BaseballTeam;

/**
 * 球団情報のデータベースを処理するリポジトリ.
 * 
 * @author kento.uemura
 *
 */
@Repository
public class BaseballTeamRepository {
	public static final String TABLE_NAME = "baseball_teams";
	@Autowired
	public NamedParameterJdbcTemplate template;
	public static final RowMapper<BaseballTeam> BASEBALL_TEAM_ROWMAPPER = (rs, i) -> {
		BaseballTeam baseballTeam = new BaseballTeam(rs.getInt("id"), rs.getString("team_name"),
				rs.getString("headquarters"), rs.getString("inauguration"), rs.getString("history"));
		return baseballTeam;
	};

	/**
	 * ロード操作(一件検索).
	 * 
	 * @param id
	 *            主キー
	 * @return 検索された球団オブジェクト
	 * 検索されたものがなかった場合例外が発生する
	 */
	public BaseballTeam load(Integer id) {
		String sql = "SELECT id,team_name,headquarters,inauguration,history FROM " + TABLE_NAME + " WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		BaseballTeam baseballTeam = template.queryForObject(sql, param, BASEBALL_TEAM_ROWMAPPER);
		return baseballTeam;
	}

	/**
	 * 全件検索.
	 * 
	 * @return 検索された球団オブジェクトを格納するList 
	 * 検索されたものがなかった場合からのListが返される
	 */
	public List<BaseballTeam> findAll() {
		String sql = "SELECT id,team_name,headquarters,inauguration,history FROM " + TABLE_NAME + ";";
		SqlParameterSource param = new MapSqlParameterSource();
		List<BaseballTeam> baseballTeams = template.query(sql, param, BASEBALL_TEAM_ROWMAPPER);
		return baseballTeams;
	}
}
