import { render } from '@testing-library/react';
import React, { useEffect,useState } from 'react';
import {EMPLOYEE_SERVICE_BASE_URL,EMPLOYEE_ID} from "../configs/Constants"

const EmployeeComponent=()=>{

    const [employee,setEmployee]=useState({});
    const [department,setDepartment]=useState({});
    const [organization,setOrganization]=useState({});


    const getEmployeeData=async ()=>{
      const data=await fetch(EMPLOYEE_SERVICE_BASE_URL+EMPLOYEE_ID+2);
      const fetchedData=await data.json();
      setEmployee(fetchedData.employee);
      setDepartment(fetchedData.department);
      setOrganization(fetchedData.organization);
      console.log(fetchedData.organization);
    }

    useEffect( ()=>{
      getEmployeeData();       
    },[])


    
      return(
        <>
           <div className='container card col-md-6  offset-md-3'>
               <h3 className='text-center card-header'>View Employee Details</h3><br></br>
               <div className='card-body'>
                <div className='row'>
                  <p><strong>Employee First Name: </strong> {employee.firstName}</p>
                </div>
                <div className='row'>
                  <p><strong>Employee Last Name: </strong> {employee.lastName}</p>
                </div>
                <div className='row'>
                  <p><strong>Employee  email: </strong>{employee.email}</p>
                </div>
                <div className='row'>
                  <p><strong>Employee departmentCode: </strong>{employee.departmentCode}</p>
                </div>
                <div className='row'>
                  <p><strong>Employee  organizationCode: </strong>{employee.organizationCode}</p>
                </div>
               </div>
               <h3 className='text-center card-header'>View Department Details</h3><br></br>
               <div className='card-body'>
                <div className='row'>
                  <p><strong>Employee DepartmentName: </strong> {department.departmentName}</p>
                </div>
                <div className='row'>
                <p><strong>Employee DepartmentDescription:</strong>{department.departmentDescription}</p>
                </div>
                <div className='row'>
                  <p><strong>Employee  DepartmentCode: </strong> {department.departmentCode}</p>
                </div>
               </div>
               <h3 className='text-center card-header'>View Organization Details</h3><br></br>
               <div className='card-body'>
                <div className='row'>
                  <p><strong>Employee OrganizationName: </strong>{organization.organizationName}</p>
                </div>
                <div className='row'>
                <p><strong>Employee OrganizationDescription: </strong>{organization.organizationDescription}</p>
                </div>
                <div className='row'>
                  <p><strong>Employee  OrganizationCode:</strong> {organization.organizationCode}</p>
                </div>
               </div>
           </div>
        </>
      );
    
}

export default EmployeeComponent;