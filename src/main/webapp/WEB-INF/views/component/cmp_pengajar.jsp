<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
  <div class="col s12 m12">    
    <div class="card">    
      <div class="card-content">
        <span class="card-title cmp-title">PENGAJAR</span> <br> 
        <div class="card-action" style="text-align: left;">
          <p><a class="waves-effect waves-light btn bt-tambah yellow darken-1" href="pengajar/tambah">Tambah</a></p>     
        </div>
         
        <table class="striped"> 
	        <thead>
	          <tr>  
	              <th>ID</th>
	              <th>NAMA</th>
	              <th>NO HP</th>
	              <th>EMAIL</th>
	              <th>ACTION</th>  
	          </tr>
	        </thead>
	
	        <tbody style="overflow-y:scroll;height: 355px !important;">  
	        <c:forEach var="pengajar" items="${pengajar}">
	        	  <tr>
		            <td>${pengajar.id}</td>
		            <td>${pengajar.nama}</td>
		            <td>${pengajar.noHp}</td> 
		            <td>${pengajar.email}</td> 
		            <td>
						<a href="${pageContext.request.contextPath}/pengajar/${pengajar.id}"><i class="material-icons md-18" style="font-size: 21px">pageview</i></a>                 
						<a href="${pageContext.request.contextPath}/pengajar/edit/${pengajar.id}"><i class="material-icons md-18" style="font-size: 21px">edit</i></a>  
						<a href="${pageContext.request.contextPath}/pengajar/hapus/${pengajar.id}"><i class="material-icons md-18" style="font-size: 21px">delete</i></a>   
					</td>
		          </tr>
	        </c:forEach>
      	</table>
      	<br>
      </div>
      
    </div>
  </div>
</div>