
const DepartmentComponent=(department)=>{

   return (<>
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
   </>
   );
}

export default DepartmentComponent;