package racingcar.utill;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Utill {

    /**
     * 모든 클래스에서 사용할 수 있는 메서드의 모음인 Utill 클래스 작성.
     */
    public static String inputString() {
        String inputStr = readLine();

        // 숫자을 포함하는가 검사
        ValidException.isValidIncludeNum(inputStr);

        // 공백입력 검사
        ValidException.isValidIncludeBlank(inputStr);

        // 공백포함 검사
        ValidException.isValidIncludeBlank(inputStr);

        // 특수기호 포함 검사.
        ValidException.isValidIncludeSpecialString(inputStr);

        return inputStr;
    }

    /**
     * 숫자입력
     *
     * @return
     */
    public static Integer inputNum() {
        String inputStr = readLine();

//        - [ ] 공백 입력 검사
        ValidException.isValidBlankCheck(inputStr);

//        - [ ] 공백 포함 검사
        ValidException.isValidIncludeBlank(inputStr);

//        - [ ] 문자열 포함 검사
        ValidException.isValidIncludeString(inputStr);

//        - [ ] 특수문자 포함 검사
        ValidException.isValidIncludeSpecialString(inputStr);

//        - [ ] 0 입력 검사
        ValidException.isValidZeroCheck(inputStr);

//        - [ ] 양수 입력 검사
        ValidException.isValidPositiveCheck(inputStr);

        Integer inputNum = parseInteger(inputStr);
        return inputNum;
    }

    public static Integer parseInteger(String str) {
        return Integer.valueOf(str);
    }

    // TODO: 10/28/23 배열을 리스트로 변환 
}
