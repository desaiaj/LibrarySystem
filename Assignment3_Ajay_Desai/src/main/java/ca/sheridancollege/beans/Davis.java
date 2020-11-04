package ca.sheridancollege.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Davis {
	private int DavisID;
	private int BookID;
	private int Davis_Qty;

	public Davis(int bookID, int davis_Qty) {
		BookID = bookID;
		Davis_Qty = davis_Qty;
	}
}
