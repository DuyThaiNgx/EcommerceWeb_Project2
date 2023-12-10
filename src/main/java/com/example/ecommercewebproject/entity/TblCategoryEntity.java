package com.example.ecommercewebproject.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tbl_category", schema = "ecommerceweb", catalog = "")
public class TblCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "category_name")
    private String categoryName;
    @Basic
    @Column(name = "brand_id")
    private String brandId;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "update_date")
    private Timestamp updateDate;
    @Basic
    @Column(name = "create_date")
    private Timestamp createDate;
    @Basic
    @Column(name = "status")
    private byte status;
    @Basic
    @Column(name = "product_type")
    private String productType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblCategoryEntity that = (TblCategoryEntity) o;
        return status == that.status && Objects.equals(id, that.id) && Objects.equals(categoryName, that.categoryName) && Objects.equals(brandId, that.brandId) && Objects.equals(description, that.description) && Objects.equals(updateDate, that.updateDate) && Objects.equals(createDate, that.createDate) && Objects.equals(productType, that.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, brandId, description, updateDate, createDate, status, productType);
    }
}
