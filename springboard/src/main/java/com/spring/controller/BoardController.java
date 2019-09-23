package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.BoardDTO;
import com.spring.domain.MakePage;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardservice;


	@RequestMapping("/")
	public String list(@RequestParam(required = false, defaultValue = "1") int currPage, @RequestParam(required=false, defaultValue="")String search, @RequestParam(required=false, defaultValue="")String keyword, Model model) {
		
		int totalCount = boardservice.count(search, keyword);

		int pageSize = 5;
		int blockSize = 5;

		MakePage page = new MakePage(currPage, totalCount, pageSize, blockSize);

		List<BoardDTO> list = boardservice.faqlist(search, keyword, page.getStartRow(), page.getEndRow());
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("search",search);
		model.addAttribute("keyword",keyword);

		return "/";
	}

	@RequestMapping("/write")
	public String write(BoardDTO dto) {

		return "write";
	}

	@RequestMapping("/insert")
	public String insert(BoardDTO dto) {
		int result = boardservice.faqinsert(dto);
	
		return "redirect:/";
	}

	@RequestMapping("/view/{no}")
	public String view(@PathVariable int no, Model model) {

		BoardDTO dto = boardservice.faqdetail(no);
		model.addAttribute("dto", dto);
		return "view";
	}

	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable int no) {
		int result = boardservice.faqdelete(no);
		return "redirect:/faq";
	}
	
	@RequestMapping("/modify/{no}")
	public String modify(@PathVariable int no, Model model) {
		BoardDTO dto = boardservice.faqdetail(no);
		model.addAttribute("dto",dto);
		
		return "modify";
	}
	
	@RequestMapping("/update")
	public String update(BoardDTO dto) {
		int result = boardservice.update(dto);
		
		return "redirect:/";
	}

}
