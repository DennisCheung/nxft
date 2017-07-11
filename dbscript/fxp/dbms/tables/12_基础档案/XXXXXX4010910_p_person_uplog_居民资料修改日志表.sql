--
-- 居民资料修改日志表
--
-- v1.0 2015.02.14
-- author：wing
--
-- 修改历史：
--
-- v1.1
--   
-- drop table fxp.p_person_uplog;
create table  fxp.p_person_uplog (
-- +-----------------------------+--------------+-----------+
   fuplog_id                     varchar2(32)   not null,   -- 日志ID
   fperson_id                    varchar2(32)   not null,   -- 居民ID， 
   --
   -- 操作者
   --
   fsdatetime                    date           not null,   -- 系统日期(含时间)
   fup_user_id                   varchar2(32)   not null,   -- 更新操作员id
   fup_user_name                 varchar2(30)   not null,   -- 更新操作员姓名
   --
   -- 数据变化
   --   
   fcolumn_id                    varchar2(40)  not null,    -- 列名id
   fcolumn_name                  varchar2(40)  not null,    -- 列名中文
   foldvalue_id                  varchar2(32),              -- 原值id
   fnewvalue_id                  varchar2(32),              -- 新值id
   foldvalue_name                varchar2(200),             -- 原值名称
   fnewvalue_name                varchar2(200),             -- 新值名称   
   fup_desc                      varchar2(256),             -- 其他描述.
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,
   --
   -- 主键、唯一键
   --
   constraint pk_p_person_uplog primary key (fuplog_id)
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
-- 索引
--
 create index fxp.idx_file_person_uplog1 on fxp.file_person_uplog(fperson_id);
 create index fxp.idx_file_person_uplog2 on fxp.file_person_uplog(fsdatetime);
--
-- 修改语句
--
