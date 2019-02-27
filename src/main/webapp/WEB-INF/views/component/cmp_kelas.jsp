<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
 <script>
  
  </script>
<div class="row">
  <div class="col s7 m7">           
    <div class="card" > 
      <div class="card-content">
        <span class="card-title cmp-title">KELAS</span> <br>   
        <table class="striped">               
	        <thead>
	          <tr>  
	              <th>Tanggal</th> 
	              <th>Mata Pelajaran</th>
	              <th>Pengajar</th>  
	              <th>Ruangan<th> 
	          </tr>
	        </thead>
	        <tbody style="overflow-y:scroll;max-height: ">  
	        <c:forEach var="kelas" items="${kelas}">
	        	  <tr style="font-size: 13px !important;">          
		            <td>${kelas.tanggal}</td>
		            <td>${kelas.mataPelajaran.getNamaMataPelajaran()}</td>
		            <td>${kelas.pengajar.getNama()}</td>
		            <td>${kelas.ruangan.getNama()} ${kelas.ruangan.getGedung()} lt ${kelas.ruangan.getLantai()}</td>      
		            <td>
						<a href="${pageContext.request.contextPath}/kelas/${kelas.id}" class="btn" style="padding-left:5px !important;padding-right: 5px;">absen</a> 	                                
						<a href="${pageContext.request.contextPath}/kelas/hapus/${kelas.id}" class="btn" style="padding-left:5px !important;padding-right: 5px;"><i class="material-icons md-18" style="font-size: 21px">delete</i></a>       
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
      	<form:form class="row" action="${pageContext.request.contextPath}/kelas/tambah" modelAttribute="Pembelajaran" method="POST">         	
			<div class="col s12">            
				<div class="row">    
			        <div class="input-field col s12">        
			        	<select   class="browser-default" style="max-height: 50px !important">                  
			        		<option value="" disabled selected>Pilih Program</option>  
					      <c:forEach var="program" items="${program}">    
					     	 <c:choose>  
					     	 	<c:when test="${editmodel.idProgram == program.id}" >
					     	 		<option value="${program.id}" selected>${program.nama} ${program.tingkat}</option>  
					     	 	</c:when>
					     	 	<c:otherwise>
					     	 		<option value="${program.id}">${program.nama} ${program.tingkat}</option>
					     	 	</c:otherwise>  
					     	 </c:choose>     
					      </c:forEach> 
					    </select>   
			    	</div>
				</div>  
				<div class="row"> 
			        <div class="input-field col s12">      
			        	<select name="idMatpel" class="browser-default">                 
			        		<option value="" disabled selected>Pilih Mata Pelajaran</option>  
					      <c:forEach var="matpel" items="${matpel}">  
			     	 		<option value="${matpel.id}">${matpel.namaMataPelajaran}</option>
					      </c:forEach>        
					    </select>   
			    	</div>
				</div>
				<div class="row" style="padding: 0 10px 0 0px !important">     
			        <div class="input-field col s12">       
			          <input name="tanggal" type="date" class="" name="browser-default" value="11/08/2012" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])/(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])/(?:30))|(?:(?:0[13578]|1[02])-31))" style="padding-left: 10px !important">                         
			    	</div>    
				</div> 
				<div class="row"> 
			        <div class="input-field col s12">      
			        	<select name="idPengajar" class="browser-default">                 
			        		<option value="" disabled selected>Pilih Pengajar</option>  
					      <c:forEach var="pengajar" items="${pengajar}">  
			     	 		<option value="${pengajar.id}">${pengajar.nama}</option>
					      </c:forEach>         
					    </select>   
			    	</div>
				</div>
				<div class="row"> 
			        <div class="input-field col s12">      
			        	<select name="idRuangan"  class="browser-default">              
			        		<option value="" disabled selected>Pilih Ruangan</option>  
					      <c:forEach var="ruangan" items="${ruangan}">  
					     	 <c:choose>
					     	 	<c:when test="${editmodel.idProgram == ruangan.id}" >
					     	 		<option value="${ruangan.id}" selected>${ruangan.nama}</option>  
					     	 	</c:when>
					     	 	<c:otherwise>
					     	 		<option value="${ruangan.id}">${ruangan.nama}</option>
					     	 	</c:otherwise>
					     	 </c:choose>    
					      </c:forEach>       
					    </select> 
			    	</div> 
				</div> 
				<br>
				<div class="row" style="text-align: right !important;padding-right: 10px !important;">     
					<button class="btn waves-effect grey lighten-1" type="reset" name="action">Clear   
					</button>   
					<button class="btn waves-effect lighten-3" type="submit" name="action">Submit
						<i class="material-icons right">send</i>    
					</button>   
				</div>
				<br>  
			</div>
		</form:form>
      </div>
  </div> 
</div>   
</div>     

