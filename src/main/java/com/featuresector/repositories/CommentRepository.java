package com.featuresector.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.featuresector.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

  List<Comment> findByFeatureId(Long featureId);

}
