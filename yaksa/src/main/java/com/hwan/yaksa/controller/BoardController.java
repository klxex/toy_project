package com.hwan.yaksa.controller;


import com.hwan.yaksa.annotation.Auth;
import com.hwan.yaksa.dto.BoardDTO;
import com.hwan.yaksa.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImpl boardServiceImpl;

    @GetMapping("/searchBoard")
    public String searchBoard(@RequestParam(value="boardNum",required = false, defaultValue="1") Long boardNum,Model model){
        model.addAttribute("boardList",boardServiceImpl.findAll(boardNum));
        return "board/searchBoard";
    }

    @GetMapping("/board")
    public String getBoard(@RequestParam("id") Long boardNum, Model model) {

        model.addAttribute("board",boardServiceImpl.find(boardNum));
        return "board/boardForm";
    }


    @GetMapping("/createBoard")
    public String createBoard(Model model) {
        model.addAttribute("boardDTO", new BoardDTO());
        return "board/createBoard";
    }

    @PostMapping("/createWord")
    public String createWord(@Valid  @ModelAttribute("boardDTO")BoardDTO boardDTO) {
         boardServiceImpl.createBoard(boardDTO);
         return "redirect:/searchBoard";

    }


}
