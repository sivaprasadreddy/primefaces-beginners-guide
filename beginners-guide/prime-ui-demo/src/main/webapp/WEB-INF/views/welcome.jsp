<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
	
	<link type="text/css" href='<spring:url value="/resources/jquery/css/aristo/aristo.css"/>' rel="stylesheet" />	
	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.7.2.min.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.21.custom.min.js"/>'></script>
	<!-- 
	<link type="text/css" href='<spring:url value="/resources/jquery/css/redmond/jquery-ui-1.8.21.custom.css"/>' rel="stylesheet" />	
	
	
	<link rel="stylesheet" href="%PATH%/jquery-ui.css" />  
	<link rel="stylesheet" href="%PATH%/theme.css" />  
	<link rel="stylesheet" href="%PATH%/prime-ui-min.css" />  
	<script type="text/javascript" src="%PATH%/jquery.js"></script>  
	<script type="text/javascript" src="%PATH%/jquery-ui.js"></script>  
	<script type="text/javascript" src="%PATH%/prime-ui.js"></script>
	 -->
	 
	<link rel="stylesheet" href="resources/primeui/prime-ui-0.9.5.css" />  
	<script type="text/javascript" src="resources/primeui/prime-ui-0.9.5.js"></script>
	
	<link type="text/css" href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />
	
	<script>
	$(function() {
		//alert('jQuery Initialized successfully');
		//$('#default').puiaccordion();  

		$('#tbllocal').puidatatable({  
            caption: 'Local Datasource',  
            paginator: {  
                rows: 5  
            },  
            columns: [  
                {field:'vin', headerText: 'Vin', sortable:true},  
                {field:'brand', headerText: 'Brand', sortable:true},  
                {field:'year', headerText: 'Year', sortable:true},  
                {field:'color', headerText: 'Color', sortable:true}  
            ],  
            datasource: [  
                {'brand':'Volkswagen','year': 2012, 'color':'White', 'vin':'dsad231ff'},  
                {'brand':'Audi','year': 2011, 'color':'Black', 'vin':'gwregre345'},  
                {'brand':'Renault','year': 2005, 'color':'Gray', 'vin':'h354htr'},  
                {'brand':'Bmw','year': 2003, 'color':'Blue', 'vin':'j6w54qgh'},  
                {'brand':'Mercedes','year': 1995, 'color':'White', 'vin':'hrtwy34'},  
                {'brand':'Opel','year': 2005, 'color':'Black', 'vin':'jejtyj'},  
                {'brand':'Honda','year': 2012, 'color':'Yellow', 'vin':'g43gr'},  
                {'brand':'Chevrolet','year': 2013, 'color':'White', 'vin':'greg34'},  
                {'brand':'Opel','year': 2000, 'color':'Black', 'vin':'h54hw5'},  
                {'brand':'Mazda','year': 2013, 'color':'Red', 'vin':'245t2s'}  
            ],  
            selectionMode: 'single',  
            rowSelect: function(event, data) {  
                $('#messages').puigrowl('show', [{severity:'info', summary: 'Row Selected', detail: (data.brand + ' ' + data.vin)}]);  
            },  
            rowUnselect: function(event, data) {  
                $('#messages').puigrowl('show', [{severity:'info', summary: 'Row Unselected', detail: (data.brand + ' ' + data.vin)}]);  
            }  
        });  

  		/*
        $('#tblremote').puidatatable({  
            caption: 'Remote Restful Webservice',  
            paginator: {  
                rows: 5  
            },  
            columns: [  
                {field:'vin', headerText: 'Vin', sortable:true},  
                {field:'brand', headerText: 'Brand', sortable:true},  
                {field:'year', headerText: 'Year', sortable:true},  
                {field:'color', headerText: 'Color', sortable:true}  
            ],  
            datasource: function(callback) {  
                $.ajax({  
                    type: "GET",  
                    url: 'rest/cars/list',  
                    dataType: "json",  
                    context: this,  
                    success: function(response) {  
                        callback.call(this, response);  
                    }  
                });  
            },  
            selectionMode: 'multiple',  
            rowSelect: function(event, data) {  
                $('#messages').puigrowl('show', [{severity:'info', summary: 'Row Selected', detail: (data.brand + ' ' + data.vin)}]);  
            },  
            rowUnselect: function(event, data) {  
                $('#messages').puigrowl('show', [{severity:'info', summary: 'Row Unselected', detail: (data.brand + ' ' + data.vin)}]);  
            }  
        }); 
        */ 
  
        $('#messages').puigrowl(); 
        
	});
	</script>
</head>

<body>
	<div id="default">  
    <h3>Title 1</h3>  
    <div>  
        Content 1  
    </div>    
  
    <h3>Title 2</h3>  
    <div>  
        Content 2  
    </div>    
  
    <h3>Title 3</h3>  
    <div>  
        Content 3  
    </div>    
    
    </div>
    
    <div id="messages"></div>  
                              
<div id="tbllocal"></div>  
  
<div id="tblremote"></div>  


</body>

</html>