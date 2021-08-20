USE ssafy_web_db;
INSERT INTO ssafy_web_db.authority (authority_name) VALUES
	 ('ROLE_ADMIN'),
	 ('ROLE_USER');

	INSERT INTO ssafy_web_db.profile (dtype,image,image_org_name,`path`,thumbnail) VALUES
	 ('member','c237f302-2b3e-45e3-aabe-23f62302dad7.jpg','profile1.jpg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_c237f302-2b3e-45e3-aabe-23f62302dad7.jpg'),
	 ('member','a4dc7df0-9455-4947-a677-3b033f3b9f0f.jpg','profile1.jpg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_a4dc7df0-9455-4947-a677-3b033f3b9f0f.jpg'),
	 ('member','12871b28-39b1-42fa-a504-4f5db2f7acea.jpg','profile1.jpg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_12871b28-39b1-42fa-a504-4f5db2f7acea.jpg'),
	 ('member','1e8b2f30-eab3-4e4f-aba9-a7d12472756e.jpg','profile1.jpg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_1e8b2f30-eab3-4e4f-aba9-a7d12472756e.jpg'),
	 ('member','e56a0df5-bb35-451d-a260-f3ce96f05a40.jpg','profile1.jpg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_e56a0df5-bb35-451d-a260-f3ce96f05a40.jpg'),
	 ('study','3cfaeadd-8864-4f92-9a6d-210f5574153c.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_3cfaeadd-8864-4f92-9a6d-210f5574153c.jpeg'),
	 ('study','bc7457b7-0720-41f4-97e3-8cfe462f5ff4.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_bc7457b7-0720-41f4-97e3-8cfe462f5ff4.jpeg'),
	 ('study','74d6e327-5ec1-48e8-84fc-edd5cad97cfc.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_74d6e327-5ec1-48e8-84fc-edd5cad97cfc.jpeg'),
	 ('study','df385c23-e8c0-4ce8-8283-03a81443ae56.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_df385c23-e8c0-4ce8-8283-03a81443ae56.jpeg'),
	 ('study','a07fb628-ee36-496c-9e34-7e7426ce7f8f.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_a07fb628-ee36-496c-9e34-7e7426ce7f8f.jpeg');
INSERT INTO ssafy_web_db.profile (dtype,image,image_org_name,`path`,thumbnail) VALUES
	 ('study','dd3849b3-5872-4970-a4c3-f70b294e069e.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_dd3849b3-5872-4970-a4c3-f70b294e069e.jpeg'),
	 ('study','28f49498-d2d2-4bab-9edc-88389dc83cb6.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_28f49498-d2d2-4bab-9edc-88389dc83cb6.jpeg'),
	 ('study','a00dfa45-f697-4b4d-82fd-8b4134a8c96d.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_a00dfa45-f697-4b4d-82fd-8b4134a8c96d.jpeg'),
	 ('study','52efeb45-7dd3-41c1-a220-544ed8edba40.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_52efeb45-7dd3-41c1-a220-544ed8edba40.jpeg'),
	 ('study','cf03a7ea-672e-4db6-83ac-a526fd9d56a8.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_cf03a7ea-672e-4db6-83ac-a526fd9d56a8.jpeg'),
	 ('study','028afb50-e04b-4093-8775-51fdc8d9b44a.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_028afb50-e04b-4093-8775-51fdc8d9b44a.jpeg'),
	 ('study','849f297c-8cd1-4632-9443-381334dcfe2a.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_849f297c-8cd1-4632-9443-381334dcfe2a.jpeg'),
	 ('study','eea19efa-380c-42a9-811c-1369975ebbe9.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_eea19efa-380c-42a9-811c-1369975ebbe9.jpeg'),
	 ('study','952fd2f8-3d26-4509-b277-17f0742b9832.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_952fd2f8-3d26-4509-b277-17f0742b9832.jpeg'),
	 ('study','e8ac4edd-51bb-4d42-98ba-96bc84c7299d.jpeg','profile2.jpeg','c:\\sweet_tomato\\upload\\2021\\08\\19/','thumb_e8ac4edd-51bb-4d42-98ba-96bc84c7299d.jpeg');
	
	
INSERT INTO ssafy_web_db.member_profile (profile_id) VALUES
	 (1),
	 (2),
	 (3),
	 (4),
	 (5);

INSERT INTO ssafy_web_db.study_profile (profile_id) VALUES
	 (7),
	 (8),
	 (10),
	 (11),
	 (12),
	 (13),
	 (14),
	 (15),
	 (16),
	 (17);
INSERT INTO ssafy_web_db.study_profile (profile_id) VALUES
	 (18),
	 (19),
	 (20);
	
INSERT INTO ssafy_web_db.`member` (age,department,email,password,username,profile_id) VALUES
	 (20,'ssafy','test@naver.com','$2a$10$Q0JjwCaTIrBDf80XbhVEReAKsEqXt3DdYGiCw0g4/G2MLcyGmHXKO','홍길동',1),
	 (20,'ssafy','test2@naver.com','$2a$10$THLJuSUT8ZNvQ7rT0CIrC.Wq4XTHC2ESl3mUgvCn5luEkZ/Auw4X2','홍길동',2),
	 (20,'ssafy','test3@naver.com','$2a$10$8f/TFKIUP.24yBu7GYQN2e4WnMFKl0dbb9heVUYOi5XdS2a694PDS','홍길동',3),
	 (20,'ssafy','test4@naver.com','$2a$10$DXHFwdO0Q5KLCn0B2RHi7eudlpGx6/N0By8QaF9gH6ErYZ3qmW2sC','홍길동',4),
	 (20,'ssafy','test5@naver.com','$2a$10$okarmeu1vkOLj1IDOhPp6eThTx6SGJRFtS0ZEKifb.GU9I6jKIPLa','홍길동',5);

-- 	
INSERT INTO ssafy_web_db.member_authority (member_id,authority_name) VALUES
	 (1,'ROLE_USER'),
	 (2,'ROLE_USER'),
	 (3,'ROLE_USER'),
	 (4,'ROLE_USER'),
	 (5,'ROLE_USER');

INSERT INTO ssafy_web_db.study (`security`,study_intro,study_leader,study_name,profile_id) VALUES
	 ('private','바뀐 스터디 소개 입니다.',1,'바뀐 이름',10),
	 ('public','스터디 소개 입니다.',2,'study',7),
	 ('public','스터디 소개 입니다.',3,'study',8),
	 ('public','스터디 소개 입니다.',1,'study',11),
	 ('public','스터디 소개 입니다.',1,'study',12),
	 ('public','스터디 소개 입니다.',1,'study',13),
	 ('public','스터디 소개 입니다.',1,'study',14),
	 ('public','스터디 소개 입니다.',1,'study',15),
	 ('public','스터디 소개 입니다.',1,'study',16),
	 ('public','스터디 소개 입니다.',1,'study',17);
INSERT INTO ssafy_web_db.study (`security`,study_intro,study_leader,study_name,profile_id) VALUES
	 ('public','스터디 소개 입니다.',1,'study',18),
	 ('public','스터디 소개 입니다.',1,'study',19),
	 ('public','스터디 소개 입니다.',1,'study',20);



INSERT INTO ssafy_web_db.theme (theme_name) VALUES
	 ('theme1'),
	 ('theme2'),
	 ('theme3'),
	 ('theme4'),
	 ('theme5'),
	 ('theme6'),
	 ('theme7');

INSERT INTO ssafy_web_db.stduy_theme_ref (study_id,theme_name) VALUES
	 (2,'theme1'),
	 (2,'theme2'),
	 (2,'theme3'),
	 (3,'theme1'),
	 (3,'theme2'),
	 (3,'theme3'),
	 (1,'theme7'),
	 (1,'theme6'),
	 (1,'theme5'),
	 (4,'theme1');
INSERT INTO ssafy_web_db.stduy_theme_ref (study_id,theme_name) VALUES
	 (4,'theme3'),
	 (4,'theme5'),
	 (5,'theme1'),
	 (5,'theme3'),
	 (5,'theme5'),
	 (6,'theme1'),
	 (6,'theme3'),
	 (6,'theme5'),
	 (7,'theme1'),
	 (7,'theme3');
INSERT INTO ssafy_web_db.stduy_theme_ref (study_id,theme_name) VALUES
	 (7,'theme5'),
	 (8,'theme1'),
	 (8,'theme2'),
	 (8,'theme3'),
	 (9,'theme1'),
	 (9,'theme2'),
	 (9,'theme3'),
	 (10,'theme1'),
	 (10,'theme2'),
	 (10,'theme3');
INSERT INTO ssafy_web_db.stduy_theme_ref (study_id,theme_name) VALUES
	 (11,'theme4'),
	 (11,'theme2'),
	 (11,'theme5'),
	 (12,'theme4'),
	 (12,'theme2'),
	 (12,'theme5'),
	 (13,'theme4'),
	 (13,'theme2'),
	 (13,'theme5');



INSERT INTO ssafy_web_db.study_member_ref (connected,nickname,recently_connection_time,member_id,study_id) VALUES
	 (1,'aaaa','2021-08-19 12:28:52',1,1),
	 (1,'ccc','2021-08-19 14:31:53',2,2),
	 (1,'ddd','2021-08-18 14:31:53',3,3),
	 (1,'bbb','2021-08-19 14:31:05',1,2),
	 (1,'nickname1','2021-08-19 14:31:05',1,4),
	 (1,'nickname2','2021-08-19 14:31:05',1,5),
	 (1,'nickname3','2021-08-19 14:31:05',1,6),
	 (1,'nickname4','2021-08-19 14:31:05',1,7),
	 (1,'nickname5','2021-08-19 14:31:05',1,8),
	 (1,'nickname6','2021-08-19 14:31:05',1,9);
INSERT INTO ssafy_web_db.study_member_ref (connected,nickname,recently_connection_time,member_id,study_id) VALUES
	 (1,'nickname7','2021-08-20 14:31:05',1,10),
	 (1,'nickname8','2021-08-20 14:31:05',1,11),
	 (0,'nickname9','2021-08-20 14:31:05',1,12),
	 (0,'nickname10','2021-08-20 14:31:05',1,13);

INSERT INTO ssafy_web_db.study_time (study_date,study_time,member_id) VALUES
	 ('2021-08-19',30,1);

INSERT INTO ssafy_web_db.tomato_plan (goal_time,goal_tomato,tomato_date,study_id) VALUES
	 (20,20,'2021-08-19',1),
	 (30,1,'2021-08-18',2),
	 (40,2,'2021-08-22',3),
	 (50,3,'2021-08-18',4);

INSERT INTO ssafy_web_db.tomato (tomato_count,tomato_date,member_id,study_id) VALUES
	 (3,'2021-08-19',1,1);

INSERT INTO ssafy_web_db.blacklist (member_id,study_id) VALUES
	 (2,1);

INSERT INTO ssafy_web_db.comment (content,reg_time,member_id,study_id) VALUES
	 ('test comment1','2021-08-20',1,1),
	 ('test comment2','2021-08-20',1,1),
	 ('test comment3','2021-08-20',1,1);

INSERT INTO ssafy_web_db.schedule (info,schedule_date,study_id) VALUES
	 ('발표','2021-08-25',1);

INSERT INTO ssafy_web_db.data_room (content,subject,member_id,study_id) VALUES
	 ('텍스트 내용','제목',2,1),
	 ('텍스트 내용','제목',2,1),
	 ('텍스트 내용','제목',2,1),
	 ('바뀐 텍스트 내용','바뀐 제목2',2,1),
	 ('내용','제목2',1,1);
