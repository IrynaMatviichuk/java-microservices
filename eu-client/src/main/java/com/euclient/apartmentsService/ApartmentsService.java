package com.euclient.apartmentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("ApartmentService")
public class ApartmentsService {

    @Autowired
    private ApartmentsRepository apartmentsRepository;

    public ApartmentsService() {}

    public List<Apartments> findAll() throws SQLException {
        List<Apartments> apartmentsEntityList = new ArrayList<>();
        apartmentsRepository.findAll().forEach(apartmentsEntityList::add);
        return  apartmentsEntityList;
    }

    public boolean existsById(Long id) throws SQLException {
        return apartmentsRepository.existsById(id);
    }

    public Apartments add(Apartments apartment) throws SQLException {
        return apartmentsRepository.save(apartment);
    }

    public void deleteById(Long id) throws SQLException {
        apartmentsRepository.deleteById(id);
    }

    public Apartments updateById(Apartments apartment) throws SQLException {
        return apartmentsRepository.save(apartment);
    }
}
