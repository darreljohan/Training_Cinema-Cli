import java.time.LocalDateTime;
import java.util.ArrayList;

public class Theater {
    String name;
    String address;
    StudioClass studioClass;
    ArrayList<Schedule> schedules = new ArrayList<>();

    public Theater(String name, String address, StudioClass studioClass) {
        this.name = name;
        this.address = address;
        this.studioClass = studioClass;
    }

    public boolean isSchedulesEmpty(){
        return schedules.isEmpty();
    }

    public boolean isScheduleAvailable(LocalDateTime startTime, LocalDateTime endTime){
        boolean result = true;
        for (Schedule schedule : schedules){
            if(startTime.isAfter(schedule.startTime) && startTime.isBefore(schedule.getEndTime())){
                result = false;
                break;
            }else if(startTime.isBefore(schedule.startTime) && endTime.isAfter(schedule.getStartTime())){
                result = false;
                break;
            }
        }
        return result;
    }

    public void appendSchedule(Schedule schedule){
        schedules.add(schedule);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StudioClass getStudioClass() {
        return studioClass;
    }

    public void setStudioClass(StudioClass studioClass) {
        this.studioClass = studioClass;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
}
