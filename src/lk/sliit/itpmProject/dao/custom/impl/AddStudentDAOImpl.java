package lk.sliit.itpmProject.dao.custom.impl;

import lk.sliit.itpmProject.dao.CrudUtil;
import lk.sliit.itpmProject.dao.custom.AddStudentDAO;
import lk.sliit.itpmProject.entity.AddStudent;
import java.util.List;

public class AddStudentDAOImpl implements AddStudentDAO {
    @Override
    public List<AddStudent> findAll() throws Exception {
        return null;
    }

    @Override
    public AddStudent find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(AddStudent entity) throws Exception {
        return CrudUtil.execute("INSERT INTO AddStudentSubGroups VALUES (?,?,?,?,?,?,?,?)",
                entity.getId(),
                entity.getYear(),
                entity.getSemester(),
                entity.getProgramme(),
                entity.getGroupNo(),
                entity.getSubGroupNo(),
                entity.getGroupId(),
                entity.getSubGroupId()
        );
    }

    @Override
    public boolean update(AddStudent entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }
}
