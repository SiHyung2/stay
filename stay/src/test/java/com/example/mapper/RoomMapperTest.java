//package com.example.mapper;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.example.domain.RoomDTO;
//
//import lombok.extern.log4j.Log4j2;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { com.example.config.RootConfig.class })
//@Log4j2
//public class RoomMapperTest {
//    
//    @Autowired
//    private RoomMapper mapper;
//
//    @Test
//    public void testGetList() {
//        List<RoomDTO> list = mapper.getList();
//        list.forEach(room -> log.info(room));
//    }
//    
////    @Test
//    public void testInsertRoom() {
//    	RoomDTO room=new RoomDTO();
//		room.setRoom_num(4);
//		room.setAc_id("asd123");
//		room.setRo_name("스탠다드");
//		room.setRo_basic_count(2);
//		room.setRo_max_count(4);
//		room.setRo_info("삽입 테스트2");
//		room.setRo_count(10);
//		
//		
//		mapper.insertroom(room);
//		
//		log.info(room);
//	}
//    
////    @Test
//    public void testUpdateRoom() {
//    	RoomDTO room=new RoomDTO();
//    	room.setRoom_num(2);
//		room.setAc_id("asd123");
//		room.setRo_name("스탠다드_수정");
//		room.setRo_basic_count(2);
//		room.setRo_max_count(4);
//		room.setRo_info("수정 테스트2");
//		room.setRo_count(10);
//		
//		mapper.updateroom(room);
//		
//		log.info(room);
//	}
//    
////    @Test
//    public void testDeleteRoom() {
//    	RoomDTO room=new RoomDTO();
//		room.setRoom_num(2);
//		
//		mapper.deleteroom(room);
//		
//		log.info(room);
//	}
//    
//    
////    @Test
//	public void testSerchBy_ac_id() {
//  		String ac_id="1";
//		List<RoomDTO> list = mapper.searchByac_id(ac_id);
//		list.forEach(room -> log.info(room));
//  	}
//}
