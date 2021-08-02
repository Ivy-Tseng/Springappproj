package org.iiiedu.eeit131.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iiiedu.eeit131.model.Member;
import org.iiiedu.eeit131.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberAjaxController {
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("/ajax/addMemberForm")
	public String AaddMembersForm() {
		return "ajax/_01/register";
	}
	
	@GetMapping("/ajax/memberForm")
	public String sendAjaxMemberForm() {
		return "ajax/_01/showAllMembers";
	}
	
	@GetMapping("/ajax/editForm")
	public String sendEditMemberForm(@RequestParam String id, Model model) {
		model.addAttribute("idid", id);
		return "ajax/_01/editMemberForm";
	}
	
	@PostMapping("/_02/CheckMemberId")
	public @ResponseBody Map<String,String> existsByMemberId(
			@RequestParam("id")String memberId) {
		Map<String,String> map = new HashMap<>();
		Member member=memberService.findByMemberId(memberId);
		
		if(member== null) {
			map.put("id", "");
		}else {
			map.put("id", member.getId());
		}
		
		return map;
	}
	@PostMapping("/members")
	public @ResponseBody Map<String,String> save(
			@RequestBody Member member) {
		System.out.println("member="+member);
		//以下敘述為模擬系統產生的訊息,會員不能修改
		member.setExtra("系統產生的訊息，會員不能修改");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		member.setCreateTime(ts);
		Integer totalPoints = (int)(Math.random()*2500)+500;
		member.setTotalPoints(totalPoints);
		member.setTotalAmount(totalPoints*3);
		member.setAverageAmount(totalPoints*3/7.0+258.7);
		member.setMemberGrade("G");
		member.setMemberScore((int)(Math.random()*101)+0.0);
		
		
		
		Map<String,String> map = new HashMap<>();
		String result="";
		try {
		    memberService.save(member);
		    result="新增成功";
		    map.put("success", result);
		}catch(Exception e) {
			result=e.getMessage();
			map.put("fail",result);
		}
		return map;
	}
	
	
	@PutMapping("/members/{pk}")
	public @ResponseBody Map<String,String> update(
			 @RequestBody Member member,
			 @PathVariable Integer pk
			) {
		System.out.println("update()之member="+member);
		//以下敘述為模擬系統產生的訊息,會員不能修改
		
		Map<String,String> map = new HashMap<>();
		String result="";
		try {
		    memberService.update(member);
		    result="修改成功";
		    map.put("success", result);
		}catch(Exception e) {
			result=e.getMessage();
			map.put("fail",result);
		}
		return map;
	}
	//一個Controller類別只有一個@ModelAttribute,在執行本類別方法前,會先跑此方法,並將此方法傳回值放在Model內
	@ModelAttribute("member")
	public Member getMember(
			//required = false表示pk可有可無
			@PathVariable(value="pk", required = false) Integer pk
			) {
		Member member= null;
		if(pk==null) {
			member = new Member();
		}else {
			member = memberService.findById(pk);
		}
		System.out.println("@ModelAttribute之member="+member);
		return member;
	}
	
	@GetMapping("/ajax/members")
	public @ResponseBody List<Member> findAll() {
		return memberService.findAll();
		
		
	}
	
	@GetMapping("/ajax/member")
	public @ResponseBody Member findByMemberId(@RequestParam String id) {
		return memberService.findByMemberId(id);
		
		
	}
	
	@GetMapping("/ajax/member/{id}")
	public @ResponseBody Member findById(@PathVariable Integer id) {
		return memberService.findById(id);
	}
	
}
