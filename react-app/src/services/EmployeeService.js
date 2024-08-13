import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/v1/api/employee";

export const listEmployees =() =>{
    return axios.get(`${REST_API_BASE_URL}/getAllEmployee`);
}

// export const createEmployee =(employee) => axios.post(REST_API_BASE_URL,employee);
export const createEmployee = (employee) => axios.post(`${REST_API_BASE_URL}/createEmployee`, employee);


// export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL +'/' +employeeId);

export const getEmployee = (employeeId) => axios.get(`${REST_API_BASE_URL}/getEmployeeById`, {
    params: { empId: employeeId }
});

// export const updateEmployee = (employeeId,employee) => axios.put(`${REST_API_BASE_URL}/updateEmployeeById`, employeeId,employee);

export const updateEmployee = (employeeId, employee) => 
    axios.put(`${REST_API_BASE_URL}/updateEmployeeById?employeeId=${employeeId}`, employee, {
        headers: {
            'Content-Type': 'application/json'
        }
    });

    // export const deleteEmployee =(employeeId) => axios.delete(REST_API_BASE_URL +'/'+employeeId);
    
    export const deleteEmployee = (employeeId) => 
        axios.delete(`${REST_API_BASE_URL}/deleteEmployee`, {
            params: {
                empId: employeeId
            }
        });
    


