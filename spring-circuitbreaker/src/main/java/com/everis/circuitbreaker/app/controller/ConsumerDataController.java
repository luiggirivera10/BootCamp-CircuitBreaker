package com.everis.circuitbreaker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.circuitbreaker.app.service.ConsumerService;

/**
 * .
 * @author lriveras
 *
 */
@RestController
public class ConsumerDataController {

  /**
   * Injectes ConsumerService.
   */
  @Autowired
  ConsumerService service;

  /**
   * Service getCourses.
   * @return
   */
  @GetMapping(value = "/getCourse")
  public String getCourses() {
    System.out.println("Haciendo llamado a Course App!!");
    return service.callCourseApp();
  }

  /**
   * Service getstudent.
   * @return
   */
  @GetMapping(value = "/getStudent")
  public String getStudents() {
    System.out.println("Haciendo llamado a Student App!!");
    return service.callStudentApp();
  }

  /**
   * Service getParent.
   * @return
   */
  @GetMapping(value = "/getParent")
  public String getParents() {
    System.out.println("Haciendo llamado a Parent App!!");
    return service.callParentApp();
  }

  /**
   * Service getTeacher.
   * @return
   */
  @GetMapping(value = "/getTeacher")
  public String getTeachers() {
    System.out.println("Haciendo llamado a Teacher App!!");
    return service.callTeacherApp();
  }
}
