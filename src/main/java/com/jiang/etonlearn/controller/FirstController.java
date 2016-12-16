package com.jiang.etonlearn.controller;

import com.jiang.etonlearn.entity.Activity;
import com.jiang.etonlearn.repository.ActivityRepository;
import com.jiang.etonlearn.service.FirstService;
import com.jiang.etonlearn.view.First;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class FirstController {

	private static final Logger log = LoggerFactory.getLogger(FirstController.class);

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	CacheManager cacheManager;

	@Autowired
	FirstService firstService;

	@RequestMapping("/query")
	@ResponseBody
	public First query() {
		log.info("rockmanexe");
		First first = new First();
		Activity activity = new Activity();
		activity.setName("rock");
		activity.setVersion(1);
		activityRepository.save(activity);
		return first;
	}

	@RequestMapping("/queryList")
	@ResponseBody
	public List<Activity> queryList() {
		List<Activity> activities = firstService.queryActivity();
		return activities;
	}

	@RequestMapping("/queryList2")
	@ResponseBody
	public List<Activity> queryList2() {
		List<Activity> activities = firstService.queryActivity2();
		return activities;
	}

	@RequestMapping("/cache")
	public ResponseEntity cache(@RequestParam String ex) {
		Cache cache = cacheManager.getCache("cache1");
		final String key = "greeting";
		final Element putGreeting = new Element(key, ex);
		cache.put(putGreeting);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping("/getCache")
	public ResponseEntity getCache(@RequestParam(required = false)String ex) {
		Cache cache = cacheManager.getCache("cache1");
		Element element = cache.get("greeting");
		System.out.print(element.getObjectKey() + "," + element.getObjectValue());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", element.getObjectKey());
		map.put("value", element.getObjectValue());
		return new ResponseEntity(map, HttpStatus.OK);
	}
}
