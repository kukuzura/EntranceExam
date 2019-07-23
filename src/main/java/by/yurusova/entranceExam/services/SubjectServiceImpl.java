package by.yurusova.entranceExam.services;

import by.yurusova.entranceExam.dao.interfaces.SubjectDAO;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.services.interfaces.SubjectService;

import java.util.List;

/**
 * Class that perform base subject services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SubjectServiceImpl implements SubjectService {

    private SubjectDAO subjectDAO;

    @Override
    public List<Subject> getAll() {
        return subjectDAO.getAll();
    }

    @Override
    public Subject findById(final long id) {
        return subjectDAO.findById(id);
    }

    @Override
    public void save(final Subject subject) {
        subjectDAO.saveSubject(subject);
    }

    @Override
    public void delete(final Subject subject) {
        subjectDAO.delete(subject);
    }

    /**
     * Sets subjectDAO.
     *
     * @param subjectDAO the subjectDAO.
     */
    public void setSubjectDAO(final SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }
}
