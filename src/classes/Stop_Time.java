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
public class Stop_Time {

    private String trip_id;
    private String stop_id;
    private String stop_sequence;

    public Stop_Time(String trip_id, String stop_id, String stop_sequence) {
        this.trip_id = trip_id;
        this.stop_id = stop_id;
        this.stop_sequence = stop_sequence;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getStop_id() {
        return stop_id;
    }

    public void setStop_id(String stop_id) {
        this.stop_id = stop_id;
    }

    public String getStop_sequence() {
        return stop_sequence;
    }

    public void setStop_sequence(String stop_sequence) {
        this.stop_sequence = stop_sequence;
    }
}
