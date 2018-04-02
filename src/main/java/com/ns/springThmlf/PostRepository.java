package com.ns.springThmlf;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ns.springThmlf.domain.PostEntity;
  
/*
 * The repository class is needed to manipulate 
 * (read, save, update, delete) on domain objects. Using Spring Data it 
 * is very easy to create simple repository interface by extending 
 * CrudRepository class from Spring Data. By default there are enabled 
 * number of common functions, but it is also possible to create own functions, 
 * like findByTitle(String title) in example below. The only thing what is 
 * needed to do is defining functions according to Spring Data rules.
 */
public interface PostRepository extends CrudRepository<PostEntity, Long> {
	List<PostEntity> findByTitle(String title);
}
