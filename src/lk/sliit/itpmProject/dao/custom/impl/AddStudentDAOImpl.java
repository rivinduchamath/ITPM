package lk.sliit.itpmProject.dao.custom.impl;

import lk.sliit.itpmProject.dao.CrudUtil;
import lk.sliit.itpmProject.dao.custom.AddStudentDAO;
import lk.sliit.itpmProject.entity.AddStudent;
import lk.sliit.itpmProject.entity.AddWorkingDaysAndHours;

import java.util.List;

public class AddStudentDAOImpl implements AddStudentDAO {
    @Override
    public List<AddStudent> findAll() throws Exception {
        return null;
    }

    @Override
    public AddStudent find(String s) throws Exception {
        return AddStudent;
    }

    @Override
    public boolean save(AddStudent entity) throws Exception {
        return CrudUtil.execute("INSERT INTO AddStudent VALUES()",
            entity.getId(),
            entity.getYear()
                );
        /*

        return CrudUtil.execute("INSERT INTO WorkingDays VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                entity.getId(),
                entity.getNoOfWorkingDays(), entity.isSunday(),
                entity.isMonday(),entity.isTuesday(),entity.isWednesday(),
                entity.isThursday(),entity.isFriday(),entity.isSaturday(),
                entity.getHours(),entity.getMinutes()
        );
         */
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
