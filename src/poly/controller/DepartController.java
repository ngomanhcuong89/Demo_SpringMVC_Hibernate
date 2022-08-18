package poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.DepartDTO;
import poly.service.DepartService;

@Controller
@RequestMapping(value="depart")
public class DepartController 
{
	@Autowired
	DepartService departService;
	
	@RequestMapping(value="save", method = RequestMethod.GET)
	public String save() 
	{
		return "manager/depart/create";
	}
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	public String save(ModelMap model, DepartDTO departDTO) 
	{
		String thongbao = departService.save(departDTO);
		model.addAttribute("thongbao", thongbao);
		return "manager/depart/create";
	}
	
	@RequestMapping(value="update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") String id, ModelMap model) 
	{
		DepartDTO departDTO = departService.findDepartById(id);
		model.addAttribute("departupdate", departDTO);
		return "manager/depart/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(ModelMap model, DepartDTO departDTO) 
	{
		String thongbao = departService.update(departDTO);
		model.addAttribute("departupdate", departDTO);
		model.addAttribute("thongbao", thongbao);
		return "manager/depart/update";
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value="id") String id, ModelMap model) 
	{
		String thongbao = departService.delete(id);
		model.addAttribute("thongbao", thongbao);
		List<DepartDTO> departsDTO = departService.findAll();
		model.addAttribute("listdepart", departsDTO);
		return "manager/depart/list";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String findAll(ModelMap model) 
	{
		List<DepartDTO> departsDTO = departService.findAll();
		model.addAttribute("listdepart", departsDTO);
		return "manager/depart/list";
	}
}
