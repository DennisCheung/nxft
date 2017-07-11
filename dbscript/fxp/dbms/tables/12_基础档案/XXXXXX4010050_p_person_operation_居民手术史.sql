--
-- 居民手术史
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_person_operation;
create table  fxp.p_person_operation (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- 主键id
   foperation_name               varchar2(40)   not null,   -- 手术名称
   fhospital_name                varchar2(40),              -- 医院名称
   foperation_time               varchar2(50),              -- 时间说明
   --
   fperson_id                    varchar2(32)   not null,   -- 居民ID，
   fordernum                     number(6,2)    not null,   -- 排序号
   foperation_desc               varchar2(256),             -- 备注
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
   constraint pk_p_person_operation primary key (fpk_id)
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
create index idx_p_person_operation1 on fxp.p_person_operation(fperson_id);

--
-- 修改历史：
--
