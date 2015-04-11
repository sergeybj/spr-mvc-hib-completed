package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Organization;
import com.sprhib.service.OrganizationService;

@Controller
@RequestMapping(value="/organization")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;
		
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addOrganizationPage()
	{
		ModelAndView modelAndView = new ModelAndView("add-org-form");
		modelAndView.addObject("organization", new Organization());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingOrganization(@ModelAttribute Organization organization)
	{
		organizationService.addOrganization(organization);
		ModelAndView modelAndView = new ModelAndView("list-of-organizations");
		List<Organization> organizations = organizationService.getOrganizations();
		modelAndView.addObject("organizations", organizations);
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfOrganizations()
	{
		ModelAndView modelAndView = new ModelAndView("list-of-organizations");
		List<Organization> organizations = organizationService.getOrganizations();
		modelAndView.addObject("organizations", organizations);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editOrganizationPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-org-form");
		Organization organization = organizationService.getOrganization(id);
		modelAndView.addObject("organization", organization);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editingOrganization(@ModelAttribute Organization organization, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("list-of-organizations");
		organizationService.updateOrganization(organization);
		String message = "Organization was successfully edited.";
		modelAndView.addObject("message", message);
		List<Organization> organizations = organizationService.getOrganizations();
		modelAndView.addObject("organizations", organizations);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteOrganization(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("list-of-organizations");
		organizationService.deleteOrganization(id);
		String message = "Organization was successfully deleted.";
		modelAndView.addObject("message", message);
		List<Organization> organizations = organizationService.getOrganizations();
		modelAndView.addObject("organizations", organizations);
		return modelAndView;
	}

	
}
