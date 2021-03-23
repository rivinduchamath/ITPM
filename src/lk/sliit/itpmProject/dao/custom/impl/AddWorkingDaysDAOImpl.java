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
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        List<AddWorkingDaysAndHours> workingDaysAndHours = new ArrayList<>();
        while (rst.next()) {
            workingDaysAndHours.add(new AddWorkingDaysAndHours(rst.getInt(1),
                    rst.getBoolean(2),
                    rst.getBoolean(3),
                    rst.getBoolean(4),
                    rst.getBoolean(5),
                    rst.getBoolean(6),
                    rst.getBoolean(7),
                    rst.getBoolean(8),
                    rst.getInt(9),
                    rst.getInt(10)));
        }
        return workingDaysAndHours;
    }

    @Override
    public AddWorkingDaysAndHours find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(AddWorkingDaysAndHours entity) throws Exception {
        return false;
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
