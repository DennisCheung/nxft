--
-- 职业类别表
--
-- v1.0 2017.03.15
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_occupation_type;
create table  fxp.p_occupation_type (
-- +-----------------------------+--------------+-----------+
   foccupation_type_id           varchar2(32)   not null,   -- 职业类别ID
   foccupation_type_code         varchar2(30)   not null,   -- 职业类别代码
   foccupation_type_name         varchar2(40)   not null,   -- 职业类别名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   foccupation_type_desc         varchar2(256),             -- 备注
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
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
   constraint pk_p_occupation_type primary key (foccupation_type_id),
   constraint uk_p_occupation_type_code unique (foccupation_type_code)
);

--
-- 同义词
--
