package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Activity;
import com.service.ActivityService;

@RestController
@RequestMapping(path="/api")
public class ActivityController {
	
	private ActivityService activityService;

	@Autowired
	public ActivityController(ActivityService activityService) {
		super();
		this.activityService = activityService;
	}
	
//	Get list of all activities
	@GetMapping("/getAllActivities")
	public List<Activity> getAllActivities(){
		return activityService.getAllActivities();
	}
	
//	Get list of activities by charges
	@GetMapping("/getActivityOfCharges/{charges}")
	public List<Activity> viewActivityOfCharges(@PathVariable float charges){
		return activityService.viewActivitiesOfCharges(charges);
	}
	
//	Get count of activities by charges
	@GetMapping("/getActivityCountByCharges/{charges}")
	public int countActivitiesOfCharges(@PathVariable float charges) {
		return activityService.countActivitiesOfCharges(charges);
	}
	
//	Add a new Activity
	@PostMapping("/addActivity")
	public ResponseEntity<Activity> insertActivity(@RequestBody Activity activity){
		return new ResponseEntity<Activity>(activityService.insertActivity(activity), HttpStatus.CREATED);
	}
	
//	Update activity by Id
	@PutMapping("/updateActivityById/{id}")
	public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity, @PathVariable int id) throws Throwable{
		return new ResponseEntity<Activity>(activityService.updateActivity(activity, id), HttpStatus.OK);
	}
	
//	Delete activity
	@DeleteMapping("/deleteActivity")
	public ResponseEntity<String> deleteActivity(@RequestBody Activity activity) {
		activityService.deleteActivity(activity);
		return new ResponseEntity<String>("Activity deleted !", HttpStatus.OK);
	}
	
//	Delete activity by Id
	@DeleteMapping("/deleteActivityById/{activityId}")
	public ResponseEntity<String> deleteActivityById(@PathVariable int activityId) throws Throwable{
		activityService.deleteActivityById(activityId);
		return new ResponseEntity<String>("Activity deleted successfully !", HttpStatus.OK);
	}

}
