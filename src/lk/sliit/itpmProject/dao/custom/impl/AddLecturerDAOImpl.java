package lk.sliit.itpmProject.dao.custom.impl;

import lk.sliit.itpmProject.dao.CrudUtil;
import lk.sliit.itpmProject.dao.custom.AddLecturerDAO;
import lk.sliit.itpmProject.entity.AddLecturer;

import java.sql.ResultSet;
import java.util.List;

public class AddLecturerDAOImpl implements AddLecturerDAO {
    @Override
    public List<AddLecturer> findAll() throws Exception {
        return null;
    }

    @Override
    public AddLecturer find(String s) throws Exception {
        return null;
    }

    @Override
    public boolean save(AddLecturer entity) throws Exception {
        return CrudUtil.execute("INSERT INTO AddLecturer VALUES (?,?,?,?,?,?,?,?,?)",
                entity.getId(),
                entity.getEmpId(),
                entity.getlName(),
                entity.getDepartment(),
                entity.getFaculty(),
                entity.getCenter(),
                entity.getBuildingNo(),
                entity.getLevel(),
                entity.getRank()
        );
    }

    @Override
    public boolean update(AddLecturer entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public int getLastLecturerID() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM AddLecturer ORDER BY id DESC LIMIT 1");
        if(resultSet.next()){
            return resultSet.getInt(1);
        }
        else {
            return 0;
        }
    }
}
