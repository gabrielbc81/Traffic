/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Roger
 */
public class Stop {

    private String stop_id;
    //private String stop_cod;
    //private String stop_name;
    //private String stop_desc;
    private double stop_lat;
    private double stop_lon;

    public Stop(String stop_id, double stop_lat, double stop_lon) {
        this.stop_id = stop_id;
        this.stop_lat = stop_lat;
        this.stop_lon = stop_lon;
    }

    public String getStop_id() {
        return stop_id;
    }

    public void setStop_id(String stop_id) {
        this.stop_id = stop_id;
    }

    public double getStop_lat() {
        return stop_lat;
    }

    public void setStop_lat(double stop_lat) {
        this.stop_lat = stop_lat;
    }

    public double getStop_lon() {
        return stop_lon;
    }

    public void setStop_lon(double stop_lon) {
        this.stop_lon = stop_lon;
    }    
}
