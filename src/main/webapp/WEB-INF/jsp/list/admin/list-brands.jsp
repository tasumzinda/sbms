<div class="card">
     <div class="card-body">
    <table id="listTable" class="table table-bordered text-center">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Description</th>
         <!--   <th>Category</th>-->
            <th>Date Created</th>
            <th>                
               <a href="" class="btn btn-primary btn-sm btn-rounded waves-effect waves-light" data-toggle="modal" data-target="#modalBrandForm">
                   New Brand<i class="fa fa-plus ml-1"></i>
               </a>
                
            </th>          
        </tr>
        </thead>
    <tbody>
        <c:forEach var="bran" items="${brands}" varStatus="loop" >
        <tr>
            <th>${loop.count}</th>
            <td>${bran.name}</td>
            <td>${bran.description}</td>
           <!-- <td></td>-->
            <td>${bran.dateCreated}</td>
            <td></td>
        </tr>
        </c:forEach>
    </tbody>
    </table>
     </div>
</div>

<div class="modal fade" id="modalBrandForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog cascading-modal" role="document">
                        <!--Content-->
                        <div class="modal-content">

                            <!--Header-->
                            <div class="modal-header light-blue darken-3 white-text">
                                <h4 class=""><i class="fa fa-pencil"></i>Add Brand</h4>
                                <button type="button" class="close waves-effect waves-light" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                            </div>
                            <!--Body-->
                            <div class="modal-body mb-0">
                              <form:form modelAttribute="brand" action="${contextPath}/admin/brand/add" method="POST">  
                                 <div class="md-form">
                                     <form:select path="name" class="mdb-select">
                                                <form:option value="" label="Select Category"/>
                                              <c:forEach var="cat" items="${category}" varStatus="loop" >
                                                <form:option value="${cat.name}" label="${cat.name}"/>
                                              </c:forEach>
                                                
                                       </form:select>
                                 </div>
                                <div class="md-form form-sm">
                                    <i class="fa fa-windows prefix"></i>
                                    <form:input path="name" id="name" class="form-control  form-control-sm"/>
                                    <label>Brand</label>
                                    <p class="help-block">
                                      <form:errors path="name" class="alert-danger"/>
                                    </p>
                                </div>


                                <div class="md-form form-sm">
                                    <i class="fa fa-pencil prefix"></i>
                              <!--      <textarea type="text" id="form8" class="md-textarea form-control form-control-sm" rows="3"></textarea>-->
                                        <form:input path="description" id="description" class="form-control form-control-sm"/>
                                    <label for="description">Description</label>
                                     <p class="help-block">
                                      <form:errors path="description" class="alert-danger"/>
                                    </p>
                                </div>

                                <div class="text-center mt-1-half">
                                    <button class="btn btn-info mb-2">Save<i class="fa fa-send ml-1"></i></button>
                                </div>
                              </form:form>
                            </div>
                        </div>
                        <!--/.Content-->
                    </div>
                </div>

