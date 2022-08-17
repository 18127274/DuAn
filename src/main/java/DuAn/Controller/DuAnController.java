package DuAn.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DuAn.model.ThamGiaDuAn;
import DuAn.model.ApiResponse;
import DuAn.model.DuAn;
import DuAn.repository.DuAnRepository;
import DuAn.repository.ThamGiaDuAnRepository;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Period;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")

public class DuAnController {
	@Autowired
	DuAnRepository repoda;
	@Autowired
	ThamGiaDuAnRepository repotgda;
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	MongoOperations mongoOperation;

	@GetMapping("/view_duan")
	public ResponseEntity<ApiResponse<List<DuAn>>> View_duan() {
		try {
			List<DuAn> wfhlst = new ArrayList<DuAn>();

			repoda.findAll().forEach(wfhlst::add);
			if (wfhlst.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			// System.out.println(wfhlst);
			ApiResponse<List<DuAn>> resp = new ApiResponse<List<DuAn>>(0, "Success", wfhlst);
			return new ResponseEntity<>(resp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get_manager1_of_staff/{MaNV_input}")
	public ResponseEntity<ThamGiaDuAn> Get_manager1_of_staff(@PathVariable(value = "MaNV_input") String MaNV_input) {
		try {
			System.out.println(MaNV_input);

			Query q = new Query();
			q.addCriteria(Criteria.where("MaNV").is(MaNV_input));
			List<ThamGiaDuAn> check = mongoTemplate.find(q, ThamGiaDuAn.class);

			if (check.isEmpty()) {
				ThamGiaDuAn resp = new ThamGiaDuAn();
				return new ResponseEntity<>(resp, HttpStatus.CREATED);
			}
			// kiem tra xem nhung data thamgiaduan cua 1 nhan vien co trong bang du an va co
			// status = 0 hay k?

			for (ThamGiaDuAn i : check) {
				// lấy ra dự án mà nhân viên đó đang hoạt động
				Query q1 = new Query();
				q1.addCriteria(Criteria.where("ID").is(i.getMaDuAn())).addCriteria(Criteria.where("TrangThai").is(0));
				List<DuAn> check1 = mongoTemplate.find(q1, DuAn.class);

				if (check1.isEmpty()) {
					ThamGiaDuAn resp = new ThamGiaDuAn();
					return new ResponseEntity<>(resp, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>(i, HttpStatus.CREATED);

				}
			}

			ThamGiaDuAn resp = new ThamGiaDuAn();
			// System.out.println(tgda.getID());
			return new ResponseEntity<>(resp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get_manager2_of_staff/{MaNV_input}")
	public ResponseEntity<DuAn> Get_manager2_of_staff(@PathVariable(value = "MaNV_input") String MaNV_input) {
		try {

			Query q = new Query();
			q.addCriteria(Criteria.where("MaNV").is(MaNV_input));
			//
			List<ThamGiaDuAn> check = mongoTemplate.find(q, ThamGiaDuAn.class);
			if (check.isEmpty()) {
				DuAn resp = new DuAn();
				return new ResponseEntity<>(resp, HttpStatus.CREATED);
			}
			for (ThamGiaDuAn i : check) {
				// tìm ra manager cấp 2 của dự án mà nhân viên đó đang làm việc
				DuAn da = new DuAn();
				Query q1 = new Query();

				q1.addCriteria(Criteria.where("ID").is(i.getMaDuAn())).addCriteria(Criteria.where("TrangThai").is(0));

				da = mongoTemplate.findOne(q1, DuAn.class);
				System.out.println(da.getMaPM());

				return new ResponseEntity<>(da, HttpStatus.CREATED);
			}

			DuAn resp = new DuAn();
			// System.out.println(tgda.getID());
			return new ResponseEntity<>(resp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/get_list_project_of_staff_by_id")
	public ResponseEntity<ApiResponse<List<DuAn>>> Get_list_project_of_staff_by_id(
			@RequestParam(value = "MaNV_input") String MaNV_input) {
		try {

			Query q = new Query();
			q.addCriteria(Criteria.where("MaNV").is(MaNV_input));
			List<ThamGiaDuAn> check = mongoTemplate.find(q, ThamGiaDuAn.class);

			System.out.println(check.isEmpty());

			if (check.isEmpty()) {
				ApiResponse<List<DuAn>> resp = new ApiResponse<List<DuAn>>(1,
						"This staff haven't any participate project", null);
				return new ResponseEntity<>(resp, HttpStatus.CREATED);
			}

			ApiResponse<List<DuAn>> resp = null;
			List<DuAn> list_duan1 = new ArrayList<>();
			List<DuAn> check1 = null;

			for (ThamGiaDuAn i : check) {
				System.out.println("do dai tgda: " + check.size());

				System.out.println(i.getMaDuAn());
				// duyet qua nhung data tham gia du an ma nhan vien co

				Query q1 = new Query();
				q1.addCriteria(Criteria.where("ID").is(i.getMaDuAn()));
				check1 = mongoTemplate.find(q1, DuAn.class);

				for (DuAn j : check1) {

					if (check1.isEmpty()) {
						System.out.println("vao trong lan 1: " + check1.isEmpty());

					} else {
						System.out.println("vao trong else");
						list_duan1.add(j);
					}
				}

			}
			if (list_duan1.isEmpty()) {
				resp = new ApiResponse<List<DuAn>>(1, "No data", null);
				// System.out.println(tgda.getID());
				return new ResponseEntity<>(resp, HttpStatus.CREATED);
			}

			resp = new ApiResponse<List<DuAn>>(0, "Success", list_duan1);
			// System.out.println(tgda.getID());
			return new ResponseEntity<>(resp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list_staff_manager1/{MaTL_input}")
	public ResponseEntity<List<ThamGiaDuAn>> list_staff_manager1(@PathVariable(value = "MaTL_input") String MaTL_input) {
		try {
			Query q = new Query();
			q.addCriteria(Criteria.where("MaTL").is(MaTL_input));
			List<ThamGiaDuAn> check = mongoTemplate.find(q, ThamGiaDuAn.class);

			if (check.isEmpty()) {
				List<ThamGiaDuAn> resp = new ArrayList<ThamGiaDuAn>();
				return new ResponseEntity<>(resp, HttpStatus.CREATED);
			}
			// kiem tra xem nhung data thamgiaduan cua 1 nhan vien co trong bang du an va co
			// status = 0 hay k?
			List<ThamGiaDuAn> result = new ArrayList<ThamGiaDuAn>();

			for (ThamGiaDuAn i : check) {
				// lấy ra dự án mà nhân viên đó đang hoạt động
				Query q1 = new Query();
				q1.addCriteria(Criteria.where("ID").is(i.getMaDuAn())).addCriteria(Criteria.where("TrangThai").is(0));
				List<DuAn> check1 = mongoTemplate.find(q1, DuAn.class);

				if (!check1.isEmpty()) {
					result.add(i);
				} 
			}
			// System.out.println(tgda.getID());
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}