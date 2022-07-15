package com.narola.testspringboot.medicine.repository;

import com.narola.testspringboot.model.Medicine;
import org.springframework.data.repository.CrudRepository;

public interface MedicineRepository extends CrudRepository<Medicine,Integer> {


}
