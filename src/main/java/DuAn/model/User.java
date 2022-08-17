package DuAn.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "USER")
public class User {
	@Id
	private String ID;
	private String HoTen;
	private String UserName;
	private String PassWord;
	private String GioiTinh;
	private int ChucVu;
	private String DiaChi;
	private String Email;
	private String SDT;
	private String Avatar;
	private int SoPhepConLai;
	private int TrangThaiLamViec;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public int getChucVu() {
		return ChucVu;
	}
	public void setChucVu(int chucVu) {
		ChucVu = chucVu;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public int getSoPhepConLai() {
		return SoPhepConLai;
	}
	public void setSoPhepConLai(int soPhepConLai) {
		SoPhepConLai = soPhepConLai;
	}
	
	public int getTrangThaiLamViec() {
		return TrangThaiLamViec;
	}
	public void setTrangThaiLamViec(int trangThaiLamViec) {
		TrangThaiLamViec = trangThaiLamViec;
	}
	
	
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
	public User(String iD, String hoTen, String userName, String passWord, String gioiTinh, int chucVu,
			String diaChi, String email, String sDT, String avatar) {
		super();
		ID = iD;
		HoTen = hoTen;
		UserName = userName;
		PassWord = passWord;
		GioiTinh = gioiTinh;
		ChucVu = chucVu;
		DiaChi = diaChi;
		Email = email;
		SDT = sDT;
		SoPhepConLai = 12;
		TrangThaiLamViec = 0;
		Avatar = avatar;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
