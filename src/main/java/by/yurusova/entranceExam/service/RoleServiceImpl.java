package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.RoleDAO;
import by.yurusova.entranceExam.entity.Role;

public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Override
    public Role findByName(String roleName) {
        return roleDAO.findByName(roleName);
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
}
