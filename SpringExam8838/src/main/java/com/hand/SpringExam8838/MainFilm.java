package com.hand.SpringExam8838;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
	import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.hand.SpringExam8838.Film;

public class MainFilm {
		public static void main(String[] args) throws SQLException {
			System.out.println("Context Start");
			System.out.print("请输入电影名称(title):");
		    Scanner scan1 = new Scanner(System.in);
		    String title = scan1.nextLine();
		    
		    System.out.print("请输入电影描述(description):");
		    Scanner scan2 = new Scanner(System.in);
		    String description = scan2.nextLine();
		    
		    System.out.print("请输入语言 ID(language_id):");
		    Scanner scan3 = new Scanner(System.in);
		    int language_id = scan3.nextInt();
		    
			ApplicationContext context = 
					new ClassPathXmlApplicationContext("ApplicationContext.xml");
			FilmJDBCTemplate filmJDBCTemplate = new FilmJDBCTemplate();
			Properties prop = new Properties();
			try {
				InputStream is = MainFilm.class.getClassLoader().getResourceAsStream("dbconfig.properties");
				prop.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(prop.getProperty("driver"));
			dataSource.setUrl(prop.getProperty("dburl"));
			dataSource.setUsername(prop.getProperty("user"));
			dataSource.setPassword(prop.getProperty("password"));
			
			filmJDBCTemplate.setDataSource(dataSource);
			
			Film film = new Film();
			film.setTitle(title);
			film.setDescription(description);
			film.setLanguage_id(language_id);
			filmJDBCTemplate.insert(film);
			System.out.println("Context Stop");
		}
	}

