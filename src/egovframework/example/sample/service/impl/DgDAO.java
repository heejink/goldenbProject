package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.EmpVO;
import egovframework.example.sample.service.MCVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("dgDAO")
public class DgDAO extends EgovAbstractDAO{
	
	/* EMP TABLE */
	/**
	 * 사원을 등록한다.
	 * @param empVO
	 * @return 등록 결과 
	 * @throws Exception
	 */
	public void insertEmp(EmpVO empVO) {
		System.out.println("DgDAO.insertEmp 함수 진입 >>>");
		
		try {
			insert("dgDAO.insertEmp", empVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	/**
	 * 사원테이블에서 정답을 업데이트한다.
	 * @param vo - 수정할 정보가 담긴 EmpVO
	 * @return upadate 적용 결과 count
	 */
	public int updateEmpAnswer(EmpVO empVO) {
		System.out.println("DgDAO.updateEmpAnswer 함수 진입 >>>");
		System.out.println("empName >>> " + empVO.getEmpName());
		System.out.println("empAnswer >>> " + empVO.getEmpAnswer());
		System.out.println("empAnswerTime >>> " + empVO.getEmpAnswerTime());
		
		int result = 0;
		try {
			result = update("dgDAO.updateEmpAnswer", empVO);
			System.out.println("DAO.udateEmpAnswer result >>> " + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	};
	
	/**
	 * [채점하기]버튼 클릭시
	 * 사원테이블에서 통과여부를 'N'으로 업데이트한다.
	 * @return update 적용 결과 count
	 */
	public int updateEmpPass(EmpVO empVO) {
		System.out.println("DgDAO.updateEmpPass 함수 진입 >>>");
		
		int result = 0;
		try {
			result = update("dgDAO.updateEmpPass", empVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	};
	
	/**
	 * [다음]버튼 클릭시
	 * 사원테이블에서 통과한 사람들 정답을 null로 초기화한다.
	 * @return update 적용 결과 count
	 */
	public int updateResetEmpAnswer() {
		System.out.println("DgDAO.updateResetEmpAnswer 함수 진입 >>>");
		
		int result = 0;
		try {
			result = update("dgDAO.updateResetEmpAnswer");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * [재시작]버튼으로 모든 emp reset
	 * @return update 적용 결과 count
	 */
	public int updateResetEmp() {
		System.out.println("DgDAO.updateResetEmp 함수 진입 >>> ");
		
		return update("dgDAO.updateResetEmp");
	}
	
	/**
	 * [마감하기]버튼 클릭 시
	 * 정답을 제출한 사원들 수 셀렉트
	 * @return select count
	 */
	public int selectEmpAnswerCount() {
		System.out.println("DgDAO.selectEmpAnswerCount 함수 진입 >>> ");
		
		return (int)select("dgDAO.selectEmpAnswerCount");
	}
	
	/**
	 * 사원테이블에서 empPass = 'Y'인 사원의 리스트를 가져와 리턴한다.
	 * @param vo - 조회할 정보가 담긴 EmpVO
	 * @return empPass = 'Y'인 사원의 리스트
	 */
	public List<EmpVO> selectEmpAnswerList() {
		System.out.println("DgDAO.selectEmpAnswerList 함수 진입 >>>");
		
		List<EmpVO> list = null;
		try {
			list = (List<EmpVO>) list("dgDAO.selectEmpAnswerList");
			
//			list = getSqlMapClientTemplate().queryForList("dgDAO.selectEmpAnswerList");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	};
	
	/* MC TABLE */
	/**
	 * MC테이블에서 문제 시작 여부를 업데이트한다.
	 * @param vo - 수정할 정보가 담긴 MCVO
	 * @return update 적용 결과 count
	 */
	public int updateMcQStart(MCVO mcVO) {
		System.out.println("DgDAO.updateMcQStart 함수 진입 >>>");
		
		int result = 0;
		try {
			result = update("dgDAO.updateMcQStart", mcVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	};
	
	/**
	 * MC테이블에서 정답을 업데이트한다.
	 * @param vo - 수정할 정보가 담긴 MCVO
	 * @return update 적용 결과 count
	 */
	public int updateMcAnswer(MCVO mcVO) {
		System.out.println("DgDAO.updateMcPass 함수 진입 >>>");
		
		int result = 0;
		try {
			result = update("dgDAO.updateMcAnswer", mcVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	};
	
	
	
	/**
	 * MC테이블에서 문제 시작 여부를 조회한다.
	 * @return vo - MCVO
	 */
	public String selectMcQStart() {
		System.out.println("DgDAO.selectMcQStart 함수 진입 >>>");
		
		MCVO mcVO = null;
		mcVO = new MCVO();
		String result = null;
		try {
			mcVO = (MCVO)select("dgDAO.selectMcQStart");
			System.out.println("mcVO >>> " + mcVO);
			System.out.println("mcName >>> " + mcVO.getMcName());
			System.out.println("mcQstart >>> " + mcVO.getMcQStart());
			result = mcVO.getMcQStart();
			System.out.println("DAO.mcQStart >>> " + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	};
	
	/**
	 * 사원의 이름을 조회하여 카운트로 리턴한다.
	 * @param empVO
	 * @return
	 */
	public int selectEmp(EmpVO empVO) {
		System.out.println("DgDAO.selectEmp 함수 진입 >>>");
		
		return (int)select("dgDAO.selectEmp", empVO);
	}
	

}
