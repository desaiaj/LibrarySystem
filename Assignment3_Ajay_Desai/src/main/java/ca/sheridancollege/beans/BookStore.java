package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookStore implements Serializable {
	private static final long serialVersionUID = 1L;

	private int BookID;
	private String Title;
	private String Author;
	private double Price;
	private String CourseCode;
	// to check the available qty if it is otherwise False
	private String Davis_Qty;
	private String HMC_Qty;
	private String Traf_Qty;
	private int Total_Qty = 0;

	public BookStore(String title, String author, double price, String courseCode, String davis_Qty, String hMC_Qty,
			String traf_Qty, int total_Qty) {
		Title = title;
		Author = author;
		Price = price;
		CourseCode = courseCode;
		Davis_Qty = davis_Qty;
		HMC_Qty = hMC_Qty;
		Traf_Qty = traf_Qty;
		Total_Qty = total_Qty;
	}

	private static List<BookStore> Dummy = new ArrayList<BookStore>();

	public void SetDummyRecord() {
		Dummy.add(this);
	}

	public static List<BookStore> getDummy() {
		return Dummy;
	}

}