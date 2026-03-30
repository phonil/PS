-- 코드를 입력하세요
SELECT
    APNT_NO,
    PT_NAME,
    A.PT_NO, # 테이블 명시
    A.MCDP_CD, # 테이블 명시
    DR_NAME, 
    APNT_YMD
FROM 
    PATIENT AS P
JOIN 
    APPOINTMENT AS A
ON 
    P.PT_NO = A.PT_NO
JOIN 
    DOCTOR AS D
ON 
    D.DR_ID = A.MDDR_ID
WHERE
    DATE_FORMAT(APNT_YMD, '%Y-%m-%d') IN ('2022-04-13')
AND
    APNT_CNCL_YN = 'N'
AND 
    A.MCDP_CD = 'CS'
ORDER BY APNT_YMD;

/*
APNT_YMD : 예약 TIMESTAMP
APNT_CNCL_YN : N - 예약 취소 X
MCDP_CD : CS - 흉부외과 코드

*/