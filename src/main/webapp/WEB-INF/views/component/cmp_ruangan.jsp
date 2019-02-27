<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col s5 m5">      
		<div class="card" >                             
			<div class="card-content">     
        		<span class="card-title cmp-title">RUANGAN ${tanggalJadwal}</span> <br>   
        		<table class="striped">   
        			<thead>
        				<tr>
        					<th>ID</th>
        					<th>NAMA</th>
        					<th>GEDUNG</th>
        					<th>LANTAI</th>
        					<th></th> 
        				</tr>
        			</thead>
        			<tbody style="overflow-y:scroll;height: 355px !important;">
        				<c:forEach var="ruangan" items="${ruangan}">
				        	<tr> 
					            <td>${ruangan.id}</td>
					            <td>${ruangan.nama}</td> 
					            <td style="text-align: center">${ruangan.gedung}</td>
					            <td style="text-align: center">${ruangan.lantai}</td> 
					            <td> 
					            	<a href="${pageContext.request.contextPath}/ruangan/${ruangan.id}" class="btn" style="padding-left:5px !important;padding-right: 5px;">
					            		<i class="material-icons md-18" style="font-size: 21px">event</i>         
					            	</a>    	                                
								</td> 
							</tr>
				        </c:forEach>
        			</tbody>
        		</table>
        	</div>
        </div>
	</div>
	<div class="col s7 m7">
		<div class="card">
			<div class="card-content"> 	
				<div class="row">
					<span class="cmp-title">DETAIL RUANGAN</span>  
				</div>
				<div class="row" style="text-align: left !important">   	
					<div class="col s6 m6">
						<div class="row">
							<div class="col s6 m6">NAMA</div>
							<div class="col s6 m6">${ruanganselected.nama}</div>
						</div>
						<div class="row">
							<div class="col s6 m6">GEDUNG</div>
							<div class="col s6 m6">${ruanganselected.gedung}</div>
						</div>
						<div class="row">
							<div class="col s6 m6">NAMA</div>
							<div class="col s6 m6">${ruanganselected.lantai}</div>   
						</div>
					</div>
					<div class="col s6 m6">
						
					</div> 
				</div>
				<div class="row">
					<span class="cmp-title">Jadwal</span>  
				</div> 
				<table>
        			<thead>
        				<tr>
	        				<th>TGL</th>
	        				<th>MATA PELAJARAN</th>
	        				<th>PENGAJAR</th>
	        				<th>
	        				
	        				</th>
        				<tr>  
        			</thead> 
        			<tbody style="overflow-y:scroll;height: 150px !important;">   
        			<c:forEach var="kelasselected" items="${kelasselected}">
        				<tr>
        					<td>${kelasselected.tanggal}</td>
        					<td>${kelasselected.mataPelajaran.getNamaMataPelajaran()}</td>
        					<td>${kelasselected.pengajar.getNama()}</td>
							<td>   
								<a href="${pageContext.request.contextPath}/kelas/${kelasselected.id}" class="btn" style="padding-left:5px !important;padding-right: 5px;">
				            		<i class="material-icons md-18" style="font-size: 21px">pageview</i> 
				            	</a> 		 			
        					</td>  
        				</tr>
        			</c:forEach>
        			</tbody>
        		</table>
			</div>
		</div>
	</div>
</div>