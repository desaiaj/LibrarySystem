package ca.sheridancollege.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.BookStore;

@Repository
public class DatabaseAccess {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public void addBook(BookStore book) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO books(Title,Author,Price,CourseCode,Davis_Qty,HMC_Qty,Traf_Qty)"
				+ "VALUES (:Title,:Author,:Price,:CourseCode,:Davis_Qty,:HMC_Qty,:Traf_qty)";
		parameters.addValue("Title", book.getTitle());
		parameters.addValue("Author", book.getAuthor());
		parameters.addValue("Price", book.getPrice());
		parameters.addValue("CourseCode", book.getCourseCode());
		parameters.addValue("Davis_Qty", book.getDavis_Qty());
		parameters.addValue("HMC_Qty", book.getHMC_Qty());
		parameters.addValue("Traf_qty", book.getTraf_Qty());
		jdbc.update(query, parameters);
	}

	public void GenerateDummy(List<BookStore> Dummybook) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO books(Title,Author,Price,CourseCode,Davis_Qty,HMC_Qty,Traf_Qty) VALUES";

		for (int i = 0; i < Dummybook.size(); i++) {
			query += " (:Title" + i + ",:Author" + i + ",:Price" + i + ",:CourseCode" + i + ",:Davis_Qty" + i
					+ ",:HMC_Qty" + i + ",:Traf_qty" + i + ")";

			parameters.addValue("Title" + i, Dummybook.get(i).getTitle());
			parameters.addValue("Author" + i, Dummybook.get(i).getAuthor());
			parameters.addValue("Price" + i, Dummybook.get(i).getPrice());
			parameters.addValue("CourseCode" + i, Dummybook.get(i).getCourseCode());
			parameters.addValue("Davis_Qty" + i, Dummybook.get(i).getDavis_Qty());
			parameters.addValue("HMC_Qty" + i, Dummybook.get(i).getHMC_Qty());
			parameters.addValue("Traf_qty" + i, Dummybook.get(i).getTraf_Qty());
			if (i < Dummybook.size() - 1)
				query += ",";

		}
		//System.out.println(query);
		jdbc.update(query, parameters);
	}

	public ArrayList<BookStore> getAllBooks() {
		String q = "Select * From books";
		ArrayList<BookStore> Books = (ArrayList<BookStore>) jdbc.query(q,
				new BeanPropertyRowMapper<BookStore>(BookStore.class));
		return Books;
	}

	public BookStore getBookByName(String Title) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "select * from books where Title=:title";
		param.addValue("title", Title);
		return (BookStore) jdbc.query(q, param, new BeanPropertyRowMapper<BookStore>(BookStore.class)).get(0);
	}

	public BookStore getBookById(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "select * from books where BookID=:id";
		param.addValue("id", id);
		return (BookStore) jdbc.query(q, param, new BeanPropertyRowMapper<BookStore>(BookStore.class)).get(0);
	}

	public void setBookById(BookStore book) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "update books set Title = :Title,Author =:Author,Price =:Price,CourseCode =:CourseCode,"
				+ "Davis_Qty =:Davis_Qty,HMC_Qty =:HMC_Qty,Traf_Qty =:Traf_qty WHERE BookID=:bookID";
		param.addValue("bookID", book.getBookID());
		param.addValue("Title", book.getTitle());
		param.addValue("Author", book.getAuthor());
		param.addValue("Price", book.getPrice());
		param.addValue("CourseCode", book.getCourseCode());
		param.addValue("Davis_Qty", book.getDavis_Qty());
		param.addValue("HMC_Qty", book.getHMC_Qty());
		param.addValue("Traf_qty", book.getTraf_Qty());
		jdbc.update(q, param);
	}

	public void deleteBookById(int bookID, String campus) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "UPDATE books SET " + campus + "='false' WHERE BookID=:ID";
		param.addValue("ID", bookID);
		jdbc.update(q, param);
	}

	public void PurchaseBook(int bookID, String Campus, int Qty) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "UPDATE books SET " + Campus + "=:Qty WHERE BookID=:ID";
		param.addValue("ID", bookID);
		param.addValue("Qty", String.valueOf(Qty));
		//System.out.println(q);
		jdbc.update(q, param);

	}

	public void deleteBook(int bookID) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "DELETE FROM books WHERE BookID=:ID";
		param.addValue("ID", bookID);
		jdbc.update(q, param);
	}

	public ArrayList<BookStore> getSearchedBooks(int bookID, String title, String author, String courseCode,
			int min_Qty, int max_Qty) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String q = "Select * From books Where 1=1";
		if (bookID != 0) {
			q += " AND BookID=:ID";
			param.addValue("ID", bookID);
		}		
		if (!title.equalsIgnoreCase("null")) {
			q += " AND Title like :title";
			param.addValue("title", '%' + title + '%');
		}
		if (!author.equalsIgnoreCase("null")) {
			q += " AND Author like :author";
			param.addValue("author", '%' + author + '%');
		}
		if (!courseCode.equalsIgnoreCase("null")) {
			q += " AND CourseCode like :courseCode";
			param.addValue("courseCode", '%' + courseCode + '%');
		}
		if (max_Qty > 0) {
			q += " AND cast(Davis_Qty as SIGNED)+cast(HMC_Qty as SIGNED)+cast(Traf_Qty as SIGNED) between :min AND :max";
			param.addValue("min", min_Qty);
			param.addValue("max", max_Qty);
		}
		//System.out.println(q);
		ArrayList<BookStore> Books = (ArrayList<BookStore>) jdbc.query(q, param,
				new BeanPropertyRowMapper<BookStore>(BookStore.class));
		return Books;
	}

}
