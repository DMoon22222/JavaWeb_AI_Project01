create table emp_expr
(
    id      int unsigned auto_increment comment 'ID, 主键'
        primary key,
    emp_id  int unsigned null comment '员工ID',
    begin   date         null comment '开始时间',
    end     date         null comment '结束时间',
    company varchar(50)  null comment '公司名称',
    job     varchar(50)  null comment '职位'
)
    comment '工作经历';

INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (1, 37, '2020-01-01', '2020-01-01', '百度', 'java开发');
INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (2, 37, '2020-01-01', '2020-01-01', '阿里', 'java开发');
INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (3, 38, '2012-07-01', '2019-03-03', '百度科技股份有限公司', 'java开发');
INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (4, 38, '2019-03-15', '2023-03-01', '阿里巴巴科技股份有限公司', '架构师');
INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (5, 46, '2012-07-01', '2019-03-03', '百度科技股份有限公司', 'java开发');
INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (6, 46, '2019-03-15', '2023-03-01', '阿里巴巴科技股份有限公司', '架构师');
INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (7, 47, '2026-04-22', '2026-04-22', '百度', 'java开发');
INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (8, 47, '2026-04-22', '2026-04-30', '腾讯', 'java高级开发');
INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (9, 37, '2020-01-01', '2020-01-01', '百度', 'java开发');
INSERT INTO tlias.emp_expr (id, emp_id, begin, end, company, job) VALUES (10, 37, '2020-01-01', '2020-01-01', '阿里', 'java开发');
