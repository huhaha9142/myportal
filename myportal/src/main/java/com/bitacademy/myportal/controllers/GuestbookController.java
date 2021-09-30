package com.bitacademy.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.myportal.repository.GuestbookVo;
import com.bitacademy.myportal.service.GuestbookService;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookServiceImpl;

	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookServiceImpl.getMessageList();
		System.out.println(list);
		model.addAttribute("list", list);
		return "guestbook/list";
	}
}