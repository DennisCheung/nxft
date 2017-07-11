--
-- 居民照片表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
-- v1.1
--   
-- drop table fxp.p_person_photo;
create table fxp.p_person_photo (
-- +-----------------------------+--------------+-----------+
   fperson_id                    varchar2(32)   not null,   -- 客户id
   ffile_id                      varchar2(200)  not null,   -- 文件id
   ffile_name                    varchar2(100)  not null,   -- 文件名
   ffile_type                    varchar2(10)   not null,   -- 文件格式（常量：JPG BMP PNG)
   fcreate_time                  date           not null,   -- 创建时间
   fcreate_desc                  varchar2(256),             -- 创建备注
-- +-----------------------------+--------------+-----------+   
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_person_photo primary key (fperson_id)
   --
   -- 约束
   --
);


--
-- 外部键约束
--

--
-- 授权
--


--
-- 索引
--

 
