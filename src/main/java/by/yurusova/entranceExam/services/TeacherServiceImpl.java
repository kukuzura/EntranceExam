package by.yurusova.entranceExam.services;

import by.yurusova.entranceExam.dao.interfaces.TeacherDAO;
import by.yurusova.entranceExam.entities.Teacher;
import by.yurusova.entranceExam.services.interfaces.TeacherService;

import java.util.List;

/**
 * Class that perform base teacher services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class TeacherServiceImpl implements TeacherService {

    private TeacherDAO teacherDAO;

    @Override
    public void addTeacher(final Teacher teacher) {
        teacherDAO.saveTeacher(teacher);
    }

    @Override
    public void deleteTeacher(final long id) {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacherDAO.delete(teacher);
    }

    @Override
    public void editTeacher(final Teacher teacher) {
        teacherDAO.update(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDAO.getAll();
    }

    @Override
    public Teacher findById(final long id) {
        return teacherDAO.findById(id);
    }

    /**
     * Sets teacherDAO.
     *
     * @param teacherDAO teacherDAO to be set.
     */
    public void setTeacherDAO(final TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }
}
