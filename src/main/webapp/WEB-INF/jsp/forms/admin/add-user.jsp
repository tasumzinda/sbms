
        
<div class="card">
    <h3 class="h4 text-center py-4 blue">CREATE/EDIT USERS</h3>
    <div class="card-body mx-1">
       
        <form:form modelAttribute="item" action="${contextPath}/admin/addUsers/form" method="POST">         
            <c:set var="id" value="${item.id}"/>
            <div class="md-form">
                <i class="fa fa-user prefix grey-text"></i>
                <form:input path="firstName" id="firstName" class="form-control"/>
                <label for="firstName" class="font-weight-light">First Name</label>
                <p class="help-block">
                <form:errors path="firstName" class="alert-danger"/>
                </p>
            </div>
             <div class="md-form">
                <i class="fa fa-user prefix grey-text"></i>
                <form:input path="lastName" id="lastName" class="form-control"/>
                <label for="lastName" class="font-weight-light">Last Name</label>
                 <p class="help-block">
                 <form:errors path="lastName" class="alert-danger"/>
                 </p>
            </div>
            <div class="md-form">
                <i class="fa fa-envelope prefix grey-text"></i>
                <form:input path="userName" id="userName" class="form-control"/>
                <label for="userName" class="font-weight-light">Email</label>
                <p class="help-block" >
                <form:errors path="userName" class="alert-danger"/>
                </p>
            </div>

            <div class="md-form ">
                <i class="fa fa-key prefix grey-text"></i>
                <label class="font-weight-light">Roles</label>
                <div class="form-check" style="margin-left: 100px">
                 <form:checkboxes class="test" path="userRoles" items="${userRoles}"  itemLabel="printName" itemValue="id" />
                </div>
                <p class="help-block" style="margin-top: 10px">
               <form:errors path="userRoles" class="alert-danger "/>
                </p>
            </div>   

            <!-- Material input password -->
            <div class="md-form">
                <i class="fa fa-lock prefix grey-text"></i>
                <form:password id="password" path="password" class="form-control"/>
                <label for="password" class="font-weight-light">Password</label>
                <p class="help-block" >
                <form:errors path="password" class="alert-danger"/>
                </p>
            </div>
            <div class="md-form">
                <i class="fa fa-lock prefix grey-text"></i>
                <form:password id="confirmPassword" path="confirmPassword" class="form-control"/>
                <label for="confirmPassword" class="font-weight-light">Confirm Password</label>
                <p class="help-block">
                <form:errors path="confirmPassword" class="alert-danger"/>
                </p>
            </div>

            <div class="text-center py-4 mt-3">
                <form:button id="save-cat" class="btn btn-blue">Add Users</form:button>
            </div>
        </form:form>
    </div>
</div>
                      
