<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>      
 	$(document).ready(function() {
 	    $('select').material_select();
 	}); 
</script>

<div class="row">
  <div class="col s12 m12">    
    <div class="card">    
      <div class="card-content" style="padding:50px 150px 50px 150px;">     
        <span class="card-title cmp-title">TAMBAH SISWA</span> <br>  
        
      	<div class="row" style="text-align: left !important;">   
      		<c:choose>
				<c:when test="${editform == 'true'}">
    				<form:form class="row" action="${pageContext.request.contextPath}/siswa/update/${editmodel.id}" modelAttribute="siswa" method="POST">     	
						<div class="col s7">       
			    			<div class="row"> 
						        <div class="input-field col s10">
						          <input  type="text" class="validate" name="nama" value="${editmodel.nama}">  
						          <label>Nama</label>
						    	</div>
							</div>
							<div class="row">
								<div class="input-field col s10">       
						        	<select name="jenisKelamin" >          
						        		<option value="" class="disabled" disabled selected>Jenis Kelamin</option>
						        		<option value="L">Laki-Laki</option>  
										<option value="P">Perempuan</option> 				        		  
								    </select>     
						    	</div> 
							</div>
							<div class="row">
						        <div class="input-field col s10">   
						          <input type="date" class="" name="tgl_lahir" value="${editmodel.tgl_lahir}">  
						          <label>Tanggal Lahir</label>    
						    	</div>
							</div>
							
							<div class="row">
						        <div class="input-field col s10"> 
						          <input  type="text" class="validate" name="asalSekolah" value="${editmodel.asalSekolah}"> 
						          <label>Asal Sekolah</label>
						    	</div>
							</div>
							<div class="row">
						        <div class="input-field col s6"> 
						          <input  type="email" class="validate" name="email" value="${editmodel.email}"> 
						          <label>Email</label>
						    	</div> 
						    	<div class="input-field col s4">  
						          <input  type="text" class="validate" name="noHp" value="${editmodel.noHp}"> 
						          <label>No Hp</label>
						    	</div>
							</div> 
						</div> 
						<div class="col s5">    
							<div class="row">
						        <div class="input-field col s12">   
						          <input  type="text" class="validate" name="namaOrtu" value="${editmodel.namaOrtu}"> 
						          <label>Nama Orang Tua</label> 
						    	</div>
							</div>
							<div class="row"> 
						        <div class="input-field col s12">     
						          <textarea type="text" class="validate materialize-textarea" name="alamat">${editmodel.alamat}</textarea>   
						          <label>Alamat</label>    
						    	</div>
							</div>	 
							<div class="row"> 
						        <div class="input-field col s12">  
						        	<select name="idProgram">              
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
							<br>
							<br>  
							<button class="btn waves-effect grey lighten-1" type="reset" name="action">Clear   
							</button> 
							<button class="btn waves-effect yellow darken-1" type="submit" name="action">Submit 
								<i class="material-icons right">send</i>    
							</button>   
						</div>
					</form:form>
				</c:when>
				<c:otherwise>
					<form:form class="row" action="${pageContext.request.contextPath}/siswa/tambah" modelAttribute="siswa" method="POST">     	
						<div class="col s7">       
			    			<div class="row"> 
						        <div class="input-field col s10">
						          <input  type="text" class="validate" name="nama"> 
						          <label>Nama</label>
						    	</div>
							</div>
							<div class="row">
								<div class="input-field col s10">       
						        	<select name="jenisKelamin" >          
						        		<option value="" class="disabled" disabled selected>Jenis Kelamin</option>
						        		<option value="L">Laki-Laki</option>  
										<option value="P">Perempuan</option> 				        		  
								    </select>     
						    	</div> 
							</div>
							<div class="row">
						        <div class="input-field col s10">
									<label>tanggal lahir</label>    
						          	<input type="date" class="" name="tgl_lahir" style="margin-top:25px;">      
						    	</div>
							</div>
							<div class="row">
						        <div class="input-field col s10"> 
						          <input  type="text" class="validate" name="asalSekolah"> 
						          <label>Asal Sekolah</label>
						    	</div>
							</div>
							<div class="row">
						        <div class="input-field col s6"> 
						          <input  type="email" class="validate" name="email"> 
						          <label>Email</label>
						    	</div> 
						    	<div class="input-field col s4">  
						          <input  type="text" class="validate" name="noHp"> 
						          <label>No Hp</label>
						    	</div>
							</div> 
						</div> 
						<div class="col s5">    
							<div class="row">
						        <div class="input-field col s12">   
						          <input  type="text" class="validate" name="namaOrtu"> 
						          <label>Nama Orang Tua</label> 
						    	</div>
							</div>
							<div class="row"> 
						        <div class="input-field col s12">     
						          <textarea type="text" class="validate materialize-textarea" name="alamat"></textarea>   
						          <label>Alamat</label>    
						    	</div>
							</div>	 
							<div class="row"> 
						        <div class="input-field col s12">  
						        	<select name="idProgram">              
						        		<option value="" disabled selected>Pilih Program</option>  
								      <c:forEach var="program" items="${program}">  
								     	 <option value="${program.id}">${program.nama} ${program.tingkat}</option>  
								      </c:forEach>      
								    </select> 
						    	</div>
							</div> 
							<br>
							<br>  
							<button class="btn waves-effect grey lighten-1" type="reset" name="action">Clear   
							</button> 
							<button class="btn waves-effect yellow darken-1" type="submit" name="action">Submit
								<i class="material-icons right">send</i>    
							</button>   
						</div>
					</form:form>
				</c:otherwise>
			</c:choose>
    	</div>
       
       	
       
      </div>
    </div>
  </div>
</div>