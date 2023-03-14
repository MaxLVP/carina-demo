package com.qaprosoft.carina.demo.mobile.bellewhole.models;

import java.util.Objects;

public class DressModel {
    private Double price;
    private String id;
    private String style;
    private String material;
    private String length;

    public DressModel() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DressModel that = (DressModel) o;
        return Objects.equals(price, that.price) && Objects.equals(style, that.style) && Objects.equals(material, that.material) && Objects.equals(length, that.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, style, material, length);
    }
}
