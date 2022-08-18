package poly.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.dto.DepartDTO;
import poly.dto.StaffDTO;
import poly.dto.UserDTO;
import poly.service.DepartService;
import poly.service.HomeService;
import poly.service.UploadService;

@Controller
@RequestMapping(value="home")
public class HomeController 
{
	@Autowired
	@Qualifier(value = "homeServicePrimary")
	HomeService homeService;

	@RequestMapping(method = RequestMethod.GET)
	public String goHomePage() 
	{
		return "home/home";
	}

	@RequestMapping(value="login", method = RequestMethod.GET)
	public String loginPage() 
	{
		return "home/login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String loginPage(ModelMap map, @RequestParam(value="username") String username, @RequestParam(value="password") String password, HttpSession session) 
	{
		String url = "";
		int checklogin = homeService.getUser().findUserByUsernameAndPassword(username, password);
		if(checklogin > 0) 
		{
			UserDTO userDTO = homeService.getUser().findUserByUsername(username);
			session.setAttribute("user", userDTO);
			url += "home/home";
		}
		else 
		{
			map.addAttribute("LoginError", "Sai Username or Password");
			url += "home/login";
		}
		return url;
	}
	
	@RequestMapping(value="manager", method = RequestMethod.GET)
	public String managerPage() 
	{
		return "manager/home";
	}
	
	@RequestMapping(value="staff", method = RequestMethod.GET)
	public String staffPage() 
	{
		return "staff/home";
	}
	
	@RequestMapping(value="create", method = RequestMethod.GET)
	public String createAccount() 
	{
		return "home/create";
	}
	
	@RequestMapping(value="create", method = RequestMethod.POST)
	public String createAccount(ModelMap model, UserDTO userDTO, StaffDTO staffDTO, @RequestParam("hinhanh") MultipartFile hinhanh) 
	{
		
		
		homeService.getUpload().UploadImage(hinhanh);
		staffDTO.setPhoto(hinhanh.getOriginalFilename());
		String thongbao1 = homeService.getStaff().addStaff(staffDTO);
		
		if(thongbao1.equals("success")) 
		{
			userDTO.setFullname(staffDTO.getName());
			userDTO.setStaffId(staffDTO.getId());
			userDTO.setIsadmin(false);
			String thongbao2 = homeService.getUser().addUser(userDTO);
			if(thongbao2.equals("success")) 
			{
				model.addAttribute("thongbao", "Ban Da Tao Thanh Cong Tai Khoan");
				model.addAttribute("kiemtra", "Success");				
			}
		}
		else 
		{
			model.addAttribute("thongbao", "Da Co Loi Vui Long Kiem Tra Lai");			
		}

		return "home/create";
	}
	
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session) 
	{
		if(session.getAttribute("user") != null) 
		{
			session.removeAttribute("user");
		}
		return "redirect:/home.htm";
	}
	
	@ModelAttribute(value = "ListDepart")
	public List<DepartDTO> listDepart()
	{
		return homeService.getDepart().findAll();
	}
	
	@ModelAttribute(value="ListReport")
	public List<Object[]> listRecordReport()
	{
		return homeService.getRecord().findRecordReport();
	}
}
