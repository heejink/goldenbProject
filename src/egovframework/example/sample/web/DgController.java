package egovframework.example.sample.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.cmmn.DgCheckAnswer;
import egovframework.example.sample.service.DgService;
import egovframework.example.sample.service.EmpVO;
import egovframework.example.sample.service.MCVO;

@Controller
@RequestMapping(value = "/dgcontroller")
public class DgController {

	/** DgService */
	@Resource(name = "dgService")
	private DgService dgService;
	
	/**
	 * Device별로 도전골든벨 첫 페이지로 이동한다.
	 * @param request
	 * @return "pcQuiz", "getName"
	 */
	@RequestMapping(value = "/detectDevice.do")
	public String detectDevice(HttpServletRequest request) {
		System.out.println("DgController.detectDevice 함수 진입 >>>");
		
		Device device = DeviceUtils.getCurrentDevice(request);
		System.out.println("device >>> " + device);
		if (device.isNormal()) {
			int pcStart = 0;
			MCVO mcVO = null;
			mcVO = new MCVO();
			mcVO.setMcQStart("Y");
			pcStart = dgService.updateMcQStart(mcVO);
			System.out.println("pcStart >>> " + pcStart);
			return "dgGame/pcQuiz2";
		} else if (device.isMobile()) {
			return "dgGame/getName";
		} else if (device.isTablet()) {
			return "dgGame/getName";
		} else
			return "../common/error";
	}
	
	/* 모바일 페이지 */ 
	/**
	 * getName.jsp 에서 mobile.jsp로 이동한다.
	 * 사원테이블에 이름, 세션을 등록한다.
	 * @param userName
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertEmp.do")
	public ModelAndView insertEmp(@RequestParam("userName") String userName, HttpServletRequest request) {
		System.out.println("DgController.insertEmp 함수 진입 >>>");
		
		// session, userName 값 확인
		HttpSession session = request.getSession();
		System.out.println("session >>> " + session);
		userName = request.getParameter("userName");
		System.out.println("userName >>> " + userName);
		
		try {
			// userName 기존값 확인
			int count  = 0;
			EmpVO empVO = null;
			empVO = new EmpVO();
			empVO.setEmpName(userName);
			count = dgService.selectEmp(empVO);
			System.out.println("Controller userName 기존값? >>> " + count);
			
			// 기존에 uerName이 없을 때 
			// INSERT userName
			if (count == 0) {
				dgService.insertEmp(empVO);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		// sesson에 userName 값 담기
		session.setAttribute("name", userName);
		System.out.println("session.getAttribute('name') : " + session.getAttribute("name"));
		
		// ModelAndView에 session, view 설정
		ModelAndView mav = new ModelAndView();
		mav.addObject("session", session);
		mav.setViewName("dgGame/mobile");
		
		return mav;
	}
	
	/**
	 * mobile.jsp에서 사원이 제출한 정답을 등록/거절한다.
	 * @param empVO
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateEmpAnswer.do")
	public @ResponseBody String updateEmpAnswer(@ModelAttribute("empVO") EmpVO empVO) {
		System.out.println("DgController.updateEmpAnswer 함수 진입 >>>");
		System.out.println("empName >>> " + empVO.getEmpName());
		System.out.println("empAnswer >>> " + empVO.getEmpAnswer());
		
		// 밀리세컨드 구하기
		Date now = null;
		now = new Date();
		String format = new SimpleDateFormat("HHmmssSS", Locale.KOREA).format(now);
		System.out.println("현재 시간 >>> " + format);
		
		// empVO.empAnswerTime 에 set하기
		empVO.setEmpAnswerTime(format);
		System.out.println("empAnswerTime >>> " + empVO.getEmpAnswerTime());
		
		try {
			// mcVO에서 mcQStart 값 가져오기
			String flag = null;
			flag = dgService.selectMcQStart();
			System.out.println("Controller.mcQStart >>> " + flag);
			
			// mcQStart == "Y" 이면 empAnswer을 업데이트한다.
			if (flag.equals("Y")) {				
				int result = dgService.updateEmpAnswer(empVO);
				System.out.println("DgController.updateEmpAnswer result >>> " + result);
				
				if (result>0) // 사원정답이 업데이트 됨
					return "success";
				else // 사원정답이 업데이트 되지 않음
					return "fail";
			} else {
				return "deny";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	}
	
	/* PC 페이지 */
	/**
	 * [마감하기] 버튼 클릭
	 * MC테이블에서 mcQStart = 'N'으로 업데이트한다.
	 * EMP테이블에서 정답 제출한 사원 수를 셀렉한다.
	 * pcQuiz.jsp 에서 pcAnswer.jsp 페이지로 이동한다.
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/goPcAnswerPage.do")
	public ModelAndView goPcAnswerPage(@RequestParam("num") String num) {
		System.out.println("DgController.goPcAnswerPage 함수 진입 >>>");
		System.out.println("num >>> "+ num);
		
		MCVO mcVO = null;
		mcVO = new MCVO();
		int result = 0;
		mcVO.setMcQStart("N");
		int count = 0;
		
		try {
			result = dgService.updateMcQStart(mcVO);
			System.out.println("Controller.result >>> " + result);
			
			count = dgService.selectEmpAnswerCount();
			System.out.println("Controller.count >>> " + count);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("num", num);
		mav.addObject("count", count);
		mav.setViewName("dgGame/pcAnswer");
		
		return mav;
	}
	
	/**
	 * [채점하기] 버튼 클릭
	 * mcAnswer을 업데이트함
	 * empPass = 'Y' 인 사람 중에서 mcAnswer == empAnswer 인지 채점
	 * empPass = 'N', empAnswer = '' 로 업데이트한다
	 * empPass = 'Y' 인 사원의 리스트를 가져와 리턴한다.
	 * pcAnswer.jsp 에서 pcResult.jsp 페이지로 이동한다.
	 * @param mcVO
	 * @return mav
	 */
	@RequestMapping(value = "/updateMcAnswerAndEmpPass")
	public ModelAndView updateMcAnswerAndEmpPass(@RequestParam("mcAnswer") String mcAnswer, HttpServletRequest request) {
		System.out.println("DgController.updateMcAnswerAndEmpPass 함수 진입 >>>");
		System.out.println("Controller.mcAnswer >>> " + mcAnswer);
		
		MCVO mcVO = new MCVO();
		mcVO.setMcAnswer(mcAnswer);
		// mcAnswer을 업데이트
		int mcResult = 0;
		mcResult = dgService.updateMcAnswer(mcVO);
		System.out.println("Controller.mcResult >>> " + mcResult);
		
		// empPass == 'Y'인 사람 셀렉
		List<EmpVO> empPassYlist = null;
		empPassYlist = new ArrayList<EmpVO>();
		empPassYlist = dgService.selectEmpAnswerList();
		System.out.println("empPassYlist.size() >>> " + empPassYlist.size());
		
		// empAnswer == mcAnswer 인지 체크, 아니면 empPass = 'N'로 업데이트
		for (int i = 0; i < empPassYlist.size(); i++) {
			EmpVO empVO = null;
			empVO = new EmpVO();
			System.out.println("empPassYlist : " + empPassYlist.get(i));
			
			empVO = empPassYlist.get(i);
			
			String checkResult = null;
			checkResult = DgCheckAnswer.checkAnswer(mcVO, empVO);
			
			if (checkResult.equals("N")) {
				int updateResult = 0;
				updateResult = dgService.updateEmpPass(empVO);
				System.out.println("Controller.틀린 사원 empPass 업데이트 >>> " + updateResult);
			}
		}
		
		// empPass == 'Y' 인 사람 셀렉해서 리턴
		empPassYlist = null; // 초기화
		empPassYlist = dgService.selectEmpAnswerList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("empPassYlist", empPassYlist);
		mav.setViewName("dgGame/pcResult");
		
		return mav;
	}
	
	/**
	 * [다음] 버튼 클릭
	 * MC테이블에서 mcQStart = 'Y'로 업데이트한다.
	 * EMP테이블에서 empPass = 'Y'인 사람들을 empAnswer = ''로 업데이트한다.
	 * pcResult.jsp 에서 pcQuiz.jsp 페이지로 이동한다.
	 * @return "pcQuiz"
	 */
	@RequestMapping(value = "/goPcQuizPage.do")
	public String goPcQuizPage() {
		System.out.println("DgController.goPcQuizPage 함수 진입 >>>");
		
		MCVO mcVO = null;
		mcVO = new MCVO();
		int mcResult = 0;
		mcVO.setMcQStart("Y");
		int empResult = 0;
		
		try {
			mcResult = dgService.updateMcQStart(mcVO);
			System.out.println("Controller.mcResult >>> " + mcResult);
			empResult = dgService.updateResetEmpAnswer();
			System.out.println("Controller.empResult >>> " + empResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "dgGame/pcQuiz";
	}
	
	/**
	 * [재시작]버튼을 누르면 판이 다시 시작한다.
	 * 모든 emp의 empPass = 'Y', empAnswer = "", empAnswerTime = "" 로 업데이트한다
	 * mcQStart = 'Y'로 업데이트한다.
	 * @return "success", "fail"
	 */
	@RequestMapping(value = "/updateReset.do")
	public @ResponseBody String updateReset() {
		System.out.println("DgController.updateReset 함수 진입 >>>");
		
		int empResult = 0;
		int mcResult = 0;
		String resultStr = null;
		
		try {
			// EMP 테이블 reset
			empResult = dgService.updateResetEmp();
			System.out.println("Controller.updateReset empResult >>> " + empResult);
			if (empResult >=0 ) {
				// mcQStart = 'Y'로 업데이트
				MCVO mcVO = new MCVO();
				mcVO.setMcQStart("Y");
				mcResult = dgService.updateMcQStart(mcVO);
				System.out.println("Controller.updateReset mcResult >>> " + mcResult);
				
				if (mcResult >= 0)
					resultStr = "success";
				else
					resultStr = "fail";
			} else
				resultStr = "fail";
		} catch (Exception e) {
			e.printStackTrace();
			resultStr = "fail";
		}
		
		System.out.println("Controller.updateReset resultStr >>> " + resultStr);
		return resultStr;
	}
}
