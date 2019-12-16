package egovframework.example.sample.service;

import java.util.List;

public interface DgService {
	
	/* EMP TABLE */
	/**
	 * 사원을 등록한다.
	 * @param empVO
	 * @return 등록 결과 
	 * @throws Exception
	 */
	public void insertEmp(EmpVO empVO);
	
	/**
	 * 사원테이블에서 정답을 업데이트한다.
	 * @param vo - 수정할 정보가 담긴 EmpVO
	 * @return upadate 적용 결과 count
	 */
	public int updateEmpAnswer(EmpVO empVO);
	
	/**
	 * 사원테이블에서 통과여부를 'N'으로 업데이트한다.
	 * @return update 적용 결과 count
	 */
	public int updateEmpPass(EmpVO empVO);
	
	/**
	 * [다음]버튼 클릭시
	 * 사원테이블에서 통과한 사람들 정답을 null로 초기화한다.
	 * @return update 적용 결과 count
	 */
	public int updateResetEmpAnswer();
	
	/**
	 * [재시작]버튼으로 모든 emp reset
	 * @return
	 */
	public int updateResetEmp();
	
	/**
	 * [마감하기]버튼 클릭 시
	 * 정답을 제출한 사원들 수 셀렉트
	 * @return select count
	 */
	public int selectEmpAnswerCount();
	
	/**
	 * 사원테이블에서 empPass = 'Y'인 사원의 리스트를 가져와 리턴한다.
	 * @param vo - 조회할 정보가 담긴 EmpVO
	 * @return empPass = 'Y'인 사원의 리스트
	 */
	public List selectEmpAnswerList();
	
	/* MC TABLE */
	/**
	 * MC테이블에서 문제 시작 여부를 업데이트한다.
	 * @param vo - 수정할 정보가 담긴 MCVO
	 * @return update 적용 결과 count
	 */
	public int updateMcQStart(MCVO mcVO);
	
	/**
	 * MC테이블에서 정답을 업데이트한다.
	 * @param vo - 수정할 정보가 담긴 MCVO
	 * @return update 적용 결과 count
	 */
	public int updateMcAnswer(MCVO mcVO);
	
	/**
	 * MC테이블에서 문제 시작 여부를 조회한다.
	 * @return vo - MCVO
	 */
	public String selectMcQStart();
	
	/**
	 * @param vo - 조회할 정보가 담긴 EmpVO(empName)
	 * @return count
	 */
	public int selectEmp(EmpVO empVO);
	

}
