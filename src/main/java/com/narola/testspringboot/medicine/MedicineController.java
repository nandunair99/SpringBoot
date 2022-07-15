package com.narola.testspringboot.medicine;

import com.narola.testspringboot.category.repository.CategoryRepository;
import com.narola.testspringboot.medicine.repository.MedicineRepository;
import com.narola.testspringboot.model.Category;
import com.narola.testspringboot.model.Medicine;
import com.narola.testspringboot.utility.DbHelper;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.xml.ws.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MedicineController {

    @Autowired
    MedicineRepository repository;
    @Autowired
    DbHelper dbHelper;
    @Autowired
    CategoryRepository categoryRepository;


//    @Autowired
//    @Qualifier("defaultViewResolver")
//    private InternalResourceViewResolver internalResourceViewResolver;

    @GetMapping("/showMedicineForm")
    public ModelAndView showMedicineForm() {
        List<Category> categorydao = (List<Category>) categoryRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("addmedicineform");
        modelAndView.addObject(categorydao);
        return modelAndView;
    }

    @PostMapping("/addMedicine")
    public ResponseEntity<String> addMedicine() {
        Category category=new Category();
        category.setCatName("cosmetics");

        Medicine medicine=new Medicine();
        medicine.setMedicineName("albandazol");
        medicine.setCost(200);
        medicine.setCategory(category);
        medicine.setMfgDate(LocalDate.now());
        medicine.setExpDate(LocalDate.now());
        medicine.setCreatedOn(LocalDateTime.now());
        medicine.setUpdatedOn(LocalDateTime.now());
        Medicine med=repository.save(medicine);
        return ResponseEntity.ok("Medicine Added");
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        dbHelper.getName();
        return ResponseEntity.ok(dbHelper.getName()+" "+dbHelper.getType());
    }

}
