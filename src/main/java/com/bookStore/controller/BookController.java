package com.bookStore.controller;

import com.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;

import java.util.*;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private MyBookListService myBookService;

	@GetMapping("/")
	public String home() {
		return "home";
	}


	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/search")
	public String searchBooks(@RequestParam("name") String name, Model model) {
		// Tìm các cuốn sách có tên chứa chuỗi tìm kiếm, không phân biệt chữ hoa chữ thường
		List<Book> books = bookRepository.findByNameContainingIgnoreCase(name);
		model.addAttribute("book", books);
		return "searchResults"; // Đây là tên template bạn sẽ trả về
	}


	@GetMapping("/book_register")
	@PreAuthorize("hasRole('ADMIN')")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = service.getAllBook();
		return new ModelAndView("bookList", "book", list);
	}

	@PostMapping("/save")
	@PreAuthorize("hasRole('ADMIN')")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	@PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookService.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}

	@RequestMapping("/mylist/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
}
