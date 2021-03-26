package lk.sliit.itpmProject.business;

import lk.sliit.itpmProject.business.custom.impl.AddStudentBOImpl;
import lk.sliit.itpmProject.business.custom.impl.AddWorkingDaysAndHoursBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory == null)? (boFactory = new BOFactory()): boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes){
        switch (boTypes){
            case AddWorkingDays:
                return (T) new AddWorkingDaysAndHoursBOImpl();
            case AddStudent:
                return (T) new AddStudentBOImpl();

            default:
                return null;
        }
    }

}
