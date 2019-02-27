<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page session="true"%>
     
    
   
 <!-- START FOOTER -->
    
    <!-- END FOOTER -->
    <!-- ================================================
    Scripts
    ================================================ -->
    
    <!-- jQuery Library -->
    <script src="<c:url value='/resources/js/jQuery.js'/>"></script>   
    <!--materialize js-->
    <script src="<c:url value='/resources/js/materialize.js'/>"></script> 
    <!--scrollbar-->
    <script src="<c:url value='/resources/js/plugin/perfect-scrollbar.min.js'/>"></script>
    <!-- chartjs -->
    <script type="text/javascript" src="../../vendors/chartjs/chart.min.js"></script>
    <!-- sparkline -->
    <script src="<c:url value='/resources/js/jquery.sparkline.min.js'/>"></script>
    <!--jvectormap-->
    <script src="<c:url value='/resources/js/plugin/jquery-jvectormap-1.2.2.min.js'/>"></script>
    <script src="<c:url value='/resources/js/plugin/jquery-jvectormap-world-mill-en.js'/>"></script>
    <script src="<c:url value='/resources/js/plugin/vectormap-script.js'/>"></script>  
    <!--plugins.js - Some Specific JS codes for Plugin Settings-->
    <script src="<c:url value='/resources/js/plugin.js'/>"></script> 
    <!--card-advanced.js - Page specific JS-->
    <script type="text/javascript" src="../../js/scripts/dashboard-analytics.js"></script>
    <!--custom-script.js - Add your own theme custom JS-->
    <script type="text/javascript" src="../../js/custom-script.js"></script>
    
    <script type="text/javascript">   
	    $(document).ready(function() {
	        $('select').material_select();
	     });
    </script>
    
  </body>
</html>