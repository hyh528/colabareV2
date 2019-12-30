package cot.colabare.approval.mapper;

import java.util.List;

import cot.colabare.approval.domain.AEmployeeDto;

public interface AEmployeeMapper {

	public List<AEmployeeDto> approvalM (String query);
	
	// 한 명 조회
	public AEmployeeDto selectMem(Long employee_no);
}
