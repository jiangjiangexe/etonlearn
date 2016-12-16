package com.jiang.etonlearn.service;

import com.jiang.etonlearn.entity.Activity;
import com.jiang.etonlearn.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstService {

	@Autowired
	ActivityRepository activityRepository;

	@Cacheable("firstService")
	public List<Activity> queryActivity(){
		return activityRepository.queryByName("rock");
	}

	public List<Activity> queryActivity2(){
		return this.queryActivity();
	}

}
