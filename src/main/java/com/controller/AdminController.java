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

import com.entity.Admin;
import com.service.AdminService;

@RestController
@RequestMapping(path="/api")
public class AdminController {
	
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

//	Insert admin
	@PostMapping("/insertAdmin")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.insertAdmin(admin), HttpStatus.CREATED);
	}
	
//	Update admin
	@PutMapping("/updateAdminById/{adminId}")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable int adminId) throws Throwable{
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, adminId), HttpStatus.OK);
	}
	
//	Delete admin
	@DeleteMapping("/deleteAdminById/{adminId}")
	public ResponseEntity<String> deleteAdminById(@PathVariable int adminId){
		return new ResponseEntity<String>("Deleted Admin Successfully", HttpStatus.OK);
	}
	
//	Get list of all admins
	@GetMapping("/getAdmins")
	public List<Admin> getAdmins(){
		return adminService.viewAdmins();
	}

}
