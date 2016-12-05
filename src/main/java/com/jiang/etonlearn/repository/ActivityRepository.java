package com.jiang.etonlearn.repository;

import com.jiang.etonlearn.entity.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository {
    List<Activity> queryByName(String name);

    int save(Activity activity);

    int update(Activity activity);

    void deleteById(int id);
}
