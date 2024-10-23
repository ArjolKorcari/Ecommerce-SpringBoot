package com.eCommerce.Ecommerce.Project.controllers.frontend;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;



//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.eCommerce.Ecommerce.Project.models.CartProduct;
import com.eCommerce.Ecommerce.Project.models.Category;
import com.eCommerce.Ecommerce.Project.models.Product;
import com.eCommerce.Ecommerce.Project.models.User;
import com.eCommerce.Ecommerce.Project.services.CartProductsService;
import com.eCommerce.Ecommerce.Project.services.CartService;
import com.eCommerce.Ecommerce.Project.services.CategoryService;
import com.eCommerce.Ecommerce.Project.services.ProductService;

//import com.eCommerce.Ecommerce.Project.repository.UserRepo;

import com.eCommerce.Ecommerce.Project.services.UserService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private CategoryService categoryService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartProductsService cartProductsService;
    
	
	@GetMapping("/")
	public String getProducts() {
		return "redirect:products";		
	}
	
	
	@GetMapping("login")
	public String userLogin(Model model) {
		return "userLogin";
	}
	@RequestMapping(value = "newuserregister", method = RequestMethod.POST)
	public ModelAndView newUserRegister(@Valid User user , BindingResult result) {
		if(result.hasErrors()) {
			ModelAndView view= new ModelAndView("register");
			
			return view;
		}
		// shik nqs usersi egziston ne databaz
		
		Boolean exists= this.userService.checkUserExists(user.getUsername(), user.getEmail());
		System.out.println(exists);
		
		if(!exists) {
			user.setRole("ROLE_NORAL");
			this.userService.addUser(user);
			
			ModelAndView mView =  new ModelAndView("userLogin");
			return mView;
		}else  {
			
			ModelAndView mView = new ModelAndView("register");
			mView.addObject("msg", user.getUsername() + " is taken. Please choose a different username.");
			return mView;
		}
	}
	
	
	@RequestMapping(value = "products", method = RequestMethod.POST)
	public ModelAndView userlogin(@RequestParam String username,
			@RequestParam String password,  
			HttpServletResponse res, ModelMap model) {
		
		User user= (User) this.userService.checkLogin(username, password);
		
		
		if(user!=null && username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			
			
			
			userService.postUser(user);
			model.put("username", user.getUsername());
			res.addCookie(new jakarta.servlet.http.Cookie("username", user.getPassword()));
			ModelAndView mView  = new ModelAndView("index");	
			mView.addObject("user", user);
			
			List<Product> products= this.productService.getProducts();
			List<Category> categories=  categoryService.getCategories();
			List<Product> popularProd= this.productService.getPopularProducts();
			model.put("categories", categories);
			mView.addObject("popularProducts",popularProd);

			if (products.isEmpty()) {
				mView.addObject("msg", "No products are available");
			} else {
				mView.addObject("products", products);
				 mView.addObject("showProductCarousel", true);
			}
			return mView;

		}
		
			ModelAndView mView = new ModelAndView("userLogin");
			mView.addObject("msg", "Please enter correct email and password");
			return mView;
		
	}
	
	
	
	@GetMapping("/register")
	public String registerUser() {
		return "register";
	}
	
	

	
	@GetMapping("products")
	public ModelAndView getProduct() {
		
		
		ModelAndView mView= new ModelAndView("index");
		
		User user = this.userService.getUser();
		List<Product> products= this.productService.getProducts();
		List<Category> categories=  categoryService.getCategories();
		List<Product> popularProd= this.productService.getPopularProducts();
		mView.addObject("categories",categories);
		mView.addObject("user",user);
		mView.addObject("popularProducts",popularProd);
		if(products.isEmpty()) {
			mView.addObject("msg","No products are available");
		}else {
			mView.addObject("products", products);
			 mView.addObject("showProductCarousel", true);
		}
		return mView;
		
	}
	
	
	@GetMapping("/category")
	public String showProductsByCategory(@RequestParam int id , ModelMap model) {
		User user = this.userService.getUser();
		List<Product> products= this.productService.findProductByCategory(id);
		List<Category> categories=  categoryService.getCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("products", products);
		model.addAttribute("user",user);
		return "index";
	}
	
	
	@GetMapping("list-categories")
	public String listAllCategories (ModelMap model) {
		//String username= (String)model.get("name");
		List<Category> categories=  categoryService.getCategories();
		
		model.addAttribute("categories", categories);
		return "listCategories";
		
	}
	
	@GetMapping("search")
	public String seachBar(@RequestParam String keyword, ModelMap model) {
		List<Product> products= this.productService.searchProducts(keyword);
		List<Category> categories= categoryService.getCategories();
		User user = this.userService.getUser();
		model.addAttribute("categories", categories);
		model.addAttribute("products", products);
		model.addAttribute("user",user);
		return "index";
	}
	

	
//	@PostMapping("/add-to-cart")
//	public String addToCart(@RequestParam int id , ModelMap model){
//		List<Product> products= cartService.createProductList(id);
//		model.addAttribute("product", products);
//		return "redirect:products";
//	}
	
	
	
	@PostMapping("/add-to-cart")
	public String addToCart(@RequestParam int id , @RequestParam int quantity, ModelMap model){
		List<CartProduct> cartProducts= cartProductsService.addToCart(id, quantity);
		//List<Product> products= cartService.createProductList(id);
		model.addAttribute("product", cartProducts);
		return "redirect:products";
	}
	
	@GetMapping("getCarts")
	public String getCartProducts(ModelMap model){
		List<CartProduct> cartProducts = cartProductsService.getCartProducts();
		
		User user = this.userService.getUser();
		
		double subtotal = cartProductsService.calculateSubtotal();
		
		int quantity= cartProductsService.totatlQuantity();
		List<Integer> number=cartService.number();
		model.addAttribute("user",user);
		model.addAttribute("number", number);
		model.addAttribute("quantity", quantity);
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("cartProducts", cartProducts);
		return "cart";
	}
	
	@PostMapping("update-quantity") 
	public String updateQuantity(@RequestParam int id , @RequestParam int quantity, ModelMap model){
		List<CartProduct> cartProducts= cartProductsService.addToCart(id, quantity);
		
		return "redirect:getCarts";
	}
	
	
	@GetMapping("list")
	@ResponseBody
	public List<CartProduct> list(){
		return cartProductsService.getCartProducts();
	}
	

	
	
	
	
	@RequestMapping("delete-products")
	public String deleteCartProducts (@RequestParam int id) {
		cartProductsService.deleteCartProduct(id);
		return "redirect:getCarts";
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/logout")
	public String logut() {
		this.userService.logout();
		return "userLogin";
	}
	
	@GetMapping("checkout")
	public String checkout(ModelMap model) {
		
		List<CartProduct> cartProducts = cartProductsService.getCartProducts();
		 double subtotal = cartProductsService.calculateSubtotal();
		
		int quantity= cartProductsService.totatlQuantity();
		
		model.addAttribute("cartProducts", cartProducts);
		model.addAttribute("quantity", quantity);
		model.addAttribute("subtotal", subtotal);
		
		
		return "checkout";
	}
	
	@PostMapping("checkout")
	public String discount(@RequestParam String code, ModelMap model) {
	    
		
		double subtotal=cartService.discountPrice(code);
		model.addAttribute("subtotal", subtotal);
		return "checkout";
	}
	
	@GetMapping("profileDisplay")
	public String userProfile(@RequestParam(required = false) Integer id, ModelMap model) {
	    if (id == null) {
	        return "userLogin";
	    }
	    
	    User user = userService.findUserById(id);
	    model.addAttribute("user", user);
	    return "displayCostumer";
	}
	
	@PostMapping("updateUser")
	public String updateUser(@ModelAttribute User user, ModelMap model) {
		
		Boolean exists= this.userService.checkUserExists(user.getUsername(), "");
		
		System.out.println(exists);
		if(!exists ) {
			 user.setRole("ROLE_NORAL");
			 userService.updateUser(user);
			    userService.postUser(user);
			    model.addAttribute("msge", "User updated succesfully");
		}
		else {
			model.addAttribute("msge", user.getUsername() + " is taken please choose a different username ");
		}
		
	   
	    return "displayCostumer";
		
	}
	
	@PostMapping("changePassword")
	public  ModelAndView changePassword(@RequestParam String currentPassword, @RequestParam String newPassword, @RequestParam String newPassword2 ) {
		Boolean check= this.userService.changePassword(currentPassword, newPassword, newPassword2);
		ModelAndView view= new ModelAndView("displayCostumer");
		 User user=userService.getUser();
		view.addObject("user", user);
		if(check) {
			view.addObject("msg","Password changed succesfully!");
		}else {
			view.addObject("msg", "Enter correct password");
		}
			return view;
	}
 
	
	@PostMapping("confirmed")
	public String succesPage() {
		return "confirmed";
	}
	
	@GetMapping("test")
	public String test(ModelMap map) {
		List<CartProduct> cartProducts = cartProductsService.getCartProducts();
		map.addAttribute("cartProducts", cartProducts);
		return "test";
	}


	
	
	

	

}
