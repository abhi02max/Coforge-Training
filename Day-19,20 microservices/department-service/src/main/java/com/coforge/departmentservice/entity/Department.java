package com.coforge.departmentservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(nullable = false)
    private String departmentName;

    @Column(nullable = false)
    private String departmentCode;

    @Column(nullable = false)
    private String departmentLocation;

    public Department() {
    }

    public Department(Long departmentId, String departmentName, String departmentCode, String departmentLocation) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.departmentLocation = departmentLocation;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }

    public static DepartmentBuilder builder() {
        return new DepartmentBuilder();
    }

    public static class DepartmentBuilder {
        private Long departmentId;
        private String departmentName;
        private String departmentCode;
        private String departmentLocation;

        public DepartmentBuilder departmentId(Long departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public DepartmentBuilder departmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public DepartmentBuilder departmentCode(String departmentCode) {
            this.departmentCode = departmentCode;
            return this;
        }

        public DepartmentBuilder departmentLocation(String departmentLocation) {
            this.departmentLocation = departmentLocation;
            return this;
        }

        public Department build() {
            return new Department(departmentId, departmentName, departmentCode, departmentLocation);
        }
    }
}
