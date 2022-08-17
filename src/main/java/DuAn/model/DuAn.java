package DuAn.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DUAN")
public class DuAn {
	@Id
	private String ID;
	private String MaPM;
	private String MoTa;
	private String TenDuAn;
	private String NgayBatDau;
	private String NgayKetThuc;
	private int TrangThai;
	

	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public String getMaPM() {
		return MaPM;
	}



	public void setMaPM(String maPM) {
		MaPM = maPM;
	}



	public String getMoTa() {
		return MoTa;
	}



	public void setMoTa(String moTa) {
		MoTa = moTa;
	}



	public String getTenDuAn() {
		return TenDuAn;
	}



	public void setTenDuAn(String tenDuAn) {
		TenDuAn = tenDuAn;
	}



	public String getNgayBatDau() {
		return NgayBatDau;
	}



	public void setNgayBatDau(String ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}



	public String getNgayKetThuc() {
		return NgayKetThuc;
	}



	public void setNgayKetThuc(String ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}


	

	public int getTrangThai() {
		return TrangThai;
	}



	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}



	


	public DuAn(String iD, String maPM, String moTa, String tenDuAn, String ngayBatDau, String ngayKetThuc,int trangThai) {
		super();
		ID = iD;
		MaPM = maPM;
		MoTa = moTa;
		TenDuAn = tenDuAn;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		TrangThai = trangThai;
	}



	public DuAn() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DuAn(List<DuAn> da) {
		// TODO Auto-generated constructor stub
		super();
		da = da;
	}

}
