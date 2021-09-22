package org.maestronic.siri.operator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Operator {

    @Id
    private String id;
    private String contact_email;
    private String contact_phone;
    private String contact_url;
    private String name;
    private String short_name;
    private String version;

    public Operator() {
    }

    public Operator(String id, String contact_email, String contact_phone, String contact_url, String name, String short_name, String version) {
        this.id = id;
        this.contact_email = contact_email;
        this.contact_phone = contact_phone;
        this.contact_url = contact_url;
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

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_url() {
        return contact_url;
    }

    public void setContact_url(String contact_url) {
        this.contact_url = contact_url;
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
        return "Operator{" +
                "id='" + id + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", contact_phone='" + contact_phone + '\'' +
                ", contact_url='" + contact_url + '\'' +
                ", name='" + name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
