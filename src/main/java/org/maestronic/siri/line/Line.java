package org.maestronic.siri.line;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Line {

    @Id
    private String id;
    private Integer accessibility_assessment;
    private String authority_ref;
    private String branding_ref;
    private String description;
    private String external_line_ref;
    private Boolean monitored;
    private String name;
    private String operational_context_ref;
    private String private_code;
    private String public_code;
    private String responsibility_set_ref;
    private String transport_mode;
    private String type_of_product_category_ref;
    private String type_of_service_ref;
    private String version;
    private String color;
    private String text_color;

    public Line() {
    }

    public Line(String id, Integer accessibility_assessment, String authority_ref, String branding_ref, String description, String external_line_ref, Boolean monitored, String name, String operational_context_ref, String private_code, String public_code, String responsibility_set_ref, String transport_mode, String type_of_product_category_ref, String type_of_service_ref, String version, String color, String text_color) {
        this.id = id;
        this.accessibility_assessment = accessibility_assessment;
        this.authority_ref = authority_ref;
        this.branding_ref = branding_ref;
        this.description = description;
        this.external_line_ref = external_line_ref;
        this.monitored = monitored;
        this.name = name;
        this.operational_context_ref = operational_context_ref;
        this.private_code = private_code;
        this.public_code = public_code;
        this.responsibility_set_ref = responsibility_set_ref;
        this.transport_mode = transport_mode;
        this.type_of_product_category_ref = type_of_product_category_ref;
        this.type_of_service_ref = type_of_service_ref;
        this.version = version;
        this.color = color;
        this.text_color = text_color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAccessibility_assessment() {
        return accessibility_assessment;
    }

    public void setAccessibility_assessment(Integer accessibility_assessment) {
        this.accessibility_assessment = accessibility_assessment;
    }

    public String getAuthority_ref() {
        return authority_ref;
    }

    public void setAuthority_ref(String authority_ref) {
        this.authority_ref = authority_ref;
    }

    public String getBranding_ref() {
        return branding_ref;
    }

    public void setBranding_ref(String branding_ref) {
        this.branding_ref = branding_ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternal_line_ref() {
        return external_line_ref;
    }

    public void setExternal_line_ref(String external_line_ref) {
        this.external_line_ref = external_line_ref;
    }

    public Boolean getMonitored() {
        return monitored;
    }

    public void setMonitored(Boolean monitored) {
        this.monitored = monitored;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperational_context_ref() {
        return operational_context_ref;
    }

    public void setOperational_context_ref(String operational_context_ref) {
        this.operational_context_ref = operational_context_ref;
    }

    public String getPrivate_code() {
        return private_code;
    }

    public void setPrivate_code(String private_code) {
        this.private_code = private_code;
    }

    public String getPublic_code() {
        return public_code;
    }

    public void setPublic_code(String public_code) {
        this.public_code = public_code;
    }

    public String getResponsibility_set_ref() {
        return responsibility_set_ref;
    }

    public void setResponsibility_set_ref(String responsibility_set_ref) {
        this.responsibility_set_ref = responsibility_set_ref;
    }

    public String getTransport_mode() {
        return transport_mode;
    }

    public void setTransport_mode(String transport_mode) {
        this.transport_mode = transport_mode;
    }

    public String getType_of_product_category_ref() {
        return type_of_product_category_ref;
    }

    public void setType_of_product_category_ref(String type_of_product_category_ref) {
        this.type_of_product_category_ref = type_of_product_category_ref;
    }

    public String getType_of_service_ref() {
        return type_of_service_ref;
    }

    public void setType_of_service_ref(String type_of_service_ref) {
        this.type_of_service_ref = type_of_service_ref;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText_color() {
        return text_color;
    }

    public void setText_color(String text_color) {
        this.text_color = text_color;
    }

    @Override
    public String toString() {
        return "Line{" +
                "id='" + id + '\'' +
                ", accessibility_assessment=" + accessibility_assessment +
                ", authority_ref='" + authority_ref + '\'' +
                ", branding_ref='" + branding_ref + '\'' +
                ", description='" + description + '\'' +
                ", external_line_ref='" + external_line_ref + '\'' +
                ", monitored=" + monitored +
                ", name='" + name + '\'' +
                ", operational_context_ref='" + operational_context_ref + '\'' +
                ", private_code='" + private_code + '\'' +
                ", public_code='" + public_code + '\'' +
                ", responsibility_set_ref='" + responsibility_set_ref + '\'' +
                ", transport_mode='" + transport_mode + '\'' +
                ", type_of_product_category_ref='" + type_of_product_category_ref + '\'' +
                ", type_of_service_ref='" + type_of_service_ref + '\'' +
                ", version='" + version + '\'' +
                ", color='" + color + '\'' +
                ", text_color='" + text_color + '\'' +
                '}';
    }
}
