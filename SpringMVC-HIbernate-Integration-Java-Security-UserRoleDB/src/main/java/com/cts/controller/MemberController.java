package com.cts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.entity.Book;
import com.cts.service.BookService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	BookService bs;
	

	@GetMapping("/")
	public String homepage(Model model) {
		return "home";
	}
	
	 @RequestMapping(value="/logout", method=RequestMethod.GET)  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);
	           System.out.println(" Logout");
	        }  
	         return "redirect:/";  
	     }  
	@GetMapping("/list")
	public String listAllMembers(Model model) {
		/*System.out.println(" Entered in List abook");
		List<Book> lb= bs.listAllBooks();
		System.out.println(" Booklist: "+lb);
		model.addAttribute("books",lb);
		return "booklist";
	*/
		return "memberlist";
		
	}
	/*
  @GetMapping("/showForm")
	    public String showFormForAdd(Model theModel) {
		 System.out.println(" I will accept book data");
	        Book theBook = new Book();
	        theModel.addAttribute("book", theBook);
	        return "addbook";
	    }
	 
	 @PostMapping("/saveBook")
	    public String saveABook(@ModelAttribute("book") Book  theBook) {
	        bs.saveBook(theBook);
	        return "redirect:/book/list";

}
	
	 @GetMapping("/updateForm")
	    public String showFormForUpdate(@RequestParam("bookId") int theId,
	        Model theModel) {
	        Book theBook = bs.getBook(theId);
	        theModel.addAttribute("book", theBook);
	        return "addbook";
	    }
	 
	 @GetMapping("/delete")
	    public String deleteABook(@RequestParam("bookId") int theId) {
	        bs.deleteBook(theId);
	        return "redirect:/book/list";
	    }
*/	 
}