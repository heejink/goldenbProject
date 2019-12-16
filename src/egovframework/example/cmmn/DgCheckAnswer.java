package egovframework.example.cmmn;

import egovframework.example.sample.service.EmpVO;
import egovframework.example.sample.service.MCVO;

public abstract class DgCheckAnswer {

	public static String checkAnswer(MCVO mcVO, EmpVO empVO) {
		System.out.println("	DgCheckAnswer.checkAnswer 함수 진입 >>>");
		System.out.println("mc정답 >>> " + mcVO.getMcAnswer());
		System.out.println("사원 이름 >>> " + empVO.getEmpName());
		System.out.println("사원 정답 >>> " + empVO.getEmpAnswer());

		String result = null;
		String mcAnswer = null;
		String empAnswer = null;

		mcAnswer = mcVO.getMcAnswer();
		empAnswer = empVO.getEmpAnswer();

		if (empAnswer != null) {

			String trimMC = mcAnswer.replaceAll("\\p{Z}", "");
			System.out.println("trimMC >>> " + trimMC);

			String trimEMP = empAnswer.replaceAll("\\p{Z}", "");
			System.out.println("trimEMP >>> " + trimEMP);

			if (trimMC.equals(trimEMP))
				result = "Y";
			else
				result = "N";
		} else
			result = "N";

		System.out.println("	DgcheckAnswer result >>> " + result);

		return result;
	}

}
