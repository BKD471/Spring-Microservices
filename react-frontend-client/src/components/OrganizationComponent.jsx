
const OrganizationComponent=(organization)=>{

   return(
    <>
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
    </>
   );
}

export default OrganizationComponent;