<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col s7 m7">        
		<div class="card" style="height: 545px !important;">                                
			<a href="${pageContext.request.contextPath}/kelas"><i class="material-icons" style="padding: 20px 0px 20px 10px !important">keyboard_backspace</i></a>                          
			<span class="card-title cmp-title" style="margin-left: 20px;">ABSENS KELAS</span>    
			<div class="card-content" style="text-align: left !important;"> 
				 <table class="striped"> 
			        <thead>
			          <tr>  
			              <th>ID</th>
			              <th>NAMA</th>
			              <th>SEKOLAH</th>  
			              <th>ACTION</th>  
			          </tr>
			        </thead>
			
			        <tbody style="overflow-y:scroll;">  
			        <c:forEach var="siswa" items="${siswa}">
			        	  <tr>
				            <td>${siswa.id}</td>
				            <td>${siswa.nama}</td>
				            <td>${siswa.asalSekolah}</td> 
				            <td>
								<a href="${pageContext.request.contextPath}/siswa/${siswa.id}"><i class="material-icons md-18" style="font-size: 21px">pageview</i></a>                 
								<a href="${pageContext.request.contextPath}/kelas/${idKelas}/hapus/${siswa.id}"><i class="material-icons md-18" style="font-size: 21px">delete</i></a>   
							</td>
				          </tr>
			        </c:forEach>
		      	</table>
			</div>
		</div>
	</div>
	<div class="col s5 m5">         
		<div class="card">     
			<div class="card-content" style="text-align: left !important;"> 
				<div class="row" style="text-align: left !important">  
					<div class="col s12">  
						<div class="col s12 row-view">
							<div class="col s5 label-view">Mata Pelajaran</div>
							<div class="col s7">${kelas.mataPelajaran.getNamaMataPelajaran()}</div>  
						</div>
						<div class="col s12 row-view">
							<div class="col s5 label-view">Pengajar</div>
							<div class="col s7">${kelas.pengajar.getNama()}</div>   
						</div>
						<div class="col s12 row-view">
							<div class="col s5 label-view">Ruangan</div>
							<div class="col s7">${kelas.ruangan.getNama()} ${kelas.ruangan.getGedung()} lt ${kelas.ruangan.getLantai()}</div>       
						</div> 
						<div class="col s12 row-view">
							<div class="col s5 label-view">Tanggal</div>
							<div class="col s7">${kelas.tanggal}</div>  
						</div>
						<div class="col s12 row-view">
							<div class="col s5 label-view">Keterangan</div>
							<div class="col s7">${kelas.keterangan}</div>  
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card" style="height: 300px !important;">                  
			<div class="card-content">             
				Tambah Siswa
				<form:form action="${pageContext.request.contextPath}/kelas/${kelas.id}/tambah/" modelAttribute="AbsenRecord" method="POST">       	
				<div class="row">   
					<div class="col s8 input-field" >   
						<input type="hidden" name="idPembelajaran" value="${kelas.id}">    
			        	<select class="browser-default" name="idSiswa">                                     
			        		<option value="" class="disabled" disabled selected></option>
							<c:forEach var="siswaavail" items="${siswaavail}">  
					     		<option value="${siswaavail.id}">${siswaavail.nama}</option>                   
							</c:forEach>
					    </select> 
					</div>
					<div class="col s4">   
						<button class="btn waves-effect lighten-3" type="submit" name="action" style="margin-top:20px !important">Tambah      
						</button>        
					</div>
				</div>
				</form:form> 
			</div>
		</div>
	</div>
</div>

           