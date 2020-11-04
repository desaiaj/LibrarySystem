package ca.sheridancollege.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HMC {
	private int HMCID;
	private int BookID;
	private int HMC_Qty;

	public HMC(int bookID, int hMC_Qty) {
		BookID = bookID;
		HMC_Qty = hMC_Qty;
	}

}
