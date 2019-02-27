<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col s12 m12">    
		<div class="card">     
			<div class="card-content" style="text-align: left !important;"> 
				<a href="${pageContext.request.contextPath}/siswa"><i class="material-icons">keyboard_backspace</i></a>    
				<span class="card-title cmp-title" style="margin-left: 20px;">DATA SISWA</span> <br><br> 
				<div class="row" style="text-align: left !important">
					<div class="col s6">
						<div class="col s12 row-view">
							<div class="col s4 label-view">id</div>
							<div class="col s8">${siswa.id}</div>  
						</div>
						<div class="col s12 row-view">
							<div class="col s4 label-view">nama</div>
							<div class="col s8">${siswa.nama}</div>
						</div>
						<div class="col s12 row-view">
							<div class="col s4 label-view">jenis Kelamin</div>
							<div class="col s8">${siswa.jenisKelamin}</div>
						</div>
						<div class="col s12 row-view">
							<div class="col s4 label-view">Tgl Lahir</div>
							<div class="col s8">${siswa.tgl_lahir}</div>      
						</div>
						<div class="col s12 row-view">
							<div class="col s4 label-view">Asal Sekolah</div>
							<div class="col s8">${siswa.asalSekolah}</div>
						</div>
						<div class="col s12 row-view">
							<small style="padding-left:20px">kontak</small> 
							<div class="col s12">
								<div class="col s4 label-view">No HP</div>
								<div class="col s8">${siswa.noHp}</div>
							</div> 
							<div class="col s12">   
								<div class="col s4 label-view">email</div>
								<div class="col s8">${siswa.email}</div>
							</div>
						</div>
						<div class="col s12 row-view">
							<div class="col s4 label-view">alamat</div>
							<div class="col s8">${siswa.alamat}</div>
						</div> 
						<div class="col s12 row-view">
							<div class="col s4 label-view">Orang Tua</div>
							<div class="col s8">${siswa.namaOrtu}</div>     
						</div>   
					</div>
					<div class="col s6">
						<div class="col s12 row-view"> 
							<div class="col s4 label-view">Tipe</div>
							<div class="col s8">${siswa.program.getNama()}</div>
						</div> 
						<div class="col s12 row-view">   
							<div class="col s4 label-view">Tingkat</div>
							<div class="col s8">${siswa.program.getTingkat()}</div>
						</div>
						<div class="col s12 row-view">  
							<div class="col s4 label-view">Tgl Masuk</div>
							<div class="col s8">${siswa.tgl_masuk}</div>  
						</div>
						<!--Tabel Pembayaran-->
						<div class="col s12 row-view"> 
							<div class="col s4">History Pembayaran</div> 
							<table class="striped">
								
							</table>
						</div>
						<div class="card-action" style="padding-left: 20px;">     
							<a href="${pageContext.request.contextPath}/siswa/edit/${siswa.id}">
								<button class="btn waves-effect grey" type="submit" name="action">EDIT     
									<i class="material-icons right">edit</i>    
								</button> 
							</a>
							<a href="${pageContext.request.contextPath}/siswa/hapus/${siswa.id}">
								<button class="btn waves-effect lighten-3" type="submit" name="action">DELETE
									<i class="material-icons right">delete</i>     
								</button>  
							</a>
						</div> 
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

      