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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.dto.DepartDTO;
import poly.dto.Gender;
import poly.dto.StaffDTO;
import poly.service.DepartService;
import poly.service.StaffService;
import poly.service.UploadService;

@Controller
@RequestMapping(value="staff")
public class StaffController 
{
	@Autowired
	StaffService staffService;
	
	@Autowired
	DepartService departService;
	
	@Autowired
	UploadService uploadService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String findAll(ModelMap model) 
	{
		List<StaffDTO> staffsDTO = staffService.findAll();
		model.addAttribute("stafflist", staffsDTO);
		return "manager/staff/list";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String addStaff() 
	{
		return "manager/staff/create";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String addStaff(ModelMap model, StaffDTO staffDTO, @RequestParam(value="photonew") MultipartFile photonew) 
	{
		if(photonew.getOriginalFilename().length()>0) 
		{
			uploadService.UploadImage(photonew);
		}
		staffDTO.setPhoto(photonew.getOriginalFilename());
		String thongbao = staffService.addStaff(staffDTO);
		List<StaffDTO> staffsDTO = staffService.findAll();
		model.addAttribute("stafflist", staffsDTO);
		model.addAttribute("thongbao", thongbao);
		return "manager/staff/list";
	}
	
	@RequestMapping(value="update/{id}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable(value="id") String id) 
	{
		StaffDTO staffDTO = staffService.findStaffById(id);
		model.addAttribute("staffupdate", staffDTO);
		return "manager/staff/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(ModelMap model, StaffDTO staffDTO, @RequestParam(value="photonew") MultipartFile photonew) 
	{
		if(photonew.getOriginalFilename().length() > 0) 
		{
			uploadService.UploadImage(photonew);
			staffDTO.setPhoto(photonew.getOriginalFilename());
		}

		String thongbao = staffService.update(staffDTO);
		model.addAttribute("thongbao", thongbao);
		model.addAttribute("staffupdate", staffDTO);
		
		return "manager/staff/update";
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable(value="id") String id) 
	{
		String thongbao = staffService.delete(id);
		
		List<StaffDTO> staffsDTO = staffService.findAll();
		model.addAttribute("stafflist", staffsDTO);
		model.addAttribute("thongbao", thongbao);		
		return "manager/staff/list";
	}
	
	@ModelAttribute(value="listdepart")
	public List<DepartDTO> listDepart()
	{
		return departService.findAll();
	}
	
	@ModelAttribute(value="listgender")
	public List<Gender> listGender()
	{
		List<Gender> genders = new ArrayList<Gender>();
		genders.add(new Gender("Female", true));
		genders.add(new Gender("Male", false));
		return genders;
	}
}
