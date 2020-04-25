package com.euclient.apartmentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ApartmentService")
public class ApartmentsService {

    @Autowired
    private ApartmentsRepository apartmentsRepository;

    public ApartmentsService() {}

    public List<Apartment> findAll() {
        List<Apartment> apartmentsEntityList = new ArrayList<>();
        apartmentsRepository.findAll().forEach(apartmentsEntityList::add);
        return  apartmentsEntityList;
    }

    public boolean existsById(Long id) {
        return apartmentsRepository.existsById(id);
    }

    public Apartment add(Apartment apartment) {
        return apartmentsRepository.save(apartment);
    }

    public void deleteById(Long id) {
        apartmentsRepository.deleteById(id);
    }

    public Apartment updateById(Apartment apartment) {
        return apartmentsRepository.save(apartment);
    }
}
