package by.yurusova.entranceExam.dao;



import by.yurusova.entranceExam.entity.Subject;

import java.util.List;
/**
 * Class responsible for operations with subject table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SubjectDAOImpl extends AbstractBaseDAO implements SubjectDAO {

    @Override
    public Subject findById(final long id) {
        return (Subject) super.findById(id, Subject.class);
    }

    @Override
    public void saveSubject(final Subject subject) {
        super.save(subject);
    }

    @Override
    public List<Subject> getAll() {
        List subjects = super.getAll("from Subject");
        return (List<Subject>) subjects;
    }

    @Override
    public void delete(final Subject subject) {
        super.delete(subject);
    }
}
