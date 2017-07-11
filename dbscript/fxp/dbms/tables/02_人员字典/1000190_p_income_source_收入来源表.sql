--
-- 收入来源表
--
-- v1.0 2017.03.15
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_income_source;
create table  fxp.p_income_source (
-- +-----------------------------+--------------+-----------+
   fincome_source_id             varchar2(32)   not null,   -- 收入来源ID
   fincome_source_code           varchar2(8)    not null,   -- 收入来源代码
   fincome_source_name           varchar2(40)   not null,   -- 收入来源名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fincome_source_desc           varchar2(256),             -- 备注
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
   constraint pk_p_income_source primary key (fincome_source_id),
   constraint uk_p_income_source_code unique (fincome_source_code)
);

--
-- 同义词
--
