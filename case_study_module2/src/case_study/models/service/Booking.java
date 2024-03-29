package case_study.models.service;

public class Booking {
    private String codeBooking;
    private String dayStart;
    private String dayEnd;
    private String codeCustomer;
    private String nameService;
    private String typeService;

    public Booking() {
    }

    public Booking(String codeBooking, String dayStart, String dayEnd, String codeCustomer, String nameService, String typeService) {
        this.codeBooking = codeBooking;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.codeCustomer = codeCustomer;
        this.nameService = nameService;
        this.typeService = typeService;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Booking | " +
                "codeBooking='" + codeBooking + '\'' +
                ", dayStart='" + dayStart + '\'' +
                ", dayEnd='" + dayEnd + '\'' +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", nameService='" + nameService + '\'' +
                ", typeService='" + typeService;
    }
}
