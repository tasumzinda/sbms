
      <div class="card">
     <div class="card-body">

    <h3 class="h4 text-center py-4 blue">Add Client</h3>
    <div class="card-body mx-1">
       
        <form:form modelAttribute="item" action="${contextPath}/client/addClient/form" method="POST">         
            <c:set var="id" value="${item.id}"/>
            <div class="md-form">
               
                
                        <form:select path="clientType" class="mdb-select">
                                    <form:option value="" label="Client Type"/>
                                   
                                    <form:option value="Company" label="Company"/>
                                    <form:option value="Individual" label="Individual"/>
                         </form:select>
                        <p class="help-block">
                            <form:errors path="clientType" class="alert-danger"/>
                        </p>
            </div>
            <div class="md-form">
                <i class="fa fa-user-circle-o prefix grey-text"></i>
                <form:input path="name" id="name" class="form-control"/>
                <label for="name" class="font-weight-light">Name</label>
                <p class="help-block">
                 <form:errors path="name" class="alert-danger"/>
                </p>
            </div>
             <div class="md-form">
                <i class="fa fa-pencil-square prefix grey-text"></i>
                <form:input path="description" id="description" class="form-control"/>
                <label for="description" class="font-weight-light">Description</label>
                 <p class="help-block">
                 <form:errors path="description" class="alert-danger"/>
                 </p>
            </div>
             <div class="md-form">
                <i class="fa fa-address-book prefix grey-text"></i>
                <form:input path="address" id="address" class="form-control"/>
                <label for="address" class="font-weight-light">Address</label>
                 <p class="help-block">
                  <form:errors path="address" class="alert-danger"/>
                 </p>
            </div>
             <div class="md-form">
                <i class="fa fa-envelope prefix grey-text"></i>
                <form:input path="email" id="email" class="form-control"/>
                <label for="email" class="font-weight-light">Email</label>
                <p class="help-block" >
                <form:errors path="email" class="alert-danger"/>
                </p>
            </div>
            <div class="md-form">
                <i class="fa fa-phone prefix grey-text"></i>
                <form:input path="phone" id="phone" class="form-control"/>
                <label for="phone" class="font-weight-light">Phone</label>
                <p class="help-block" >
                <form:errors path="phone" class="alert-danger"/>
                </p>
            </div>
            <div class="md-form">
                <i class="fa fa-link prefix grey-text"></i>
                <form:input path="website" id="website" class="form-control"/>
                <label for="website" class="font-weight-light">Website</label>
                <p class="help-block" >
                <form:errors path="website" class="alert-danger"/>
                </p>
            </div>
             <div class="md-form">            
                        <form:select path="branchesYesNo" class="mdb-select">
                                    <form:option value="" label="Branches(Yes/No)"/>
                                    <form:option value="Yes" label="Yes"/>
                                    <form:option value="No" label="No"/>
                         </form:select>
                        <p class="help-block">
                            <form:errors path="branchesYesNo" class="alert-danger"/>
                        </p>
             </div>
                <div class="text-center py-4 mt-3">
                <form:button class="btn btn-blue">Add Client</form:button>
            </div>
        </form:form>
    </div>
</div>
</div>

                      

