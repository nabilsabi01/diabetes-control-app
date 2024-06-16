package com.diabetes.control.service.impl;

import com.diabetes.control.model.PhysicalActivity;
import com.diabetes.control.model.User;
import com.diabetes.control.repository.PhysicalActivityRepository;
import com.diabetes.control.service.PhysicalActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicalActivityServiceImpl implements PhysicalActivityService {

    @Autowired
    private PhysicalActivityRepository activityRepository;

    @Override
    public List<PhysicalActivity> getAllActivitiesForUser(Long userId) {
        return activityRepository.findByUserId(userId);
    }

    @Override
    public void createActivity(PhysicalActivity activity, Long userId) {
        User user = new User();
        user.setId(userId);
        activity.setUser(user);
        activityRepository.save(activity);
    }

    @Override
    public Optional<PhysicalActivity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }

    @Override
    public void updateActivity(Long id, PhysicalActivity updatedActivity) {
        Optional<PhysicalActivity> existingActivity = activityRepository.findById(id);
        if (existingActivity.isPresent()) {
            PhysicalActivity activity = existingActivity.get();
            activity.setActivityType(updatedActivity.getActivityType());
            activity.setDuration(updatedActivity.getDuration());
            activity.setStartDateTime(updatedActivity.getStartDateTime());
            activity.setEndDateTime(updatedActivity.getEndDateTime());
            activity.setNotes(updatedActivity.getNotes());
            activityRepository.save(activity);
        }
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }

    @Override
    public Long getUserIdForActivity(Long activityId) {
        Optional<PhysicalActivity> activity = activityRepository.findById(activityId);
        return activity.map(PhysicalActivity::getUser)
                .map(User::getId)
                .orElse(null);
    }
}
