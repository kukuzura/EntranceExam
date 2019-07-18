package by.yurusova.entranceExam.dao;


import by.yurusova.entranceExam.dao.interfaces.SubjectDAO;
import by.yurusova.entranceExam.entities.Subject;

import java.util.List;

/**
 * Class responsible for operations with subject table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SubjectDAOImpl extends AbstractBaseDAO<Subject> implements SubjectDAO {

    @Override
    public Subject findById(final long id) {
        return super.findById(id, Subject.class);
    }

    @Override
    public void saveSubject(final Subject subject) {
        super.save(subject);
    }

    @Override
    public List<Subject> getAll() {
        return super.getAll("from Subject", Subject.class);
    }

    @Override
    public void delete(final Subject subject) {
        super.delete(subject);
    }
}
