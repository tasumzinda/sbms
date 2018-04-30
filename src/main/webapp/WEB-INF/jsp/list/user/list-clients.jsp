 <div class="card">
     <div class="card-body">
         <table id="listTable" class="table table-striped table-bordered text-center table-responsive-lg w-auto">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Client Type</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Website</th>  
                    <th></th>
                    <th></th>
                    <th></th>  
                    <th></th> 
                </tr>
                </thead>
            <tbody>
                <c:forEach var="client" items="${clients}" varStatus="loop" >
                <tr>
                    <th>${loop.count}</th>
                    <td>${client.clientType}</td>
                    <td>${client.name}</td>
                    <td>${client.description}</td>
                    <td>${client.email}</td>
                    <td>${client.phone}</td>
                    <td>${client.website}</td>
                    <td><a href="<c:url value="${contextPath}/client/contact/addContact?id=${client.id}"/>"><i class="fa fa-address-book blue-text fa-1x"></i></a></td> 
                    <td><a href="" id="getProcs"  
                           data-toggle="modal"
                           data-target="#procurement"
                           data-cname="${client.name}"
                           data-link="${contextPath}/ajax/procurementDocs/${client.id}">
                            <i class="fa fa-newspaper-o grey-text fa-1x"></i>
                        </a>
                    </td> 
                    <td>
                        <a href="${contextPath}/client/inventory/addClientinventory?id=${client.id}"><i class="fa fa-building blue-text fa-1x"></i></a>
                    </td>
                    <td>
                        <a href="#"><i class="fa fa-trash red-text fa-1x"></i></a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
         </table>
     </div>
 </div>

<div class="modal fade right" id="procurement" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                    aria-hidden="true" data-backdrop="false">
                    <div class="modal-dialog modal-full-height modal-right modal-notify modal-primary" role="document">
                       
                        <div class="modal-content">
                           
                            <div class="modal-header">
                                <p class="heading lead">Supporting Documents</p>

                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true" class="white-text">&times;</span>
                                                        </button>
                            </div>

                            <!--Body-->
                            <div class="modal-body">
                                
                                <div id="companyname" class="text-center"></div>
                                <ul class="docs list-group z-depth-0">
                                    
                                </ul>
                            </div>

                            <!--Footer-->
                            <div class="modal-footer justify-content-center">
                                <center><a type="button" class="btn btn-blue">Edit <i class="fa fa-pencil-square-o ml-1"></i></a></center>
                                
                            </div>
                        </div>
                        <!--/.Content-->
                    </div>
                </div>
