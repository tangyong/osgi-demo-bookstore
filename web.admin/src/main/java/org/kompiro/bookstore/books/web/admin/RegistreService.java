package org.kompiro.bookstore.books.web.admin;

import java.util.List;

import org.kompiro.bookstore.books.model.Book;
import org.kompiro.bookstore.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register.htm")
public class RegistreService {

	@Autowired
	BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public String registerForm(ModelMap model) {
		return "registerForm" ;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doRegister(String name,String author,int price, ModelMap model) {
//		List<Book> books = bookService.find(name);
//		if(isExist(books)){
//			return "exists";			
//		}
		Book book = bookService.register(name, author, price);
		model.addAttribute("book",book);
		return "registerResults";
	}

//	private boolean isExist(List<Book> books) {
//		return books.isEmpty();
//	}

	
}
