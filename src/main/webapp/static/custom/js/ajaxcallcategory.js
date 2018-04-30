/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {    
    $('#categories').on('submit', function(e){  
        e.preventDefault();
      //  var data = $(this).serialize();
     
      var date = new Date().toDateString();
      var data = {
    		name : $("#name").val(),
    		description :  $("#description").val()
    	};
        var url = $(this).attr('action');
        var post = $(this).attr('method');
        $('#categories #save-cat').prop('disabled', true);   
        $.ajax({      
            type : "POST",
            url : url,
            data : JSON.stringify(data),
            contentType : "application/json",
            success : function(result){
                toastr["success"]("Category Saved Successfully", "Notification");
                $('#categories #save-cat').prop('disabled', false);
                var tr = $('<tr/>');
                tr.append($("<td/>", {
                  text: result.data.id
                })).append($("<td/>", {
               text: data.name
                })).append($("<td/>", {
                    text: data.description
                })).append($("<td/>", {
                    text: date
                })).append($("<td/>", {
                    html : '<center><a class="btn btn-sm  btn-default"><em class="fa fa-pencil"></em></a><a class="btn btn-sm btn-danger" id="del" data-id="'+result.data.id+'" data-name="'+data.name+'" data-description="'+data.description+'"><em class="fa fa-trash"></em></a></center>'
                }));
                $('#catDetails').append(tr);
                $('#name').val('');
                $('#description').val('');
               
            
        },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown+jqXHR+textStatus);
                toastr["error"]("Error, Category Not Saved!!!", "Notification");
            }
        });


    });
    
  $('#inventoryForm').on('submit', function(e){
       e.preventDefault();
       var data = {
                 
    		model : $("#model").val(),
    		ci :  $("#ci").val(),
                brand : $("#brand").val(),
    		quantity :  $("#quantity").val(),
                needMaintenence : $("#needMaintenence").val()
    		
    	};
        var date = new Date().toDateString();
         var url = $(this).attr('action');
         $('#inventoryForm #save-inv').prop('disabled', true); 
         $.ajax({      
            type : "POST",
            url : url,
            data : JSON.stringify(data),
            contentType : "application/json",
            success: function (result) {
              toastr["success"]("Inventory Saved Successfully", "Notification");
              $('#inventoryForm #save-inv').prop('disabled', false); 
              var tr = $('<tr/>'); 
                tr.append($("<td/>", {
                  text: result.data.id
                })).append($("<td/>", {
                    text: data.brand
                })).append($("<td/>", {
                    text: data.model
                })).append($("<td/>", {
                    text: data.quantity
                })).append($("<td/>", {
                    text: data.needMaintenence
                })).append($("<td/>", {
                    text: date
                }));
                $('#clientInventories').append(tr);
                $("#model").val('');
    	        $("#quantity").val('');            
            },
            error: function (jqXHR, textStatus, errorThrown) {
                toastr["error"]("Error Encountered:", "Notification");
                }
      });
  }); 
 $('#contactsForm').on('submit', function(e){
       e.preventDefault();
        var data = {
                ci :  $("#ci").val(),
    		firstName : $("#firstName").val(),
    		lastName :  $("#lastName").val(),
                gender : $("#gender").val(),
    		department :  $("#department").val(),
                jobPosition : $("#jobPosition").val(),
    		email :  $("#email").val(),
                mobilePhone : $("#mobilePhone").val(),
    		officePhone :  $("#officePhone").val()
    	};
         var url = $(this).attr('action');
         $('#contactsForm #save-con').prop('disabled', true); 
         $.ajax({      
            type : "POST",
            url : url,
            data : JSON.stringify(data),
            contentType : "application/json",
            success: function (result) {
                $('#contactsForm #save-con').prop('disabled', false); 
               toastr["success"]("Contact Saved Successfully", "Notification");
                var tr = $('<tr/>'); 
                tr.append($("<td/>", {
                  text: result.data.id
                })).append($("<td/>", {
                    text: data.firstName
                })).append($("<td/>", {
                    text: data.lastName
                })).append($("<td/>", {
                    text: data.jobPosition
                })).append($("<td/>", {
                    text: data.department
                })).append($("<td/>", {
                    text: data.email
                })).append($("<td/>", {
                    text: data.mobilePhone
                })).append($("<td/>", {
                    text: data.officePhone
                }));
                 $('#conDetails').append(tr);
                 $("#firstName").val('');
    		 $("#lastName").val('');
                 $("#gender").val('');
    		 $("#department").val('');
                 $("#jobPosition").val('');
    		 $("#email").val('');
                 $("#mobilePhone").val('');
    	         $("#officePhone").val('');
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown+jqXHR+textStatus);
                toastr["error"]("Error, Contact Not Saved!!!", "Notification");
            }
        });
        
 });
 $(document).on('click', '#getProcs', function(e){
       e.preventDefault();
       var link = $(this).data('link');
        var cname = $(this).data('cname');
         
         $('#companyname').replaceWith('<div id="companyname" class="text-center"><h3>'+cname+'</h3>');
       // $('#companyname').append("<h3>"+cname+"</h3>");
        console.log(cname);
       $.get(link, function(result){
            console.log(result);
            if(result.data===null){
                console.log("hakuna chinhu");
                $('ul.docs').replaceWith('<center><ul class="docs list-group z-depth-0"></u></center>');
                $('ul.docs').append('<li class="list-group-item justify-content-between">No Documents Required<br><i class="fa fa-close fa-3x mb-3 red-text animated rotateIn"></i></li>');
            }
            else{
                $('ul.docs').replaceWith('<ul class="docs list-group z-depth-0"></u>');
                if(result.data.applicationLetter===null){
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Application Letter&nbsp;<i class="fa fa-close fa-1x red-text animated rotateIn"></i></h5></li>');
                }
                 else{
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Application Letter&nbsp;<i class="fa fa-check fa-1x animated rotateIn"></i></h5></li>');
                }
                 if(result.data.certOfIncorporation===null){
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Certification Of Incorportion&nbsp;<i class="fa fa-close fa-1x red-text animated rotateIn"></i></h5></li>');
                }
                 else{
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Certification Of Incorportion&nbsp;<i class="fa fa-check fa-1x animated rotateIn"></i></h5></li>');
                }
                if(result.data.companyProfile===null){
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Company Profile&nbsp;<i class="fa fa-close fa-1x red-text animated rotateIn"></i></h5></li>');
                }
                 else{
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Company Profile&nbsp;<i class="fa fa-check fa-1x animated rotateIn"></i></h5></li>');
                }
                 if(result.data.crFourteen===null){
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>CR-14&nbsp;<i class="fa fa-close fa-1x red-text animated rotateIn"></i></h5></li>');
                }
                 else{
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>CR-14&nbsp;<i class="fa fa-check fa-1x animated rotateIn"></i></h5></li>');
                }
                if(result.data.itf===null){
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>ITF 263 Tax Clearance Cerficate&nbsp;<i class="fa fa-close fa-1x red-text animated rotateIn"></i></h5></li>');
                }
                 else{
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>ITF 263 Tax Clearance Cerficate&nbsp;<i class="fa fa-check fa-1x animated rotateIn"></i></h5></li>');
                }
                 if(result.data.mou===null){
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Memorundum Of Association&nbsp;<i class="fa fa-close fa-1x red-text animated rotateIn"></i></h5></li>');
                }
                 else{
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Memorundum Of Association&nbsp;<i class="fa fa-check fa-1x animated rotateIn"></i></h5></li>');
                }
                  if(result.data.vat===null){
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Vat Registration Certificate&nbsp;<i class="fa fa-close fa-1x red-text animated rotateIn"></i></h5></li>');
                }
                 else{
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Vat Registration Certificate&nbsp;<i class="fa fa-check fa-1x animated rotateIn"></i></h5></li>');
                }
                if(result.data.tradeLicense===null){
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Trade License&nbsp;<i class="fa fa-close fa-1x red-text animated rotateIn"></i></h5></li>');
                }
                 else{
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Trade License&nbsp;<i class="fa fa-check fa-1x animated rotateIn"></i></h5></li>');
                }
                if(result.data.traceableReference===null){
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Traceable Reference&nbsp;<i class="fa fa-close fa-1x red-text animated rotateIn"></i></h5></li>');
                }
                 else{
                    $('ul.docs').append('<li class="list-group-item justify-content-between"><h5>Traceable Reference&nbsp;<i class="fa fa-check fa-1x animated rotateIn"></i></h5></li>');
                }
            }
        });
   });
});
