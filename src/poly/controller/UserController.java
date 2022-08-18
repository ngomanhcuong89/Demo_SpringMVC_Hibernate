package poly.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.AdminDTO;
import poly.dto.StaffDTO;
import poly.dto.UserDTO;
import poly.service.StaffService;
import poly.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController 
{
	@Autowired
	UserService userService;
	@Autowired
	StaffService staffService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String findAll(ModelMap model) 
	{
		List<UserDTO> userDTO = userService.findAll();
		model.addAttribute("listuser", userDTO);
		return "manager/user/list";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String addUser() 
	{
		return "manager/user/create";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String addUser(ModelMap model, UserDTO userDTO) 
	{
		String thongbao = userService.addUser(userDTO);
		model.addAttribute("thongbao", thongbao);
		return "redirect:/user/list.htm";
	}
	
	@RequestMapping(value="delete/{username}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable(value="username") String username) 
	{
		String thongbao = userService.delete(username);
		model.addAttribute("thongbao", thongbao);
		return "redirect:/user/list.htm";
	}
	
	@RequestMapping(value="update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") String id, ModelMap model) 
	{
		UserDTO userDTO = userService.findUserByUsername(id);
		model.addAttribute("updateuser", userDTO);
		return "manager/user/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(ModelMap model, UserDTO userDTO) 
	{
		String thongbao = userService.update(userDTO);
		model.addAttribute("updateuser", userDTO);
		model.addAttribute("thongbao", thongbao);
		return "manager/user/update";
	}
	
	@ModelAttribute(value="staffs")
	public List<StaffDTO> findAllStaff()
	{
		return staffService.findAll();
	}
	
	@ModelAttribute(value="admin")
	public List<AdminDTO> listAdmin()
	{
		List<AdminDTO> adminsDTO = new ArrayList<AdminDTO>();
		adminsDTO.add(new AdminDTO("admin",true));
		adminsDTO.add(new AdminDTO("staff", false));
		return adminsDTO;
	}
}
