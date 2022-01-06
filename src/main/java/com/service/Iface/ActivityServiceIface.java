package com.service.Iface;

import java.util.List;

import com.entity.Activity;
import com.exception.ActivityNotFoundException;

public interface ActivityServiceIface {
	
	public Activity insertActivity(Activity activity);
	public Activity updateActivity(Activity activity, int id) throws ActivityNotFoundException;
	public String deleteActivityById(int id) throws ActivityNotFoundException;
	public List<Activity> getAllActivities();
	
//	Custom Queries
	public List<Activity> viewActivitiesOfCharges(float charges);
	public int countActivitiesOfCharges(float charges);
	

}
