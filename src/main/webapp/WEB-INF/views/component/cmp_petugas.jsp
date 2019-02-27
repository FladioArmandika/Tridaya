<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
  <div class="col s12 m12">    
    <div class="card">    
      <div class="card-content">
        <span class="card-title cmp-title">PETUGAS</span> <br>  
        <div class="card-action" style="text-align: left;">   
          <p><a class="waves-effect waves-light btn bt-tambah yellow darken-1" href="petugas/tambah">Tambah</a></p>          
        </div>
        <table class="striped"> 
	        <thead>
	          <tr>  
	              <th>ID</th>
	              <th>NAMA</th>
	              <th>JABATAN</th> 
	              <th>TUGAS</th>  
	              <th></th>  
	          </tr>
	        </thead>
	        <tbody style="overflow-y:scroll;height: 355px !important;">
	        <c:forEach var="petugas" items="${ petugas}">
	        	  <tr> 
		            <td>${petugas.id}</td>
		            <td>${petugas.nama}</td>  
		            <td>${petugas.jabatan}</td> 
		            <td>${petugas.tugas}</td> 
		            <td>
						<a href="${pageContext.request.contextPath}/petugas/${petugas.id}"><i class="material-icons md-18" style="font-size: 21px">pageview</i></a>                 
						<a href="${pageContext.request.contextPath}/petugas/edit/${petugas.id}"><i class="material-icons md-18" style="font-size: 21px">edit</i></a>  
						<a href="${pageContext.request.contextPath}/petugas/hapus/${petugas.id}"><i class="material-icons md-18" style="font-size: 21px">delete</i></a>   
					</td>
		          </tr>
	        </c:forEach>
      	</table>
      	<br>
      </div>
      
    </div> 
  </div>
</div>