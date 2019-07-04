package by.yurusova.entranceExam.dao;

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
public class TeacherDAOImpl extends AbstractBaseDAO implements TeacherDAO {

    @Override
    public Teacher findById(final long id) {
        return (Teacher) super.findById(id, Teacher.class);
    }

    @Override
    public void saveTeacher(final Teacher teacher) {
        super.save(teacher);
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
        List teachers = super.getAll("from Teacher");
        return (List<Teacher>) teachers;
    }
}
