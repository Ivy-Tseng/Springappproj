package org.iiiedu.eeit131.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit131.model.CompanyBean;
import org.iiiedu.eeit131.model.Member;
import org.iiiedu.eeit131.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	
		
	@GetMapping("/springmvc/members")
	public String getMemberSpringMvc(Model model) {
		List<Member> members=memberService.findAll();
		model.addAttribute("members123", members);
		return "smvc/showAllMembers";
	}
	
	@GetMapping("/springmvc/classpathResource")
	public String getClassPathResource(Model model) {
		List<CompanyBean> list= new ArrayList<>();
		Resource resource = new ClassPathResource("static/data/bookCompany.dat");
		String line = null;
		try (
		    InputStream is = resource.getInputStream();
		    InputStreamReader isr = new InputStreamReader(is, "UTF8");                    
		    BufferedReader br = new BufferedReader(isr);
		) {
		    while ((line = br.readLine()) != null) {
				System.out.println("line="+line);
				String[] sa=line.split(",");
				String companyId= sa[0];
				String companyName=sa[1];
				String phone=sa[2];
				CompanyBean bean = new CompanyBean(companyId, companyName, phone);
				list.add(bean);
			}
		    model.addAttribute("companys", list);
		} catch(Exception e){
		  e.printStackTrace();
		}	

		return "index";
	}
	
	
}
