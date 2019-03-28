package com.work.api.repositories;

import com.work.api.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository <Lesson, Long> {
    Optional<Lesson> findByGroupNameAndId(String groupName, Long Id);
    List<Lesson> findAllByGroupName(String groupName);

}