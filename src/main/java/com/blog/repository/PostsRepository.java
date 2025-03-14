
package com.blog.repository;

import com.blog.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostsRepository  extends JpaRepository <Posts,Long>{
    
}
