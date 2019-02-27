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
      	<a class="waves-effect waves-light grey btn lighten-1" href="${pageContext.request.contextPath}/petugas" style="float: left;"><</a>       
        <span class="card-title cmp-title">TAMBAH PETUGAS</span> <br>  
        
      	<div class="row" style="text-align: left !important;">   
      		<c:choose>
				<c:when test="${editform == 'true'}">
    				<form:form class="row" action="${pageContext.request.contextPath}/petugas/update/${editmodel.id}" modelAttribute="pengajar" method="POST">     	
						<div class="col s7">       
			    			<div class="row"> 
						        <div class="input-field col s10">
						          <input  type="text" class="validate" name="nama" value="${editmodel.nama}" >   
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
						          <input  type="text" class="validate" name="jabatan" value="${editmodel.jabatan}">  
						          <label>Jabatan</label>
						    	</div>
							</div>
							<div class="row"> 
						        <div class="input-field col s10">
						          <input  type="text" class="validate" name="tugas" value="${editmodel.tugas}">  
						          <label>Tugas</label>
						    	</div>
							</div>
						</div> 
						<div class="col s5">    
							<div class="row"> 
						        <div class="input-field col s12">     
						          <textarea type="text" class="validate materialize-textarea" name="alamat">${editmodel.alamat}</textarea>   
						          <label>Alamat</label>    
						    	</div>
							</div>	 
							<br>
							<br>  
							<button class="btn waves-effect grey lighten-1" type="reset" name="action">Clear   
							</button> 
							<button class="btn waves-effect lighten-3" type="submit" name="action">Submit
								<i class="material-icons right">send</i>    
							</button>   
						</div>
					</form:form>
				</c:when>
				<c:otherwise>
					<form:form class="row" action="${pageContext.request.contextPath}/petugas/tambah" modelAttribute="siswa" method="POST">     	
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
						          <input  type="text" class="validate" name="jabatan" value="${editmodel.jabatan}">  
						          <label>Jabatan</label>
						    	</div>
							</div>
							<div class="row"> 
						        <div class="input-field col s10">
						          <input  type="text" class="validate" name="tugas" value="${editmodel.tugas}">  
						          <label>Tugas</label>
						    	</div>
							</div> 
						</div> 
						<div class="col s5">    
							<div class="row"> 
						        <div class="input-field col s12">     
						          <textarea type="text" class="validate materialize-textarea" name="alamat"></textarea>   
						          <label>Alamat</label>    
						    	</div>
							</div>	 
							<br>
							<br>  
							<button class="btn waves-effect grey lighten-1" type="reset" name="action">Clear   
							</button> 
							<button class="btn waves-effect lighten-3" type="submit" name="action">Submit
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