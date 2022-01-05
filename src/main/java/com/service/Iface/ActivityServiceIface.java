package com.service.Iface;

import java.util.List;

import com.entity.Activity;

public interface ActivityServiceIface {
	
	public Activity insertActivity(Activity activity);
	public Activity updateActivity(Activity activity, int id);
	public String deleteActivity(Activity activity); //delete
	public String deleteActivityById(int id);
	public List<Activity> getAllActivities();
	
//	Custom Queries
	public List<Activity> viewActivitiesOfCharges(float charges);
	public int countActivitiesOfCharges(float charges);
	

}
