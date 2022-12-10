package de.bitc.kraken.api.model;

import java.util.Objects;

public class Status {

    private String status;

    private String timestamp;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return Objects.equals(status, status1.status) && Objects.equals(timestamp, status1.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, timestamp);
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
