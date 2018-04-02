package com.ns.springThmlf;

import org.springframework.transaction.annotation.Transactional;

import com.ns.springThmlf.domain.PostEntity;
import com.ns.springThmlf.form.Post;

public class SavePost {
	
	@Transactional
	public void savePostEntry(PostRepository postRepository, Post post) {
		postRepository.save(new PostEntity(post.getTitle(), post.getContent()));
	}
}
