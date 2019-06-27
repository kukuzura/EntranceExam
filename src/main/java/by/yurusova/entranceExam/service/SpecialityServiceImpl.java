package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.SpecialityDAO;
import by.yurusova.entranceExam.dao.SpecialityDAOImpl;
import by.yurusova.entranceExam.entity.Speciality;

import java.util.List;

public class SpecialityServiceImpl implements SpecialityService {

    SpecialityDAO specialityDAO;

    @Override
    public List<Speciality> getAll() {
        return specialityDAO.getAll();
    }

    public void setSpecialityDAO(SpecialityDAO specialityDAO) {
        this.specialityDAO = specialityDAO;
    }
}
