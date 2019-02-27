<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
 <script>
  
  </script>
<div class="row"> 
  <div class="col s7 m7">           
    <div class="card" >  
      <div class="card-content">
        <span class="card-title cmp-title">RIWAYAT PEMBAYARAN</span> <br>      
        <table class="striped">               
	        <thead>
	          <tr>  
	              <th>TANGGAL</th> 
	              <th>SISWA</th>   
	              <th>PROGRAM</th>  
	              <th>PETUGAS</th>  
	              <th>JUMLAH</th> 
	              <th></th>
	          </tr>
	        </thead>
	        <tbody style="overflow-y:scroll;max-height: ">  
	        <c:forEach var="pembayaran" items="${pembayaran}">
	        	  <tr style="font-size: 13px !important;">          
		            <td>${pembayaran.tanggal}</td>
		            <td>${pembayaran.siswa.getNama()}</td>
		            <td>${pembayaran.siswa.getProgram().getNama()} ${pembayaran.siswa.getProgram().getTingkat()}</td>
		            <td>${pembayaran.petugas.getNama()}</td> 
		            <td>${pembayaran.jumlahBayar}</td>
		            <td>
						<a href="${pageContext.request.contextPath}/pembayaran/hapus/${pembayaran.id}" class="btn" style="padding-left:5px !important;padding-right: 5px;"><i class="material-icons md-18" style="font-size: 21px">delete</i></a>       
					</td>
		          </tr>  
	        </c:forEach> 
      	</table>
      	<br> 
      </div>
    </div> 
  </div> 
  <div class="col s5 m5">    
  	<div class="card">     
      <div class="card-content"> 
      	<span class="card-title cmp-title">BUAT PEMBAYARAN</span>  
      	<form:form class="row" action="${pageContext.request.contextPath}/pembayaran/tambah" modelAttribute="Pembayaran" method="POST">         	
			<div class="col s12">            
				<div class="row"> 
			    	<div class="input-field col s12">       
			        	<select name="idSiswa" class="browser-default">
			        		<option value="" disabled selected>Pilih Siswa</option>
							<c:forEach var="siswa" items="${siswa}">  
		     	 				<option value="${siswa.id}">${siswa.nama}</option> 
							</c:forEach>        
				    	</select>
			    	</div>
				</div>
				<div class="row"> 
			    	<div class="input-field col s12">       
			        	<select name="idPetugas" class="browser-default"> 
			        		<option value="" disabled selected>Pilih Petugas</option>  
							<c:forEach var="petugas" items="${petugas}">  
		     	 				<option value="${petugas.id}">${petugas.nama}</option> 
							</c:forEach>         
				    	</select>
			    	</div>
				</div>
				<div class="row"> 
			    	<div class="input-field col s12" style="text-align: left !important">    
			    		<input  type="text" class="validate" name="jumlahBayar" style="padding: 0 10px 0 10px !important">           
						<label>Jumlah</label>        
			    	</div>  
				</div>
				<br>
				<button class="btn waves-effect lighten-3" type="submit" name="action">Submit
					<i class="material-icons right">send</i>    
				</button>   
			</div>
		</form:form>
      </div>
  </div> 
</div>   
</div>     

