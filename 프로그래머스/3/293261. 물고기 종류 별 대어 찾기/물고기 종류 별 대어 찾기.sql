-- 코드를 작성해주세요
SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO AS FI
JOIN FISH_NAME_INFO AS FN
ON FI.FISH_TYPE = FN.FISH_TYPE
WHERE (FI.FISH_TYPE, LENGTH) IN 
    (SELECT FISH_INFO.FISH_TYPE, MAX(LENGTH)
     FROM FISH_INFO 
     GROUP BY FISH_INFO.FISH_TYPE
    )
ORDER BY ID;