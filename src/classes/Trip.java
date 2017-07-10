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
public class Trip {

    private String route_id;
    //private String service_id;
    private String trip_id;
   // private String trip_headsign;
    //private String trip_short_name;
    //private String direction_id;
    //private String block_id;
    //private String shape_id;
    //private String wheelchair_accessible;
    //private String trip_time;

    public Trip(String route_id, String trip_id) {
        this.route_id = route_id;
        //this.service_id = service_id;
        this.trip_id = trip_id;
        //this.trip_headsign = trip_headsign;
        //this.trip_short_name = trip_short_name;
        //this.direction_id = direction_id;
        //this.block_id = block_id;
        //this.shape_id = shape_id;
        //this.wheelchair_accessible = wheelchair_accessible;
        //this.trip_time = trip_time;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }
}
