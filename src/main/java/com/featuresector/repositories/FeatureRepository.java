package com.featuresector.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.featuresector.domain.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {

}
