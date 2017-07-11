--
-- 客户助老员表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_person_helper;
create table  fxp.p_person_helper (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- 主键id
   fhelper_id                    varchar2(32)   not null,   -- 助老员id
   fhelper_name                  varchar2(40)   not null,   -- 助老员姓名
    --
   fperson_id                    varchar2(32)   not null,   -- 客户ID， 
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fhelper_desc                  varchar2(256),             -- 备注
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
   constraint pk_p_person_helper primary key (fpk_id),
   constraint uk_p_person_helper unique (fperson_id,fhelper_id)
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


--
-- 修改历史：
--
