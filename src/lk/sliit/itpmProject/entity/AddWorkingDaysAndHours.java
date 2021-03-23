package lk.sliit.itpmProject.entity;

public class AddWorkingDaysAndHours implements SuperEntity{

        private int noOfWorkingDays;
        boolean sunday, monday,  tuesday,  wednesday,  thursday,  friday,  saturday;
        int hours;
        int minutes;

        public AddWorkingDaysAndHours(int noOfWorkingDays, boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, int hours, int minutes) {
            this.noOfWorkingDays = noOfWorkingDays;
            this.sunday = sunday;
            this.monday = monday;
            this.tuesday = tuesday;
            this.wednesday = wednesday;
            this.thursday = thursday;
            this.friday = friday;
            this.saturday = saturday;
            this.hours = hours;
            this.minutes = minutes;
        }

        public AddWorkingDaysAndHours() {
        }

        public int getNoOfWorkingDays() {
            return noOfWorkingDays;
        }

        public void setNoOfWorkingDays(int noOfWorkingDays) {
            this.noOfWorkingDays = noOfWorkingDays;
        }

        public boolean isSunday() {
            return sunday;
        }

        public void setSunday(boolean sunday) {
            this.sunday = sunday;
        }

        public boolean isMonday() {
            return monday;
        }

        public void setMonday(boolean monday) {
            this.monday = monday;
        }

        public boolean isTuesday() {
            return tuesday;
        }

        public void setTuesday(boolean tuesday) {
            this.tuesday = tuesday;
        }

        public boolean isWednesday() {
            return wednesday;
        }

        public void setWednesday(boolean wednesday) {
            this.wednesday = wednesday;
        }

        public boolean isThursday() {
            return thursday;
        }

        public void setThursday(boolean thursday) {
            this.thursday = thursday;
        }

        public boolean isFriday() {
            return friday;
        }

        public void setFriday(boolean friday) {
            this.friday = friday;
        }

        public boolean isSaturday() {
            return saturday;
        }

        public void setSaturday(boolean saturday) {
            this.saturday = saturday;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }
}


