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

import poly.dto.RecordDTO;
import poly.dto.StaffDTO;
import poly.dto.TypeRecord;
import poly.service.RecordService;
import poly.service.StaffService;

@Controller
@RequestMapping(value="record")
public class RecordController 
{
	@Autowired
	RecordService recordService;
	
	@Autowired
	StaffService staffService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(ModelMap model) 
	{
		List<RecordDTO> recordsDTO = recordService.findAll();
		model.addAttribute("listrecord", recordsDTO);
		return "manager/record/list";
	}
	
	@RequestMapping(value="save", method = RequestMethod.GET)
	public String save() 
	{
		return "manager/record/create";
	}
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	public String save(ModelMap model, RecordDTO recordDTO) 
	{
		String thongbao = recordService.save(recordDTO);
		model.addAttribute("thongbao", thongbao);
		List<RecordDTO> recordsDTO = recordService.findAll();
		model.addAttribute("listrecord", recordsDTO);
		return "manager/record/list";
	}
	
	@RequestMapping(value="update/{id}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable(value="id") int id) 
	{
		RecordDTO recordDTO = recordService.findRecordById(id);
		model.addAttribute("recordupdate", recordDTO);
		return "manager/record/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(ModelMap model, RecordDTO recordDTO) 
	{
		String thongbao = recordService.update(recordDTO);
		model.addAttribute("thongbao", thongbao);
		model.addAttribute("recordupdate", recordDTO);		
		return "manager/record/update";
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable(value="id") int id) 
	{
		String thongbao = recordService.delete(id);
		model.addAttribute("thongbao", thongbao);
		List<RecordDTO> recordsDTO = recordService.findAll();
		model.addAttribute("listrecord", recordsDTO);		
		return "manager/record/list";
	}
	
	@ModelAttribute(value="liststaff")
	public List<StaffDTO> listStaff()
	{
		return staffService.findAll();
	}
	
	@ModelAttribute(value="typerecord")
	public List<TypeRecord> listTypeRecord()
	{
		List<TypeRecord> typeRecord = new ArrayList<TypeRecord>();
		typeRecord.add(new TypeRecord("Ky luat", false));
		typeRecord.add(new TypeRecord("Thanh tich", true));
		return typeRecord;
	}
}
