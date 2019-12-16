package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.DgService;
import egovframework.example.sample.service.EmpVO;
import egovframework.example.sample.service.MCVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("dgService")
public class DgServiceImpl extends EgovAbstractServiceImpl implements DgService{

	/** DgDAO */
	@Resource(name = "dgDAO")
	private DgDAO dgDAO;
	
	/* EMP TABLE */
	/**
	 * 사원을 등록한다.
	 * @param empVO
	 * @return 등록 결과 
	 * @throws Exception
	 */
	@Override
	public void insertEmp(EmpVO empVO) {
		// TODO Auto-generated method stub
		System.out.println("Service.insertEmp 함수 진입 >>>");
		try {
			dgDAO.insertEmp(empVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 사원테이블에서 정답을 업데이트한다.
	 * @param vo - 수정할 정보가 담긴 EmpVO
	 * @return upadate 적용 결과 count
	 */
	@Override
	public int updateEmpAnswer(EmpVO empVO) {
		// TODO Auto-generated method stub
		System.out.println("Service.updateEmpAnswer 함수 진입 >>>");
		
		int result = 0;
		try {
			result = dgDAO.updateEmpAnswer(empVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 사원테이블에서 통과여부를 'N'으로 업데이트한다.
	 * @return update 적용 결과 count
	 */
	@Override
	public int updateEmpPass(EmpVO empVO) {
		// TODO Auto-generated method stub
		System.out.println("Service.updateEmpPass 함수 진입 >>>");
		int result = 0;
		
		try {
			result = dgDAO.updateEmpPass(empVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * [다음]버튼 클릭시
	 * 사원테이블에서 통과한 사람들 정답을 null로 초기화한다.
	 * @return update 적용 결과 count
	 */
	@Override
	public int updateResetEmpAnswer() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * [재시작]버튼으로 모든 emp reset
	 * @return
	 */
	@Override
	public int updateResetEmp() {
		// TODO Auto-generated method stub
		System.out.println("Service.updateResetEmpPass 함수 진입 >>>");
		
		int result = 0;
		try {
			result = dgDAO.updateResetEmp();
			System.out.println("DgService.updateResetEmp Service.result >>> " + result);
		} catch(Exception e) {
			e.printStackTrace();
			result = -1;
		}
		
		return 0;
	}
	
	/**
	 * [마감하기]버튼 클릭 시
	 * 정답을 제출한 사원들 수 셀렉트
	 * @return select count
	 */
	@Override
	public int selectEmpAnswerCount() {
		System.out.println("Service.selectEmpAnswerCount 함수 진입 >>>");
		int result = 0;
		try {
			result = dgDAO.selectEmpAnswerCount();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 사원테이블에서 empPass = 'Y'인 사원의 리스트를 가져와 리턴한다.
	 * @param vo - 조회할 정보가 담긴 EmpVO
	 * @return empPass = 'Y'인 사원의 리스트
	 */
	@Override
	public List<EmpVO> selectEmpAnswerList() {
		// TODO Auto-generated method stub
		System.out.println("Service.selectEmpAnswerList 함수 진입 >>>");
		
		List<EmpVO> list = null;
		
		try {
			list = dgDAO.selectEmpAnswerList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* MC TABLE */
	/**
	 * MC테이블에서 문제 시작 여부를 업데이트한다.
	 * @param vo - 수정할 정보가 담긴 MCVO
	 * @return update 적용 결과 count
	 */
	@Override
	public int updateMcQStart(MCVO mcVO) {
		// TODO Auto-generated method stub
		System.out.println("Service.updateMcQStart 함수 진입 >>>");
		
		int result = 0;
		try {
			result = dgDAO.updateMcQStart(mcVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * MC테이블에서 정답을 업데이트한다.
	 * @param vo - 수정할 정보가 담긴 MCVO
	 * @return update 적용 결과 count
	 */
	@Override
	public int updateMcAnswer(MCVO mcVO) {
		// TODO Auto-generated method stub
		System.out.println("Service.updateMcAnswer 함수 진입 >>>");
		
		int result = 0;
		try {
			result = dgDAO.updateMcAnswer(mcVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * MC테이블에서 문제 시작 여부를 조회한다.
	 * @return vo - MCVO
	 */
	@Override
	public String selectMcQStart() {
		// TODO Auto-generated method stub
		System.out.println("Service.selectMcQStart 함수 진입 >>>");
		
		String result = null;
		try {
			result = dgDAO.selectMcQStart();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @param vo - 조회할 정보가 담긴 EmpVO(empName)
	 * @return count
	 */
	@Override
	public int selectEmp(EmpVO empVO) {
		// TODO Auto-generated method stub
		System.out.println("Service.selectEmp 함수 진입 >>>");
		System.out.println("empName >>> " + empVO.getEmpName());
		int result = 0;
		
		try {
			result = dgDAO.selectEmp(empVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}



}
