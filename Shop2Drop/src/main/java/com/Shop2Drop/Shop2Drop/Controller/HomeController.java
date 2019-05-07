package com.Shop2Drop.Shop2Drop.Controller;

import com.Shop2Drop.Shop2Drop.entity.Product;
import com.Shop2Drop.Shop2Drop.entity.Role;
import com.Shop2Drop.Shop2Drop.entity.User;
import com.Shop2Drop.Shop2Drop.entity.UserRole;
import com.Shop2Drop.Shop2Drop.security.PasswordResetToken;
import com.Shop2Drop.Shop2Drop.service.ProductService;
import com.Shop2Drop.Shop2Drop.service.UserSecurityService;
import com.Shop2Drop.Shop2Drop.service.UserService;
import com.Shop2Drop.Shop2Drop.utility.MailConstructor;
import com.Shop2Drop.Shop2Drop.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.*;
import java.util.stream.Stream;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@Autowired
	UserSecurityService userSecurityService;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MailConstructor mailContructor;

	@Autowired
	private ProductService productService;
	@RequestMapping("/")
	public String index() {
		return "index";
	}


	@RequestMapping("/myProfile")
	public String myProfile() {
		return "myProfile";
	}

	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("classActiveLogin",true);
		return "myAccount";
	}

	@RequestMapping(value = "/newUser",method = RequestMethod.POST)
	public String newUserPost(Model model,HttpServletRequest request, @ModelAttribute("email") String userEmail,@ModelAttribute("newUsername") String username) throws Exception{
		model.addAttribute("classActiveNewAccount", true);
		model.addAttribute("email", userEmail);
		model.addAttribute("username",username);

		if(userService.findByUsername(username)!=null){
			model.addAttribute("usernameExists",true);
			return "myAccount";
		}

		if(userService.findByEmail(userEmail)!=null){
			model.addAttribute("emailExists",true);
			return "myAccount";
		}

		User user=new User();
		user.setUsername(username);
		user.setEmail(userEmail);

		String password= SecurityUtility.randomPassword();
		String encryptPassword=SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptPassword);

		Role role=new Role();
		role.setRoleid(1);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles=new HashSet<>();
		userRoles.add(new UserRole(user,role));
		userService.createUser(user,userRoles);

		String token= UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user,token);
		String appUrl="http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		SimpleMailMessage email=mailContructor.constructResetTokenEmail(appUrl,request.getLocale(),token,user,password);

		mailSender.send(email);
		model.addAttribute("emailSent",true);
		return "myAccount";
	}

	@RequestMapping("/productList")
	public String productList(Model model)
	{
		List<Product> productList=productService.findAll();
		model.addAttribute("productList",productList);
		return "ProductList";
	}

	@RequestMapping("/newUser")
	public String createAccount(Model model, Locale locale, @RequestParam("token")String token){

		PasswordResetToken passToken=userService.getPasswordResetToken(token);

		if(passToken==null){
			String message="Invalid Token";
			model.addAttribute("message",message);
			return "redirect:/badRequest";
		}

		User user=passToken.getUser();
		String username=user.getUsername();

		UserDetails userDetails=userSecurityService.loadUserByUsername(username);

		Authentication authentication=new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		model.addAttribute("user",user);

		model.addAttribute("classActiveNewAccount",true);
		return "myProfile";
	}
	@RequestMapping("/forgetPassword")
	public String forgotPassword(Model model,HttpServletRequest request, @ModelAttribute("email") String userEmail,@ModelAttribute("newUsername") String username) throws Exception {
		model.addAttribute("classActiveForgotPassword",true);
		User user=userService.findByEmail(userEmail);
		if(user==null){
			model.addAttribute("emailNotExists", true);
			return "myAccount";
		}

		String password= SecurityUtility.randomPassword();
		String encryptPassword=SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptPassword);

		userService.save(user);

		String token= UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user,token);
		String appUrl="http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		SimpleMailMessage email=mailContructor.constructResetTokenEmail(appUrl,request.getLocale(),token,user,password);

		mailSender.send(email);
		model.addAttribute("emailSent",true);
		model.addAttribute("username",username);

		return "myProfile";
	}

	@RequestMapping("/productDetails")
	public String productDetails(@PathParam("id") Long id, Model model, Principal principal){
		if(principal!=null){
			String username=principal.getName();
			User user=userService.findByUsername(username);
			model.addAttribute("user",user);
		}
		Product product=productService.findOne(id);
		model.addAttribute("product",product);
		List<Integer> qtyList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		model.addAttribute("qtyList",qtyList);
		model.addAttribute("qty",1);
		return "ProductDetails";
	}

}
