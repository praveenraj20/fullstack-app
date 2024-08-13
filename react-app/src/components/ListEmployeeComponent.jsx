import React,{useEffect, useState} from 'react'
import { deleteEmployee, listEmployees } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const ListEmployeeComponent = () => {

    const [employees, setEmployee]= useState([]);
    const navigator = useNavigate();

    useEffect(() => {
        getAllEmployee();
    },[])

    function getAllEmployee(){
        listEmployees().then((response) => {
            setEmployee(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    // const dummyData =[
    //     {
    //         "id":1,
    //         "firstName":"Subramani",
    //         "lastname":"Raja",
    //         "email":"raja@gmail.com"
    //     },
    //     {
    //         "id":2,
    //         "firstName":"Anil",
    //         "lastname":"Chauhan",
    //         "email":"anil@gmail.com"
    //     },
    //     {
    //         "id":3,
    //         "firstName":"Upedra",
    //         "lastname":"Dewedi",
    //         "email":"upendra@gmail.com"
    //     },
    //     {
    //         "id":4,
    //         "firstName":"Praveen",
    //         "lastname":"Raj",
    //         "email":"raj@gmail.com"
    //     },
    // ]

    function addNewEmployee(){
        navigator('/add-employee')
    }
    function updateEmployee(id){
        navigator(`/edit-employee/${id}`)
    }

    function removeEmployee(id){
        console.log(id);
        deleteEmployee(id).then((response) => {
            getAllEmployee();
        }).catch(error => {
            console.error(error);
        })

    }

  return (
    <div className='container'> 
        <h2 className='text-center'>List Of Employees</h2>
        <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                   <th>Employee Id</th>  
                   <th>Employee First Name</th>
                   <th>Employee last Name</th>
                   <th>Employee Mail Id</th>
                   <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee =>
                        <tr key={employee.id}>
                            <th>{employee.id}</th>
                            <th>{employee.firstName}</th>
                            <th>{employee.lastName}</th>
                            <th>{employee.email}</th>
                            <td>
                                <button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>Update</button>
                                <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)}
                                    style={{marginLeft:'10px'}}
                                    >Delete</button>

                            </td>
                        </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent