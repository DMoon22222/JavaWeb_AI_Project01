create table operate_log
(
    id             int unsigned auto_increment comment 'ID'
        primary key,
    operate_emp_id int unsigned    null comment '操作人ID',
    operate_time   datetime        null comment '操作时间',
    class_name     varchar(100)    null comment '操作的类名',
    method_name    varchar(100)    null comment '操作的方法名',
    method_params  varchar(2000)   null comment '方法参数',
    return_value   varchar(2000)   null comment '返回值',
    cost_time      bigint unsigned null comment '方法执行耗时, 单位:ms'
)
    comment '操作日志表';

INSERT INTO tlias.operate_log (id, operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES (1, 1, '2026-04-09 11:50:25', 'com.scut.controller.DeptController', 'add', '[Dept(id=null, name=678, createTime=2026-04-09T11:50:24.621226400, updateTime=2026-04-09T11:50:24.621226400)]', 'Result(code=1, msg=success, data=null)', 10);
INSERT INTO tlias.operate_log (id, operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES (2, 1, '2026-04-09 11:50:38', 'com.scut.controller.DeptController', 'update', '[Dept(id=11, name=678555, createTime=2026-04-09T11:50:25, updateTime=2026-04-09T11:50:37.719644500)]', 'Result(code=1, msg=success, data=null)', 6);
INSERT INTO tlias.operate_log (id, operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES (3, 1, '2026-04-09 11:50:42', 'com.scut.controller.DeptController', 'delete', '[11]', 'Result(code=1, msg=success, data=null)', 5);
INSERT INTO tlias.operate_log (id, operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES (4, 68, '2026-04-09 16:20:56', 'com.scut.controller.DeptController', 'add', '[Dept(id=null, name=567, createTime=2026-04-09T16:20:56.460300400, updateTime=2026-04-09T16:20:56.460300400)]', 'Result(code=1, msg=success, data=null)', 8);
INSERT INTO tlias.operate_log (id, operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES (5, 68, '2026-04-09 16:21:01', 'com.scut.controller.DeptController', 'update', '[Dept(id=12, name=5678, createTime=2026-04-09T16:20:56, updateTime=2026-04-09T16:21:00.814949600)]', 'Result(code=1, msg=success, data=null)', 5);
INSERT INTO tlias.operate_log (id, operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES (6, 68, '2026-04-09 16:21:03', 'com.scut.controller.DeptController', 'delete', '[12]', 'Result(code=1, msg=success, data=null)', 5);
