package com.ns.springThmlf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ns.springThmlf.PostRepository;
import com.ns.springThmlf.SavePost;
import com.ns.springThmlf.form.Post;

@Controller
public class Home {

	@Autowired
	private PostRepository 	postRepository; 
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Post post) {
		return "index";
	}
	
	
	/*
	 * Right now we can use the repository in our other classes. 
	 * PostRepository is used in Home controller for storing in database post 
	 * passed in form and getting all posts from database to show them on results 
	 * view. Spring can automatically find it out if we use @Autowired annotation. 
	 * Functions postRepository.findAll() and postRepository.save() are inherited 
	 * from CrudRepository, so we had not to implement them.
	 */
	@RequestMapping(value="/", method=RequestMethod.POST) 
	public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "index";
		}
		// postRepository.save(new PostEntity(post.getTitle(), post.getContent()));
		SavePost saver = new SavePost();
		saver.savePostEntry(postRepository, post);
		model.addAttribute("posts", postRepository.findAll());
		
		// return "result"; -> this would cause only the new post to be displayed, not all
		return "redirect:result";
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showAllPosts(Model model) {
		model.addAttribute("posts", postRepository.findAll());
		return "result";
	}
	// Test only
}
