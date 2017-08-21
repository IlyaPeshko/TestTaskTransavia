package by.htp.task.ui.webDriver;


public enum DriverTypes {
    FIREFOX ("firefox"), IE ("internet explorer"), GC ("google chrome");

    private String driverName;

    private DriverTypes(String driverName){
        this.driverName = driverName;
    }

    public String getDriverName() {
        return this.driverName;
    }
}
