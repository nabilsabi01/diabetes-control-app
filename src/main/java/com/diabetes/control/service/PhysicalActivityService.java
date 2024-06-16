package com.diabetes.control.service;

import com.diabetes.control.model.PhysicalActivity;

import java.util.List;
import java.util.Optional;

public interface PhysicalActivityService {
    List<PhysicalActivity> getAllActivitiesForUser(Long userId);

    void createActivity(PhysicalActivity activity, Long userId);

    Optional<PhysicalActivity> getActivityById(Long id);

    void updateActivity(Long id, PhysicalActivity updatedActivity);

    void deleteActivity(Long id);

    Long getUserIdForActivity(Long activityId);
}
