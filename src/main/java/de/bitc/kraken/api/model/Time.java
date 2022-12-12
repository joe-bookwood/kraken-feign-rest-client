package de.bitc.kraken.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.bitc.kraken.api.deserializer.EpochToZonedDateTimeDeserializer;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Time implements Serializable {

    @JsonDeserialize(using = EpochToZonedDateTimeDeserializer.class)
    private ZonedDateTime unixtime;

    private String rfc1123;

    public ZonedDateTime getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(ZonedDateTime unixtime) {
        this.unixtime = unixtime;
    }

    public String getRfc1123() {
        return rfc1123;
    }

    public void setRfc1123(String rfc1123) {
        this.rfc1123 = rfc1123;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(unixtime, time.unixtime) && Objects.equals(rfc1123, time.rfc1123);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unixtime, rfc1123);
    }

    @Override
    public String toString() {
        return "Time{" +
                "unixtime=" + unixtime +
                ", rfc1123='" + rfc1123 + '\'' +
                '}';
    }
}
