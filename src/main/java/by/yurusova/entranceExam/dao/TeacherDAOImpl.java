package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.TeacherDAO;
import by.yurusova.entranceExam.entities.Teacher;

import java.util.List;

/**
 * DAO class that responsible for operations with teacher table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class TeacherDAOImpl extends AbstractBaseDAO<Teacher> implements TeacherDAO {

    @Override
    public Teacher findById(final long id) {
        return (Teacher) super.findById(id, Teacher.class);
    }

    @Override
    public Long saveTeacher(final Teacher teacher) {
        return (Long) super.save(teacher);
    }

    @Override
    public void delete(final Teacher teacher) {
        super.delete(teacher);
    }

    @Override
    public void update(final Teacher teacher) {
        super.update(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return super.getAll("from Teacher", Teacher.class);
    }
}
