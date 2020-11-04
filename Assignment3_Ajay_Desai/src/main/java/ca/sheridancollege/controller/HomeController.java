package ca.sheridancollege.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.BookStore;
import ca.sheridancollege.beans.Davis;
import ca.sheridancollege.beans.HMC;
import ca.sheridancollege.beans.Trafalgar;
import ca.sheridancollege.database.DatabaseAccess;

@Controller
public class HomeController {
	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String home() {
		return "index.html";
	}

	@GetMapping("/AddBook")
	public String goAddBook() {
		return "AddBook.html";
	}

	@GetMapping("/GenerateDummy")
	public String goGenerateDummy() {

		BookStore.getDummy().clear();
		BookStore B1 = new BookStore("Learn Java 12 Programming", "Nick Samoylov", 34.99,
				"PROG32758, PROG10082, PROG24178", "10", "3", "0", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Learn Java in One Day", "Jamie Chan", 11.33, "PROG10082", "false", "20", "false", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Java: A Beginner's Guide", "Herbert Schildt", 26.66, "PROG24178, PROG10082", "40", "0",
				"false", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Java: The Complete Reference", "Herbert Schildt", 39.51, "PROG32758, PROG10082, PROG24178",
				"14", "3", "3", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Mastering Java", "Michael B. White", 17.97, "PROG32758, PROG10082, PROG24178", "1", "3",
				"6", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Core Java, Volume II-Advanced Features", "Cay S. Horstmann", 35.49, "PROG32758, PROG24178",
				"6", "2", "false", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Java: Advanced Features and Programming Techniques", "Nathan Clark", 16.38, "PROG32758",
				"false", "1", "false", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Learn JavaScript Visually", "Ivelin Demirov", 31.00, "SYST10049", "10", "3", "9", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Web Programming with HTML5, CSS, and JavaScript", "John Dean", 72.36, "SYST10199", "9", "5",
				"1", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Learning Web Design: A Beginner's Guide", "Jennifer Robbins", 32.57, "SYST10199, SYST10049",
				"1", "1", "1", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("The Full Stack Developer", "Chris Northwood", 27.24, "SYST10199, SYST10049", "4", "7",
				"false", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("HTML & CSS for Complete Beginners", "Ikram Hawramani", 14.95, "SYST10049", "3", "3", "2",
				0);
		B1.SetDummyRecord();

		B1 = new BookStore("Learn Web Development with Python", "Fabrizio Romano", 49.99, "SYST10199, PROG32758",
				"false", "1", "2", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("HTML, CSS & JavaScript Web Publishing in One Hour a Day, Sams Teach Yourself",
				"Laura Lemay", 30.09, "SYST10199, SYST10049, SYST28951", "3", "3", "3", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Applied Network Security Monitoring: Collection, Detection, and Analysis", "Chris Sanders",
				39.49, "INFO24178, TELE13167", "2", "3", "1", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Hacking With Kali Linux: A Complete Guide for Beginners to Hacking, Security",
				"Alan Scripting", 19.39, "INFO24178", "7", "6", "false", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("High-Speed Cisco Networks: Planning, Design, and Implementation", "John R. Vacca", 108,
				"TELE13167, PROG10082", "4", "8", "2", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("NETWORKING HACKING: Complete guide tools for computer wireless network technology",
				"Erickson Karnel", 46.04, "INFO24178", "1", "3", "2", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("CWNA Certified Wireless Network Administrator Official Study Guide", "David D. Coleman",
				79.90, "INFO24178, TELE13167", "1", "1", "1", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Linux Basics for Hackers: Getting Started with Networking, Scripting, and Security in Kali",
				"OccupyTheWeb", 72.5, "INFO24178", "4", "7", "2", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Hacking with Kali Linux: Wireless Penetration", "Grzegorz Nowak", 26.79, "INFO24178",
				"false", "1", "false", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("C Programming Language, 2nd Edition", "Brian W. Kernighan, Dennis M. Ritchie", 66.79,
				"PROGC58795", "8", "1", "false", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Introduction to Algorithms", "Thomas H. Cormen, Charles E. Leiserson", 89.10,
				"PROG79525, PROG32758", "6", "1", "0", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("SQL in 10 Minutes, Sams Teach Yourself", "Ben Forta", 28.13, "DBAS27198", "2", "false", "1",
				0);
		B1.SetDummyRecord();

		B1 = new BookStore("PHP and MySQL Web Development", "Laura Thomson", 14.90, "PROG97655", "1", "1", "false", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Python for Data Analysis: Data Wrangling with Pandas, NumPy and IPython", "Wes McKinney",
				14.55, "PROG97855", "1", "2", "3", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Data Structures and Algorithms Made Easy", "Narasimha Karumanchi", 44.99,
				"PROG97855, PROG72569", "2", "1", "3", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Computer Architecture: A Quantitative Approach (ISSN)",
				"John L. Hennessy, David A. Patterson", 416.39, "SYST26671", "3", "2", "1", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("Cisco CCNA complete reference", "Cisco", 79.27, "INFO24178, TELE13167", "9", "25", "0", 0);
		B1.SetDummyRecord();

		B1 = new BookStore("PHP programming with web", "Jems", 47.27, "WEB79455, PROG79994", "false", "1", "4", 0);
		B1.SetDummyRecord();

		da.GenerateDummy(BookStore.getDummy());
		return "redirect:/ViewBooks";
	}

	@GetMapping("/Insert")
	public String AddBook(@RequestParam String title, @RequestParam(defaultValue = "0") Double price,
			@RequestParam String author, @RequestParam(defaultValue = "null") String CourseCode,
			@RequestParam(defaultValue = "false") Boolean isDavis, @RequestParam(defaultValue = "false") Boolean isHMC,
			@RequestParam(defaultValue = "false") Boolean isTraf,
			@RequestParam(defaultValue = "false") String davis_qty,
			@RequestParam(defaultValue = "true") String traf_qty,
			@RequestParam(defaultValue = "false") String hmc_qty) {

		String hMC = (isHMC ? hmc_qty : isHMC.toString());
		String davis = (isDavis ? davis_qty : isDavis.toString());
		String traf = (isTraf ? traf_qty : isTraf.toString());
		//System.out.println(isDavis.toString() + isHMC + isTraf);
		BookStore book = new BookStore(title, author, price, CourseCode, davis, hMC, traf, 0);
		da.addBook(book);
		return "AddBook.html";
	}

	@GetMapping("/ViewBooks")
	public String viewBooks(@RequestParam(defaultValue = "false") String MSG,
			@RequestParam(defaultValue = "byStore") String page, Model model) {
		ArrayList<BookStore> list = da.getAllBooks();
		model.addAttribute("MSG", MSG);
		model.addAttribute("list", list);
		if (page.equalsIgnoreCase("FullList")) {
			for (int i = 0; i < list.size(); i++) {
				int qty = list.get(i).getTotal_Qty();

				if (!list.get(i).getDavis_Qty().equalsIgnoreCase("false")) {
					qty += Integer.parseInt(list.get(i).getDavis_Qty());
				}
				if (!list.get(i).getHMC_Qty().equalsIgnoreCase("false")) {
					qty += Integer.parseInt(list.get(i).getHMC_Qty());
				}
				if (!list.get(i).getTraf_Qty().equalsIgnoreCase("false")) {
					qty += Integer.parseInt(list.get(i).getTraf_Qty());
				}
				list.get(i).setTotal_Qty(qty);
			}
			return "ViewAllBooks.html";
		}
		return "ViewBooks.html";
	}

	@GetMapping("/edit/{id}")
	public String Edit(@PathVariable int id, Model model) {
		BookStore book = da.getBookById(id);
		model.addAttribute("list", book);
		return "editBook.html";
	}

	@GetMapping("/SearchBook")
	public String SearchBook(@RequestParam(defaultValue = "0", required = false) int BookID,
			@RequestParam(defaultValue = "null") String title, @RequestParam(defaultValue = "null") String author,
			@RequestParam(defaultValue = "null") String CourseCode, @RequestParam(defaultValue = "0") int Min_Qty,
			@RequestParam(defaultValue = "0") int Max_Qty, Model model) {
		ArrayList<BookStore> list = da.getSearchedBooks(BookID, title, author, CourseCode, Min_Qty, Max_Qty);
		model.addAttribute("list", list);
		return "ViewBooks.html";
	}

	@GetMapping("/editRecord")
	public String Edit(@RequestParam int BookID, @RequestParam String title,
			@RequestParam(defaultValue = "0") Double price, @RequestParam String author,
			@RequestParam(defaultValue = "null", required = false) String CourseCode,
			@RequestParam(defaultValue = "false") Boolean isDavis, @RequestParam(defaultValue = "false") Boolean isHMC,
			@RequestParam(defaultValue = "false") Boolean isTraf,
			@RequestParam(defaultValue = "false") String davis_qty,
			@RequestParam(defaultValue = "true") String traf_qty,
			@RequestParam(defaultValue = "false") String hmc_qty) {
		String hMC = (isHMC ? hmc_qty : isHMC.toString());
		String davis = (isDavis ? davis_qty : isDavis.toString());
		String traf = (isTraf ? traf_qty : isTraf.toString());
		BookStore book = new BookStore(BookID, title, author, price, CourseCode, davis, hMC, traf, 0);
		da.setBookById(book);
		return "redirect:/ViewBooks?MSG=S";
	}

	@GetMapping("/Purchase/{BookID}/{Campus}/{Qty}")
	public String Purchase(@PathVariable int BookID, @PathVariable String Campus, @PathVariable int Qty) {
		if (!(Campus.equalsIgnoreCase("Traf_Qty") || Campus.equalsIgnoreCase("HMC_Qty")
				|| Campus.equalsIgnoreCase("Davis_Qty"))) {
			return "redirect:/ViewBooks?MSG=F";
		}
		da.PurchaseBook(BookID, Campus, Qty - 1);
		return "redirect:/ViewBooks?MSG=S";
	}

	@GetMapping("/Delete/{BookID}/{Campus}")
	public String Delete(@PathVariable int BookID, @PathVariable String Campus) {
		da.deleteBookById(BookID, Campus);
		return "redirect:/ViewBooks?MSG=S";
	}

	@GetMapping("/DeleteBook/{BookID}")
	public String DeleteBook(@PathVariable int BookID) {
		da.deleteBook(BookID);
		return "redirect:/ViewBooks?MSG=S&page=FullList";
	}

}
