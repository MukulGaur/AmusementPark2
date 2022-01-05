package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Activity;
import com.repository.ActivityRepository;
import com.service.Iface.ActivityServiceIface;

@Service
public class ActivityService implements ActivityServiceIface{
	
	private ActivityRepository activityRepo;
	
	@Autowired
	public ActivityService(ActivityRepository activityRepo) {
		super();
		this.activityRepo = activityRepo;
	}

//	Insert Activity record into database
	@Override
	public Activity insertActivity(Activity activity) {
		return activityRepo.save(activity);
	}

//	Update Activity record by id
	@Override
	public Activity updateActivity(Activity activity, int id) {//didn't use supplier object
		
		Activity existingActivity = activityRepo.findById(id).orElseThrow();
//		didn't give id
		existingActivity.setCharges(existingActivity.getCharges());
		existingActivity.setDescription(existingActivity.getDescription());
		existingActivity.setActivityName(existingActivity.getActivityName());
		
		activityRepo.save(existingActivity);
		return existingActivity;
	}

//	Delete Activity record by id
	@Override
	public String deleteActivityById(int id) { //didn't use supplier object
		
		activityRepo.findById(id).orElseThrow();
		
		activityRepo.deleteById(id);
		
		return "Record deleted";
	}

//	View Activity records for the given charges
	@Override
	public List<Activity> viewActivitiesOfCharges(float charges) {
		List<Activity> activityList = activityRepo.viewActivitiesOfCharges(charges);
		return activityList;
	}

//	Count Activity records of given charges
	@Override
	public int countActivitiesOfCharges(float charges) {
		List<Activity> activityList = activityRepo.viewActivitiesOfCharges(charges);
		int count = activityList.size();
		return count;
	}

//	Delete Activity by Activity Object
	@Override
	public String deleteActivity(Activity activity) {
		activityRepo.delete(activity);
		return "Activity deleted !";
	}

	@Override
	public List<Activity> getAllActivities() {
		return activityRepo.findAll();
	}

}
