package com.QATechTesting.HMS.DockerSpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.QATechTesting.HMS.DockerSpringBoot.DAO.PatientRepo;
import com.QATechTesting.HMS.DockerSpringBoot.Model.HMS;

@Controller
public class HMSController {
	@Autowired
	private PatientRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addRecord")
	public String addPatient(HMS patient) {
		System.out.println("patientname----------" + patient);
		repo.save(patient);
		return "CreateRecord.jsp";
	}

	@RequestMapping("/findRecordByID")
	public ModelAndView findPatientByID(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("ShowRecord.jsp");
		HMS t = repo.findById(id).orElse(null);
		mv.addObject("hms", t);
		return mv;
	}

}
