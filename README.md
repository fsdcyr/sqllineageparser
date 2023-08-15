# SQL LINEAGE PARSER

通过antlr4解析sql得到表血缘与字段血缘。

## 表血缘算法
要计算出血缘关系，需要如何区分目标表、来源表、中间表。 其中中间表既是内层的目标表，也是外层的来源表，起到链接的作用。

下面通过一些sql类型或者关键字来标识表类型。
1. create table x —— x为目标表 
2. select c from x —— x为来源表，字段c为来源表字段
3. insert into table x —— x为目标表
4. with x as select c from y —— x为中间表，x为y的目标表，y是x的来源表。
5. update x set —— x为目标表

## 字段血缘算法
有了表血缘，很容易得到相应的字段血缘，只是有些细节需要特别处理。 

例如：
```sql
insert into x
select *
from (select a.*, b.c1
      from a join b on a.c1 = b.c1) t;
```
我们一步步解析这条sql语句。
1. 从外到内开始解析sql
2. insert into x —— 这里解析出x为目标表
3. select * from (...)t —— 这里解析出x的来源表为t，t是个子查询，标记为中间表。而这里的来源表字段是*，这个*我们需要根据内层解析出来具体有哪些字段。 
4. select a.*, b.c1 from a join b on a.c1 = b.c1 —— 这里解析出来源表为a和b，目标表是父级的t，查询字段为a.*,b.c1，这里我们可以得到t的字段有a.*和b.c1，那么我们只需要拿到表a的元数据信息，得到表a的字段有哪些，那么就可以得到完整的t表字段。 
5. 最后，从内到外回溯，建立起血缘关系。

## support
- MySQL
- PostgreSQL
- Greenplum



# TODO
