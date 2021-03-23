package lk.sliit.itpmProject.dao.custom.impl;

import lk.sliit.itpmProject.dao.CrudUtil;
import lk.sliit.itpmProject.dao.custom.AddWorkingDaysDAO;
import lk.sliit.itpmProject.entity.AddWorkingDaysAndHours;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddWorkingDaysDAOImpl implements AddWorkingDaysDAO {

    @Override
    public List<AddWorkingDaysAndHours> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM WorkingDays");
        List<AddWorkingDaysAndHours> workingDaysAndHours = new ArrayList<>();
        while (rst.next()) {
            workingDaysAndHours.add(new AddWorkingDaysAndHours(
                    rst.getInt(1),
                    rst.getInt(2),
                    rst.getBoolean(3),
                    rst.getBoolean(4),
                    rst.getBoolean(5),
                    rst.getBoolean(6),
                    rst.getBoolean(7),
                    rst.getBoolean(8),
                    rst.getBoolean(9),
                    rst.getInt(10),
                    rst.getInt(11)));
        }
        return workingDaysAndHours;
    }

    @Override
    public boolean save(AddWorkingDaysAndHours entity) throws Exception {
        return CrudUtil.execute("INSERT INTO WorkingDays VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                entity.getId(),
                entity.getNoOfWorkingDays(), entity.isSunday(),
                entity.isMonday(),entity.isTuesday(),entity.isWednesday(),
                entity.isThursday(),entity.isFriday(),entity.isSaturday(),
                entity.getHours(),entity.getMinutes()
        );
    }

    @Override
    public AddWorkingDaysAndHours find(String s) throws Exception {
        return null;
    }



    @Override
    public boolean update(AddWorkingDaysAndHours entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }
}
