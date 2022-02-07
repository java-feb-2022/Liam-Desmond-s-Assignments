package com.liam.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
    public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
	        session.setAttribute("count", 0);
	        return "index.jsp";
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count"); 
	        session.setAttribute("count", currentCount + 1);
	        return "index.jsp";
		}
    }
	
	@RequestMapping("/count")
    public String showCount(HttpSession session, Model model) {
        Integer currentCount = (Integer) session.getAttribute("count");
        model.addAttribute("countToShow", currentCount);
        return "counter.jsp";
    }
	
	@RequestMapping("/reset")
    public String resetCount(HttpSession session, Model model) {
		session.invalidate();
        return "counter.jsp";
    }

}
