--
-- 配送单生成日志表
--
-- v1.0 2017.05.05
-- author：wing
--
-- 说明：
-- 1、 
--
-- 
--
-- 修改历史：
--
-- Drop Table nxft.delive_create_log;
Create Table  nxft.delive_create_log (
-- +-----------------------------+--------------+-----------+
   flog_id                       varchar2(32)   not null,   -- 日志id
   --
   -- 生成控制
   --
   fmeal_date                    date           not null,   -- 就餐日期
   fmeal_type_id                 varchar2(32)   not null,   -- 餐别ID
   fcreate_time                  date           not null,   -- 创建时间
   flog_desc                     varchar2(256),             -- 备注      
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
   constraint pk_delive_create_log primary key (flog_id),
   constraint uk_delive_create_log unique (fmeal_date,fmeal_type_id)
   --
   -- 约束
   --
);

--
-- 同义词
--
--
-- 授权
--

-- 
--索引 
--


--
-- 修改语句：
--

