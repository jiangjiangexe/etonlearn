package com.jiang.etonlearn.controller;

import com.jiang.etonlearn.entity.Activity;
import com.jiang.etonlearn.entity.Company;
import com.jiang.etonlearn.repository.ActivityRepository;
import com.jiang.etonlearn.service.FirstService;
import com.jiang.etonlearn.view.First;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/test")
public class FirstController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    CacheManager cacheManager;

    @Autowired
    FirstService firstService;

    @Autowired
    LocaleResolver localeResolver;

    // 變更多國語系用
    @RequestMapping("/lang/{locale}")
    public LocaleResolver changeLang(HttpServletRequest request, HttpServletResponse response, @PathVariable String locale) {
        localeResolver.setLocale(request, response, new Locale(locale));
        return localeResolver;
    }

    @RequestMapping("/query")
    public First query() {

        Locale locale = LocaleContextHolder.getLocale();

        log.info("rockmanexe");
        First first = new First();
        Activity activity = new Activity();
        String message = messageSource.getMessage("pokemon", null, locale);
        first.setUsername(message);
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
    public ResponseEntity getCache(@RequestParam(required = false) String ex) {
        Cache cache = cacheManager.getCache("cache1");
        Element element = cache.get("greeting");
        System.out.print(element.getObjectKey() + "," + element.getObjectValue());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", element.getObjectKey());
        map.put("value", element.getObjectValue());
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @RequestMapping("/get1/{item}")
    public ResponseEntity getOne(@PathVariable int item) {
        return new ResponseEntity(firstService.getOne(item), HttpStatus.OK);
    }

    @RequestMapping("/get2/{item}")
    public ResponseEntity getTwo(@PathVariable int item) {
        List<Activity> activities = activityRepository.queryByName("DIOGA");
        final Stream<List<Company>> listStream = activities.stream()
                .map(Activity::getCompanies);

        // http://ifeve.com/stream/

        List<String> gg = activities.stream()
                .map(Activity::getCompanies) // 回傳的是一個，对一个流中的值进行某种形式的转换
                .flatMap(companies -> companies.stream()) // company, company, company將list轉為Stream<Company>，並展開
                .map(Company::getAddress) //
                .collect(toList());

        List<Integer> rock = activityRepository.queryByName("DIOGA").stream()
                .filter(activity -> activity.getOid() == item).map(Activity::getOid)
                .collect(toList());
        return new ResponseEntity(gg, HttpStatus.OK);
    }
}
