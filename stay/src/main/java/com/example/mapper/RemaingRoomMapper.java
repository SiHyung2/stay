package com.example.mapper;

import java.util.List;

import com.example.domain.RoomDTO;

public interface RemaingRoomMapper {
	
//	남은 방의 개수를 세려고 만든 인터페이스이다.    나중에 이 코드들 search에 합치던가 해야할지도
	
	
//	DB의 room테이블에서 날짜별 ro_count를 계산해야함을 깨달음 체크인과 체크아웃을 입력했을 때 해당 날짜에 비어있지 않는 숙소를
//	찾는 과정이다
//	1) 일단.. room테이블에서 해당 숙소(ac_id로 검색)의 ro_count를 각각 가져온다
//	2) 그리고 booking에서 해당 숙소의 예약을 조회한다 이때, 조건문에서 booking의 체크인과 체크아웃 날짜를
//       검색어의 체크인날짜보다 이후거나 검색어의 체크아웃 날짜 이전일때로 만든다
//		 그런다음 count(*)로
//	booking배열에 집어넣는다 그다음 각각 남은 방 계산
//  3) 해당 숙소의 모든 ro_count를 다 더한다음 total_ro_count배열에 집어넣는다
//	4) 숙소 목록을 조회한다. 다음과 같이 조건문을 넣는다. booking배열 - total_ro_count배열 가 0이 아니라면 해당 숙소를 조회.
	
//	ps)여기서 날짜를 오늘로 설정한 다음, 조건문에 bo_type을 넣어서 각각의 방의 ro_count를 센다면 숙소의 각각의 방 타입에 대해서
//       남은 방을 계산할 수 있다
	
	
//	1)첫번째 과정
	public List<RoomDTO> searchroomByac_id();
	
	
//	이건 쿼리문인데 일단 개발 보류
//	<!--  		SELECT d.day, nvl(rm.remaingroom,r.v_ro_count) -->
//	<!-- 		FROM ( -->
//	<!-- 		    SELECT TO_DATE('2024-04-10', 'YYYY-MM-DD') + LEVEL - 1 AS day -->
//	<!-- 		    FROM dual -->
//	<!-- 		    CONNECT BY TO_DATE('2024-04-10', 'YYYY-MM-DD') + LEVEL - 1 <= TO_DATE('2024-04-30', 'YYYY-MM-DD') -->
//	<!-- 		) d -->
//	<!-- 		LEFT JOIN remaingroom rm ON d.day = rm.day -->
//	<!-- 		LEFT JOIN ( -->
//	<!-- 		    SELECT ro_count AS v_ro_count -->
//	<!-- 		    FROM room -->
//	<!-- 		    WHERE ac_id = 'asd123' AND ro_type = 2 -->
//	<!-- 		) r ON 1 = 1; -->
	
	
//	2)
	
}
