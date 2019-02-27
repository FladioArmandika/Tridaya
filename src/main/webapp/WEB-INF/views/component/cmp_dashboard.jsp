<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<div class="row">
	<div class="col s6 m6">
		<div class="row">
			  <div class="col s4 m4">
			  	<a href="${pageContext.request.contextPath}/siswa">          
				    <div class="card">    
				      <div class="card-content">
				        <span class="">SISWA</span><br>   
				        <hr>
				      </div>
				      <div class="card-content">
				      	<div class="row">
				      		<div class="col s12" style="text-align: left !important;">  
				      			<span >SD</span><span class="badge ">${jumSiswaSD}</span>         
				      		</div>
				      		<div class="col s12" style="text-align: left !important;"> 
				      			<span>SMP</span><span class="badge ">${jumSiswaSMP}</span>     
				      		</div> 
				      		<div class="col s12" style="text-align: left !important;"> 
				      			<span>SMA</span><span class="badge ">${jumSiswaSMA}</span>            
				      		</div> 
				      	</div>
				      </div>
				    </div>
			    </a> 
			  </div>
			  <div class="col s4 m4">  
			  	<a href="${pageContext.request.contextPath}/pengajar">       
				    <div class="card">    
				      <div class="card-content">
				        <span class="">PENGAJAR</span> <br> 
				        <hr>  
				      </div>
				      <div class="card-content">  
				      	<div class="row">
				      		<div class="col s12" style="text-align: left !important;">  
				      			<span >Jumlah</span><span class="badge ">${jumPengajar}</span>        
				      		</div> 
				      		<div class="col s12" style="text-align: left !important;">  
				      			<span >Aktif</span><span class="badge ">${jumPengajarAktif}</span>          
				      		</div> 
				      		<div class="col s12" style="text-align: left !important;">  
				      			<span ><br></span><span class="badge "> </span> 
 				      		</div>  
				      	</div>
				      </div>
				    </div>
				</a>
			  </div>
			  <div class="col s4 m4">       
			  	<a href="${pageContext.request.contextPath}/petugas">          
				    <div class="card">    
				      <div class="card-content">
				        <span class="">PETUGAS</span> <br>      
				        <hr>
				      </div>
				      <div class="card-content">
				      	<div class="row">
				      		<div class="col s12" style="text-align: left !important;">  
				      			<span >Jumlah</span><span class="badge ">${jumPetugas}</span>          
				      		</div> 
				      		<div class="col s12" style="text-align: left !important;">  
				      			<span class="row"> </span><span class="badge "> </span>           
				      		</div> 
				      		<div class="col s12" style="text-align: left !important;">  
				      			<span class=""> </span><span class="badge "> </span>          
				      		</div> 
				      	</div>  
				      </div>
				    </div>
				</a> 
			  </div>
			</div>
			
			<!--GRAF-->
			<div class="row">
				<div class="col s12 m12">
					<div class="card">  
						<div class="card-content">
							<span class="card-title cmp-title">CARI RUANGAN</span>        
							<form:form class="row" action="${pageContext.request.contextPath}/ruangan/cari" modelAttribute="Pembelajaran" method="GET">        	
							<div class="row">
								<div class="col s8 m8" style="padding-left: 30px !important">      
									<input type="date" class="" name="tanggal">  
								</div>
								<div class="col s4 m4">   
									<button class="btn waves-effect lighten-3" type="submit" name="action" style="margin-top:0px !important">Tambah              
									</button>   
								</div> 
							</div> 
							</form:form> 
						</div> 
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col s12 m12">
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
					        <tbody style="overflow-y:scroll;max-height:75px !important; ">                
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
			</div>
	</div>
	<div class="col s6 m6">
		<div class="row">
			<div class="col s12 m12">
				<div class="card">  
					<div class="card-content">
					 	<span class="card-title cmp-title">KELAS</span> <br>   
				        <table class="striped">               
					        <thead>
					          <tr>  
					              <th>TANGGAL</th> 
					              <th>MATPEL</th>
					              <th>PENGAJAR</th>  
					              <th>RUANGAN<th>   
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
										<a href="${pageContext.request.contextPath}/kelas/${kelas.id}" class="btn" style="padding-left:5px !important;padding-right: 5px;"><i class="material-icons">account_circle</i></a>    	                                
										<a href="${pageContext.request.contextPath}/kelas/hapus/${kelas.id}" class="btn" style="padding-left:5px !important;padding-right: 5px;"><i class="material-icons md-18" style="font-size: 21px">delete</i></a>         
									</td>
						          </tr>   
					        </c:forEach>  
				      	</table>
					</div>
				</div>   
			</div>
		</div>
	</div>
</div>
