-- 코드를 작성해주세요
SELECT C.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO AS P
JOIN ITEM_TREE AS C
ON P.ITEM_ID = C.ITEM_ID
WHERE C.PARENT_ITEM_ID IN (SELECT ITEM_ID FROM ITEM_INFO WHERE RARITY = 'RARE')
ORDER BY ITEM_ID DESC;
