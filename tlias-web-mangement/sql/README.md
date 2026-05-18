# SQL 导入说明

本目录包含 `tlias` 项目的数据库初始化脚本。

## 推荐导入顺序

1. `dept.sql`
2. `emp.sql`
3. `emp_expr.sql`
4. `clazz.sql`
5. `student.sql`
6. `operate_log.sql`
7. `emp_login_log.sql`
8. `emp_log.sql`

## 说明

- 每个脚本都包含建表语句和示例数据。
- 脚本中的插入语句默认使用数据库名 `tlias`，导入前请先创建该数据库。
- 如果你已经在本地存在同名表，建议先清空或新建一个干净数据库后再导入。
- 如果你只想初始化表结构，也可以手动保留 `create table` 部分，去掉 `insert into` 部分。

## 创建数据库示例

```sql
CREATE DATABASE IF NOT EXISTS tlias DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE tlias;
```

## 命令行导入示例

```bash
mysql -u root -p tlias < sql/dept.sql
mysql -u root -p tlias < sql/emp.sql
mysql -u root -p tlias < sql/emp_expr.sql
mysql -u root -p tlias < sql/clazz.sql
mysql -u root -p tlias < sql/student.sql
mysql -u root -p tlias < sql/operate_log.sql
mysql -u root -p tlias < sql/emp_login_log.sql
mysql -u root -p tlias < sql/emp_log.sql
```

## 测试建议

导入完成后，建议至少验证以下内容：

- `dept`、`emp`、`clazz`、`student` 表存在且有数据
- 登录接口可正常使用测试账号登录
- 员工、部门、班级、学员页面都能查到数据
- 报表和日志页面能正常显示
