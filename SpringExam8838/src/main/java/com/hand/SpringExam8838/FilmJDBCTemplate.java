package com.hand.SpringExam8838;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


public class FilmJDBCTemplate implements MyDataDAO {
	 private DataSource dataSource;
	 private JdbcTemplate jdbcTemplateObject; 
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	public void insert(Film film) {
		String sql = "insert into film (title,description,language_id) values(?,?,?)";
		jdbcTemplateObject.update(sql,film.getTitle(),film.getDescription(),film.getLanguage_id());
		System.out.println("Before Insert Film Data.");
		System.out.println("After Insert Film Data.");
		
	}
	public void delete(Integer id) {
		String sql = "delete from film where film_id = ?";
		jdbcTemplateObject.update(sql,id);
	}
	public void update(Integer id,String title,String description) {
		String sql = "update film set title = ?,description=? where film_id=?";
		jdbcTemplateObject.update(sql,title,description,id);
	}
	public Film select(Integer id) {
		String sql = "select * from film where film_id = ?";
		Film film = new Film();
		try {
			film = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new FilmMapper());
		} catch (DataAccessException e) {
			System.out.println("条目不存在！");
		}
		return film;
	}
	public List<Film> selectAll() {
		String sql = "select * from Film";
	      List <Film> films = jdbcTemplateObject.query(sql,new FilmMapper());
	    return films;
	}

}
