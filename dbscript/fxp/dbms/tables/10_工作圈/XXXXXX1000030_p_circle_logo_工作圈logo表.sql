--
-- 工作圈logo表
--
--
-- v1.0 2017.02.24
-- author：
--
-- 修改历史：
--
-- drop table fxp.p_circle_logo;
create table  fxp.p_circle_logo (
-- +-----------------------------+--------------+-----------+
   fcircle_id                    varchar2(32)   not null,   -- 工作圈id
   ffile_id                      varchar2(200)  not null,   -- 文件id
   ffile_name                    varchar2(100)  not null,   -- 文件名
   ffile_type                    varchar2(10)   not null,   -- 文件格式（常量：JPG BMP PNG)
   fcreate_time                  date           not null,   -- 创建时间
   fcreate_desc                  varchar2(256),             -- 创建备注
-- +-----------------------------+--------------+-----------+
   fversion                      number(6)      not null,   -- 版本号
   --
   -- 主键、唯一键
   --
   constraint pk_p_circle_logo primary key (fcircle_id)
   --
   -- 约束
   --
);

--
-- 授权
--

--
-- 索引
--

--
-- 修改语句
--
