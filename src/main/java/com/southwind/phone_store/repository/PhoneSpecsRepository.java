package com.southwind.phone_store.repository;

import com.southwind.phone_store.entity.PhoneSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PhoneSpecsRepository extends JpaRepository<PhoneSpecs,Integer> {

    public List<PhoneSpecs> findAllByPhoneId(Integer phoneId);

}
