package com.coforge.departmentservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDTO {

    private Long departmentId;

    @NotBlank(message = "Department Name cannot be blank")
    private String departmentName;

    @NotBlank(message = "Department Code cannot be blank")
    private String departmentCode;

    @NotBlank(message = "Department Location cannot be blank")
    private String departmentLocation;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long departmentId, String departmentName, String departmentCode, String departmentLocation) {
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

    public static DepartmentDTOBuilder builder() {
        return new DepartmentDTOBuilder();
    }

    public static class DepartmentDTOBuilder {
        private Long departmentId;
        private String departmentName;
        private String departmentCode;
        private String departmentLocation;

        public DepartmentDTOBuilder departmentId(Long departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public DepartmentDTOBuilder departmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public DepartmentDTOBuilder departmentCode(String departmentCode) {
            this.departmentCode = departmentCode;
            return this;
        }

        public DepartmentDTOBuilder departmentLocation(String departmentLocation) {
            this.departmentLocation = departmentLocation;
            return this;
        }

        public DepartmentDTO build() {
            return new DepartmentDTO(departmentId, departmentName, departmentCode, departmentLocation);
        }
    }
}
