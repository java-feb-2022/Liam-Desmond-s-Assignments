package com.liam.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liam.dojooverflow.models.Answer;
import com.liam.dojooverflow.models.Question;
import com.liam.dojooverflow.models.Tag;
import com.liam.dojooverflow.services.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService mainServ;
	


	// Dashboard
	@RequestMapping("/")
	public String index() {
		return "redirect:/questions";
	}
	
	// Get All
    @RequestMapping("/questions")
    public String dashboard(@ModelAttribute("question") Question obj, Model model) {
        List<Question> everything = mainServ.getAll();
        
        model.addAttribute("questions", everything);
        return "views/index.jsp";
    }
    
    // Get Main with All Serfs ---&--- Serfs already related
    @RequestMapping("/questions/show/{id}")
    public String show(@PathVariable("id") Long id,@ModelAttribute("answer") Answer side, Model model) {
    	Question main = mainServ.getOne(id);
    	
    	List<Tag> allOthersSerfs = mainServ.findByQuestionsNotContains(main);
//    	List<Answer> allOtherSides = mainServ.findByQuestionNotContainsSide(main);
    	List<Answer> allOtherSides = mainServ.getAllSides();

    	
    	
    	model.addAttribute("tags", allOthersSerfs);
        model.addAttribute("answers", allOtherSides);
    	model.addAttribute("question", mainServ.getOne(id));
        return "views/show.jsp";
    }
    
    // Create Form PAGE
    @RequestMapping("/questions/new")
    public String newForm(@ModelAttribute("question") Question obj,@ModelAttribute("tag") Tag serf) {
        return "views/new.jsp";
    }

    // Create Processing
    @PostMapping("/create/question")
    public String create(@Valid @ModelAttribute("question") Question obj, BindingResult result, Model model) {
    	
        if (result.hasErrors()) {
        	
            List<Question> everything = mainServ.getAll();
            model.addAttribute("questions", everything);
            return "views/new.jsp";
        } else {
        	mainServ.create(obj);
            return "redirect:/questions";
        }
    }
    
    // Edit Form
    @GetMapping("/questions/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {
    	Question question = mainServ.getOne(id);
        model.addAttribute("question", question);
        return "views/edit.jsp";
    }
    
    // Edit Processing
    @PutMapping("/questions/{id}")
    public String update(@Valid @ModelAttribute("question") Question obj, BindingResult result) {
        if (result.hasErrors()) {
        	return "views/edit.jsp";

        } else {
        	mainServ.update(obj);
            return "redirect:/questions";
        }
    }
    
    
    // Delete
    @RequestMapping(value="/questions/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	mainServ.delete(id);
        return "redirect:/questions";
    }
    
    // ONE:MANY ///////////////////
    
    // Serf form
    @GetMapping("/tags/new")
    public String newSerfForm(@ModelAttribute("tag") Tag obj, Model model) {
        List<Question> everything = mainServ.getAll();
        model.addAttribute("questions", everything);
        return "views/newSerf.jsp";
    }
    
    // Create Serf Processing
    @PostMapping("/create/tag")
    public String createSerf(@Valid @ModelAttribute("tag") Tag obj, BindingResult result, Model model) {
//    	Long questionId = obj.getQuestion().getId();
        if (result.hasErrors()) {
            List<Question> everything = mainServ.getAll();
            model.addAttribute("questions", everything);
            return "views/newSerf.jsp";
        } else {
        	mainServ.createSerf(obj);
        	return "redirect:/questions";
//            return String.format("redirect:/questions/%s", obj.getQuestions().getId());
        }
    }
    
    // Get all Serfs
    @GetMapping("/tags")
    public String getAllOthers(Model model) {
    	
    	List<Tag> allOthers = mainServ.getAllSerfs();
        model.addAttribute("tags", allOthers);
        return "views/serfs.jsp";
    }
    
    // Get one Serf with All Mains ---&--- Mains already related
    @GetMapping("/tags/show/{id}")
    public String getOneSerf(@PathVariable("id") Long id, Model model) {
    	Tag serf = mainServ.getOneSerf(id);

    	List<Question> allOthers = mainServ.findByTagsNotContains(serf);
//    	List<Question> allOthers = mainServ.getAll();


    	model.addAttribute("tag", serf);
        model.addAttribute("questions", allOthers);
        return "views/showSerf.jsp";
    }
    
    // Edit Serf Form
    @GetMapping("/tags/edit/{id}")
    public String editSerfForm(@PathVariable("id") Long id, Model model) {
    	Question question = mainServ.getOne(id);
        model.addAttribute("question", question);
        return "views/editSerf.jsp";
    }
    
    // Edit Serf Processing
    @PutMapping(value="/tags/{id}")
    public String updateSerf(@Valid @ModelAttribute("question") Tag obj, BindingResult result) {
        if (result.hasErrors()) {
        	return "views/editSerf.jsp";

        } else {
        	mainServ.updateSerf(obj);
            return "redirect:/tags";
        }
    }
    
    
    // Delete Serf
    @RequestMapping(value="/tags/{id}", method=RequestMethod.DELETE)
    public String destroySerf(@PathVariable("id") Long id) {
    	Tag serf = mainServ.getOneSerf(id);
    	List<Question> questions = serf.getQuestions();
    	Question questionId= mainServ.getOne(id);
    	mainServ.delete(id);
    	
    	return String.format("redirect:/questions/%s", questionId.getId());
//        return "redirect:/questions";
    }
    
    
    
    
    
    // MANY TO MANY////////////////////////////////////////////////////////////////////////////
    
    
	// Add Serf to Main
    @RequestMapping("/addSerfToMain/{id}")
	public String addSerftoMain(@PathVariable("id") Long id, @RequestParam("tag_id") Long serfId) {

		Tag serfToAdd = mainServ.getOneSerf(serfId);
		Question mainToAddTo = mainServ.getOne(id);
		
		mainServ.addSerfToMain(serfToAdd, mainToAddTo);
		return "redirect:/questions/show/" + id;
	}
	
	// Remove Serf from Main ----------- ???
    @RequestMapping("/RemoveSerfFromMain/{id}")
	public String removeSerfFromMain(@PathVariable("id") Long id, @RequestParam("tag_id") Long serfId) {

		Tag serfToRemove = mainServ.getOneSerf(serfId);
		Question mainToRemoveFrom = mainServ.getOne(id);
		
		mainServ.removeSerfFromMain(serfToRemove, mainToRemoveFrom);
		return "redirect:/questions/";
	}
    
    
	// Add Main to Serf
    @RequestMapping("/addMainToSerf/{id}")
	public String addMainToSerf(@PathVariable("id") Long id, @RequestParam("question_id") Long mainId) {

		Question mainToAdd = mainServ.getOne(mainId);
		Tag serfToAddTo = mainServ.getOneSerf(id);
		
		mainServ.addMainToSerf(mainToAdd, serfToAddTo);
		return "redirect:/tags/show/" + id;
	}
	
	// Remove Main from Serf --------------- ???
    @RequestMapping("/RemoveMainFromSerf/{id}")
	public String removeMainFromSerf(@PathVariable("id") Long id, @RequestParam("question_id") Long mainId) {

		Question mainToRemove = mainServ.getOne(mainId);
		Tag serfToRemoveFrom = mainServ.getOneSerf(id);
		
		mainServ.removeMainFromSerf(mainToRemove, serfToRemoveFrom);
		return "redirect:/tags/";
	}
    
    
    
    // ONE:MANY ///////////////////
    
    // Side form
    @GetMapping("/answers/new")
    public String newSideForm(@ModelAttribute("answer") Answer obj, Model model) {
        List<Question> everything = mainServ.getAll();
        model.addAttribute("questions", everything);
        return "/views/newSide.jsp";
    }
    
    
    
    
    // Create Side Processing with MAIN dropdown
    @PostMapping("/create/answer")
    public String createSide(@Valid @ModelAttribute("answer") Answer obj, BindingResult result, Model model) {
//    	Long questionId = obj.getQuestion().getId();
        if (result.hasErrors()) {
            List<Question> everything = mainServ.getAll();
            model.addAttribute("questions", everything);
            return "/views/newSide.jsp";
        } else {
        	mainServ.createSide(obj);
            return String.format("redirect:/questions/show/%s", obj.getQuestion().getId());
        }
    }
    

    


    
    // Get all Sides
    @GetMapping("/answers")
    public String getAllSides(Model model) {
    	
    	List<Answer> allSides = mainServ.getAllSides();
        model.addAttribute("answers", allSides);
        return "/views/others.jsp";
    }
    
    // Get one Side
    @GetMapping("/answers/show/{id}")
    public String getOneSide(@PathVariable("id") Long id, Model model) {
    	Answer side = mainServ.getOneSide(id);
    	Question question = side.getQuestion();
    	
        // Just testing
    	List<Answer> allSideMains = mainServ.getAllSides();
        model.addAttribute("answers", allSideMains);
    	// End

    	model.addAttribute("answer", side);
        model.addAttribute("question", question);
        return "/views/others.jsp";
    }
    
    
    // Delete Side
    @RequestMapping(value="/answers/{id}", method=RequestMethod.DELETE)
    public String destroySide(@PathVariable("id") Long id) {
    	Answer side = mainServ.getOneSide(id);
    	Question question = side.getQuestion();
    	Question questionId= mainServ.getOne(id);
    	mainServ.delete(id);
    	
    	return String.format("redirect:/questions/%s", questionId.getId());
//        return "redirect:/questions";
    }
    
    
//	// Add Main AANNNNDDDD Serf
//    @RequestMapping("/addMainANDSerf/{id}")
//	public String addMainAndSerf(@PathVariable("id") Long id, @RequestParam("question_id") Long mainId) {
//
//		Question mainToAdd = mainServ.getOne(mainId);
//		Tag serfToAddTo = mainServ.getOneSerf(id);
//		
//		mainServ.addMainToSerf(mainToAdd, serfToAddTo);
//		return "redirect:/tags/show/" + id;
//	}
    
    
    // Add Main AANNNNDDDD Serf
    @PostMapping("/createQuestionAndTag")
    public String createQuestionAndTag(@Valid @ModelAttribute("question") Question obj, BindingResult result, @RequestParam("subject") String tag, Model model) {
    	
        if (result.hasErrors()) {
        	
            List<Question> everything = mainServ.getAll();
            model.addAttribute("questions", everything);
            return "views/new.jsp";
        }
        if(tag.isEmpty()) {
            List<Question> everything = mainServ.getAll();
            model.addAttribute("questions", everything);
            return "views/new.jsp";
        }
        Tag newTag = new Tag();
        newTag.setSubject(tag);
        
        mainServ.createSerf(newTag);
        mainServ.create(obj);
//        Long questId = obj.getId();
//		Long tagId = newTag.getId();
//		Question question = mainServ.getOne(questId);
//		Tag addTag = mainServ.getOneSerf(tagId);
//		
//		System.out.println(question);
//		System.out.println(addTag);
        
//        List<Tag> allTags = obj.getTags();
//        allTags.add(newTag);

        
//    	mainServ.addMainAndSerf(newTag, obj);
        return "redirect:/questions";

    }
    
    // Create new Side on Main Show Page
    @PostMapping("/create/answerForQuestion")
	public String createTag(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model viewModel) {
		Long mainId = answer.getQuestion().getId();
		if (result.hasErrors()) {
			viewModel.addAttribute("dog", this.mainServ.getOne(mainId));
			return "views/show.jsp";
		}
		this.mainServ.createSide(answer);
		return "redirect:/questions/show/" + mainId;
	}
    
    
    
    
    

}
