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
    @Column(name = "des_cate")
    private String desCate;
    @Basic
    @Column(name = "update_date")
    private Timestamp updateDate;
    @Basic
    @Column(name = "create_date")
    private Timestamp createDate;

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

    public String getDesCate() {
        return desCate;
    }

    public void setDesCate(String desCate) {
        this.desCate = desCate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblCategoryEntity that = (TblCategoryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(categoryName, that.categoryName) && Objects.equals(brandId, that.brandId) && Objects.equals(desCate, that.desCate) && Objects.equals(updateDate, that.updateDate) && Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, brandId, desCate, updateDate, createDate);
    }
}
