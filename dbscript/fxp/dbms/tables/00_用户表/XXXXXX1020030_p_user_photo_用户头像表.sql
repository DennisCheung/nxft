--
-- 用户头像表
--
-- v1.0 2015.11.09
-- author：yw
--
-- 修改历史：
--
-- drop table fxp.p_user_photo;
create table  fxp.p_user_photo (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户id
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
   constraint pk_p_user_photo primary key (fuser_id)
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
