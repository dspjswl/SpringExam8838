package com.hand.SpringExam8838;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class FilmMapper implements RowMapper<Film> {

	public Film mapRow(ResultSet rs, int rownum) throws SQLException {
		Film film = new Film();
		film.setId(rs.getInt("film_id"));
		film.setTitle(rs.getString("title"));
		film.setLanguage_id(1);
		return film;
	}

}
