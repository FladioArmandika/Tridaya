<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page session="true"%>
    
<jsp:include page="template/header.jsp"></jsp:include>

<!-- START MAIN -->
    <div id="main">
      <!-- START WRAPPER -->  
      <div class="wrapper">
        <!-- START LEFT SIDEBAR NAV-->
        <aside id="left-sidebar-nav"> 
          <ul id="slide-out" class="side-nav fixed leftside-navigation" >      
            <li class="no-padding" >         
              <ul class="collapsible" data-collapsible="accordion"> 
                <li class="bold">  
                  <a href="${pageContext.request.contextPath}/home" class="waves-effect waves-cyan">
                    <i class="material-icons" style="font-size: 25px !important;">dashboard</i> 
                    <span class="nav-text" style="font-size: 18px !important;">Dashboard</span>
                  </a>
                </li>  
                <li class="bold">
                  <a href="${pageContext.request.contextPath}/siswa" class="waves-effect waves-cyan">    
                    <i class="material-icons" style="font-size: 25px !important;">school</i>  
                    <span class="nav-text" style="font-size: 18px !important;">Siswa</span>  
                  </a>
                </li> 
                <li class="bold">
                  <a class="collapsible-header waves-effect waves-cyan">
                    <i class="material-icons" style="font-size: 25px !important;">people</i>
                    <span class="nav-text" style="font-size: 18px !important;">Staff</span>
                  </a>
                  <div class="collapsible-body">
                    <ul>
                      <li>
                        <a href="${pageContext.request.contextPath}/pengajar">
                          <i class="material-icons" style="font-size: 25px !important;">keyboard_arrow_right</i>
                          <span style="font-size: 18px !important;">Pengajar</span>
                        </a>
                      </li>
                      <li>
                        <a href="${pageContext.request.contextPath}/petugas">
                          <i class="material-icons" style="font-size: 25px !important;">keyboard_arrow_right</i>
                          <span style="font-size: 18px !important;">Petugas</span>
                        </a>
                      </li>
                    </ul>
                  </div>
                </li>
                <li class="bold">
                  <a href="${pageContext.request.contextPath}/kelas" class="waves-effect waves-cyan">
                    <i class="material-icons" style="font-size: 25px !important;">today</i>
                    <span class="nav-text" style="font-size: 18px !important;">Kelas</span>  
                  </a>
                </li>
                <li class="bold">
                  <a href="${pageContext.request.contextPath}/pembayaran" class="waves-effect waves-cyan">    
                    <i class="material-icons" style="font-size: 25px !important;">payment</i>         
                    <span class="nav-text" style="font-size: 18px !important;">Pembayaran</span>    
                  </a>
                </li>  
                <li class="bold">
                  <a href="${pageContext.request.contextPath}/ruangan" class="waves-effect waves-cyan">
                    <i class="material-icons" style="font-size: 25px !important;">room</i>
                    <span class="nav-text" style="font-size: 18px !important;">Ruangan</span>  
                  </a>
                </li> 
                <li class="bold">
                  <a href="${pageContext.request.contextPath}/settings" class="waves-effect waves-cyan">
                    <i class="material-icons" style="font-size: 25px !important;">settings</i> 
                    <span class="nav-text"style="font-size: 18px !important;">Settings</span> 
                  </a>
                </li>
                <li class="bold">
                  <a href="${pageContext.request.contextPath}/help" class="waves-effect waves-cyan">
                    <i class="material-icons" style="font-size: 25px !important;">help</i>
                    <span class="nav-text" style="font-size: 18px !important;">Help</span> 
                  </a>
                </li>
          	</ul>   
          	</li>
          </ul>  
          <a href="#" data-activates="slide-out" class="sidebar-collapse btn-floating btn-medium waves-effect waves-light hide-on-large-only">
            <i class="material-icons" style="font-size: 18px !important;">menu</i>
          </a>
        </aside>
        <!-- END LEFT SIDEBAR NAV-->
        <!-- //////////////////////////////////////////////////////////////////////////// -->

		<section id="content">
       		<!--start container-->
        	<div class="container">
            	<!--card stats start-->
            	<div id="card-stats" style="padding:20px">  
					   <jsp:include page="${componentUrl}" />
				</div>
			</div>
		</section>


	</div>
	</div>
	

<jsp:include page="template/footer.jsp"></jsp:include>