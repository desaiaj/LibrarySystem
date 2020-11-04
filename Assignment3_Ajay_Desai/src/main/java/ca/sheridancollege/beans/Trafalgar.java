package ca.sheridancollege.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trafalgar {
	private int TrafID;
	private int BookID;
	private int Traf_Qty;

	public Trafalgar(int bookID, int traf_Qty) {
		BookID = bookID;
		Traf_Qty = traf_Qty;
	}

}
