package org.maestronic.siri.authority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Authority {

    @Id
    private String id;
    private String name;
    private String short_name;
    private String version;

    public Authority() {
    }

    public Authority(String id, String name, String short_name, String version) {
        this.id = id;
        this.name = name;
        this.short_name = short_name;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
