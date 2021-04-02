package lk.sliit.itpmProject.dao;


import lk.sliit.itpmProject.dao.custom.impl.AddLecturerDAOImpl;
import lk.sliit.itpmProject.dao.custom.impl.AddStudentDAOImpl;
import lk.sliit.itpmProject.dao.custom.impl.AddWorkingDaysDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory == null)? (daoFactory = new DAOFactory()): daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case AddWorkingDaysDAO:
                return (T) new AddWorkingDaysDAOImpl();
            case AddStudent:
                return (T) new AddStudentDAOImpl();
            case AddLecturer:
                return (T) new AddLecturerDAOImpl();


            default:
                return null;
        }
    }

}
