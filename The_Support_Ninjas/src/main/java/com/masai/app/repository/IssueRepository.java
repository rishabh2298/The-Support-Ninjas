package com.masai.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
