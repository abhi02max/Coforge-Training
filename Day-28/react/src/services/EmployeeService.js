import axios from "axios";


class EmployeeService  {
    constructor(){
    this.BASE_URL = "http://localhost:1111/api/v1/ems";
    }

    saveEmployee(employee) {
    return axios.post(this.BASE_URL + "/employees", employee);
    }

  updateEmployee(eid, employee) {
        return axios.put(this.BASE_URL + "/employees/" + eid, employee)
            .then((response) => {
                console.log(response.data);
                return response.data;
            });
    }

    deleteEmployee(eid) {
        return axios.delete(this.BASE_URL + "/employees/" + eid)
            .then((response) => {
                console.log(response.data);
                return response.data;
            });
    }

    findEmployee(eid) {
        return axios.get(this.BASE_URL + "/employees/" + eid)
            .then((response) => {
                console.log(response.data);
                return response.data;
            });
    }

    findAllEmployees() {
        return axios.get(this.BASE_URL + "/employees")
            .then((response) => {
                console.log(response.data);
                return response.data;
            });
    }
}

export default EmployeeService;