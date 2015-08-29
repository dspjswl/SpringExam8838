package com.hand.SpringExam8838;

import java.util.List;

import javax.sql.DataSource;


public interface MyDataDAO {
	public void setDataSource(DataSource ds);
	public void insert(Film film);
	public void delete(Integer id);
	public void update(Integer id ,String title,String description);
	public Film select(Integer id);
	public List<Film> selectAll();
}
