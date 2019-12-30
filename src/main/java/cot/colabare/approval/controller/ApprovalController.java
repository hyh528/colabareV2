package cot.colabare.approval.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cot.colabare.approval.domain.AEmployeeDto;
import cot.colabare.approval.domain.ApprovalDto;
import cot.colabare.approval.domain.ApprovalViewerDto;
import cot.colabare.approval.domain.ApproverDto;
import cot.colabare.approval.service.ApprovalService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/approval/")
@RestController
@Log4j
@AllArgsConstructor
public class ApprovalController { 
	
	// 서비스 입력
	private ApprovalService service;
	
	// 전자결재 문서 내 삽입
	@PostMapping(value ="/insertApproval" , produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<String> insertApproval(@RequestBody ApprovalDto approvaldto){
		
	
		int insertCount = service.insertApproval(approvaldto);
		
		
		
		System.out.println("넘버!!!!!!@@@@ : " + approvaldto.getApproval_no()); 
		
		
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/search" , produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<AEmployeeDto>> approvalM(String query){
		
		System.out.println("approval Controller!");
		List<AEmployeeDto> list = service.approvalM(query);
		System.out.println("리스트야 " + list);
		
		return new ResponseEntity<List<AEmployeeDto>>(service.approvalM(query),  HttpStatus.OK);
	}
	
	@PostMapping(value="/{employee_no}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<AEmployeeDto> selectMem(@PathVariable("employee_no") Long employee_no){
		
		System.out.println("selectMember Controller " + employee_no);
		
		return new ResponseEntity<AEmployeeDto>(service.selectMem(employee_no), HttpStatus.OK);
	}
	
	@PostMapping(value="/newApprover")
	public ResponseEntity<String> insertApprover(@RequestBody ApproverDto apverDto){
		
		System.out.println("ReplyVO: " + apverDto);
		
		int insertCount = service.insertApprover(apverDto);
		
		
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/lastNum" , produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Long lastNum(){
		
		System.out.println("마지막 문서번호1");
		Long juang = service.lastNum();
		System.out.println("컨트롤러야 " + juang);
	
		return juang;
	}
	
	@PostMapping(value="/approverList/{approval_no}" , produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ApproverDto>> approverList(@PathVariable("approval_no") Long approval_no){
		
		System.out.println("결재자 목록 리스트 컨트롤러");

		return new ResponseEntity<List<ApproverDto>>(service.approverList(approval_no), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{no}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> approverRemove(@PathVariable("no") Long no) {
		
		System.out.println("컨트롤러  삭제 + " + no);
		
		return service.approverRemove(no) == 1? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/approvalNumSelect", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Long approvalNumSelect(Long no){
		Long approvalNumSelect = service.approvalNumSelect(no);
		
		return approvalNumSelect;
	}
	
	@PostMapping(value="/newApprovalV")
	public ResponseEntity<String> insertApprovalV(@RequestBody ApprovalViewerDto approvalV){
		
		System.out.println("ReplyVO: " + approvalV);
		
		int insertCount = service.insertAppViewer(approvalV);
		
		
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
	@PostMapping(value="/approvalVList/{approval_no}" , produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ApprovalViewerDto>> approvalVList(@PathVariable("approval_no") Long approval_no){
		
		System.out.println("참조자 목록 리스트 컨트롤러");

		return new ResponseEntity<List<ApprovalViewerDto>>(service.approvalVList(approval_no), HttpStatus.OK);
	}

	@PostMapping(value="/approvalVNumSelect", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public Long approvalVNumSelect(Long apprviewer){
		Long approvalVNumSelect = service.approvalNumVSelect(apprviewer);
		
		return approvalVNumSelect;
	}
	
	@DeleteMapping(value="/appV/{apprviewer}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> approvalVRemove(@PathVariable("apprviewer") Long apprviewer) {
		
		System.out.println("컨트롤러  삭제 + " + apprviewer);
		
		return service.approvalVRemove(apprviewer) == 1? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
