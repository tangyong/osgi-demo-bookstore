package org.kompiro.bookstore.web;

import java.util.List;

import org.kompiro.bookstore.books.model.Book;
import org.kompiro.bookstore.books.service.BookService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/search.htm")
public class SearchController {

	public SearchController(){
		System.out.println("SearchController.SearchController()");
	}
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showSearchForm(String searchString, ModelMap model) {
		System.out.println("SearchController.showSearchForm()");
	if(searchString != null) return doSearch(searchString, model);
	return "searchForm" ;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doSearch(String searchString, ModelMap model) {
		List<Book> books = bookService.find(searchString);
		System.out.println(books.size());
		model.addAttribute("books",books);
		return "searchResults";
	}
	
}