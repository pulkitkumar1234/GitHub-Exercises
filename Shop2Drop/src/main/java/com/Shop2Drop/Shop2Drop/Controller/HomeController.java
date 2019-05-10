package com.Shop2Drop.Shop2Drop.Controller;

import com.Shop2Drop.Shop2Drop.entity.*;
import com.Shop2Drop.Shop2Drop.security.PasswordResetToken;
import com.Shop2Drop.Shop2Drop.service.*;
import com.Shop2Drop.Shop2Drop.utility.MailConstructor;
import com.Shop2Drop.Shop2Drop.utility.SecurityUtility;
import com.Shop2Drop.Shop2Drop.utility.USConstants;
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

	@Autowired
	private UserPaymentService userPaymentService;

	@Autowired
	private UserShippingService userShippingService;
	@RequestMapping("/")
	public String index() {
		return "index";
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

	@RequestMapping("/myProfile")
	public String myProfile(Model model,Principal principal){
		User user=userService.findByUsername(principal.getName());
		model.addAttribute("user",user);
		model.addAttribute("userPaymentList",user.getUserPaymentList());
		model.addAttribute("userShippingList",user.getUserShippingList());
		//model.addAttribute("orderList",user.getOrderList());

		UserShipping userShipping=new UserShipping();
		model.addAttribute("userShipping",userShipping);

		model.addAttribute("listOfCreditCards",true);
		model.addAttribute("listOfShippingAddresses",true);

		List<String> stateList= USConstants.listOfUSStatesCode;
		Collections.sort(stateList);
		model.addAttribute("statelist",stateList);
		model.addAttribute("classActiveEdit",true);
		return "myProfile";

	}

	@RequestMapping("/listOfCreditCards")
	public String listOfCreditCards(Model model,Principal principal,HttpServletRequest request){
		User user=userService.findByUsername(principal.getName());
		model.addAttribute("user",user);
		model.addAttribute("userPaymentList",user.getUserPaymentList());
		model.addAttribute("userShippingList",user.getUserShippingList());
		/*model.addAttribute("orderList",user.orderList());*/

		model.addAttribute("listOfCreditCards",true);
		model.addAttribute("classActiveBilling",true);
		model.addAttribute("listOfShippingAddresses",true);


		return "myProfile";

	}

	@RequestMapping("/listOfShippingAddresses")
	public String listOfShippingAddresses(Model model,Principal principal,HttpServletRequest request){
		User user=userService.findByUsername(principal.getName());
		model.addAttribute("user",user);
		model.addAttribute("userPaymentList",user.getUserPaymentList());
		model.addAttribute("userShippingList",user.getUserShippingList());
		/*model.addAttribute("orderList",user.orderList());*/

		model.addAttribute("listOfCreditCards",true);
		model.addAttribute("classActiveShipping",true);
		model.addAttribute("listOfShippingAddresses",true);


		return "myProfile";

	}

	@RequestMapping("/addNewCreditCard")
	public String addNewCreditCard(Model model,Principal principal){
		User user=userService.findByUsername(principal.getName());
		model.addAttribute("user",user);


		model.addAttribute("addNewCreditCard",true);
		model.addAttribute("classActiveBilling",true);
		//model.addAttribute("listOfCreditCards",true);
		model.addAttribute("listOfShippingAddresses",true);

		UserBilling userBilling=new UserBilling();
		UserPayment userPayment=new UserPayment();

		model.addAttribute("userBilling",userBilling);
		model.addAttribute("userPayment",userPayment);

		List<String> stateList=USConstants.listOfUSStatesCode;
		Collections.sort(stateList);
		model.addAttribute("stateList",stateList);

		List<String> cityList=USConstants.listOfUSCitiesCode;
		Collections.sort(cityList);
		model.addAttribute("cityList",cityList);

		model.addAttribute("userPaymentList",user.getUserPaymentList());
		model.addAttribute("userShippingList",user.getUserShippingList());
		/*model.addAttribute("orderList",user.orderList());*/



		return "myProfile";

	}
	@RequestMapping("/addNewShippingAddress")
	public String addNewShippingAddress(Model model,Principal principal){
		User user=userService.findByUsername(principal.getName());
		model.addAttribute("user",user);


		model.addAttribute("addNewShippingAddress",true);
		model.addAttribute("classActiveShipping",true);
		model.addAttribute("listOfCreditCards",true);

		UserShipping userShipping=new UserShipping();

		model.addAttribute("userShipping",userShipping);

		List<String> stateList=USConstants.listOfUSStatesCode;
		Collections.sort(stateList);
		model.addAttribute("stateList",stateList);

		List<String> cityList=USConstants.listOfUSCitiesCode;
		Collections.sort(cityList);
		model.addAttribute("cityList",cityList);

		model.addAttribute("userPaymentList",user.getUserPaymentList());
		model.addAttribute("userShippingList",user.getUserShippingList());
		/*model.addAttribute("orderList",user.orderList());*/

		return "myProfile";

	}


	@RequestMapping(value = "/addNewShippingAddress",method=RequestMethod.POST)
	public String addNewCreditCardPost(@ModelAttribute("userShipping") UserShipping userShipping,Principal principal,Model model){
		User user=userService.findByUsername(principal.getName());
		userService.updateUserShipping(userShipping,user);

		model.addAttribute("user",user);
		model.addAttribute("userPaymentList",user.getUserPaymentList());
		model.addAttribute("userShippingList",user.getUserShippingList());
		model.addAttribute("listOfCShippingAddresses",true);
		model.addAttribute("classActiveBilling",true);
		model.addAttribute("listOfCreditCards",true);

		return "myProfile";

	}

	@RequestMapping(value = "/addNewCreditCard",method=RequestMethod.POST)
	public String addNewShippingAddressPost(@ModelAttribute("userPayment") UserPayment userPayment,@ModelAttribute("userBilling")UserBilling userBilling,Principal principal,Model model){
		User user=userService.findByUsername(principal.getName());
		userService.updateUserBilling(userBilling,userPayment,user);

		model.addAttribute("user",user);
		model.addAttribute("userPaymentList",user.getUserPaymentList());
		model.addAttribute("userShippingList",user.getUserShippingList());
		model.addAttribute("listOfCreditCards",true);
		model.addAttribute("classActiveBilling",true);
		model.addAttribute("listOfShippingAddresses",true);

		return "myProfile";

	}

	@RequestMapping("/updateCreditCard")
	public String updateCreditCard(@ModelAttribute("id") Long creditCard,Principal principal,Model model){
		User user=userService.findByUsername(principal.getName());
		UserPayment userPayment=userPaymentService.findById(creditCard);

		if(user.getId()!=userPayment.getUser().getId()){
			return "badRequestPage";
		}else {
			model.addAttribute("user",user);
			UserBilling userBilling=userPayment.getUserBilling();
			model.addAttribute("userPayment",userPayment);
			model.addAttribute("userBilling",userBilling);

			List<String> stateList=USConstants.listOfUSStatesCode;
			Collections.sort(stateList);
			model.addAttribute("stateList",stateList);

			List<String> cityList=USConstants.listOfUSStatesCode;
			Collections.sort(cityList);
			model.addAttribute("cityList",cityList);

			model.addAttribute("addNewCreditCard",true);
			model.addAttribute("classActiveBilling",true);
			//model.addAttribute("listOfCreditCards",true);
			model.addAttribute("listOfShippingAddresses",true);

			model.addAttribute("userPaymentList",user.getUserPaymentList());
			model.addAttribute("userShippingList",user.getUserShippingList());

			return "myProfile";

		}

	}

	@RequestMapping("/removeCreditCard")
	public String removeCreditCard(@ModelAttribute("id") Long creditCardId,Principal principal,Model model){
		User user=userService.findByUsername(principal.getName());
		UserPayment userPayment=userPaymentService.findById(creditCardId);
		if(user.getId()!=userPayment.getUser().getId()){
			return "badRequestPage";
		}else {
			model.addAttribute("user",user);
			userPaymentService.removeById(creditCardId);


			model.addAttribute("listOfCreditCards",true);
			model.addAttribute("classActiveBilling",true);
			model.addAttribute("listOfShippingAddresses",true);

			model.addAttribute("userPaymentList",user.getUserPaymentList());
			model.addAttribute("userShippingList",user.getUserShippingList());

			return "myProfile";

		}

	}

	@RequestMapping(value = "/setDefaultPayment",method = RequestMethod.POST)
	public String setDefaultPayment(@ModelAttribute("defaultUserPaymentId") Long userPaymentId,Principal principal,Model model){
		User user=userService.findByUsername(principal.getName());
		userService.setUserDefaultPayment(userPaymentId,user);

		model.addAttribute("user",user);
		model.addAttribute("listOfCreditCards",true);
		model.addAttribute("classActiveBilling",true);
		model.addAttribute("listOfShippingAddresses",true);

		model.addAttribute("userPaymentList",user.getUserPaymentList());
		model.addAttribute("userShippingList",user.getUserShippingList());

		return "myProfile";

	}


	@RequestMapping("/updateUserShipping")
	public String updateUserShipping(@ModelAttribute("id") Long creditCard,Principal principal,Model model){
		User user=userService.findByUsername(principal.getName());
		UserShipping userShipping=userShippingService.findById(creditCard);

		if(user.getId()!=userShipping.getUser().getId()){
			return "badRequestPage";
		}else {
			model.addAttribute("user",user);
			model.addAttribute("userShipping",userShipping);


			List<String> stateList=USConstants.listOfUSStatesCode;
			Collections.sort(stateList);
			model.addAttribute("stateList",stateList);

			List<String> cityList=USConstants.listOfUSStatesCode;
			Collections.sort(cityList);
			model.addAttribute("cityList",cityList);

			model.addAttribute("addNewShippingAddress",true);
			model.addAttribute("classActiveShipping",true);
			//model.addAttribute("listOfCreditCards",true);
			model.addAttribute("listOfCreditCards",true);

			model.addAttribute("userPaymentList",user.getUserPaymentList());
			model.addAttribute("userShippingList",user.getUserShippingList());

			return "myProfile";

		}

	}

	@RequestMapping(value = "/setDefaultShippingAddress",method = RequestMethod.POST)
	public String setDefaultShippingAddress(@ModelAttribute("defaultShippingAddressId") Long defaultShippingId,Principal principal,Model model){
		User user=userService.findByUsername(principal.getName());
		userService.setUserDefaultShipping(defaultShippingId,user);

		model.addAttribute("user",user);
		model.addAttribute("listOfCreditCards",true);
		model.addAttribute("classActiveBilling",true);
		model.addAttribute("listOfShippingAddresses",true);

		model.addAttribute("userPaymentList",user.getUserPaymentList());
		model.addAttribute("userShippingList",user.getUserShippingList());

		return "myProfile";

	}

	@RequestMapping("/removeUserShipping")
	public String removeUserShipping(@ModelAttribute("id") Long userShippingId,Principal principal,Model model){
		User user=userService.findByUsername(principal.getName());
		UserShipping userShipping=userShippingService.findById(userShippingId);
		if(user.getId()!=userShipping.getUser().getId()){
			return "badRequestPage";
		}else {
			model.addAttribute("user",user);
			userShippingService.removeById(userShippingId);


			model.addAttribute("listOfCreditCards",true);
			model.addAttribute("classActiveBilling",true);


			model.addAttribute("userPaymentList",user.getUserPaymentList());
			model.addAttribute("userShippingList",user.getUserShippingList());

			return "myProfile";

		}

	}

}
