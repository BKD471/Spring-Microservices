import React, { useEffect,useState } from 'react';
import {EMPLOYEE_SERVICE_BASE_URL,EMPLOYEE_ID} from "../configs/Constants"
import DepartmentComponent from './DepartmentComponent';
import EmployeeComponent from './EmployeeComponent';
import OrganizationComponent from './OrganizationComponent';

const BioDataComponent=()=>{

    const [employee,setEmployee]=useState({});
    const [department,setDepartment]=useState({});
    const [organization,setOrganization]=useState({});


    const getEmployeeData=async ()=>{
      const data=await fetch(EMPLOYEE_SERVICE_BASE_URL+EMPLOYEE_ID+2);
      const fetchedData=await data.json();
      setEmployee(fetchedData.employee);
      setDepartment(fetchedData.department);
      setOrganization(fetchedData.organization);
    }

    useEffect( ()=>{
      getEmployeeData();       
    },[])


    
      return(
        <>
           <div className='container card col-md-6  offset-md-3'>
               <EmployeeComponent {...employee}/>
               <DepartmentComponent {...department}/>
               <OrganizationComponent {...organization}/>    
           </div>
        </>
      );
    
}

export default BioDataComponent;