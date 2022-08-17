package DuAn.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "THAMGIADUAN")
public class ThamGiaDuAn {
	@Id
	private String ID;
	private String MaDuAn;
	private String MaNV;
	private String MaTL;
	private String VaiTro;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getMaDuAn() {
		return MaDuAn;
	}
	public void setMaDuAn(String maDuAn) {
		MaDuAn = maDuAn;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getMaTL() {
		return MaTL;
	}
	public void setMaTL(String maTL) {
		MaTL = maTL;
	}
	public String getVaiTro() {
		return VaiTro;
	}
	public void setVaiTro(String vaiTro) {
		VaiTro = vaiTro;
	}
	
	
	public ThamGiaDuAn(String iD, String maDuAn, String maNV, String maTL, String vaiTro) {
		super();
		ID = iD;
		MaDuAn = maDuAn;
		MaNV = maNV;
		MaTL = maTL;
		VaiTro = vaiTro;
	}
	public ThamGiaDuAn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String ThamGiaDuAn1(String str) {
		return str;
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
