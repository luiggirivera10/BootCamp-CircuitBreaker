package com.everis.circuitbreaker.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * .
 * @author lriveras
 *
 */
@Service
public class ConsumerService {

  /**
   * Injected RestTemplate.
   */
  @Autowired
  private RestTemplate restTemplate;

  /**
   * CallApp.
   */
  @HystrixCommand(fallbackMethod = "callCourseApp_Fallback")
  public String callCourseApp() {
  System.out.println("Cargando informacion");
  
  String response = restTemplate
      .exchange("http://localhost:8081/spring-course/api/v1.0/courses", HttpMethod.GET
      ,null
      ,new ParameterizedTypeReference<String>() {}
      ,"")
      .getBody();
  System.out.println("Respuesta recibida de Course!");
  return "CARGA NORMAL !! " + "Course Detalle : " + response;
  }

  /**
   * CallAppFallBack.
   * @return
   */
  private String callCourseApp_Fallback() {
    System.out.println("Course App Fuera de Servicio !!  :C   FallBack Enabled!!");
    return "CIRCUIT BREAKER ENABLED!! No hay respuesta de Course App en este momento!!"; 
  }

  /**
   * CallApp.
   */
  @HystrixCommand(fallbackMethod = "callStudentApp_Fallback")
  public String callStudentApp() {
  System.out.println("Cargando informacion");
  
  String response = restTemplate
      .exchange("http://localhost:8081/spring-student/api/v1.0/students", HttpMethod.GET
      ,null
      ,new ParameterizedTypeReference<String>() {}
      ,"")
      .getBody();
  System.out.println("Respuesta recibida de Student!");
  return "CARGA NORMAL !! " + "Student Detalle : " + response;
  }

  /**
   * CallAppFallBack.
   * @return
   */
  private String callStudentApp_Fallback() {
    System.out.println("Student App Fuera de Servicio !!  :C   FallBack Enabled!!");
    return "CIRCUIT BREAKER ENABLED!! No hay respuesta de Student App en este momento!!"; 
  }

  /**
   * CallApp.
   */
  @HystrixCommand(fallbackMethod = "callTeacherApp_Fallback")
  public String callTeacherApp() {
  System.out.println("Cargando informacion");
  
  String response = restTemplate
      .exchange("http://localhost:8081/spring-teacher/api/v1.0/teachers", HttpMethod.GET
      ,null
      ,new ParameterizedTypeReference<String>() {}
      ,"")
      .getBody();
  System.out.println("Respuesta recibida de Teacher!");
  return "CARGA NORMAL !! " + "Teacher Detalle : " + response;
  }

  /**
   * CallAppFallBack.
   * @return
   */
  private String callTeacherApp_Fallback() {
    System.out.println("Teacher App Fuera de Servicio !!  :C   FallBack Enabled!!");
    return "CIRCUIT BREAKER ENABLED!! No hay respuesta de Teacher App en este momento!!"; 
  }

  /**
   * CallApp.
   */
  @HystrixCommand(fallbackMethod = "callParentApp_Fallback")
  public String callParentApp() {
  System.out.println("Cargando informacion");
  
  String response = restTemplate
      .exchange("http://localhost:8081/spring-parents/api/v1.0/parents", HttpMethod.GET
      ,null
      ,new ParameterizedTypeReference<String>() {}
      ,"")
      .getBody();
  System.out.println("Respuesta recibida de Parent!");
  return "CARGA NORMAL !! " + "Parent Detalle : " + response;
  }

  /**
   * CallAppFallBack.
   */
  private String callParentApp_Fallback() {
    System.out.println("Parent App Fuera de Servicio !!  :C   FallBack Enabled!!");
    return "CIRCUIT BREAKER ENABLED!! No hay respuesta de Parent App en este momento!!"; 
  }
}
