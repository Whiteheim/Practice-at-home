insert into article(id, title, content) VALUES (1, '가가가가', '1111');
insert into article(id, title, content) VALUES (2, '나나나나', '2222');
insert into article(id, title, content) VALUES (3, '다다다다', '3333');

-- article dummy data insert
insert into article(id, title, content) VALUES (4, '당신의 인생 영화는?', '댓글 ㄱ');
insert into article(id, title, content) VALUES (5, '당신의 소울 푸드는?', '댓글 ㄱㄱ');
insert into article(id, title, content) VALUES (6, '당신의 취미는?', '댓글 ㄱㄱㄱ');

-- comment dummy data insert
-- 4번 게시글
insert into comment (id, article_id, nickname, body) values (1, 4, 'Park', 'Good Will Hunting');
insert into comment (id, article_id, nickname, body) values (2, 4, 'Kim', 'I AM SAM');
insert into comment (id, article_id, nickname, body) values (3, 4, 'Choi', 'TENET');
-- 5번 게시글
insert into comment (id, article_id, nickname, body) values (4, 5, 'Park', '치킨');
insert into comment (id, article_id, nickname, body) values (5, 5, 'Kim', '샤브샤브');
insert into comment (id, article_id, nickname, body) values (6, 5, 'Choi', '초밥');
-- 6번 게시글
insert into comment (id, article_id, nickname, body) values (7, 6, 'Park', '조깅');
insert into comment (id, article_id, nickname, body) values (8, 6, 'Kim', '유튜브');
insert into comment (id, article_id, nickname, body) values (9, 6, 'Choi', '독서');
