package org.example.url.test.controller;

import org.example.url.test.service.HtmlInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HtmlInfoController {
    private final HtmlInfoService htmlInfoService;

    @Autowired
    public HtmlInfoController(HtmlInfoService htmlInfoService) {
        this.htmlInfoService = htmlInfoService;
    }

    @RequestMapping(path = "/letter")
    public String getCurrentLetter(Model model){

        model.addAttribute("deletedHtmlInfo", htmlInfoService.getDeletedHtmlInfo());
        model.addAttribute("changedHtmlInfo", htmlInfoService.getChangedHtmlInfoList());
        model.addAttribute("newHtmlInfo", htmlInfoService.getNewHtmlInfo());
        model.addAttribute("secretaryName", "и.о. секретаря");

        return "letter";
    }
}
