package com.narola.testspringboot.medicine;

import com.narola.testspringboot.model.Medicine;
import com.narola.testspringboot.medicine.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicineController {

    @Autowired
    MedicineRepository repository;
    @PostMapping("/showMedicineForm")
    public String showMedicineForm()
    {
//        Medicine medicine=new Medicine();
//        medicine.setMedicineName("raj");
//        medicine.setCost(25);
//        ModelAndView modelAndView=new ModelAndView("addmedicineform.jsp");
//        modelAndView.addObject(medicine);
//        return modelAndView;
        return "addmedicineform";
    }
}
