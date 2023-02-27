

const EmployeeComponent=(employee)=>{
    
  return(
    <>
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
    </>
  );
}


export default EmployeeComponent;