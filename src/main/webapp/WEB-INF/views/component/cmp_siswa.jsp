<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
  <div class="col s12 m12">    
    <div class="card" >                             
      <div class="card-content">     
        <span class="card-title cmp-title">SISWA</span> <br> 
        <div class="card-action" style="text-align: left;"> 
          <p>
          	<a class="waves-effect waves-light btn bt-tambah yellow darken-1" href="siswa/tambah">Tambah</a>
			<input type="checkbox" class="filled-in" id="cb-sma" checked="checked" />
      		<label for="cb-sma" style="margin-right: 20px">SMA</label>    
      		<input type="checkbox" class="filled-in" id="cb-smp" checked="checked" />
      		<label for="cb-smp" style="margin-right: 20px">SMP</label>      
      		<input type="checkbox" class="filled-in" id="cb-sd" checked="checked" />
      		<label for="cb-sd" style="margin-right: 20px">SD</label>        	 
          </p>        
        </div> 
         
        <table class="striped">                
	        <thead>
	          <tr>  
	              <th>ID</th>
	              <th>NAMA</th>
	              <th>L/P</th>
	              <th>PROGRAM</th>
	              <th>SEKOLAH</th>
	              <th>ACTION</th>  
	          </tr>
	        </thead>
	
	        <tbody style="overflow-y:scroll;height: 355px !important;">                                  
	        <c:forEach var="siswa" items="${siswa}">
	        	  <tr>
		            <td>${siswa.id}</td>
		            <td>${siswa.nama}</td>
		            <td>${siswa.jenisKelamin}</td>
		            <td>${siswa.program.getNama()}</td> 
		            <td>${siswa.asalSekolah}</td> 
		            <td>
						<a href="${pageContext.request.contextPath}/siswa/${siswa.id}"><i class="material-icons md-18" style="font-size: 21px">pageview</i></a>                 
						<a href="${pageContext.request.contextPath}/siswa/edit/${siswa.id}"><i class="material-icons md-18" style="font-size: 21px">edit</i></a>  
						<a href="${pageContext.request.contextPath}/siswa/hapus/${siswa.id}"><i class="material-icons md-18" style="font-size: 21px">delete</i></a>   
					</td>
		          </tr>
	        </c:forEach>
	        </tbody> 
      	</table>
      	<br>
      </div>
      
    </div>
  </div>
</div>  