package com.narola.testspringboot.medicine;

import com.narola.testspringboot.category.repository.CategoryRepository;
import com.narola.testspringboot.medicine.repository.MedicineRepository;
import com.narola.testspringboot.medicine.validation.MedicineValidator;
import com.narola.testspringboot.model.Category;
import com.narola.testspringboot.model.Medicine;
import com.narola.testspringboot.utility.ApplicationException;
import com.narola.testspringboot.utility.DbHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class MedicineController {

    @Autowired
    MedicineRepository repository;
    @Autowired
    DbHelper dbHelper;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MedicineValidator medicineValidator;
    @Autowired
    MessageSource messageSource;
//    @Autowired
//    @Qualifier("defaultViewResolver")
//    private InternalResourceViewResolver internalResourceViewResolver;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.addValidators(medicineValidator);
    }
    @GetMapping("/showMedicineForm")
    public ModelAndView showMedicineForm() {
        List<Category> categorydao = (List<Category>) categoryRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("addmedicineform");
        modelAndView.addObject(categorydao);
        return modelAndView;
    }

    @PostMapping("/addMedicine")
    public ResponseEntity<String> addMedicine(@Validated Medicine medicine1, BindingResult bindingResult, RedirectAttributes attributes) {
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

        Map<String, String> errorList = new HashMap<>();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError e : errors
            ) {
                errorList.put("medicineErrors",messageSource.getMessage(e.getCode(), null, Locale.getDefault()));
                throw new ApplicationException("redirect:/showMedicineForm", errorList);
            }
        }
        return ResponseEntity.ok("Medicine Added");
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        dbHelper.getName();
        return ResponseEntity.ok(dbHelper.getName()+" "+dbHelper.getType());
    }

}
