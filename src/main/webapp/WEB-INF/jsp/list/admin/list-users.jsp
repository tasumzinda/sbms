<div class="card">
     <div class="card-body">
<table id="listTable" class="table table-bordered text-center">

    <!--Table head-->
    <thead class="blue">
        <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Date Created</th>
            <th></th>
            <th></th>
            
            
        </tr>
    </thead>
    <!--Table head-->

    <!--Table body-->
    <tbody>
        
        <c:forEach var="item" items="${items}" varStatus="loop" >
        <tr>
            <th>${loop.count}</th>
            <td>${item.firstName}</td>
            <td>${item.lastName}</td>
            <td>${item.userName}</td>
            <td>${item.dateCreated}</td>
            <td><a href="<c:url value="${contextPath}/admin/addUsers/form?id=${item.id}"/>"><i class="fa fa-pencil-square fa-1x"></i></a></td>
            <td><a href="<c:url value="${contextPath}/admin/addUsers/form?id=${item.id}"/>"><i class="fa fa-trash red-text fa-1x"></i></a></td>
        </tr>
         </c:forEach>
       
    </tbody>
    <!--Table body-->

</table>
     </div>
</div>

